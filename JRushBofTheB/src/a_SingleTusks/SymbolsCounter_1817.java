package a_SingleTusks;

/* 
Пробелы
*/

import java.io.*;
// https://javarush.ru/tasks/com.javarush.task.task18.task1817
//В метод main первым параметром приходит имя файла.
//        Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
//        1. Посчитать количество всех символов.
//        2. Посчитать количество пробелов.
//        3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
//        4. Закрыть потоки.
//
//        Требования:
//        •	Считывать с консоли ничего не нужно.
//        •	Создай поток чтения из файла, который приходит первым параметром в main.
//        •	Посчитай отношение пробелов ко всем символам в файле и выведи в консоль это число.
//        •	Выведенное значение необходимо округлить до 2 знаков после запятой.
//        •	Поток чтения из файла должен быть закрыт.
public class SymbolsCounter_1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = "C:\\z_n\\new_test_folder\\file_name.txt";
        String fileName = args[0];

        String[] engArr = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(fileName));
        double tmpInt, countSpace = 0, countSymbols = 0, countAll = 0;
        while (bfIn.available() > 0) {
            tmpInt = bfIn.read();
//            System.out.println(tmpInt); // 32 это пробел
                countAll++;
//            if (Character.isAlphabetic((char) tmpInt)) {
//                countAll++;
//            }
            if (tmpInt == 32) {
                countSpace++;
            } else {
                countSymbols++;
                // 1. Посчитать количество всех символов.
                //Пробелы сюда тоже входят.
            }
        }
        bfIn.close();

//        System.out.println("пробелов: " + countSpace + ", символов: " + countSymbols);
        // 3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
//        double result = (countAll / countSymbols) * 100;
        double result = countSpace / countAll * 100;
//        System.out.println(result); // double 42.857142857142854 _ int 0
//        System.out.println(Double.toString(result).substring(0, 5)); // 42.85
        System.out.printf("%.2f", result);   // 42,857143
//        System.out.println(Math.round(result));

    }
}
