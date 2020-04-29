package b_BigTusks.WordChain_2209_Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NotMy7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        String[] words = Files.readAllLines(Paths.get(fileName))
                .stream().map(line -> line.split(" ")).flatMap(Arrays::stream).toArray(String[]::new);
        StringBuilder result = getLine(words.clone());
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) return new StringBuilder();
        List<String> w = new ArrayList<>(Arrays.asList(words));
        ArrayList<String> states = new ArrayList<>();
        states.add(w.toString());
        boolean notFound = true;
        while (notFound) {
            boolean valid = true;
            for (int i = 0; i < w.size() - 1; i++) {
                String s1 = w.get(i).toLowerCase();
                String s2 = w.get(i + 1).toLowerCase();
                if (s1.charAt(s1.length() - 1) != s2.charAt(0)) {
                    valid = false;
                    while (states.contains(w.toString())) {
                        Collections.shuffle(w);
                    }
                    states.add(w.toString());
                    break;
                }
            }
            if (valid) notFound = false;
        }
        StringBuilder sb = new StringBuilder();
        w.forEach(word -> {
            sb.append(word);
            sb.append(" ");
        });
        sb.trimToSize();
        return sb;
    }
}