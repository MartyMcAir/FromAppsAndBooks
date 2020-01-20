package z_ChatSimple;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        String wordFromClient = null;
        try (ServerSocket serverSocket = new ServerSocket(4403);
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
