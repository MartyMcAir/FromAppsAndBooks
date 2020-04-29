package b_BigTusks.RetrievesInArray_2026_Z;

import java.util.ArrayList;
import java.util.Arrays;

public class Test2 {
    private static long before;
    private static long start;
    private static int index = -1;
    private static ArrayList<Rectangle> list = new ArrayList<Rectangle>(); // идекс и есть кол-во прямоугольников

    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 1, 0, 1}, // 0
                {1, 1, 0, 1, 0, 1}, // 1
                {1, 1, 0, 1, 0, 1}, // 1
        };

        byte[] a2 = new byte[]{1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1};

        startT();   //
        isV1(a1); // работает только в случае если двумерный массив состоит из двух иднексов

        list.forEach(v -> System.out.println(v));
//        subV1(a2, 0);
        endT();   //
    }

    public static void isV1(byte[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            subV1(arr[i], i);
        }

//        System.out.println(arr.length * arr[0].length); // т.е. сверка через каждые 6 _ 18
//        for (int i = 0; i < list.size(); i++) {
//
//        }
    }

    public static void subV1(byte[] arr, int evenOddJ) {
        boolean flag = false;
        String sequence = "";

        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);

            if (arr[i] == 1) {   // OPEN
//                if (evenOddJ > 0) { // сравниваем последовательности
//                    list.get(index).equals(list.get());
//                } else {
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
//                }
            }

            if (arr[i] == 0 | (i + 1) == arr.length) {   // CLOSE
//                if (evenOddJ > 0) {

//                } else {
                // если последовательность закончилась обновляем sequence
                list.get(index).setSequence(list.get(index).getSequence() + sequence); // по индексу
//                System.out.println("обновлен: " + list.get(index));
                sequence = "";
                flag = false;
//                }
            }
        }
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
