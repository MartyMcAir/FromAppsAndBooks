package z_ChatSimple;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             Socket socket = new Socket("localhost", 4403);
             PrintWriter out = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
            String word = null;
            do {
                word = bf.readLine(); // пишем
                out.println(word); // отправляем серверу
                System.out.println(in.readLine()); // ответ от сервера
            } while (!"exit".equals(word.trim().toLowerCase()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
