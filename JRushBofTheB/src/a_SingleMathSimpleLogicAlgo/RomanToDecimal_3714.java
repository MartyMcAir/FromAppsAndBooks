package com.javarush.task.task37.task3714;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Древний Рим
*/
// https://javarush.ru/tasks/com.javarush.task.task37.task3714#discussion
// Амиго, привет! Я недавно увлекся историей вашей планеты и меня заинтересовал период Древнего Рима.
//Интересно тогда было жить, сплошные развлечения и вино! Или рабство, если не повезло со стартовой локацией...
//В общем, мне нужен метод romanToInteger, который будет конвертировать число в римской системе счисления
// {I, V, X, L, C, D, M} в десятичную. Иначе никак не разобрать что и когда у них происходило.
public class Solution {
    public static void main(String[] args) throws IOException {
//        origin();
//        withStringWriter();
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "I", "IV", "CM", "IX", "CD");
        for (String item : list)
            System.out.println("romanString is:" + item + ", in decimal: " + romanToInteger(item));
    }

    private static void origin() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        if (s == null || s.isEmpty() || !s.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"))
            return -1;

        final Matcher matcher = Pattern.compile("M|CM|D|CD|C|XC|L|XL|X|IX|V|IV|I").matcher(s);
        final int[] decimalValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int result = 0;

        while (matcher.find())
            for (int i = 0; i < romanNumerals.length; i++)
                if (romanNumerals[i].equals(matcher.group(0)))
                    result += decimalValues[i];

        return result;
    }

    public static int romanToIntegerV1_WrongNPE(String s) {
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        ht.put('i', 1);
        ht.put('x', 10);
        ht.put('c', 100);
        ht.put('m', 1000);
        ht.put('v', 5);
        ht.put('l', 50);
        ht.put('d', 500);

        int intNum = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int temp = ht.get(s.charAt(i));
            if (temp < prev)
                intNum -= temp;
            else
                intNum += temp;
            prev = temp;
        }
        return intNum;
    }

    // Смотрите, чтоб у вас проходило проверку на:
    //MMMM, IIXX, VIIV, MMCMM, CIIX, IXI, VIIII, IIII
    //  909 должно выглядеть так по правилам CMIX, но можно и так DCDIX
    // I = 1
    //V = 5
    //X = 10
    //L = 50
    //C = 100
    //D = 500
    //M = 1000
    //
    //IV = 4
    //IX = 9
    //XL = 40
    //XC = 90
    //CD = 400
    //CM = 900

    // https://stackoverflow.com/questions/9073150/converting-roman-numerals-to-decimal - Converting Roman Numerals To Decimal

    // http://graecolatini.bsu.by/htm-different/num-converter-roman.htm - Римские цифры и числа
    // https://www.kalkulaator.ee/ru/konverter-rimskix-i-arabskix-chisel - Конвертер римских и арабских чисел
}
