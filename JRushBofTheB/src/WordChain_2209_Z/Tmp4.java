package WordChain_2209_Z;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Tmp4 { // 09.12.2019
    public static ArrayList<String> listCombinations = new ArrayList<>(); // хранилище комбинаций

    public static void main(String[] args) throws IOException {
        String fileName = SimpleMethods.getPath()[0];
        try (BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
//             BufferedReader fileReader = new BufferedReader(new FileReader(fileName, Charset.forName("cp1251")))) {
             BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String content = fileReader.lines().collect(Collectors.joining(" "));
            String[] words;
            if (content.isEmpty()) {
                words = new String[3];
            } else {
                words = content.split("\\s+");
            }
            StringBuilder result = getLine(words);
            System.out.println("'" + result.toString() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder res = new StringBuilder();
        if (words.length < 1) {
            return res;
        }
        if (words.length == 1) {
            res.append(words[0]);
            return res;
        }

        SimpleMethods smp = new SimpleMethods();
        smp.baseMethod(words); // отправляем массив слов в базовый метод

        // перебираем список для получения строки c максим длинной комбинацией слов
        String strMaxLength = "";
        int length = 0;
        for (String item : listCombinations) {
            if (item.length() > length) {
                length = item.length();
                strMaxLength = item;
            }
        }
        res.append(strMaxLength);
        return res;
    }
}
