package com.javalesson.chapter1.task0;


import java.io.IOException;
import java.util.Scanner;

/**
 * Создайте программу, которая будет принимать две группы параметров:
 * - количество циклов выполнения программы;
 * - 3 числа a, b, n
 * и выводить на экран последовательность результатов вычисления следующего выражения
 * (a + 2^0*b),(a + 2^0*b + 2^1*b),(a + 2^0*b + 2^1*b + 2^2*b)..., (a+2^0*b + 2^1*b + 2^2*b +...+ 2^(n-1)*b)
 * где ^ обозначает возведение в степень, и эта операция выполняется до умножения.
 * <p>
 * Пример:
 * Please enter the number of iterations
 * 2
 * Enter the group of 3 numbers
 * 0 2 10
 * Output:
 * 2 6 14 30 62 126 254 510 1022 2046
 * Enter the group of 3 numbers
 * 5 3 5
 * Output:
 * 8 14 26 50 98
 * <p>
 * Пример:
 * a=5, b=3, n=5
 * (5+2^0*3)=8,(5+2^0*3 + 2^1*3)=14,(5+2^0*3 + 2^1*3 + 2^2*3)=26,(5+2^0*3 + 2^1*3 + 2^2*3 + 2^3*3)=50,
 * (5+2^0*3 + 2^1*3 + 2^2*3 + 2^3*3 + 2^4*3)=98
 */
public class LoopTask {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the number of iterations: ");
//        int num0 = sc.nextInt();
        int inter = 3;

        System.out.print("Enter the group of 3 numbers: ");
//        int num1 = sc.nextInt();
        int num1 = 5;
//        int num2 = sc.nextInt();
        int num2 = 3;
//        int num3 = sc.nextInt();
        int num3 = 5;

        num(num1, num2, num3, inter);
        sc.close();
    }

    public static void num(int a, int b, int n, int inter) {
        // задание не оч. понятное _ но увидев код стало ясно
        // a - это кол-во интераций и цифра степеней
        int accumulator = a;
        for (int i = 0; i < inter; i++) {
            for (int j = 0; j < n; j++) {
                // http://math-prosto.ru/?page=pages/stepeni/stepeni2.php
                // pow - возведение в степерь число умножается само на себя
                // степень раз
                int x = (int) Math.pow(2, j);
                accumulator = accumulator + x * b;
                System.out.print(accumulator + " ");
            }
            System.out.println();

        }
    }
}
