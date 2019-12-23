package a_SingleTusks;

/* 
Встречаемость символов
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
// https://javarush.ru/tasks/com.javarush.task.task18.task1821
//Программа запускается с одним параметром - именем файла, который содержит английский текст.
//        Посчитать частоту встречания каждого символа.
//        Отсортировать результат по возрастанию кода ASCII (почитать в инете).
//
//        Пример:
//        ','=44, 's'=115, 't'=116.
//
//        Вывести на консоль отсортированный результат:
//        [символ1] частота1
//        [символ2] частота2
//        Закрыть потоки.
//
//        Пример вывода:
//        , 19
//        - 7
//        f 361
//
//        Требования:
//        •	Считывать с консоли ничего не нужно.
//        •	Создай поток для чтения из файла, который приходит первым параметром в main.
//        •	В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
//        •	Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
//        •	Поток для чтения из файла должен быть закрыт.
public class SymbolsCounterASCllOrder_1821 {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
//        String pathDir = "C:\\z_n\\new_test_folder\\";
//        String file1 = pathDir + "data1.txt", file2 = pathDir + "data2.txt", file3 = pathDir + "result.txt";
        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(file1));

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int tmp;
        while (bfIn.available() > 0) {
            tmp = bfIn.read();
            // если не полбел и не новая строка
//            if (!Character.isWhitespace(tmp) && !Character.isSpaceChar(tmp)) {
//            }
                map.merge((tmp), 1, Integer::sum);
        }
//        map.forEach((k, v) -> System.out.println("[" + (char) Integer.parseInt(k.toString()) + "] " + v));
        ArrayList<Integer> listKey = new ArrayList<Integer>(map.keySet());
//        listKey.forEach(v -> System.out.print(v + " "));
        Collections.sort(listKey);
//        System.out.println();
//        listKey.forEach(v -> System.out.print(v + " "));
//        System.out.println();

        // Отсортировать результат по возрастанию кода ASCII (почитать в инете).
        // т.е. по коду полученного байта, 32 это пробел
        for (Integer item : listKey) {
//            System.out.println("[" + (char) Integer.parseInt(item.toString()) + "] " + map.get(item));
            System.out.println((char) Integer.parseInt(item.toString()) + " " + map.get(item));
        }

        bfIn.close();
    }
}
