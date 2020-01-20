package z_Chat_NOT_Resolvete;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientSomthing_2 {
    private SimpleDateFormat dt1 = new SimpleDateFormat("HH:mm:ss"); // берем только время до секунд
    private Date time = new Date(); // текущая дата;
    private Socket socket;
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток чтения в сокет
    private BufferedReader inputUser; // поток чтения с консоли
    private String addr; // ip адрес клиента
    private int port; // порт соединения
    private String nickname; // имя клиента

    // конструктор клиента в котором запускаются нити ReadMsg и WriteMsg
    public ClientSomthing_2(String addr, int port) { // и инициализируются остальные поля класса
        this.addr = addr;
        this.port = port;
        try {
            this.socket = new Socket(addr, port);
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try { // потоки чтения из сокета / записи в сокет, и чтения с консоли
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.pressNickname(); // перед началом необходимо спросит имя
            new ReadMsg().start(); // нить читающая сообщения из сокета в бесконечном цикле
            new WriteMsg().start(); // нить пишущая сообщения в сокет приходящие с консоли в бесконечном цикле
        } catch (IOException e) {
            // Сокет должен быть закрыт при любой ошибке, кроме ошибки конструктора сокета:
            ClientSomthing_2.this.downService();
        }
        // В противном случае сокет будет закрыт в методе run() нити.
    }

    private void pressNickname() { // просьба ввести имя, и отсылка эхо с приветсвием на сервер
        System.out.print("Press your nick: ");
        try {
            nickname = inputUser.readLine();
            out.write("Hello " + nickname + "\n");
            out.flush();
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
                        ClientSomthing_2.this.downService(); // харакири
                        break; // выходим из цикла если пришло "stop"
                    }
                    System.out.println(str); // пишем сообщение с сервера на консоль
                }
            } catch (IOException e) {
                ClientSomthing_2.this.downService();
            }
        }
    }

    public class WriteMsg extends Thread { // нить отправляющая сообщ приходящ с консоли на сервер
        @Override
        public void run() {
            while (true) {
                String userWord;
                try {
                    userWord = inputUser.readLine(); // сообщения с консоли
                    if (userWord.equals("stop")) {
                        out.write("stop" + "\n");
                        ClientSomthing_2.this.downService(); // харакири
                        break; // выходим из цикла если пришло "stop"
                    } else {
                        out.write("(" + dt1.format(time) + ") " + nickname + ": " + userWord + "\n"); // отправляем на сервер
                    }
                    out.flush(); // чистим
                } catch (IOException e) {
                    ClientSomthing_2.this.downService(); // в случае исключения тоже харакири
                }
            }
        }
    }


    public static class Client {
        public static String ipAddr = "localhost";
        public static int port = 8080;

        public static void main(String[] args) {
            new ClientSomthing_2(ipAddr, port);
        }
    }
}

