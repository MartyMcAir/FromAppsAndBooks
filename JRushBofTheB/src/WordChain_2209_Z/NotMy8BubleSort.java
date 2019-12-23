package WordChain_2209_Z;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NotMy8BubleSort {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        sc.close();

        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        String words = "";
        while (bf.ready()) {
            words += bf.readLine();
        }
        bf.close();
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.equals("") || words == null || words.equals(null) || words.length == 0) {
            return new StringBuilder();
        }

        String[] s = words.clone()[0].trim().split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }
        StringBuilder res = new StringBuilder();

        while (true) {
            Collections.shuffle(list);

            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                String w = "";
                String q = "";

                if (i > 0) {
                    w = String.valueOf(list.get(i).charAt(0));
                    q = String.valueOf(list.get(i - 1).charAt(list.get(i - 1).length() - 1));

                    if (w.equalsIgnoreCase(q)) {
                        count++;
                    }
                }
            }
            if (count == list.size() - 1) {
                StringBuilder total = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    res.append(list.get(i) + " ");
                }
                return res;
            }


        }

    }
}


