package a_Other;

import java.io.IOException;

public class LetterSwapper {

    public static void main(String[] args) throws IOException {
        coderByteCom("hello*3");
    }

    // Замените каждую букву в строке буквой, следующей за ней в алфавите
    // если след буква согласная, то привести её в верхний регистр
    public static void coderByteCom(String str) {
        String res = "";
        // 1
        char[] arrCh = str.toLowerCase().toCharArray();
        for (int i = 0; i < arrCh.length; i++) {
            char current = arrCh[i];
//            Character.isLetter(current); // тоже самое
            if (isAlphabet(current)) { // если буква
                char nextChar = getNextLetter(current); // получаем след букву
                arrCh[i] = nextChar; // присваиваем текущему индексу след букву
                if (isVolves(nextChar)) { // если буква гласная
                    arrCh[i] = Character.toUpperCase(nextChar); // в верхний регистр
                }
            }
        }
        res = new String(arrCh);
        System.out.println(res);
    }

    public static char getNextLetter(char current) {
        char[] arrAlphabet = getAlphabet();
        for (int i = 0; i < arrAlphabet.length; i++) {
            if (current == arrAlphabet[i]) {
                if (i + 1 <= arrAlphabet.length) {
                    current = arrAlphabet[i + 1];
                    break;
                } else { // если это послед буква алфавита
                    current = arrAlphabet[0];
                }
            }
        }
        return current;
    }

    public static boolean isAlphabet(char ch) {
        boolean res = false;
        char[] arrVowels = getAlphabet();
        for (char item : arrVowels) {
            if (ch == item) {
                res = true;
            }
        }
        return res;
    }

    public static boolean isVolves(char ch) {
        boolean res = false;
        char[] arrVowels = getVowels();
        for (char item : arrVowels) {
            if (ch == item) {
                res = true;
            }
        }
        return res;
    }

    public static char[] getAlphabet() {
        return new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
                'z'};
    }

    public static char[] getVowels() { // гласные
        return new char[]{'a', 'e', 'i', 'o', 'u'};
    }

    public static char[] getConsonants() { // согласные
        return new char[]{'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
                'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};
    }

    public static String[] getPath() {
        String folder = "c:\\z_n\\new_test_folder\\1\\";
        return new String[]{folder + "data.txt", folder + "data2.txt", folder + "dataLite.txt"};
    }
}
