package a_SingleMathSimpleLogicAlgo;

/* 
Ближайшее к 10
*/
// https://javarush.ru/tasks/com.javarush.task.task04.task0409
// Напишите метод displayClosestToTen. Метод должен выводить на экран ближайшее к 10 из двух чисел, записанных в аргументах метода.
//Например, среди чисел 8 и 11 ближайшее к десяти 11. Если оба числа на равной длине к 10, то вывести на экран любое из них.
//
//Подсказка:
//используйте метод public static int abs(int a), который возвращает абсолютную величину числа.
//
//Требования:
//•	Программа должна выводить числа на экран.
//•	Метод main не должен вызывать System.out.println() или System.out.print().
//•	Метод main должен вызывать метод displayClosestToTen.
//•	Метод displayClosestToTen должен вызывать метод abs.
//•	Метод displayClosestToTen должен выводить число на экран согласно заданию.
public class MathNearestNumber_0409 {
    public static void main(String[] args) {
        displayClosestToTen(8, 11);
        displayClosestToTen(7, 14);
    }

    public static void displayClosestToTen(int a, int b) {
        int res = 0, tmpA, tmpB;
        tmpA = 10 - a;
        tmpB = 10 - b;
        if (abs(tmpA) < abs(tmpB)) {
            res = a;
        } else {
            res = b;
        }
        System.out.println(res);
    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    static int abs2(int a) {
        if (a < 0) return a * -1;
        else return a;
    }
}