package com.javalesson.chapter1.task3;


import java.util.Scanner;

/**
 * Напишите программу которая  проверяет введенное с клавиатуры число и говорит
 * является ли данное число палиндромом.
 * Палиндром - это число которое читается одинаково и спереди назад и сзади наперед.
 * Примеры 12321, 45654, 787 и т.д.
 * <p>
 * Дополнительное условие: программа принимает только числа длинной 5 знаков.
 * В случае если было введено число длинной != 5, программа должна выполнить еще
 * одно прохождение цикла и попросить снова ввести значение с клавиатуры.
 * У данной задачи есть разные варианты решения.
 * 1) С помощью конвертации чисел в строки и обратно.
 * 2) Решение с помощью щю использования остатка от деления на 10.
 * <p>
 * Вам нужно выполнить задания двумя способами.
 */
public class PalindromeFinderTask {

    public static void main(String[] args) {
//        palindromeString();
        palindromeNumber();
    }

    public static void palindromeString() {
        Scanner sc = new Scanner(System.in);
        String num;
        while (true) {
            System.out.println("Enter your number (5 digit): ");
            num = sc.nextLine();
            if (num.length() != 5) {
                System.out.println("your number do not have 5 digits.. enter again..");
            } else {
                break;
            }
        }
        sc.close();
        if (num.equals(new StringBuilder(num).reverse().toString())) {
            System.out.println("Your number: " + num + ", is palindrome!");
        } else {
            System.out.println("Your number: " + num + ", is NOT palindrome!");
        }
    }

    public static void palindromeNumber() {
        Scanner sc = new Scanner(System.in);
        String num;
        while (true) {
            System.out.println("Enter your number (5 digit): ");
            num = sc.nextLine();
            if (num.length() != 5) {
                System.out.println("your number do not have 5 digits.. enter again..");
            } else {
                break;
            }
        }
        sc.close();
        // с этим _ посложнее (вообще не математик), так что скопипастил
        int originalInt = Integer.parseInt(num);
        int reversedInt = 0;
        int tmp = originalInt;
        while (tmp > 0) {
//            Делим оригинальное значение на 10 и остаток от деления сохраняем в переменную rest.
            int rest = tmp % 10;
//            Домножаем  reversedInt полученый в предыдущей итерации на 10 и добавояем остаток
//            от деления полученый в текущем круге.
            reversedInt = reversedInt * 10 + rest;
//            Делим tmp на 10 для того чтобы перейти на следущую итерацию избавившись от младшего разряда.
            tmp = tmp / 10;
        }
//            Сравниваем оригинальное число с результатом.
        if (originalInt == reversedInt) {
            System.out.println(originalInt + " is palindrome");
        } else {
            System.out.println(originalInt + " is not palindrome");
        }
    }
}
