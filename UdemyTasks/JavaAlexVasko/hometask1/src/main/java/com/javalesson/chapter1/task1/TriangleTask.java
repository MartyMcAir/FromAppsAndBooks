package com.javalesson.chapter1.task1;

import java.util.Scanner;

/**
 * Напишите программу которая принимает 3 числовых значения и проверяет, могут ли они быть
 * сторонами треугольника.
 * Для ввода значений с консоли Вам понадобится класс Scanner.
 * <code>Scanner scanner = new Scanner(System.in);</code>
 * <code>scanner.nextInt();</code>
 */
public class TriangleTask {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n1 = sc.nextInt();
//        int n2 = sc.nextInt();
//        int n3 = sc.nextInt();
        sc.close();
        int n1 = 3, n2 = 3, n3;
    }

    public static void checkRictangle(int n1, int n2, int n3) {
        // не понял задание
        // https://ru.onlinemschool.com/math/formula/triangle/
        if (n1 == 0 | n2 == 0 | n3 == 0) {
            System.out.println("Это не треугольник, у трейгольника нет 0-вой стороны");
        }

        if (n1 == n2 && n2 == n3) {
            System.out.println("Равносторонний треугольник: все стороны равны. (углы по 60%)" +
                    "_ и углы острые т.к. угол меньше 90% считается острым");
        } else if (n1 == n2 | n2 == n3) {
            System.out.println("Равнобедренный треугольник: две стороны равны");
        }

    }
}
