package RetrievesInArray_2026_Z;

import java.util.ArrayList;

public class Test {
    private static long before;
    private static long start;
    private static String[] arrSt1, arrSt2, arrControl1, arrControl2;
    private static ArrayList<Integer> listTotalAmount = new ArrayList<>();

    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 1, 0, 1}, // 0
                {1, 1, 0, 1, 0, 0}, // 1
                {1, 1, 0, 1, 0, 1}, // 1
        };
        byte[] a2 = new byte[]{1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0};

        //        v1(a3);
        // идея с запоминанием строк _ идет лесом т.к. в строке может быть любая последователность 00101
//        fillMap(a3);
//        loopsMap();
//        loopsStV2("110101");

        startT();   //
        isV1(a1); // работает только в случае если двумерный массив состоит из двух иднексов
//        subV1(a2, 0);
        endT();   //
    }

    public static void isV1(byte[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            subV1(arr[i], i);
        }

//        // если индекс ничего не содержит значит предпоследний и говорит о кол-ве
//        for (int m = 1; m < arrSt1.length; m++) {
//            if (arrSt1[m] == null) {
//                System.out.println("кол-во последовательностей arrSt1: " + (m - 1));
//                break;
//            }
//            System.out.println(arrSt1[m]);
//        }
//
//        for (int m = 1; m < arrSt2.length; m++) {
//            if (arrSt2[m] == null) {
//                System.out.println("кол-во последовательностей arrSt2: " + (m - 1));
//                break;
//            }
//            System.out.println(arrSt2[m]);
//        }
    }

    public static void subV1(byte[] arr, int evenOddJ) {
        // идекс есть кол-во последовательности едениц
        // значение есть набор индексов этой последовательности едениц в строке
        if ((evenOddJ % 2) == 0) { // для контроля обнуления массивов
            arrSt1 = new String[arr.length];
        } else {
            arrSt2 = new String[arr.length];
        }

        boolean flag = false;
        int k1 = 0, k2 = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 1) { // OPEN
                if (flag == false) { // сначала делаем +1
                    if ((evenOddJ % 2) == 0) { // если четн то запись в перв массив
                        arrSt1[++k1] = (j + ""); // в значение идекс
                    } else {
                        arrSt2[++k2] = (j + "");
                    }
                }

                if (flag == true) { // на след раз сработает эта секция, без увел ++k
                    if ((evenOddJ % 2) == 0) { // если четн то запись в перв массив
                        arrSt1[k1] = (arrSt1[k1] + j); // в этот же индекс прибавляем значение
                    } else {
                        arrSt2[k2] = (arrSt2[k2] + j);
                    }
                }
                flag = true; // а после присваиваем
            }

            if (arr[j] == 0) { // CLOSE
                flag = false;
            }
        }

        counter(evenOddJ, arr);  // после интерации заполнения ведём подсчет

//        for (int i = 0; i < arrSt1.length; i++) {
//            System.out.println(arrSt1[i]);
//        }
    }

    public static void counter(int evenOddJ, byte[] arr) {
        boolean flag = false;
        if ((evenOddJ % 2) == 0) { // arrSt1 обнулена и сранивается с arrControl1
            arrControl2 = new String[arr.length];
        } else {
            arrControl1 = new String[arr.length];
        }

        int amount = 0;

        for (int i = 1; i < arrSt1.length; i++) {
            // если оба не null т.е. содержат индекс последовательностей еденицы
            if (!(arrSt2[i] == null) & !(arrSt1[i] == null)) {
                if (arrSt1[i].equals(arrSt2[i])) { // если индексы последовательности едениц совпадают
                    arrControl2[i] = arrSt1[i]; // запоминаем эту последовательность

                    amount++; // то это считается за 1
                } else { // если индексы последовательности едениц НЕ совпадают
                    amount += 2; // то это считается за 2
//                    System.out.println(amount + " : " + arrSt1[i]);
                }
            } else if (!(arrSt2[i] == null) | !(arrSt1[i] == null)) { // если один из них содержит последдовательность
                amount++; // то это считается за 1
            }
        }

        System.out.println("total amount: " + amount);
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
