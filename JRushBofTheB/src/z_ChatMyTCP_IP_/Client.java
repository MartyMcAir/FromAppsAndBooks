package z_ChatMyTCP_IP_;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Client {
    private static Date currentDate = new Date();
    private static final String HOST_NAME = "localhost";
    private static final int PORT = 4403;

    public static void main(String[] args) {
        connectV3();
    }

    private static void connectV3() {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             Socket socket2 = new Socket(HOST_NAME, PORT); // делаем коннект на определенный адрес и порт
             PrintWriter out2 = new PrintWriter(new BufferedOutputStream(socket2.getOutputStream()), true);
             BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));) {

            System.out.println("(в консоли юзера #1) подключение к серверу создано. Вы вошли в чат, что бы выйти введите exit.");
            String word = null;
            while (true) {  // запущен пока, не введем exit
                word = bf.readLine(); // ждем пока юзер не напишет
                out2.println(word);
                if ("exit".equals(word.trim().toLowerCase())) {
                    break;
                }
                System.out.println("(в консоли юзера #1) сервер ответил: " + in2.readLine());
            }
        } catch (IOException e) {
            System.out.println("Ошибка, попробуйте перезайти позднее..");
        }
        System.out.println("Good luck! & хорошего дня. by/.");
    }
}
