package b_BigTusks.RetrievesInArray_2026_Z;

import java.util.ArrayList;

/*
Алгоритмы-прямоугольники
*/
public class Solution_2 {
    private static int k = 0;
    private static ArrayList<String> list = new ArrayList<>();

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

    public static void subV1(byte[] arr) {
        boolean flag = false;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 1) { // open
                if (flag = false) { // сначала делаем +1

                }
                flag = true; // а после присваиваем
            }
            if (arr[j] == 0) { // close
                flag = false;
            }
        }
    }

    public static void v1(byte[][] arr) {
        int sequence = 0;
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
//            subV1(arr, i);
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) { // open
                    if (flag = false) { // сначала делаем +1

                    }
                    flag = true; // а после присваиваем
                }
                if (arr[i][j] == 0) { // close
                    flag = false;
                }
            }
        }
    }


    public static void fillMap(byte[][] arr) {
        String tmpSt = "";
        int tmp, count = 0;
        for (int i = 0; i < arr.length; i++) {
            tmpSt = "";
            for (int j = 0; j < arr[i].length; j++) {
                tmpSt += arr[i][j];
            }
            list.add(tmpSt);
        }
    }

    public static void loopsMap() {
        String current = "", future = "", before;
        for (int i = 0; i < list.size(); i++) {
            current = list.get(i);
            // обнуляем чтоб, не совпало старое значение переменной
            future = ""; // с текущ элементом при окончании массива
            before = "";
            if (i + 1 < list.size()) { // проверяем чтоб не вышло за размеры массива IndexOfBounds
                future = list.get(i + 1);
            }
            if (i - 1 > 0) { // проверяем чтоб не был запрос отрицательного
                before = list.get(i - 1);
            }

            if (current.contains("1") & current.equals(future) || //||-если первое уловие true,то 2ое не проверяется
                    current.equals(before)) {
                System.out.println(current);
            } else if (current.contains("1") & i == list.size()) {
                System.out.println(k + 2);
            }  // если содержит 1 и не совпадает с предыдущим или след элементом

            else if (current.contains("1") & !current.equals(future) |
                    !current.equals(before)) {
                loopsStV2(current);
            }
        }
    }

    public static void loopsStV2(String current) {
        for (int u = 0; u < current.length(); u++) {
            char futureCh = 'z', beforeCh = 'z';
            if ((u + 1) < current.length()) {
                futureCh = current.charAt(u + 1);
            }
            if ((u - 1) > 0) {
                beforeCh = current.charAt(u - 1);
            }

            if (Character.compare(current.charAt(u), '1') == 0) {
                System.out.println(current);
                if (u == current.length()) {
                    System.out.println(++k);
                }
            } else if (Character.compare(current.charAt(u), '0') == 0 &
                    Character.compare(beforeCh, '1') == 0 ||
                    Character.compare(current.charAt(u), '1') == 0) {
                System.out.println(++k);
            }
        }
    }

    public static void loopsStV1(String current) {
        for (int u = 0; u < current.length(); u++) {
            char futureCh = 'z';
            if ((u + 1) < current.length()) {
                futureCh = current.charAt(u + 1);
            }
            if (Character.compare(current.charAt(u), futureCh) == 0 ||
                    Character.compare(current.charAt(u), current.charAt(u - 1)) == 0) {
                System.out.println(current);
            } else {
                System.out.println(++k);
            }
        }
    }

    public static int getRectangleCount(byte[][] a) {
        return 0;
    }
}
