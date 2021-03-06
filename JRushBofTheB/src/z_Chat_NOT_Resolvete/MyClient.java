package z_Chat_NOT_Resolvete;

import java.io.*;
import java.net.Socket;

public class MyClient {
    private final static String ADDRESS = "localhost"; // localhost or 127.0.0.1
    private final static int PORT = 4403;
    private Socket socket;
    private BufferedWriter out;
    private BufferedReader in;
    // что бы юзер мог ввести свое сообщение в консоли
    private BufferedReader inUserConsole = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        MyClient myClient = new MyClient();
//        myClient.connectV2();
        myClient.connectV3();
    }

    private void connectV3() {
        try (Socket socket2 = new Socket(ADDRESS, PORT); // делаем коннект на определенный адрес и порт
             PrintWriter out2 = new PrintWriter(new BufferedOutputStream(socket2.getOutputStream()), true);
             BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));) {

            System.out.println("(в консоли юзера #1) подключение к серверу создано.");
            System.out.println("(в консоли юзера #1) вы вошли в чат, что бы выйти введите exit.");
            String word = null;
            while (true) {  // запущен пока, не введем exit
                word = inUserConsole.readLine(); // ждем пока юзер не напишет
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

    private void connectV2() {
        try (Socket socket2 = new Socket(ADDRESS, PORT); // делаем коннект на определенный адрес и порт
             BufferedWriter out2 = new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));
             BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));) {

            System.out.println("(в консоли юзера #1) подключение к серверу создано.");
            System.out.println("(в консоли юзера #1) вы вошли в чат, что бы выйти введите exit.");
            String word = null;
            while (true) {  // запущен пока, не введем exit
                word = inUserConsole.readLine(); // ждем поrа юзер не напишет
                out2.write(word + "\n"); // \n- что бы сервер знал, что это конец сообщения
                out2.flush();
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
