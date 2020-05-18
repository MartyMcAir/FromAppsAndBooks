package z_HTTPURLemail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/
// Перепиши реализацию метода getSite, он должен явно создавать и использовать сокетное соединение Socket с сервером.
//Адрес сервера и параметры для GET-запроса получи из параметра url.
//Порт используй дефолтный для http (80).
//Классы HttpURLConnection, HttpClient и т.д. не использовать.
//Не оставляй закомементированный код.
// https://javarush.ru/tasks/com.javarush.task.task40.task4006#discussion

public class Socket_4006 {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
            Socket socket = new Socket(url.getHost(), 80); // url.getDefaultPort()

            // пишем в сокет что надо
            PrintWriter wtr = new PrintWriter(socket.getOutputStream(), true);
            wtr.println("GET " + url.getFile() + " HTTP/1.1");
            wtr.println("Host: " + url.getHost());
//            wtr.flush(); // true = is auto Flush

            // получаем из сокета и выводим в консоль
            BufferedReader bufRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String outStr;
            while ((outStr = bufRead.readLine()) != null) {
                System.out.println(outStr);
            }

            bufRead.close();
            wtr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод getSite не должен использовать HttpURLConnection или HttpClient.
//    public static void getSiteOrigin(URL url) {
//        try {
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String responseLine;
//            while ((responseLine = bufferedReader.readLine()) != null)
//                System.out.println(responseLine);
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}