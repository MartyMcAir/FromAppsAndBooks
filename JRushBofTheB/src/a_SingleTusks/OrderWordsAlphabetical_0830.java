package a_SingleTusks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам
*/
// https://javarush.ru/tasks/com.javarush.task.task08.task0830
//Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
//        Каждое слово - с новой строки.
//
//        Требования:
//        •	Программа должна выводить текст на экран.
//        •	Программа должна считывать значения с клавиатуры.
//        •	Класс Solution_3105 должен содержать три метода.
//        •	Метод main() должен вызывать метод sort().
//        •	Метод sort() должен вызывать метод isGreaterThan().
//        •	Выведенные слова должны быть отсортированы в алфавитном порядке.
public class OrderWordsAlphabetical_0830 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
//        String[] array = {"angular", "building", "ceil"};
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }
        sort(array);
        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        String tmp;
        int k = array.length - 2;
        boolean is_swap = false;
        for (int i = 0; i <= k; i++) {
            is_swap = false;
            for (int j = k; j >= i; j--) {
                if (isGreaterThan(array[j], array[j + 1])) {
                    tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    is_swap = true;
                }
            }
            // Если перестановок не было, то выходим
            if (is_swap == false) break;
        }

//        String current, beafore, after;
//        for (int j = 0; j < array.length; j++) {
//            for (int i = 1; i < array.length - 1; i++) {
//                beafore = array[i - 1];
//                current = array[i];
////                after = array[i + 1];
//                // current _ before
////                if (isGreaterThan(current.substring(0).toLowerCase(), beafore.substring(0).toLowerCase())) { // [d, d, c, c, b, b, a, a]
////                    array[i - 1] = current;
////                    array[i] = beafore;
////                }
//                if (!isGreaterThan(current.substring(0).toLowerCase(), beafore.substring(0).toLowerCase())) { // [a, b, b, c, c, d, d, a]
//                    array[i - 1] = current;
//                    array[i] = beafore;
//                }
//
//                // beafore _ current
////                if (!isGreaterThan(beafore.toLowerCase(), current.toLowerCase())) { // [d, d, c, c, b, b, a, a]
////                    array[i] = beafore;
////                    array[i-1] = current;
////                }
////                if (isGreaterThan(beafore.toLowerCase(), current.toLowerCase())) { // [a, b, b, c, c, d, d, a]
////                    array[i] = beafore;
////                    array[i - 1] = current;
////                }
//            }
//        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
