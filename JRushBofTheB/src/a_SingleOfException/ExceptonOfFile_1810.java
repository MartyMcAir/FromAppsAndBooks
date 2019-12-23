package a_SingleOfException;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
// https://javarush.ru/tasks/com.javarush.task.task18.task1810
//1 Считывать с консоли имена файлов.
//        2 Если файл меньше 1000 байт, то:
//        2.1 Закрыть потоки работы с файлами.
//        2.2 Выбросить исключение DownloadException.
//
//        Требования:
//        •	Программа должна считать имена файлов с консоли.
//        •	Для чтения из файлов используй поток FileInputStream.
//        •	Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
//        •	Программа должна завершиться исключением DownloadException.
//        •	Поток FileInputStream должен быть закрыт.
public class ExceptonOfFile_1810 {
    public static void main(String[] args) throws DownloadException, IOException {
        Scanner sc = new Scanner(System.in);
        InputStream in = null;
        String filePath;
        do {
            filePath = sc.nextLine();
            in = new FileInputStream(filePath);
            if (in.available() < 1000) {
                throw new DownloadException();
            }
        } while (in.available() >= 1000); // больше или равно 1000 байт не должно прекращать работу

        sc.close();
        in.close();
        
    }

    public static class DownloadException extends Exception {

    }
}
