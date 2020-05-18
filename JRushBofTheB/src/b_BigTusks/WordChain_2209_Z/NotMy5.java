package b_BigTusks.WordChain_2209_Z;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// https://javarush.ru/help/17888
public class NotMy5 {
    public static void main(String[] args) {

        String[] words_input = new String[0];
        ArrayList<ArrayList> arrays = new ArrayList<>();

        try {
            BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//            BufferedReader input = new BufferedReader(new FileReader("e:\\input.txt"));
            BufferedReader input = new BufferedReader(new FileReader(bfr.readLine()));

            words_input = input.readLine().split("\\s");
            bfr.close();
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Берем по очереди слово из переданного массива.
        for (int index = 0; index < words_input.length; index++) {

            // Создаем массив, в который будем записывать последовательность,
            // составленную на основе переданного слова.
            ArrayList<String> sorted = new ArrayList<>();
            // Записываем переданное слово в массив.
            sorted.add(words_input[index]);
            // Добавляем основу в глобальный массив.
            arrays.add(sorted);

            // Создаем переменную для хранения первой или последней буквы слова.
            String letter;
            // Флаг определяет направление поиска соответствия (по первой букве или последней).
            boolean flag = false;

            // Движение вправо.
            while (!flag) {
                // Меняем значение флага для поиска с левой стороны, если поиск вправо закончен,
                // что будет определено ниже.
                flag = true;
                // Определяем индекс последнего слова в массиве sorted.
                int i = sorted.size() - 1;
                // Определяем индекс последней буквы текущего слова.
                int j = sorted.get(i).length() - 1;
                // Берем последнюю букву текущего слова.
                letter = sorted.get(i).substring(j);

                // Берем по очереди слово из входного массива words_input,
                for (String match_first : words_input) {
                    // и определяем его первую букву.
                    String first_letter = match_first.substring(0, 1);

                    // Если первая буква текущего слова входного массива words_input
                    // соответствует последней букве слова массива sorted,
                    if (first_letter.equalsIgnoreCase(letter)) {

                        // и если массив sorted уже содержит слово из входного массива words_input,
                        // то поиск прерываем и по значению флага начинаем двигаться влево.
                        if (sorted.contains(match_first)) break;
                            // Если массив sorted не содержит слово из входного массива words_input,
                        else {
                            // то текущее слово добавляем в конец массива sorted.
                            sorted.add(match_first);
                            // Меняем флаг на продолжение поиска вправо с учетом нового слова в цепочке.
                            flag = false;
                        }
                    }
                }
            }

            // Движение поиска влево.
            while (flag) {
                // Меняем значение флага для выхода из цикла, если поиск закончен,
                // что будет определено ниже.
                flag = false;

                // Берем по очереди слово из входного массива words_input.
                for (String match_last : words_input) {
                    // Определяем первую букву первого слова из массива sorted,
                    // сформированного по поиску вправо.
                    letter = sorted.get(0).substring(0, 1);
                    // Определяем индекс последней буквы текущего слова из входного массива words_input.
                    int indx = match_last.length() - 1;
                    // Опеределяем последнюю букву текущего слова из входного массива words_input.
                    String last_letter = match_last.substring(indx);

                    // Если последняя буква текущего слова входного массива words_input
                    // соответствует первой букве слова массива sorted,
                    if (last_letter.equalsIgnoreCase(letter)) {

                        // и если массив sorted уже содержит слово из входного массива words_input,
                        // то поиск прерываем и по значению флага и переходим к составлению цепочки
                        // на основе следующего слова, входного массива words_input.
                        if (sorted.contains(match_last)) break;

                            // Если массив sorted не содержит слово из входного массива words_input,
                        else {
                            // то текущее слово добавляем в начало массива sorted.
                            sorted.add(0, match_last);
                            // Меняем флаг на продолжение поиска влево с учетом нового слова в цепочке.
                            flag = true;
                        }
                    }
                }
            }
            // Для проверки содержания полученных цепочек.
//            for (String checkNext: sorted) {
//                System.out.print(checkNext + " ");
//            }
//            System.out.println("\n" + sorted.size() + " word(s)\n");
        }

        // Определение индекса массива, содержащего максимальное количество слов.
        int max_length = 0;
        int index_for_max = 0;
        for (int w = 0; w < arrays.size(); w++) {
            int lngth = arrays.get(w).size();
            if (max_length < lngth) {
                max_length = lngth;
                index_for_max = w;
            }
        }

        // Запись массива типа Array<String> в массив String[].
        String[] fin = new String[max_length];
        for (int i = 0; i < max_length; i++) {
            fin[i] = arrays.get(index_for_max).get(i).toString();
        }

        StringBuilder result = getLine(fin);
        System.out.println(result.toString());

    }

    public static StringBuilder getLine(String... words) {
        if (words.length != 0) {
            StringBuilder words_in_line = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                words_in_line.append(words[i]);
                if (i < words.length - 1) {
                    words_in_line.append(" ");
                }
            }
            return words_in_line;
        }
        return new StringBuilder();
    }
}
