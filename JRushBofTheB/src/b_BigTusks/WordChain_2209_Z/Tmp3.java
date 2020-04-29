package b_BigTusks.WordChain_2209_Z;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Tmp3 {
    public static void main(String[] args) throws IOException {
        String fileName = getPath()[0];
        try (BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
//             BufferedReader fileReader = new BufferedReader(new FileReader(fileName, Charset.forName("cp1251")))) {
            String content = fileReader.lines().collect(Collectors.joining(" "));
            String[] words;
            if (content.isEmpty()) {
                words = new String[3];
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
        StringBuilder sb = new StringBuilder();
        if (words.length == 0)
            return sb;

        List<String> list = new ArrayList<>(Arrays.asList(words));
        Collections.sort(list);
//        System.out.println(list);

        String current = "", next = "", inner = "";
        char end, start;
        BLOCK1:
        for (int i = 0, j = i + 1; i < list.size() - 1; i++, j++) {
            current = list.get(i);
            next = list.get(j);
            end = current.toLowerCase().charAt(current.length() - 1);
            start = next.toLowerCase().charAt(0);
            if (!(end == start)) {
                inner = getComparableWord(list, current);
                if (inner != null) {
                    list.remove(inner);
                    list.add(j, inner);
                } else {
                    list = tryWordInput(list, next);
                    continue BLOCK1;
//                    break;
                }
            }
        }
        System.out.println(list);


        return sb;
    }

    // Подбирает найболее подходящее след. слово
    public static String getComparableWord(List<String> list, String word) {
        ArrayList<String> compareWords = new ArrayList<>();

        String res = null, current = "", letter = word.substring(word.length() - 1).toLowerCase();
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            current = list.get(i);
            if (current.toLowerCase().startsWith(letter)) {
                compareWords.add(current);
                flag = true;
            }
        }

        if (compareWords.size() == 1) {
            res = compareWords.get(0);
        } else {
//            String[] strArr = (String[]) list.toArray();
//            res = getComparableWord(compareWords, strArr);
        }

        if (!flag) {
            list.add(word); // если вставка не удалась добавляем в конец списка
        }
        return res;
    }

    public static String getWordAlotRibire(ArrayList<String> list, String[] strArr) {
        String res = null;
        ArrayList<Integer> listReiting = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

        }
        return res;
    }

    public static List<String> tryWordInput(List<String> list, String word) {
        String current = "", next = "", letterStart = "", letterEnd = "";
        letterStart = word.substring(0, 1).toLowerCase();
        letterEnd = word.substring(word.length() - 1).toLowerCase();
        list.remove(word); // для избежания дубликата
        for (int i = 0, j = i + 1; i < list.size() - 1; i++, j++) {
            current = list.get(i).toLowerCase();
            next = list.get(j).toLowerCase();
            if (current.endsWith(letterStart) & next.startsWith(letterEnd)) {
                list.add(j, word);
                break;
            }
        }
        return list;
    }


    public static String[] getPath() {
        String folder = "c:\\z_n\\new_test_folder\\1\\";
        return new String[]{folder + "data.txt", folder + "data2.txt", folder + "dataLite.txt"};
    }
}
