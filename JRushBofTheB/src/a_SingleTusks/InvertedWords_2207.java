package a_SingleTusks;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
// https://javarush.ru/tasks/com.javarush.task.task22.task2207
// В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
//Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
//Использовать StringBuilder.
//Кодировка файла - UTF-8.
//
//Пример содержимого файла
//рот тор торт о
//о тот тот тот
//
//Вывод:
//рот тор
//о о
//тот тот
//
//Требования:
//•	Метод main должен считывать имя файла с клавиатуры.
//•	В методе main должен быть использован StringBuilder.
//•	В классе Solution должен содержаться вложенный класс Pair с методами equals, hashCode и toString. Удалять или изменять эти методы нельзя.
//•	В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
//•	Список result должен быть заполнен корректными парами согласно условию задачи.

// понял что требуетя благодаря коду from
// https://github.com/critick86/JavaRushTasks/blob/master/task2207/Solution.java
public class InvertedWords_2207 {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // взято от сюда: https://javarush.ru/help/24317
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
//        String fileName = getPath()[0];
//        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),
//                Charset.forName("cp1251")));
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        consoleReader.close();
        ArrayList<String> words = new ArrayList<>();
        while (fileReader.ready()) {
            String s = fileReader.readLine();
            String arrS[] = s.split("(\\s|\\r|\\n)+");
            for (int i = 0; i < arrS.length; i++) {
                words.add(arrS[i]);
            }
        }
        fileReader.close();

        // Читаем строки файла, перегоняем всё в список слов (с помощью split() а из массива в список),
        // перебираем список -> если список содержит reverse().toString() - текущего слова,
        // то Pair.first = текущее слово, а Pair.second = его реверс ___ добавленные слова удаляем.

        while (words.size() > 0) { // т.е. выборка по одному слову
            StringBuilder word = new StringBuilder(words.get(0));
            StringBuilder wordR = new StringBuilder(word.toString());
            wordR.reverse();
            words.remove(0); // удаляя нулевой список смещается на один и так далее..
            if (words.contains(wordR.toString())) {
                Pair pair = new Pair();
                pair.first = word.toString();
                pair.second = wordR.toString();
                result.add(pair);
                words.remove(wordR.toString());
            }
        }
//        myResoldedV1();
        System.out.println(result);
        result.forEach(v -> System.out.println(v));
    }

    public static void myResoldedV1() throws IOException {
        // моё решение тоже работает но пустые строки не пропускает а валид _ надо чтоб пропускал
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//        String file_name = bfr.readLine();
        String file_name = getPath()[2];
        bfr.close();

        BufferedReader bfr2 = new BufferedReader(new FileReader(file_name));
//        BufferedReader bfr2 = new BufferedReader(new FileReader(file_name, Charset.forName("cp1251")));
        StringBuilder sb = new StringBuilder();
        while (bfr2.ready()) {
            String tmp = bfr2.readLine().trim();
            sb.append(tmp + " ");
        }
        bfr2.close();

        String[] arrStr = sb.toString().split(("\\s+"));   // создали массив слов
        List<String> list = new ArrayList<>(Arrays.asList(arrStr)); // преобазовали в список

        String current = "", next = "";
        for (int i = 0; i < list.size(); i++) {
            current = list.get(i);
            list.remove(i);
            for (int j = 0; j < list.size(); j++) {
                next = list.get(j);
                if (current.equals(new StringBuilder(next).reverse().toString())) {
                    Pair p = new Pair(current, next);
                    result.add(p);
                    list.remove(j);
                }
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }

    }

    public static String[] getPath() {
        String sep = File.separator;
        String folder = "C:" + sep + "z_n" + sep + "new_test_folder" + sep + "1" + sep;
        String[] arr = new String[]{folder + "data.txt", folder + "data2.txt", folder + "data3.txt"};
        return arr;
    }

}
