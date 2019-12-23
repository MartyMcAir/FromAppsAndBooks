package a_SingleTusks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/
// https://javarush.ru/tasks/com.javarush.task.task07.task0712
//1. Создай список строк.
//        2. Добавь в него 10 строчек с клавиатуры.
//        3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
//        Если таких строк несколько, то должны быть учтены самые первые из них.
//        4. Выведи на экран строку из п.3. Должна быть выведена одна строка.
//
//        Требования:
//        •	Объяви переменную типа список строк и сразу проинициализируй ee.
//        •	Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
//        •	Программа должна выводить на экран самую короткую строку, если она была раньше самой длинной.
//        •	Программа должна выводить на экран самую длинную строку, если она была раньше самой короткой.
//        •	Должна быть выведена только одна строка.
public class ShortLongString_0712 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            list.add(bf.readLine());
        }

        String min = list.get(0), max = list.get(0), tmp, res = "";
        for (String item : list) {
            tmp = item;
            if (max.length() < tmp.length()) {
                max = tmp;
            } else if (min.length() > tmp.length()) {
                min = tmp;
            }
        }

        for(int i =0; i<list.size(); i++){
            tmp =list.get(i);
            if(list.get(i).length()==max.length()){
                System.out.println(tmp);
                break;
            } else if(list.get(i).length()==min.length()){
                System.out.println(tmp);
                break;
            }
        }

//        int minInt = list.indexOf(min); // получаем индекс по слову _ опочемуто не срабатывает т.е. чтот нето с индексацией
//        int maxInt = list.indexOf(max);  // ни как в массиве
//
//        if (minInt < maxInt) {
//            res = list.get(minInt);
//        } else if (maxInt < minInt) {
//            res = list.get(maxInt);
//        }
//
//        System.out.println("res: " + res +
//                "" + "\n minInt: " + list.get(minInt) + " _  maxInt: " + list.get(minInt) +
//                "\n index minInt: " + minInt + " maxInt: " + maxInt);
    }
}
