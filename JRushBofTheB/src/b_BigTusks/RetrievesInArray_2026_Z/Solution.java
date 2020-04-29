package b_BigTusks.RetrievesInArray_2026_Z;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Алгоритмы-прямоугольники
*/
// https://javarush.ru/tasks/com.javarush.task.task20.task2026#discussion
public class Solution {
//    Я смотрю используются разные алгоритмы. Расскажу свой.
//    Простым перебором массива нахожу первое вхождение единицы - это соответственно начальная точка start[i][j].
//    Потом с помощью j++ нахожу докуда идет квадрат (крайнюю правую верхнюю единицу), потом с помощью i++ нахожу
//    правую нижнюю точку квадрата, которая имеет значение end [i][j]. Count++, удаляю квадрат из матрицы заполнив
//    его нолями и начинаю все сначала. Если вхождений единицы больше нет, то return count.
//    Может кому то поможет.

    // map'a индексов главного массива, у каждого индекса map'ы свой ArrayList Rectangl'ов
    // это для того что бы зная индекс глв массива, сделав от индекса-1 получить все найденные предыдущего
    // и сравнить их
    private static LinkedHashMap<Integer, ArrayList<Rectangle>> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0}, // 0
                {1, 1, 0, 0}, // 1
                {1, 1, 0, 0}, // 2
                {1, 1, 0, 1}  // 3
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        byte[][] a3 = new byte[][]{
                {1, 1, 0, 0, 0}, // 0
                {1, 1, 0, 0, 0} // 1
        };

        byte[] a4 = new byte[]{1, 1, 0, 1, 0, 1};

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        for (int i = 0; i < a.length; i++) {
            subV1(a[i], i);
        }

        // перебор и сравнение
        for (int i = 0; i < a.length; i++) {
            ArrayList<Rectangle> current = map.get(i);
            for (int j = 0; j < current.size(); j++) {
                if (i > 0) {
                    ArrayList<Rectangle> past = map.get(i - 1);
                    for (int k = 0; k < past.size(); k++) {
                        // если один из индексов совпал с предыдушим
                        if (past.get(k).getSequence().equals(current.get(j).getSequence())) {
                            past.get(k).setSequence("empty");
//                            System.out.println(current.get(j));
                        }
                    }
                }
            }
        }

        int counterV = 0; // финальная стадия
        for (Map.Entry<Integer, ArrayList<Rectangle>> pare : map.entrySet()) {
            for (Rectangle item : pare.getValue()) {
                if (!item.getSequence().equals("empty")) {
                    counterV++;
                }
//                System.out.println(item);
            }
        }
        return counterV;
    }

    public static void subV1(byte[] arr, int evenOddJ) { // перебор под массивов
        boolean flag = false;
        String sequence = "";
        int index = -1;

        // даже если эта строка будет вся в 0
        ArrayList<Rectangle> list = new ArrayList<Rectangle>();

        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
            if (arr[i] == 1) {   // OPEN
                if (!flag) {
                    Rectangle rec = new Rectangle(i + "");
                    rec.setIndexMainArr(evenOddJ);
                    list.add(rec);
//                    System.out.println("added: " + rec);
                    index++;
                }
                if (flag) { // при след совпадении сохраняем только индексы
                    sequence += i + "";
                }
                flag = true;
            }
            if (arr[i] == 0 & index >= 0 | (i + 1) == arr.length & index >= 0) {   // CLOSE
                // если последовательность закончилась обновляем sequence
                list.get(index).setSequence(list.get(index).getSequence() + sequence); // по индексу
//                System.out.println("обновлен: " + list.get(index));
                sequence = "";
                flag = false;

            }
        }
        if (list.isEmpty()) {
            Rectangle rec2 = new Rectangle("empty");
            rec2.setIndexMainArr(evenOddJ);
            list.add(rec2);
        }
        map.put(evenOddJ, list);
    }

    public static class Rectangle {
        private String sequence; //  последовательность индексов (в подмассиве) из которых он состоит
        private ArrayList<Integer> indexMainArr = new ArrayList<>(); // индексы глв массива которые он занял

        Rectangle(String sequence) {
            this.sequence = sequence;
        }

        public void setSequence(String sequence) {
            this.sequence = sequence;
        }

        public String getSequence() {
            return this.sequence;
        }

        public void setIndexMainArr(int indexMainArr) {
            this.indexMainArr.add(indexMainArr);
        }

        public ArrayList<Integer> getIndexMainArr() {
            return indexMainArr;
        }

        @Override
        public String toString() {
            return "индексы главн массива" + Arrays.toString(indexMainArr.toArray()) +
                    ", sequence последовательность под идексов: " + sequence;
        }
    }
}
