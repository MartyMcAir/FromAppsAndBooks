package z_ChatSimple;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientSomthing {

    private static final String ipAddr = "localhost";
    private static int port = 4403;

    private Date time = new Date(); // текущая дата
    private SimpleDateFormat dt1 = new SimpleDateFormat("HH:mm:ss"); // берем только время до секунд
    private String dtime = dt1.format(time); // время

    private String nickname; // имя клиента
    private String addr; // ip адрес клиента

    private Socket socket;
    private BufferedReader in; // поток чтения из сокета
    private PrintWriter out; // поток чтения в сокет
    private BufferedReader inputUser; // поток чтения с консоли

    public static void main(String[] args) {
        new ClientSomthing(ipAddr, port);
    }

    public ClientSomthing(String addr, int port) {
        this.addr = addr;
        this.port = port;
        try {
            this.socket = new Socket(addr, port);
        } catch (IOException e) {
            System.out.println("Сервер чата, не активен. Попробуйте позже.");
        }
        try { // потоки чтения из сокета / записи в сокет, и чтения с консоли
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()), true);
            pressNickname(); // перед началом необходимо спросить имя

            // отделяная нить что бы видеть актульное состояние чата
            new ReadMsg().start(); // нить читающая сообщения из сокета в бесконечном цикле

            ////////////////
            // отдельная нить для большей стабильности программы-клиента!?
            // прикрасно работает и без этой нити
//            new WriteMsg().start(); // нить пишущая сообщения в сокет приходящие с консоли в бесконечном цикле
            String userWord;
            while (true) {
                userWord = inputUser.readLine(); // сообщения с консоли
                if (userWord.equals("stop")) {
                    out.println("stop");
                    ClientSomthing.this.downService(); // харакири
                    break; // выходим из цикла если пришло "stop"
                } else if (!userWord.equals("\n")) {
                    out.println("(" + dtime + ") " + nickname + ": " + userWord); // отправляем на сервер
                }
            }
            ////////////////
        } catch (IOException e) {
            // Сокет должен быть закрыт при любой ошибке, кроме ошибки конструктора сокета:
            System.out.println("Ошибка при подключении к чату. Попробуйте позже.");
            ClientSomthing.this.downService();
        }
        // В противном случае сокет будет закрыт в методе run() нити.
    }

    private void pressNickname() { // росьба ввести имя, отсылка эхо с приветсвием на сервер
        System.out.print("Press your nick: ");
        try {
            nickname = inputUser.readLine();
            out.println("Hello " + nickname);
        } catch (IOException ignored) {
        }
    }

    private void downService() { // закрытие сокета
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {
        }
    }

    private class ReadMsg extends Thread { // нить чтения сообщений с сервера
        @Override
        public void run() {
            String str;
            try {
                while (true) {
                    str = in.readLine(); // ждем сообщения с сервера
                    if (str.equals("stop")) {
                        ClientSomthing.this.downService(); // харакири
                        break; // выходим из цикла если пришло "stop"
                    }
                    System.out.println(str); // пишем сообщение с сервера на консоль
                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении с сервера. Попробуйте позже.");
                ClientSomthing.this.downService();
            }
        }
    }

    public class WriteMsg extends Thread { // нить отправляющая сообщения приходящие с консоли на сервер
        @Override
        public void run() {
            String userWord;
            try {
                while (true) {
                    userWord = inputUser.readLine(); // сообщения с консоли
                    if (userWord.equals("stop")) {
                        out.println("stop");
                        ClientSomthing.this.downService(); // харакири
                        break; // выходим из цикла если пришло "stop"
                    } else {
                        out.println("(" + dtime + ") " + nickname + ": " + userWord); // отправляем на сервер
                    }
                }
            } catch (IOException e) {
                System.out.println("Ошибка при отправке сообщения на сервер. Попробуйте позже.");
                ClientSomthing.this.downService(); // в случае исключения тоже харакири
            }
        }
    }
}

