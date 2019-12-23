package a_SingleTusks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/
// https://javarush.ru/tasks/com.javarush.task.task09.task0923
//Написать программу, которая вводит с клавиатуры строку текста.
//        Программа должна вывести на экран две строки:
//        1. первая строка содержит только гласные буквы из введённой строки.
//        2. вторая - только согласные буквы и знаки препинания из введённой строки.
//        Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.
//        Пример ввода:
//        Мама мыла раму.
//
//        Пример вывода:
//        а а ы а а у
//        М м м л р м .
//
//        Требования:
//        •	Программа должна считывать данные с клавиатуры.
//        •	Программа должна выводить две строки.
//        •	Первая строка должна содержать только гласные буквы из введенной строки, разделенные пробелом.
//        •	Вторая строка должна содержать только согласные и знаки препинания из введенной строки, разделенные пробелом.
//        •	Каждая строка должна заканчиваться пробелом.
public class VowelsConsonants_0923 {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String str = "           Мама мыла     раму.               "; //bf.readLine();
        String str = bf.readLine();

        String[] sss = str.trim().split("[\\s]+");
        String nS = String.join(" ", sss);
//        System.out.println(nS); // Мама, мыла. раму

        ArrayList<Character> consonantsList = new ArrayList<Character>();
        ArrayList<Character> vowelsList = new ArrayList<Character>();

        char[] arrCh = nS.toCharArray();
        char tmp;
        for (int i = 0; i < arrCh.length; i++) {
            tmp = arrCh[i];
            if (isVowel(tmp)) {
                vowelsList.add(tmp);
            }
            if (Character.toString(tmp).equals(" ")) {
                continue;
            }
            if (!isVowel(tmp)) {
                consonantsList.add(tmp);
            }
        }

        vowelsList.forEach((v) -> System.out.print(v + " "));
        System.out.println();
        consonantsList.forEach((c) -> System.out.print(c + " "));
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}