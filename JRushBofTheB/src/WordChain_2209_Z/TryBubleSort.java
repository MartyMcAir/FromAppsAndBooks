package WordChain_2209_Z;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TryBubleSort {
    // из Киев Нью-Йорк    Алмата
    //   Крымск
    //Амстердам    Вена
    //   Мельбурн               Аланга
    //		Москва
    //Вашингтон
    // НЕ выдает _ Правильной последовательности
    // Мельбурн Нью-Йорк Крымск Киев Вена Аланга Амстердам Москва Алмата Вашингтон
    // ПОстоянно какие-то неурядицы и ошибки с загвостками
    private static ArrayList<Word> listWords = new ArrayList<>();

    public static void main(String[] args) {
        String fileName = SimpleMethods.getPath()[2];
        String[] words = null;
        try (BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            //             BufferedReader fileReader = new BufferedReader(new FileReader(fileName, Charset.forName("cp1251")))) {
            String content = fileReader.lines().collect(Collectors.joining(" "));
            words = content.split("\\s+");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(words));

        listWords = new ArrayList<>();
        for (String item : words) {
            listWords.add(new Word(item));
        }

        // со словами более 5ти просиходит бессканечная перестановка
        boolean flag = false;
        Word currentW, nextW, tmp;
        String letterToWordsFL;
        while (!flag) {
            flag = true; // ставим true чтоб преравлось, если..
            for (int i = 0, j = i + 1; i < listWords.size() - 1; i++, j++) {
                currentW = listWords.get(i);
                nextW = listWords.get(j);
                letterToWordsFL = String.valueOf(currentW.getCharLast()) + String.valueOf(nextW.getCharFirst());
                // если текущ последовательность не корректна и это не последняя интерация
                if (currentW.getCharLast() != nextW.getCharFirst() & j != listWords.size() - 1) {
                    // пытаемся подобрать расстановку смены индексов слов, с учетом текущей последовательности
                    flag = false;
                    // пытаемся подобрать корректное слово (связывающее два текущих) между текущ словами
                    if (!tryAddBetweenWords(letterToWordsFL, j, nextW)) { // если вернуло false т.е. слова не нашлось
                        // пытаемся подобрать текущему currentW слову, следующее за ним слово
                        if (!tryAddRightNextWord(j, currentW, nextW)) { // если не удалось
                            // нет слов, что подошли бы currentW текущему слову (c одной стороны с справа)
                            // то, кидаем такое currentW слово в конец списка
                            tmp = currentW;
                            listWords.remove(i); // если в процессе не совпадет с цепью
                            listWords.add(currentW); // то будет смена комбинаций при след интерации
                        }
                    }
                    // если текущ последовательность не корректна и это последняя интерация
                } else if (currentW.getCharLast() != nextW.getCharFirst() & j == listWords.size() - 1) {
                    flag = false;
                    tmp = listWords.get(0); // при след интерации
                    listWords.set(0, nextW); // это слово будет первым
                    listWords.remove(j);
                    listWords.add(tmp); // а первое последним
                }
            }
        }
        listWords.forEach(v -> System.out.print(v + " "));
    }

    // вставка след словом
    private static boolean tryAddRightNextWord(int j, Word currentW, Word nextW) {
        Word tmp;
        for (int k = 0; k < listWords.size(); k++) {
            if (currentW.getCharLast() == listWords.get(k).getCharFirst()
                    & k != (j - 1) & k != j) { // проверяем что индекс не равен слову, которому ищем пару
                tmp = listWords.get(k);
                listWords.remove(k);
                // подходящее слово станет nextW, а
                listWords.add(nextW); // next, кидаем в конец списка
                listWords.set(j, tmp);  // заменяем next на подход слово
                return true;
            }
        }
        return false;
    }

    // вставка между слов
    private static boolean tryAddBetweenWords(String letterToWordsFL, int j, Word nextW) {
        for (int k = 0; k < listWords.size(); k++) {
            // если подобрано слово, что можно вставить между этих текущих i j слов
            if (listWords.get(k).getLetterFL().equals(letterToWordsFL)
                    // проверяем что индекс, не равен словам которым ищем соединительное слово
                    & k != j & k != (j - 1)) { // слово не является не самим этим же предыдущ ил след словом
                listWords.set(j, listWords.get(k));  // заменяем next на подход слово
                listWords.set(j + 1, nextW); // слово next будет следующим после подходящего
                return true;
            }
        }
        return false;
    }

    public static void bubleSortInt() {
        int[] numArr = {9, 8, 3, 6, 0,};
        System.out.println(Arrays.toString(numArr));

        boolean flag = false;
        int current, next;
        while (!flag) {
            flag = true;
            for (int i = 0, j = i + 1; i < numArr.length - 1; i++, j++) {
                current = numArr[i];
                next = numArr[j];
                if (current > next) {
                    flag = false;
                    numArr[i] = next;
                    numArr[j] = current;
                }
            }
        }
        System.out.println(Arrays.toString(numArr));
    }
}
