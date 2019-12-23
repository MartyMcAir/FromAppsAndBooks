package WordChain_2209_Z;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class NotMy2 {
    // ВЗЯТО ОТ СЮДА https://pastebin.com/JLeV5xHr
// Самый сложный код 8 из 11ти
    public static void main(String[] args) {
        String fileName = getPath()[0];
        // выдает 10 из 11
        // Мельбурн Нью-Йорк Крымск Киев Вена Аланга Амстердам Москва Алмата Вашингтон
        try (BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
//             BufferedReader fileReader = new BufferedReader(new FileReader(fileName, Charset.forName("cp1251")))) {
            String content = fileReader.lines().collect(Collectors.joining(" "));

            String[] words;
            if (content.isEmpty()) {
                words = new String[0];
            } else {
                words = content.split("\\s+");
            }

            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();
        if (words.length == 0)
            return builder;

        DirectedMultighraph graph = new DirectedMultighraph(words);
        List<String> trail = graph.findEulerianTrail();
        for (String word : trail) {
            if (builder.length() != 0) {
                builder.append(" ");
            }
            builder.append(word);
        }
        return builder;
    }

    public static String[] getPath() {
        String folder = "c:\\z_n\\new_test_folder\\1\\";
        return new String[]{folder + "data.txt", folder + "data2.txt", folder + "dataLite.txt"};
    }
}
