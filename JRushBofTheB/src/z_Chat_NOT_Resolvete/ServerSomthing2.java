package z_Chat_NOT_Resolvete;

import java.io.*;
import java.net.Socket;

public class ServerSomthing2 extends Thread {
    private Socket socket; // сокет, через который сервер общается с клиентом,
    // кроме него - клиент и сервер никак не связаны
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток записи в сокет

    public ServerSomthing2(Socket socket) throws IOException {
        this.socket = socket;
        // если потоку ввода/вывода приведут к генерированию исключения, оно проброситься дальше
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start(); // вызываем run()
    }

    @Override
    public void run() {
        String word;
        try {
            while (true) {
                word = in.readLine();
                if (word.equals("stop")) {
                    break;
                }
                for (ServerSomthing2 vr : MyServer.serverList) {
                    vr.send(word); // отослать принятое сообщение с
                    // привязанного клиента всем остальным включая его
                }
            }

        } catch (IOException e) {
        }
    }

    private void send(String msg) {
        try { // при этом this - это явл. текущим клиентом т.е. чисто его сообщение
            // ему самому можно и не отправлять
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {
        }
    }
}
