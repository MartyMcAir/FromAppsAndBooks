package a_SingleMathSimpleLogicAlgo;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
isPowerOfThree                                                                                                                                                      
*/
// https://javarush.ru/tasks/com.javarush.task.task39.task3910#discussion
//Исправь ошибку в методе isPowerOfThree(int n), он должен возвращать true,
// если n является целочисленной степенью числа 3. Иначе - false.
public class MathPowLogarifm_3910 {
    public static void main(String[] args) {
        int num1 = 9, num2 = 728;
        // вариант с делением на числа на нужную стпень т.е. 3 и = выявление остатка..
        System.out.println(num1 + " isPowerOfThree: " + isPowerOfThree(num1));
        System.out.println(num2 + " isPowerOfThree: " + isPowerOfThree(num2));

        // вариант с исользованием логарифмов
        System.out.println(num1 + " isPowerOfThreeNotMyV1: " + isPowerOfThreeNotMyV1(num1));
        System.out.println(num2 + " isPowerOfThreeNotMyV1: " + isPowerOfThreeNotMyV1(num2));

        // вариант через остаток от деления % _ неверное решение для 729ти
        System.out.println(num1 + " isPowerOfThreeNotMyV2: " + isPowerOfThreeNotMyV2(num1));
        System.out.println(num2 + " isPowerOfThreeNotMyV2: " + isPowerOfThreeNotMyV2(num2));

        System.out.println(num1 + " getThreePowMy: " + getThreePowMy(num1));
        System.out.println(num2 + " getThreePowMy: " + getThreePowMy(num2));

        // pow - раз..  numberIs * numberIs * numberIs =..
        int pow = 3;
        int numberIs = 9;
        // через самый простой подбор возведение в степень 3 в цикле
        // до близкого к искомому _ слишком затратный способ
        System.out.println("Math.pow: " + Math.pow(numberIs, pow));
        System.out.println("Math.pow: " + Math.pow(3, 3)); // = 27
        System.out.println("Math.pow: " + Math.pow(2, 3)); // 8
        System.out.println("Math.pow: " + Math.pow(2.0801, 3)); // 9.000209982400998
    }

    // возвращать true, если n является целочисленной степенью числа 3. Иначе - false.
    public static boolean isPowerOfThree(int n) {
        if (n < 0 || n == 0) return false;
        if (n == 1) return true;
        double d = n;
        // когда число больше или равно трем
        while (d >= 3)
            d /= 3; // делим на 3 и по новой
        // отправляем true если остаток от таких манипуляций == 1
        return d == 1 ? true : false;
    }

    // цело численная степень числа 3, это означает
    // что это число можно поделить на 3 без остатка? т.е. 9 в 3ей степени это 729
    // и на входе допустим получаем 729, а значит что бы понять является ли 729
    // 729 целочисленной степенью тройки
    // (т.е. делится он и всего его результы на 3 без остатка)
    public static boolean isPowerOfThreeMy(int n) {
        //if (n % 3 == 0) {                                                                                                    
//        if (n == getThreeMy(n)) {
//            return true;
//        }
        return false;
    }

    // пытаемся получить число 729, из чисел в цикле возведенных в 3ью степень
    public static boolean getThreePowMy(int numberIsNeed) {
        double res = 0;

        // возводим в степень тройки числа пока не получим искомое число
        // или близкое к искомому
        for (int i = 2; res <= numberIsNeed; i++) {
            res = Math.pow(3, i);
        }

        System.out.println("res: " + res);

        // если результ на вызоде полностью соответствует искомому..
        if (res == numberIsNeed) return true;
        return false;
    }

    // from https://javarush.ru/help/40270
    public static boolean isPowerOfThreeNotMyV2(int n) {
        if (n == 0) return false;

        while (n > 1) {
            if (n % 3 == 1) return false;
            else n /= 3;
        }
        return true;
    }

    // from https://javarush.ru/help/14597
    //задача решается,используя свойство логарифмов
    //x = log3(9) - логарифм 9 по основанию 3
    //Это означет, что X - это степень в которую нужно возвести 3,
    //чтобы получить 9. Можно записать 3^X = 9
    //Известно, что log3(9) = log(9) / log(3) - свойство логарифмов
    //При вычислении может получиться результат 1.999999 вместо 2
    //Тогда прибавим маленькое число 0.000001, чтобы получить 2,0000999
    //потом откинем дробную часть 2 и сравним с 2,0000999
    //Может получиться такое выражение 1,000001 + 0.000001 = 1,000002
    //Тогда 1 - 1,000002 = -0,000002, что меньше 0, поэтому проверяем по модулю
    public static boolean isPowerOfThreeNotMyV1(int n) {
        if (n == 0 | (n < 1)) return false;
        else if (n == 1) return true;

        double result = Math.log(n) / Math.log(3);
        int whole = (int) (result + 0.000001);
        result = result + 0.000001;
        result = Math.abs(whole - result);
        result = BigDecimal.valueOf(result).

                setScale(6, RoundingMode.HALF_EVEN).
                doubleValue();
        return result <= 0.000001; //разница болжна быть минимальна
    }

}