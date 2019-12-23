package a_SingleMathSimpleLogicAlgo;


/* 
Как-то средненько
*/

import java.util.Scanner;
// https://javarush.ru/tasks/com.javarush.task.task04.task0441
// Ввести с клавиатуры три числа, вывести на экран среднее из них.
//Т.е. не самое большое и не самое маленькое.
//Если все числа равны, вывести любое из них.
//
//Требования:
//•	Программа должна считывать числа c клавиатуры.
//•	Программа должна выводить число на экран.
//•	Программа должна выводить среднее из трех чисел.
//•	Если все числа равны, вывести любое из них.
//•	Если два числа из трех равны, вывести любое из двух.
public class LogicMidleNumber_0441 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int res = 0, n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        if (n1 == n2 && n1 == n3) {
            res = n1;
        } else if (n1 == n2 && n1 != n3) {
            res = n2;
        } else if (n2 == n3 && n2 != n1) {
            res = n3;
        } else if (n3 == n1 && n3 != n2) {
            res = n3;
        } else if (maxIs(n1, n2, n3) == n1 && minIs(n1, n2, n3) == n2) {
            res = n3;
        } else if (maxIs(n1, n2, n3) == n2 && minIs(n1, n2, n3) == n1) {
            res = n3;
        } else if (maxIs(n1, n2, n3) == n2 && minIs(n1, n2, n3) == n3) {
            res = n1;
        } else if (maxIs(n1, n2, n3) == n3 && minIs(n1, n2, n3) == n2) {
            res = n1;
        } else if (maxIs(n1, n2, n3) == n3 && minIs(n1, n2, n3) == n1) {
            res = n2;
        } else if (maxIs(n1, n2, n3) == n1 && minIs(n1, n2, n3) == n3) {
            res = n2;
        }
        System.out.println(res);
    }

    public static int maxIs(int a, int b, int c) {
        int res = 0;
        if (a > b && a > c) {
            res = a;
        } else if (b > c && b > a) {
            res = b;
        } else if (c > a && c > b) {
            res = c;
        }
//        int max = a >= b && a >= c && a >= d ? a : (b >= a && b >= c && b >= d ? b : (c >= a && c >= b && c >= d ? c : d));
//        System.out.println(max); // тернарный
//        System.out.println("количество дней в году: " +
//                (i % 4 == 0 ? i % 100 == 0 ? i % 400 == 0 ? "366" : "365" : "366" : "365"));
        return res;
    }

    public static int minIs(int a, int b, int c) {
        int res = 0;
        if (a < b && a < c) {
            res = a;
        } else if (b < c && b < a) {
            res = b;
        } else if (c < a && c < b) {
            res = c;
        }
//        res = (a < b && a < c) ? (b < c && b < a) ? a : b : c; // работает не корректно
        return res;
    }


}
