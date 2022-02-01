package a_SingleMathSimpleLogicAlgo;

import z_Thread_BiG_Pack.T_PhaserPlantZombie_2809.Character;

import java.util.HashMap;
import java.util.Map;

/*
Возможен ли палиндром?
*/
// Реализуй метод isPalindromePermutation(String s) который будет возвращать true, если из всех символов строки s
// можно составить палиндром. Иначе - false.
//
//Символы в анализируемой строке ограничены кодировкой ASCII.
//Регистр букв не учитывается.

// https://javarush.ru/tasks/com.javarush.task.task39.task3908#discussion
public class PalindromASCII_3908 {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("wqewe"));
        System.out.println(isPalindromePermutation("tot"));

        String s = "аваZ";
        StringBuilder leftTORight = new StringBuilder();
        s.chars(). // символы строки
                // фильтруем символы оставив только буквы и цифры
                        filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase) // полученное в нижний регистр
                .forEach(leftTORight::appendCodePoint); // сохраняем в StringBuilder
        System.out.println(leftTORight);
    }

    public static boolean isPalindromePermutation(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        Map<Character, Integer> stats = new HashMap<>();
        for (char c : s.toLowerCase().toCharArray()) {
            if (stats.containsKey(c)) {
                stats.put(c, stats.get(c) + 1);
            } else {
                stats.put(c, 1);
            }
        }

        if (s.length() % 2 == 0) {
            for (int i : stats.values()) {
                if (i % 2 != 0) {
                    return false;
                }
            }
            return true;
        } else {
            boolean wasOddNumber = false;
            for (int i : stats.values()) {
                if (i % 2 != 0) {
                    if (wasOddNumber) {
                        return false;
                    }
                    wasOddNumber = true;
                }
            }
            return wasOddNumber;
        }
    }



    public static boolean isPalindromePermutationV2(String s) {
        if (s == null || s.isEmpty()) return false;
        char[] chars = s.toUpperCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }

        boolean wasOdd = false;
        for (Integer integer : map.values()) {
            if (chars.length % 2 == 0) {
                if (integer % 2 != 0) return false;
            } else {
                if (integer % 2 != 0) {
                    if (wasOdd) return false;
                    wasOdd = true;
                }
            }
        }
        return true;
    }
}
