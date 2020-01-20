package z_ChatMyTCP_IP_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private final ServerSocket serverSocket;
    private final Socket currentSocket;
    private final Date dateCreated;
    private String password;
    private String name;
    private AtomicInteger userId = new AtomicInteger();

    public User(Socket currentSocket, ServerSocket serverSocket) {
        this.currentSocket = currentSocket;
        this.dateCreated = new Date();
        this.serverSocket = serverSocket;
    }


    public void method() {
        System.out.println("Вы вошли в чат, для выхода введите exit.");
        String word = null;
        int id = userId.getAndIncrement();
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(currentSocket.getOutputStream())));
             BufferedReader in = new BufferedReader(new InputStreamReader(currentSocket.getInputStream()));) {
            while (!currentSocket.isClosed()) { // держим соединение пока юзер его не разорвал
                word = in.readLine(); // написал
                out.println("#" + id + " " + new Date() + ": " + word); // отправил серверу
                if ("exit".equals(word.trim().toLowerCase())) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Goog Luck & Good Daaay.");
    }


    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public Socket getCurrentSocket() {
        return currentSocket;
    }
}
