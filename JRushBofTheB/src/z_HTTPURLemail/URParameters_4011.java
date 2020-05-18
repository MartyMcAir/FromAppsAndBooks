package z_HTTPURLemail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* 
Свойства URL
*/
// Метод decodeURLString должен принимать URL ссылку в виде строки и выводить ее свойства на экран:
//- protocol
//- authority
//- file
//- host
//- path
//- port
//- default port
//- query
//- ref
//
//Если переданная строка не является валидной URL ссылкой, на экран должно быть выведено сообщение формата:
// "Parameter s is not a valid URL.", где s - полученная в качестве параметра строка.
//
//P.S. Парсить строку не нужно, создай объект типа URL и вызови необходимые тебе методы.
// https://javarush.ru/tasks/com.javarush.task.task40.task4011#discussion
public class URParameters_4011 {
    public static void main(String[] args) throws IOException {
        decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");
    }

    public static void decodeURLString(String s) throws MalformedURLException {
//        if(s.isEmpty() | s==null) System.out.println("Parameter " + s + " is not a valid URL.");

        try{
        URL url = new URL(s);
        System.out.println(url.getProtocol());
        System.out.println(url.getAuthority());
        System.out.println(url.getFile());
        System.out.println(url.getHost());
        System.out.println(url.getPath());
        System.out.println(url.getPort());
        System.out.println(url.getDefaultPort());
        System.out.println(url.getQuery());
        System.out.println(url.getRef());
        }catch (MalformedURLException e){
//            System.out.println("Parameter " + s + " is not a valid URL.");
            System.out.println(String.format("Parameter %s is not a valid URL.", s));
        }
    }
}

