package a_SingleTusks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/
// https://javarush.ru/tasks/com.javarush.task.task15.task1519
//1. Считать с консоли данные, пока не введено слово "exit".
//        2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
//        2.1. содержит точку '.', то вызвать метод print для Double;
//        2.2. больше нуля, но меньше 128, то вызвать метод print для short;
//        2.3. меньше либо равно нулю или больше либо равно 128, то вызвать метод print для Integer;
//        2.4. иначе, вызвать метод print для String.
//
//
//
//        Требования:
//        •	Программа должна считывать данные с клавиатуры.
//        •	Программа должна прекращать считывать данные с клавиатуры после того, как была введена строка "exit".
//        •	Если введенная строка содержит точку(".") и может быть корректно преобразована в число типа Double - должен быть вызван метод print(Double value).
//        •	Если введенная строка может быть корректно преобразована в число типа short и полученное число больше 0, но меньше 128 - должен быть вызван метод print(short value).
//        •	Если введенная строка может быть корректно преобразована в число типа Integer и полученное число меньше или равно 0 или больше или равно 128 - должен быть вызван метод print(Integer value).
//        •	Во всех остальных случаях должен быть вызван метод print(String value).
public class DetermineNumbers_1519 {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] arrStr = {'a','b','c','d',};
        String tmp;
        int tmpInt;
        while (true) {
            tmp = reader.readLine();
            if (!tmp.trim().equalsIgnoreCase("exit")) {
                try {
                    if (tmp.contains(".")) { // NumberFormatException
                        print(Double.parseDouble(tmp));
                    } else {
                        tmpInt = Integer.parseInt(tmp);
                        if (tmpInt > 0 & tmpInt < 128) {
                            print(Short.parseShort(tmp));
                        }
                        if (tmpInt <= 0 | tmpInt >= 128) { // NumberFormatException
                            print(Integer.parseInt(tmp));
                        }
                    }
                } catch (Exception e) {
//                    e.printStackTrace();
                    print(tmp);
                }
            } else {
                break;
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
