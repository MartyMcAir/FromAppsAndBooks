package a_SingleTusks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/
//https://javarush.ru/tasks/com.javarush.task.task08.task0823
//Написать программу, которая вводит с клавиатуры строку текста.
//        Программа заменяет в тексте первые буквы всех слов на заглавные.
//        Вывести результат на экран.
//
//        Пример ввода:
//        мама мыла раму.
//
//        Пример вывода:
//        Мама Мыла Раму.
//
//        Требования:
//        •	Программа должна выводить текст на экран.
//        •	Программа должна считывать строку с клавиатуры.
//        •	Класс Solution_3105 должен содержать один метод.
//        •	Программа должна заменять в тексте первые буквы всех слов на заглавные.
public class FirstLatterUpperCase_0823 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        // toLowerCase() - на всякий случай всё в нижн регистр
//        String s = " mother   washing    mashine ".trim().toLowerCase(); // .trim() убираем в начале и в конце пробелы

        //напишите тут ваш код
//        String[] arrS =  s.split(" "); // Разделяем строку на подстроки в массив строк
        String[] arrS =  s.trim().toLowerCase().split("[\\s]+");
        // регулярным выражением чтоб допускать между слов более одного пробела
        // или строку в массив байтов s.getBytes() -  после перебор массива ссравнением с байтами проблеа " "
        // с проверкой последовательности пробелов и уменьшением их до одого

//        System.out.println(Arrays.toString(arrS)); // [a, b, c]

        char[] arrCh, arrCh2;
        String tmpSt;
        char tmpCh;
        for(int i=0; i<arrS.length; i++){
            arrCh = arrS[i].toCharArray(); // строку в массив символов
            tmpCh = arrCh[0]; // a - первй элемнт массива символов т.е. первая буква строки
//            tmpSt = String.valueOf(tmpCh).toUpperCase(); // A - преобразуем в строку и в верхний регистр
            tmpSt = Character.toString(tmpCh).toUpperCase(); // A - тоже самое
            arrCh2 = tmpSt.toCharArray(); // строку в char массив

            arrCh[0]= arrCh2[0]; // Присваиваем первому элменету char массива измененный в верхн регистре
            arrS[i] = String.valueOf(arrCh); // Преобразуем в строку char array и присваиваем текущ элементу цикла
        }
//        System.out.println(Arrays.toString(arrS)); // [A, B, C]
        System.out.println(String.join(" ", arrS)); // A B C _ Массив строк в строку
        // _ или через цикл  используя конкатенацию или StringBuilder append()..
    }
}
