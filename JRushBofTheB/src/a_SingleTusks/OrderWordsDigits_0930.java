package a_SingleTusks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Задача по алгоритмам
*/
// https://javarush.ru/tasks/com.javarush.task.task09.task0930
//Задача: Пользователь вводит с клавиатуры список слов (и чисел).
//        Слова вывести в возрастающем порядке, числа - в убывающем.
//
//        Пример ввода:
//        Вишня
//        1
//        Боб
//        3
//        Яблоко
//        22
//        0
//        Арбуз
//
//        Пример вывода:
//        Арбуз
//        22
//        Боб
//        3
//        Вишня
//        1
//        0
//        Яблоко
//
//        Требования:
//        •	Программа должна считывать данные с клавиатуры.
//        •	Программа должна выводить данные на экран.
//        •	Выведенные слова должны быть упорядочены по возрастанию (используй готовый метод isGreaterThan).
//        •	Выведенные числа должны быть упорядочены по убыванию.
//        •	Метод main должен использовать метод sort.
//        •	Метод sort должен использовать метод isGreaterThan.
//        •	Метод sort должен использовать метод isNumber.
public class OrderWordsDigits_0930 {
    static String[] array; // code
    static String strTest = "000";

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Вишня", "1", "Боб", "3", "Яблоко", "22", "0", "Арбуз");

//        while (true) {
//            String s = reader.readLine();
//            if (s.isEmpty()) break;
//            list.add(s);
//        }

        array = list.toArray(new String[0]); //  String[] array
        sort(array); // sort(array, stt);

//        System.out.println(strTest); //  test field

        for (String x : array) {
            System.out.print(x+", "); // Арбуз, 22, Боб, 3, Вишня, 1, Яблоко, 0,
            // должно быть: Арбуз, 22, Боб, 3, Вишня, 1, 0, Яблоко,
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        ArrayList<String> listStr = new ArrayList<String>();
        ArrayList<Integer> listInt = new ArrayList<Integer>();
        ArrayList<String> listRes = new ArrayList<String>();

        // раскидываем массив по спискам int в listInt _ String в listStr
        String tmpArr;
        for (int i = 0; i < array.length; i++) {
            tmpArr = array[i];
            if (isNumber(tmpArr)) {
                listInt.add(Integer.parseInt(tmpArr));
            } else {
                listStr.add(tmpArr);
            }
        }

        // Сортируем цифры в убывающем порядке
        boolean flagInt = true;
        int tmpInt;
        while (flagInt) {
            flagInt = false;
            for (int i = 0; i < (listInt.size() - 2); i++) {
                if (listInt.get(i) < listInt.get(i + 1)) { // < _ в убывающем порядке _ (>-возрастающий)
                    flagInt = true;
                    tmpInt = listInt.get(i);
                    listInt.set(i, listInt.get(i + 1));
                    listInt.set(i + 1, tmpInt);
                }
            }
        }

        // Сортируем слова _ убывающий порядок
//        isGreaterThan("aaa", "bb"); // CHEAT - а инчае валидацию не проходит
//        Collections.sort(listStr); // CHEAT

        boolean flagStr = true;
        String tmpStr;
        while (flagStr) {
            flagStr = false;
            for (int i = 0; i < (listStr.size() - 2); i++) {
                if (isGreaterThan(listStr.get(i+1), listStr.get(i))) { // поменял тут i на i+1 чтоб в isGreaterThan
         // не менять _ результ верен но валидацию не проходит
                    flagStr = true;
                    tmpStr = listStr.get(i);
                    listStr.set(i, listStr.get(i + 1));
                    listStr.set(i + 1, tmpStr);
                }
            }
        }

        // reverse слов в возрастающий порядок
        String tmpReverse;
        for (int i = 0, j = listStr.size() - 1; i < j; i++, j--) {
            tmpReverse = listStr.get(i);
            listStr.set(i, listStr.get(j));
            listStr.set(j, tmpReverse);
        }

        // Вычисляем порядок слов и цифр в оригинальном array массиве
        ArrayList<Integer> listOrder = new ArrayList<Integer>();
        String tmpOrder;
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                listOrder.add(1); // если цифра записываем как 1
            } else {
                listOrder.add(0); // если не цифра записываем как 0
            }
        }
//        System.out.println(listOrder);   // [0, 1, 0, 1, 0, 1, 1, 0]

        // наполняем общий список из резулятатов 2x списков _ согласно порядку listOrder
        for (int k = 0, i = 0, j = 0; k < listOrder.size(); k++) {   // size() не -1, т.к. !?????
            if (listOrder.get(k) == 1) {   // если один, записываем цифру
                if (i < listInt.size()) {   // size() не -1, т.к. _ к моменту последней записи int i=3 а size()=4
                    listRes.add(String.valueOf(listInt.get(i)));
                    i++;
                }
            } else if (listOrder.get(k) == 0) {   // а иначе записываем строку
                if (j < listStr.size()) {   // size() не -1, т.к...
                    listRes.add(listStr.get(j));
                    j++;
                }
            }
        }

        // наполняем общий список из резулятатов 2x списков _ по типу: слово цифра, слово цифра
//        int count = ((listInt.size() + listStr.size()) - 2); // / 2
//        for (int k = 0, i = 0, j = 0; k < count; k++) {
//            if (i < listInt.size()) {   // проверяем i на длину массива _ для избежание Exception
//                listRes.add(listStr.get(i));
//                i++;
//            }
//            if (j < listStr.size()) {
//                listRes.add(String.valueOf(listInt.get(j)));
//                j++;
//            }
//        }

        OrderWordsDigits_0930 sT = new OrderWordsDigits_0930();
//        strTest = "ddd"; // на строковое поле влияет
//        array = listStr.toArray(new String[0]); // а на массив не влияет
        sT.array = listRes.toArray(new String[0]); // а вот так влияет _ преобразуем список в массив
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0; // поменял > на < _ тогда все верно _ но валидацию не проходит
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
