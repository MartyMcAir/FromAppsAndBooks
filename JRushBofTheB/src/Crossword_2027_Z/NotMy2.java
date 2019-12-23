package Crossword_2027_Z;

import java.util.ArrayList;
import java.util.List;

// взял тут https://github.com/ZdorenkoS/JavaRushTasks/blob/master/2.JavaCore/src/com/javarush/task/task20/task2027/Solution.java
// by https://javarush.ru/users/1371611
public class NotMy2 {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> res = detectAllWords(crossword, "home", "same");
        System.out.println(res);

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (String s : words) {
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (s.charAt(0) == crossword[i][j]) {
                        Word w = new Word(s);
                        w.setStartPoint(j, i);
                        // указываем координаты за пределами массива, чтобы потом отфильтровать слова (есть первая буква, но нет слова полностью)
                        w.setEndPoint(-1, -1);
                        NotMy2 solution = new NotMy2();
                        // вызываем findLast который проверяет слово и устанавливает координаты последней буквы
                        solution.findLast(crossword, w, w.startX, w.startY, 1, 0, 1);
                        solution.findLast(crossword, w, w.startX, w.startY, 1, 0, -1);
                        solution.findLast(crossword, w, w.startX, w.startY, 1, 1, 0);
                        solution.findLast(crossword, w, w.startX, w.startY, 1, -1, 0);
                        solution.findLast(crossword, w, w.startX, w.startY, 1, -1, -1);
                        solution.findLast(crossword, w, w.startX, w.startY, 1, -1, 1);
                        solution.findLast(crossword, w, w.startX, w.startY, 1, 1, 1);
                        solution.findLast(crossword, w, w.startX, w.startY, 1, 1, -1);
                        // если слово имеет корректные координаты добавляем в список
                        if (w.endX != -1 && w.endY != -1) list.add(w);
                    }
                }
            }
        }
        return list;
    }

    // передаем массив, обьект, координаты первой буквы, номер символа text который проверяем, направление смещения
    public void findLast(int[][] crossword, Word w, int startX, int startY, int z, int x, int y) {
        try {
            // если символ с заданным смещением равен следующему символу в text - продолжаем проверку
            if (crossword[startY + y][startX + x] == w.text.charAt(z)) {
                // если проверили последний символ в text устанавливаем ему endX и endY
                if (z == w.text.length() - 1) {
                    w.setEndPoint(startX + x, startY + y);
                } else
                    // метод вызывает сам себя с новыми параметрами
                    findLast(crossword, w, startX + x, startY + y, ++z, x, y);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
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
