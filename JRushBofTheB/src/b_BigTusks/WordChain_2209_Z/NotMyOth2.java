package b_BigTusks.WordChain_2209_Z;

import java.util.ArrayList;

public class NotMyOth2 {
    // http://www.cyberforum.ru/java-j2se/thread1783280.html
    static int count = 0;
    static ArrayList<String> arrList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) {
        String[] s = {"Was", "it", "a", "cat", "I", "saw"};
        for (int i = 1; i < s.length + 1; i++)
            permutate(s, i);
        for (String string : arrList) System.out.println(++count + ": " + string);

    }

    public static void permutate(String[] arr, int limit) {
        permuteIteration(arr, 0, limit);
    }

    private static void permuteIteration(String[] arr, int index, int limit) {
        //последняя итерация
        if (index >= limit) {
            for (int i = 0; i < limit; i++) sb.append(arr[i] + " ");
            arrList.add(sb.toString());
            sb.delete(0, sb.length());
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
