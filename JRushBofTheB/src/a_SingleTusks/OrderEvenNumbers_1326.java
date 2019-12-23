package a_SingleTusks;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
// https://javarush.ru/tasks/com.javarush.task.task13.task1326
//1. Ввести имя файла с консоли.
//        2. Прочитать из него набор чисел.
//        3. Вывести на консоль только четные, отсортированные по возрастанию.
//
//        Пример ввода:
//        5
//        8
//        -2
//        11
//        3
//        -5
//        2
//        10
//
//        Пример вывода:
//        -2
//        2
//        8
//        10
//
//        Требования:
//        •	Программа должна считывать данные с консоли.
//        •	Программа должна создавать FileInputStream для введенной с консоли строки.
//        •	Программа должна выводить данные на экран.
//        •	Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
//        •	Программа должна закрывать поток чтения из файла(FileInputStream).
public class OrderEvenNumbers_1326 {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String filePath= bf.readLine();
//        String st = "C:\\z_n\\new_test_folder\\file_name.txt";

        ArrayList<Integer> listEven = new ArrayList<Integer>();
        try(BufferedReader bf2 = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))){
            String line;
            int tmp;
            while((line=bf2.readLine())!=null){
                tmp =Integer.parseInt(line.trim());
                if((Math.abs(tmp)%2)==0){
                    listEven.add(tmp);
                }
            }
        }
        Collections.sort(listEven);
        listEven.forEach((v)->System.out.println(v));
    }

    // возвращает абсолютную величину числа т.е. независимую от знака - или +
    public static int abs(int a){ // (Math.abs(tmp)
        if(a<0){
            a=-a;
        } else{
            a=a;
        }
        return a;
    }
}




