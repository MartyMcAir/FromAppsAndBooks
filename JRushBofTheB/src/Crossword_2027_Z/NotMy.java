package Crossword_2027_Z;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// взято тут https://drive.google.com/drive/folders/1E-dQvskO1nxOWR0qWzM1ZcX9K5FSkOxT
// by https://javarush.ru/users/1821206
public class NotMy {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'i', 'a', 'r', 'o', 'v'},
                {'m', 't', 'p', 'm', 'r', 'h'},
                {'p', 'e', 'e', 'e', 'h', 'j'}
        };
        for (Word w : detectAllWords(crossword, "home", "same")) {
            System.out.println(w.toString());
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        Word newWord;
        char[] chars;
        int tempI = 0;
        int tempJ = 0;
        ArrayList<Word> wordList = new ArrayList<>();
        for (String word : words) { // перебираем слова из words (String... words - массив стрингов переданных в этот метод из main)
            chars = word.toCharArray();
            for (int i = 0; i < crossword.length; i++) {            // перебираем массив crossword
                for (int j = 0; j < crossword[i].length; j++) {
                    if (crossword[i][j] == chars[0]) {              // если первый символ найден, запускаем поиск следующих вокруг него
                        HashMap<Integer, StringBuilder> temp = new HashMap<>(); // создали коллекцию, или пересоздали ее в случае нахождения еще одного первого(стартового)символа
                        for (int k = 1; k < chars.length; k++) {    // запускаем нижний цикл "k" раз (кол-во оставшихся для поиска букв)
                            for (int c = 0; c < 8; c++) {
                                switch (c) {                        // перебираем по всем направлениям от найденного первого символа
                                    case (0):
                                        tempI = i - k;
                                        tempJ = j;
                                        break;                     // ↑
                                    case (1):
                                        tempI = i - k;
                                        tempJ = j + k;
                                        break;                     // ↗
                                    case (2):
                                        tempI = i;
                                        tempJ = j + k;
                                        break;                     // →
                                    case (3):
                                        tempI = i + k;
                                        tempJ = j + k;
                                        break;                     // ↘
                                    case (4):
                                        tempI = i + k;
                                        tempJ = j;
                                        break;                     // ↓
                                    case (5):
                                        tempI = i + k;
                                        tempJ = j - k;
                                        break;                     // ↙
                                    case (6):
                                        tempI = i;
                                        tempJ = j - k;
                                        break;                     // ←
                                    case (7):
                                        tempI = i - k;
                                        tempJ = j - k;
                                        break;                     // ↖
                                }

                                if (tempI >= 0 && tempI < crossword.length) {            // проверка на не выход за пределы массива
                                    if (tempJ >= 0 && tempJ < crossword[i].length) {     // проверка на не выход за пределы массива

                                        if (k == 1) {                                    // на совпадении второй буквы создаем и заполняем StringBuilder
                                            StringBuilder sb = new StringBuilder();      // затем забрасываем его в коллекцию
                                            sb.append(i);
                                            sb.append(" ");
                                            sb.append(j);
                                            sb.append(" ");
                                            sb.append((char) crossword[i][j]);
                                            sb.append((char) crossword[tempI][tempJ]);
                                            temp.put(c, sb);
                                        } else {
                                            temp.get(c).append((char) crossword[tempI][tempJ]); // если нашли 3-й...итд символ(любую букву)просто дополняем обьект прямо в коллекции
                                        }

                                        if (k == chars.length - 1) {                            // если это последний символ то добавляем его кооринаты
                                            temp.get(c).append(" ");
                                            temp.get(c).append(tempI);
                                            temp.get(c).append(" ");
                                            temp.get(c).append(tempJ);
                                        }
                                    }
                                }
                            }
                        }
                        for (Map.Entry<Integer, StringBuilder> entry : temp.entrySet()) {       // проверяем список temp на наличие искомых слов
                            String tmpStr = entry.getValue().toString();
                            String[] arr = tmpStr.split(" ");
                            if (arr.length == 5 && arr[2].equals(word)) {                       // высекаем строки в которых есть нужные нам слова и верное количество координат
                                newWord = new Word(arr[2]);
                                newWord.setStartPoint(Integer.parseInt(arr[1]), Integer.parseInt(arr[0]));
                                newWord.setEndPoint(Integer.parseInt(arr[4]), Integer.parseInt(arr[3]));
                                wordList.add(newWord);
                            }
                        }
                    }
                }
            }
        }
        return wordList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
