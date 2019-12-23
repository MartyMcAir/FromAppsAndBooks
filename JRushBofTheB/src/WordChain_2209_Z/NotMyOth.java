package WordChain_2209_Z;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NotMyOth {
// http://www.cyberforum.ru/java-j2se/thread1783280.html
// _ комбинация всех возможных вариантов

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4"};
        int count = fuctorial(arr.length);
        int max = arr.length - 1;
        System.out.println("Вариантов " + count);
        int shift = max;
        String t;
        while (count > 0) {
            t = arr[shift];
            arr[shift] = arr[shift - 1];
            arr[shift - 1] = t;
            print(arr);
            count--;
            if (shift < 2) {
                shift = max;
            } else {
                shift--;
            }
        }

        ////////////// /////
        // TODO code application logic here
        Rearrange("", "123");
        for (String j : set) System.out.println(j);

        //////////////////////
        String[] s = {"Was", "it", "a", "cat", "I", "saw"};
        permutate(s);

        ////////////
        permuteIteration(arr, 0, 3);
    }

    public static Set<String> set = new HashSet();

    public static void Rearrange(String prefix, String str) {
        set.add(prefix);
        for (char ch : str.toCharArray())
            Rearrange(prefix + ch, str.replaceFirst(ch + "", ""));
    }

    ///////////////////////
    static void print(String[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static int fuctorial(int n) {
        return (n > 0) ? n * fuctorial(n - 1) : 1;
    }

    ////////////////////
    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

    ////////////////////////////////
    public static void permutate(String[] arr) {
        permuteIteration(arr, 0);
    }

    private static void permuteIteration(String[] arr, int index) {
        //последняя итерация
        if (index >= arr.length - 1) {
            for (String s : arr) System.out.print(s + " ");
            System.out.println("");
            return;
        }

        for (int i = index; i < arr.length; i++) {
            String temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

            permuteIteration(arr, index + 1);

            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    //////////////////////////
    private static void permuteIteration(String[] arr, int index, int limit) {
        //последняя итерация
        if (index >= limit) {
            for (int i = 0; i < limit; i++) System.out.print(arr[i] + " ");
            System.out.println("");
            return;
        }

        for (int i = index; i < arr.length; i++) {
            String temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

            permuteIteration(arr, index + 1, limit);

            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}
