package a_SingleTusks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/
// https://javarush.ru/tasks/com.javarush.task.task19.task1924
// 1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
//Например, 0 - "ноль", 1 - "один", 2 - "два"
//2. Считать с консоли имя файла, считать содержимое файла.
//3. Заменить все числа на слова используя словарь map.
//4. Результат вывести на экран.
//5. Закрыть потоки.
//
//Пример данных в файле:
//Это стоит 1 бакс, а вот это - 12 .
//Переменная имеет имя file1.
//110 - это число.
//
//Пример вывода в консоль:
//Это стоит один бакс, а вот это - двенадцать .
//Переменная имеет имя file1.
//110 - это число.
//
//Требования:
//•	Класс Solution_3105 должен содержать публичное статическое поле map типа Map<Integer, String>, которое должно быть сразу проинициализировано.
//•	Программа должна считывать имя файла с консоли (используй BufferedReader).
//•	BufferedReader для считывания данных с консоли должен быть закрыт.
//•	Программа должна считывать содержимое файла (используй FileReader).
//•	Поток чтения из файла (FileReader) должен быть закрыт.
//•	Программа должна выводить в консоль все строки из файла, но числа должны быть заменены на слова из словаря map.
//•	Класс Solution_3105 должен содержать статический блок, в котором добавляются в map тринадцать пар.
public class DigitToWord_1924 {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
//        String file1 = myPath()[0];

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bf.readLine();
        bf.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        while (fileReader.ready()) {
            String line[] = fileReader.readLine().split("\\s+");
            for (int i = 0; i < line.length; i++) {
                try {
                    if (map.containsKey(Integer.parseInt(line[i]))) {
                        line[i] = map.get(Integer.parseInt(line[i]));
                    }
                } catch (NumberFormatException e) {
                }
            }
            // выводим результ из (разсплиттиного) массива строк
            for (String s : line) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        fileReader.close();
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "file1.txt", dir
                + "file2.txt", dir
                + "file3.txt"};
    }
}
