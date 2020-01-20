package z_ChatSimple;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRunner implements Runnable {
    private final ServerSocket serverSocketNow;

    public ServerRunner(ServerSocket serverSocket) {
        this.serverSocketNow = serverSocket;
    }

    public static void main(String[] args) {
        try {
            int i = 0;
            while (true) {
                // Пробовал и просто Sever и new ServerSocket() отправлять и не отправлять всеравно эта ошибка
                // зато без цикла один поток работает на ура
                // java.net.BindException: Address already in use: NET_Bind
                ServerSocket serverSocket = new ServerSocket(4403);
                serverSocket.accept();
                Thread thread = new Thread(new ServerRunner(serverSocket));
                thread.start();
                System.out.println(++i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        connect();
    }

    public void connect() {
        String wordFromClient = null;
        try (ServerSocket serverSocket = serverSocketNow;
             Socket socket = serverSocket.accept();
             PrintWriter out = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
            while (!socket.isClosed()) {
                wordFromClient = in.readLine();
                System.out.println("юзер написал: " + wordFromClient);
                out.println("ответ от сервера: " + wordFromClient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
