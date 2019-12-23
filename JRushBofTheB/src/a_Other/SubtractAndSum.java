package a_Other;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SubtractAndSum {
    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
//        int i = Integer.parseInt(scan.nextLine());
//        double d = Double.parseDouble(scan.nextLine());
//        String s = scan.nextLine();
//        scan.close();
        // Write your code here.

//        System.out.println("String: " + s);
//        System.out.println("Double: " + d);
//        System.out.println("Int: " + i);


        ArrayList<Integer> arr = new ArrayList<Integer>(100);
        Collections.fill(arr, 88);
        System.out.println(arr); // 0

    }

    public static Map<String, Integer> duplicateCount(String text) {
        int res = 0;
        char[] arrCh = text.toLowerCase().toCharArray();
        char[] arrCh2 = text.toLowerCase().toCharArray();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arrCh.length; i++) {
            char current = arrCh[i];
            for (int j = 0; j < arrCh2.length; j++) {
                if (current == arrCh2[j]) {
                    map.merge(String.valueOf(current), 1, Integer::sum);
                }
                arrCh2[j] = 0;
            }
        }
        int max = 0;
        for (Map.Entry<String, Integer> pare : map.entrySet()) {
            if (pare.getValue() > max) {
                max = pare.getValue();
            }
        }
        return map;
    }

    public static int SimpleAdding(int num) {
        int[] arrInt = new int[num + 1];

        int res = 0, tmp;
        for (int i = 1; i < arrInt.length; i++) {
            arrInt[i] = i;
        }
        for (int item : arrInt) {
            res += item;
        }
        return res;
    }

    public static void numberChanger(int n) {
        int res = 0, prefixResMultiple1 = 1, prefixResSum2 = 0;
        char[] charArr = String.valueOf(n).toCharArray();

        for (char item : charArr) {
            int currentInt = Integer.parseInt(String.valueOf(item));
            prefixResMultiple1 = currentInt * prefixResMultiple1;
            System.out.println(currentInt);
            prefixResSum2 += currentInt;
        }
        res = prefixResMultiple1 - prefixResSum2;
        System.out.println(res);
    }

}
