package z_ChatSimple;

import z_Chat_NOT_Resolvete.ServerSomthing;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;

public class ServerSomthingMod extends Thread {
    public static class Server {

        public static final int PORT = 4403;
        public static LinkedList<ServerSomthingMod> serverList = new LinkedList<>(); // список всех нитей - экземпляров
        // сервера, слушающих каждый своего клиента
        public static Story story; // история переписки

        public static void main(String[] args) throws IOException {
            ServerSocket server = new ServerSocket(PORT);
            story = new Story();
            System.out.println("Server Started");
            try {
                while (true) {
                    // Блокируется до возникновения нового соединения:
                    Socket socket = server.accept();
                    try {
                        serverList.add(new ServerSomthingMod(socket)); // добавить новое соединенние в список
                    } catch (IOException e) {
                        // Если завершится неудачей, закрывается сокет, в противном случае, нить закроет его:
                        socket.close();
                    }
                }
            } finally {
                server.close();
            }
        }
    }

    private Socket socket; // сокет, через который сервер общается с клиентом
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток завписи в сокет

    public ServerSomthingMod(Socket socket) throws IOException { // для общения с клиентом необходим сокет (адресные данные)
        this.socket = socket;
        // если потоку ввода/вывода приведут к генерированию искдючения, оно проброситься дальше
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Server.story.printStory(out); // поток вывода передаётся для передачи истории последних 10
        // сооюбщений новому поключению
        start(); // вызываем run()
    }

    @Override
    public void run() {
        String word;
        try { // первое сообщение отправленное сюда - это никнейм
            word = in.readLine();
            try {
                out.write(word + "\n");
                out.flush(); // flush() нужен для выталкивания оставшихся данных
                // если такие есть, и очистки потока для дьнейших нужд
            } catch (IOException ignored) {
            }
            try {
                while (true) {
                    word = in.readLine();
                    if (word.equals("stop")) {
                        this.downService(); // харакири
                        break; // если пришла пустая строка - выходим из цикла прослушки
                    }
                    System.out.println("Echoing: " + word);
                    Server.story.addStoryEl(word);
                    for (ServerSomthingMod vr : Server.serverList) {
                        vr.send(word); // отослать принятое сообщение с привязанного клиента всем остальным влючая его
                    }
                }
            } catch (NullPointerException ignored) {
            }
        } catch (IOException e) {
            this.downService();
        }
    }

    private void send(String msg) { // отсылка одного сообщения клиенту по указанному потоку
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {
        }
    }

    private void downService() { // закрытие сервера прерывание себя как нити и удаление из списка нитей
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
                for (ServerSomthingMod vr : Server.serverList) {
                    if (vr.equals(this)) vr.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException ignored) {
        }
    }
}