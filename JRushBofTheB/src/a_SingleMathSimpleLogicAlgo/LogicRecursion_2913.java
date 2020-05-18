package a_SingleMathSimpleLogicAlgo;

import java.util.Random;

/* 
Замена рекурсии
*/
// В программе случайным образом генерируются два целых числа A и В в диапазоне от 0 (включая) до 1000 (не включая).
// Нужно вывести все целые числа от A до B включительно, в порядке возрастания, если A меньше B, или в порядке
// убывания в противном случае.
//
// Задача реализована с использованием рекурсии.
// Иногда в результате работы программы получаем Exception in thread "main" java.lang.StackOverflowError.
//Твоя задача: перепиши код без использования рекурсии.
//Метод recursion() переименуй на getAllNumbersBetween().

// https://javarush.ru/tasks/com.javarush.task.task29.task2913#discussion
// решил сам _ просто интересная задачка
public class LogicRecursion_2913 {
    private static int numberA;
    private static int numberB;

    //    public static String recursion(int a, int b) {
//        if (a > b) { // конкатенируется в строку + " "
    // возвращает результ из след. рекурсии и отнимает -1 от a,
    // таким образом выводится от 30 до 20 ___ (30 29 28 27 26 25 24 23 22 21 20)
//            return a + " " + recursion(a - 1, b);
//        } else {  // все это время a > b и след условие и есть,
//            if (a == b) { // момент остановы рекурсии на 20-ке
//                return Integer.toString(a);
//            } // во всех остальных случаях ___ (20 21 22 23 24 25 26 27 28 29 30)
//            return a + " " + recursion(a + 1, b);
//        }
//    }

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder sb = new StringBuilder();
        if (a > b) {
            while (a >= b) {
                sb.append(a--).append(" ");
            }
        } else if (a == b) { // на случай если в условии потребуется
            sb.append(a);
//        } else if (a < b) {
        } else {
            while (a <= b) {
                sb.append(a++).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
//        numberA = 30;
//        numberB = 20;
        // 2 запуска, для перестановки параметров отправленных в рекурсию
        System.out.println(getAllNumbersBetween(numberA, numberB));
//        System.out.println("___");
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }

}