package a_SingleMathSimpleLogicAlgo;

/* 
Сортировка трех чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
// https://javarush.ru/tasks/com.javarush.task.task04.task0420
// Ввести с клавиатуры три числа, и вывести их в порядке убывания.
//Выведенные числа должны быть разделены пробелом.
//
//Требования:
//•	Программа должна считывать числа c клавиатуры.
//•	Программа должна выводить числа на экран.
//•	Программа должна выводить три числа разделенных пробелами.
//•	Программа должна выводить числа в порядке убывания.
public class LogicSortNumbers_0420 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer[] arr = new Integer[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr)); // 2 3 7

        Arrays.sort(arr, Collections.reverseOrder());
        // System.out.println(Arrays.toString(arr)); // 7 3 2
/*        for (int i = 0; i < 3; i++) {
            System.out.print(arr[i] + " ");
        }*/

// можно без обратной сортировки вывести массив просто в обратномпорядке через цикл
        // без reverseOrder()
        for (int i = 2; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
