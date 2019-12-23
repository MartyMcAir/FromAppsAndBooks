package WordChain_2209_Z;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tmp {
    public static void main(String[] args) throws IOException {
        BufferedReader bfrConsole = new BufferedReader(new InputStreamReader(System.in));
//        String fileName=bfrConsole.readLine();
        String fileName = getPath()[0];
        bfrConsole.close();

        BufferedReader bfr = new BufferedReader(new FileReader(fileName));
//        BufferedReader bfr = new BufferedReader(new FileReader(fileName, Charset.forName("cp1251")));
//        BufferedReader bfr = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        while (bfr.ready()) {
            sb.append(bfr.readLine().trim() + " ");
        }
        bfr.close();

        // replaceAll - для замены 2 и более пробелов на один
        List<String> list = new ArrayList<>(Arrays.asList(sb.toString()
                .replaceAll("  ", " ").split(" ")));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isEmpty()) {
                list.remove(i); // удаляем пустые строки
            }
        }
//        list.forEach(v -> System.out.println("'" + v + "'"));

        System.out.println("'" + recursiveSityComparatorV3(list).toString() + "'");
    }

    public static void mainFromSolution() throws IOException {
        String fileName = "";
        BufferedReader bfr = new BufferedReader(new FileReader(fileName));
//        BufferedReader bfr = new BufferedReader(new FileReader(fileName, Charset.forName("cp1251")));
        ArrayList<String> list = new ArrayList<>();
        String line = "";
        while (bfr.ready()) {
            line = bfr.readLine().trim();
            String[] strArr = line.split(" ");
            for (String item : strArr) {
                if (!item.isEmpty()) {
                    list.add(item);
                }
            }
        }
        bfr.close();
//        list.forEach(v -> System.out.println("'" + v + "'"));

        String[] newStrArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newStrArr[i] = list.get(i);
        }
    }

    public static StringBuilder recursiveSityComparatorV3(List<String> list) {
        List<String> original = new ArrayList<>(list); // для отправки в рекурсию
        StringBuilder sb = new StringBuilder();
        String current = "", compare = "", letter = ""; // для удобсвта при переборе
        int listLength = list.size() + 3, k = 1;
        for (int i = 0; list.size() > 0; i++) {
            current = compare; // предыдущее слово становится текущим
            if (i == 0) {
                current = list.get(i);
            }
            compare = getComparableWord(list, current);
            sb.append(current + " ");
            list.remove(current);
            list.remove(compare);
            if (list.size() == 1) { // если интерация последняя
                letter = current.substring(current.length() - 1).toUpperCase(); // последн буква пред посл сл.
                if (!list.get(0).startsWith(letter)) { // если не совпадает перв буква последнего сл с предыдущ сл.
                    // пытаемся найти совпадение начала и конца слова в массиве слов
                    sb = tryWordInput(sb.toString().split(" "), list.get(0));
                    break; // прерываем для возврата sb
                } else { // если всё совпадает
                    compare = list.get(0);
                    sb.append(compare);
                }

                // если длина полученного массива не равна оригиналу, то рекурсия
                if (!(sb.toString().split(" ").length == original.size())) {
                    System.out.println("попытка№ " + k++);
                    current = original.get(0); // перемещаем первое слово в конец
                    original.remove(current);
                    original.add(current);
                    recursiveSityComparatorV3(original);
                }
            }
        }
        return sb;
    }

    public static String getComparableWord(List<String> list, String word) {
        String res = "", current = "", letter = word.substring(word.length() - 1).toUpperCase();
        for (int i = 0; i < list.size(); i++) {
            current = list.get(i);
            if (current.startsWith(letter)) {
                res = current;
                break; // есои найдено сразу прерываем
            }
        }
        return res;
    }

    public static StringBuilder tryWordInput(String[] strArr, String word) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new LinkedList<>(Arrays.asList(strArr));
        String current = "", next = "", letterStart = "", letterEnd = "";
        letterStart = word.substring(0, 1).toLowerCase();
        letterEnd = word.substring(word.length() - 1).toUpperCase();
        for (int i = 0; i < list.size(); i++) {
            current = list.get(i);
            next = list.get(i + 1);
            if (current.endsWith(letterStart) & next.startsWith(letterEnd)) {
                list.add(i + 1, word);
                break;
            }
        }
        // перебираем список для возврата StringBuilder
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) { // в псоледн слове убираем пробел
                sb.append(list.get(i).trim());
            } else {
                sb.append(list.get(i) + " ");
            }
        }
        return sb;
    }


    ////////////////////////////////////////////////////////////////
    public static StringBuilder myGetLineVersion2(String... words) {
        ArrayList<String> original = new ArrayList<>(Arrays.asList(words));

        ArrayList<String> list = new ArrayList<>(original);
        System.out.println(list);

        StringBuilder sb = new StringBuilder();
        String current = "", inner = "", next = "", tmp = "";
        for (int i = 0; i < list.size(); i++) {
            current = list.get(i).trim();
            if (i + 1 < list.size()) {
                next = list.get(i + 1);
            }
            list.remove(i);
            sb.append(current + " ");
            tmp = current.substring(current.length() - 1);
            if (!next.trim().toLowerCase().startsWith(tmp)) {
                for (int j = 0; j < list.size(); j++) {
                    inner = list.get(j).trim();
                    if (inner.toLowerCase().startsWith(tmp)) {
                        sb.append(inner + " ");
                        list.remove(j);
                    }
                }
            } else {
                sb.append(next);
                list.remove(next);
                if (i + 1 < list.size()) {
                    sb.append(" "); // чтоб пробела небыло в конце последнего
                }
            }
        }
        return sb;
    }

    public static StringBuilder myGetLineVersion1(String... words) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
        ArrayList<String> clone = new ArrayList<>(list);
        StringBuilder sb = new StringBuilder();

        String current = "", inner = "", next = "", letter = "";
        BLOCK1:
        for (int i = 0, j = i + 1; j < list.size(); i++) {
            if (i == 0) { // если первая интерация
                current = list.get(i).trim();
                list.remove(current);
                letter = current.substring(current.length() - 1).toUpperCase();
                next = list.get(j).trim();
            }
            if (next.startsWith(letter)) { // если у след слова совпадает 1ая буква
                // с последн буквой предыдущ слова
                sb.append(current + " " + next + " ");
                list.remove(current);
                list.remove(next);
            } else {
                for (int k = 0; k < list.size(); k++) {
                    inner = list.get(k).trim();
                    if (inner.startsWith(letter)) {
                        sb.append(current + " " + inner + " ");
                        current = inner;
                        letter = inner.substring(inner.length() - 1).toUpperCase();
                        list.remove(inner);
                        continue BLOCK1;
                    }
                }
            }
//            System.out.println("current: " + current + ", next: " + next + ", inner: " + inner);
        }
        return sb;
    }

    //
    public static class WordsChecker {
//        WordsChecker.list = list;
//        WordsChecker w = new WordsChecker(list.get(1));
//        w.checkCurrentWord();

        public static List<String> list; // список один на всех
        public String word; // Киев
        // но у каждого слова своя арава пододящих слов
        public String letterStart = this.word.substring(0, 1).toLowerCase(); // к
        public List<String> wordsStart = new ArrayList<>(); // Нью-Йорк <-> "к"
        public String letterEnd = this.word.substring(word.length() - 1); // в
        public List<String> wordsEnd = new ArrayList<>(); // в <-> Вена

        public WordsChecker(String word) {
            this.word = word.trim();
        }

        public void checkCurrentWord() {
            for (int i = 0; i < list.size(); i++) {

            }
            System.out.println(word + " _start: " + letterStart + " _end: " + letterEnd);
        }
    }

    public String[] isAlfabetIndex() {
        return new String[]{
                "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и",
                "й", "к", "л", "м", "н", "о", "п", "р", "с", "т",
                "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь",
                "э", "ю", "я"};
    }

    public static String[] getPath() {
        String folder = "c:\\z_n\\new_test_folder\\1\\";
        return new String[]{folder + "data.txt", folder + "data2.txt"};
    }
}
