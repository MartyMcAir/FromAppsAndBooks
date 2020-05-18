package z_HTTPURLemail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* 
Коды ошибок
*/
// В методе main присутствуют ошибки. Исправь их. Постарайся сделать минимум изменений.
//Результатом работы программы должно быть отображение JSON документа по ссылке url.
// https://javarush.ru/tasks/com.javarush.task.task40.task4010#discussion
public class ResponseCode_4010 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0"); // added


            if (conn.getResponseCode() != 200) { // 100 changed
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Server output .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

