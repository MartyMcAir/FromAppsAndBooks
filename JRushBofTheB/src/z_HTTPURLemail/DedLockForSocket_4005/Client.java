package z_HTTPURLemail.DedLockForSocket_4005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/* 
Сокетный сервер и клиент
*/
// from comments
// Программа зависает. Делаем отладку и видим, что зависает на создании потока чтения.
// Заходим в конструктор ObjectInputStream - и видим, что он использует   BlockDataInputStream.
//Вот и ответ. Он блокирует поток до тех пор, пока не появится то, что читать.
// А чтобы оно появилось, нужно создать объект потока записи, который и положит данные.
// DeadLock for OutPut and Input
// https://stackoverflow.com/questions/14110986/new-objectinputstream-blocks
// http://frequal.com/java/OpenObjectOutputStreamFirst.html

// https://javarush.ru/tasks/com.javarush.task.task40.task4005#discussion
public class Client {
    private Connection connection;

    private String getServerAddress() {
        return "localhost";
    }

    private int getServerPort() {
        return 4444;
    }

    public void run() {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        try {
            connection = new Connection(new Socket(getServerAddress(), getServerPort()));

            SocketThread socketThread = new SocketThread();
            socketThread.setDaemon(true);
            socketThread.start();

            while (true) {
                String text = bis.readLine();
                if (text.equalsIgnoreCase("exit"))
                    break;
                connection.send(text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    String message = connection.receive();
                    System.out.println(message);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}