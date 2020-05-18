package a_SingleTusks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам
*/
// https://javarush.ru/tasks/com.javarush.task.task10.task1020
//Задача: ввести с клавиатуры 30 чисел. Вывести 10-е и 11-е минимальные числа.
//        Пояснение:
//        Самое минимальное число - 1-е минимальное.
//        Следующее минимальное после него - 2-е минимальное
//
//        Пример:
//        1 6 5 7 1 15 63 88
//        Первое минимальное - 1
//        Второе минимальное - 1
//        Третье минимальное - 5
//        Четвертое минимальное - 6
//
//        Требования:
//        •	Программа должна считывать данные с клавиатуры.
//        •	Программа должна выводить текст на экран.
//        •	Класс Solution_3105 должен содержать два метода.
//        •	Метод sort() должен сортировать массив элементов.
//        •	Метод main() должен вызывать метод sort().
//        •	Программа должна выводить 10-е и 11-е минимальные числа. Каждое значение с новой строки.
public class TenMinNumber_1020 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }
}
