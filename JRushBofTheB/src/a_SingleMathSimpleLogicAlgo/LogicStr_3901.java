package a_SingleMathSimpleLogicAlgo;
// Уникальные подстроки
//Реализуй метод lengthOfLongestUniqueSubstring таким образом, чтобы он возвращал длину самой длинной подстроки без повторяющихся символов, найденной в строке полученной в качестве параметра.
//Например, для строки "a123bcbcqwe" - 6, а для строки "ttttwt" - 2.
//Если анализируемая строка пуста или равна null - верни 0.
//
//
//Требования:
//1. Метод lengthOfLongestUniqueSubstring должен возвращать длину подстроки с максимальным количеством уникальных символов.
//2. Метод lengthOfLongestUniqueSubstring должен возвращать 0 для пустой строки, или строки равной null.
//3. Метод lengthOfLongestUniqueSubstring должен быть публичным.
//4. Метод lengthOfLongestUniqueSubstring должен быть статическим.

//https://javarush.ru/tasks/com.javarush.task.task39.task3901#discussion
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LogicStr_3901 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Please enter your string: ");
//        String s = bufferedReader.readLine();
//
//        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));

        /// Берем цикл по элементам string, добавляем char в set. Проверяя что в set нет символа, кидаем его туда,
        // увеличиваем значение переменной длины length, и это же значение присваиваем переменной max
        // (с проверкой если length больше), а если символ уже есть в set, то длина length=1
        // обнуляем set и добавляем в него же только последний символ.

        // PS. Залез в комменты - понятно. Очередная кривая формулировка и примеры в задаче.
        //Хотят, чтобы в abcddee , например, ответ был 4, т.к. abcd не повторяются подряд.


        // abcdeaouiz - 9   еееееее -1    a123bcbcqwe  - 6    ttttwt - 2
        // a123bcbcqwe - 11   ttttwt - 3    qwertyuytr - 10   abcddee - 4
//        String arrStr[] = {"ttttwt", "123", "tzz", "abcdeaouiz", "a123bcbcqwe"};

        String arrStr[] = {"a123bcbcqwe"}; // не понял задачу

        for (String item : arrStr)
            System.out.println(lengthOfLongestUniqueSubstring(item));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        Set<Character> set = new HashSet<>();
        int l = 0;
        for (Character c : s.toCharArray()) {
            if (set.contains(c)) {
                if (l < set.size()) {
                    l = set.size();
                    set.clear();
                }
            }
            set.add(c);
        }
        return l < set.size() ? set.size() : l;
    }

    public static int lengthOfLongestUniqueSubstringMy(String s) {
        // все работает валя не принимает
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        char[] chars = s.toCharArray();

        int maxTmp = 1, max = 1, counter = 1;
        for (int i = 0, j = 1; i < chars.length - 1; i++, j++) {
            if (chars[i] != chars[j]) { // по ка буквы разные кидаем в сет и увеличиваем счетчик
                maxTmp = ++counter;
            } else if (maxTmp > max) { // иначе т.е. последовательность закончилась, а значит
                // в случаеесли текущ мксимум больше предыдущего.. кидаем текущ максимум
                max = maxTmp; // обновляем максимум
                maxTmp = 0; // обнуляем tmp переменную
                counter = 0; // обнулям счетчик
            }
        }

        return Math.max(maxTmp, max);   // отправляем максимум из двух
    }


    // для строк подряд без повторов символов
    public static int lengthOfLongestUniqueSubstring_MyV1(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();

        int maxTmp = 0, max = 0;
        for (char item : chars) {
            if (!set.contains(item)) { // по ка буквы разные кидаем в сет и увеличиваем счетчик
                set.add(item);
                maxTmp = set.size();
            } else if (maxTmp > max) { // иначе т.е. последовательность закончилась, а значит
                // в случаеесли текущ мксимум больше предыдущего.. кидаем текущ максимум
                max = maxTmp; // обновляем максимум
                maxTmp = 0; // обнуляем счетчик
                set.clear(); // очищаем сет
            }
        }

        return Math.max(maxTmp, max);   // отправляем максимум из двух
    }
}
