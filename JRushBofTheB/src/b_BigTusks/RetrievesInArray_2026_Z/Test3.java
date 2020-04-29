package b_BigTusks.RetrievesInArray_2026_Z;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test3 {
    private static long before;
    private static long start;
    // map'a индексов главного массива, у каждого индекса map'ы свой ArrayList Rectangl'ов
    // это для того что бы зная индекс глв массива, сделав от индекса-1 получить все найденные предыдущего
    // и сравнить их
    private static LinkedHashMap<Integer, ArrayList<Rectangle>> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 1, 0, 1, 0, 0}, //
                {1, 1, 0, 1, 0, 1, 0, 0}, //
                {1, 1, 0, 1, 0, 1, 0, 1}, //
                {0, 0, 0, 0, 0, 0, 0, 0}, //
                {0, 1, 0, 0, 1, 0, 0, 1}, //
                {0, 1, 0, 0, 1, 0, 0, 1}, //
        };

        byte[][] a3 = new byte[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };

        byte[] a2 = new byte[]{1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1};

        startT();   //
        int res = isV1(a3); //
        System.out.println(res);
//        subV1(a2, 0);
        endT();   //
    }

    public static int isV1(byte[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            subV1(arr[i], i);
        }

        // перебор и сравнение
        for (int i = 0; i < arr.length; i++) {
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

    public static void startT() {
        start = System.currentTimeMillis();
        before = mem();
    }

    public static void endT() {
        System.out.println("used memory = " + ((mem() - before) / 1024 / 1024) + " Mb");
        System.out.println("running time: " + (System.currentTimeMillis() - start) + " ms");
    }

    public static long mem() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "file1.txt", dir
                + "file2.txt", dir
                + "file3.txt"};
    }
}
