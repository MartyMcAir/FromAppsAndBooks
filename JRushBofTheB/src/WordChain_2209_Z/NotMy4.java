package WordChain_2209_Z;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class NotMy4 {
    public static void main(String[] args) throws IOException {
        //...
        Scanner scanner = new Scanner(System.in);
        scanner = new Scanner(Paths.get(scanner.nextLine()));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) sb.append(scanner.nextLine()).append(" ");

        String[] strings = sb.toString().trim().split(" ");
        Arrays.sort(strings);
        StringBuilder result = getLine(strings);
        System.out.println(result.toString().trim());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) return new StringBuilder();

        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> deque = new ArrayDeque<>(Arrays.asList(words));

        String word = deque.pollFirst();
        sb.append(word).append(" ");

        boolean isManipulated = false;
        boolean flag = false;

        while (deque.peekFirst() != null) {

            //Если больше совпадений нет - добавляем остальные слова в конструктор
            if (isManipulated) {
                if (!flag) {
                    while (deque.peekFirst() != null) sb.append(deque.pollFirst()).append(" ");
                }
            }

            for (String s : deque) { //Ищем совпадения в цикле
                if (word.toLowerCase().charAt(word.length() - 1) == s.toLowerCase().charAt(0)) {
                    isManipulated = true;
                    flag = true;
                    sb.append(s).append(" ");
                    deque.removeFirstOccurrence(s);
                    word = s;
                    break;
                }
                flag = false;
            }

            //Если первое слово не совпадает ни с одним из последующих
            //то просто добавляем остальные слова к конструктору
            if (!isManipulated) {
                while (deque.peekFirst() != null) sb.append(deque.pollFirst()).append(" ");
            }
        }

        return sb;
    }

    // Идевльный вариант
    /*
    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) return new StringBuilder();

        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> deque = new ArrayDeque<>(Arrays.asList(words));

        String word = deque.stream() //получаем случайное слово из коллекции
                .parallel()
                .findAny()
                .get();

        deque.removeFirstOccurrence(word); //удаляем это случайное слово
        sb.append(word).append(" ");

        boolean isManipulated = false; //Переманная для проверки хотя бы одного совпадения
        boolean flag = false;

        while (deque.peekFirst() != null) {

            if (isManipulated) {
                if (!flag) break;
            }

            for (String s : deque) { //Ищем совпадения в цикле
                if (word.toLowerCase().charAt(word.length() - 1) == s.toLowerCase().charAt(0)) {
                    isManipulated = true;
                    flag = true;
                    sb.append(s).append(" ");
                    deque.removeFirstOccurrence(s);
                    word = s;
                    break;
                }
                flag = false;
            }


//            На случай, если первое рандомное слово ни с чем не совпадет
//            оно выкидывается, и проверяются остальные слова на совпадения
            if (!isManipulated) {
                word = deque.stream()
                        .parallel()
                        .findAny()
                        .get();
                deque.removeFirstOccurrence(word);
                sb.setLength(0);
                sb.append(word).append(" ");
            }
        }

        return sb;
    }
    */
    
}
