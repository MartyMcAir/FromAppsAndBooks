package b_BigTusks.Crossword_2027_Z;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class SolutionCopy2 {
    // Класс Solution не должен содержать статические поля.
//    private static List<Word> res = new ArrayList<Word>();

    public static void main(String[] args) {
        int[][] crosswordLine = new int[][]{
                {'s', 'a', 'm', 'e', 'l', 's'},
                {'d', 'a', 'o', 'm', 'a', 's'},
                {'a', 'a', 'm', 'e', 'a', 'e'},
                {'s', 'a', 'e', 'm', 'o', 'h'},
                {'f', 'a', 'e', 'e', 'j', 'a'},
                {'d', 'o', 'm', 'e', 'j', 's'}
        };
        int[][] diagonal = new int[][]{
                {'s', 'e', 'm', 'h', 'h'},
                {'e', 'a', 'm', 'e', 's'}, // как начать перебор с следующего i!?
                {'a', 'm', 'm', 'a', 's'}, // или может изменить алгоритм так чтобы было с самого низу
                {'e', 'o', 'a', 'e', 's'}, // до самого верху
                {'h', 'e', 'm', 's', 's'},
                {'h', 'e', 'e', 'e', 'j'}
        };
        int[][] crosswordVertical = new int[][]{
                {'s', 'a', 'm', 'f', 'l', 'e'},
                {'a', 's', 'a', 'm', 'k', 'm'},
                {'m', 'a', 'g', 'r', 'e', 'o'},
                {'e', 'g', 'p', 'r', 'f', 'h'},
                {'s', 'e', 'e', 'e', 'a', 'j'},
                {'s', 'o', 'e', 'e', 's', 's'}
        };
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
//        List<Word> res = detectAllWords(diagonal, "home", "same");
        List<Word> res = detectAllWords(diagonal, "same", "home");
        res.forEach(v -> System.out.println(v));

        /*
Ожидаемый результат
home - (j-startY, i-startX) - (j-endY, i-endX) // home по диагонали справа на лево _ снизу вверх
same - (1, 1) - (4, 1) // вторая строка слева на право

home - (5, 3) - (2, 0) // home по диагонали справа на лево _ снизу вверх
same - (1, 1) - (4, 1) // вторая строка слева на право
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> rrr = new ArrayList<>();
        List<Word> listLine = null, listVertical = null, listDiagonal = null;
        for (int k = 0; k < words.length; k++) {
            String currentW = words[k];
            for (int i = 0; i < crossword.length; i++) {
                listLine = checkOneLine(i, crossword[i], currentW);
                if (!listLine.isEmpty()) {
                    for (Word item : listLine) {
//                        rrr.add(item);
                    }
                }
            }
            listVertical = checkVertical(crossword, currentW);
            if (!listVertical.isEmpty()) {
                for (Word item : listVertical) {
//                    rrr.add(item);
                }
            }
            listDiagonal = checkDiagonal(crossword, currentW);
            if (!listDiagonal.isEmpty()) {
                for (Word item : listDiagonal) {
                    rrr.add(item);
                }
            }
        }

        return rrr;
    }

    public static List<Word> checkDiagonal(int[][] crossword, String word) {
        List<Word> resFull = new ArrayList<Word>();

        List<Word> res1 = diagonal1(crossword, word); // сверху вниз справо на лево
        List<Word> res2 = diagonal2(crossword, word); // снизу вверх слева на право
        List<Word> res3 = diagonal3(crossword, word); // сверху вниз слева на право
        List<Word> res4 = diagonal4(crossword, word); // снизу вверх справо на лево

        if (!res1.isEmpty()) {
            for (Word item : res1) {
//                resFull.add(item);
            }
        }
        if (!res2.isEmpty()) {
            for (Word item : res2) {
//                resFull.add(item);
            }
        }
        if (!res3.isEmpty()) {
            for (Word item : res3) {
//                resFull.add(item);
            }
        }
        if (!res4.isEmpty()) {
            for (Word item : res4) {
                resFull.add(item);
            }
        }
        return resFull;
    }

    public static List<Word> diagonal1(int[][] crossword, String word) { // сверху вниз справо на лево
        List<Word> res1 = new ArrayList<Word>();
        Word wordW = null;
        char[] currentChar = word.toCharArray();

        boolean flag = false, flagR = false, flagReverse = false, flagReverseR = false, flagDiagonal = false;
        int tmpStartJ = -1, tmpStartI = -1, tmpStartReverseJ = -1, tmpStartReverseI = -1;
        int tmpStJ = -1, tmpStI = -1, tmpStRevJ = -1, tmpStRevI = -1;
        int jLoopReverse = crossword[0].length - 1;

        int iChar = 0, iReverse = currentChar.length - 1, iCharR = 0, iReverseR = currentChar.length - 1;

        // for loop
        int lineCounter = crossword[0].length - 1, lineCounterTmp = crossword[0].length - 1;
        int i = 0, j = 0;
        while (lineCounter > 0) { // сверху вниз
            if (i >= crossword.length | j >= crossword[0].length) { // инкрементеры декрементеры
                i = 0;
                lineCounter -= 1;
                j = lineCounterTmp - lineCounter;
                jLoopReverse = lineCounterTmp - j;
//                System.out.println();
            }
//            System.out.print((char) crossword[i][j] + " ");
//            System.out.print((char) crossword[i][jLoopReverse] + " ");
            ///////////////////////////////////////////////////////
            // для цикла по диагонали сврерху вниз справо налево   // ПО ПОРЯДКУ
            if (!(Character.compare(currentChar[iCharR], (char) crossword[i][jLoopReverse]) == 0) // CLOSE
                    | flagR & Character.compare(currentChar[0], (char) crossword[i][jLoopReverse]) == 0) {
                // доп проверка если, две подряд повторяющиеся первые буквы
                iCharR = 0;
                flagR = false;
            }
            if (Character.compare(currentChar[iCharR], (char) crossword[i][jLoopReverse]) == 0) { // OPEN
                if (!flagR) {
                    tmpStJ = jLoopReverse;
                    tmpStI = i;
                    flagR = true;
                }
                if (iCharR == currentChar.length - 1 & flagR) {
                    wordW = new Word(word);
                    wordW.setStartPoint(tmpStJ, tmpStI);
                    wordW.setEndPoint(jLoopReverse, i);
                    res1.add(wordW);
                    iCharR = 0;
                    flagR = false;
                    System.out.println(1); // Good сверху вниз справо на лево
                }
                iCharR++;
            }
            ///////////////////////////////////////////////////////
            jLoopReverse--;
            i++;
            j++;
        }
        return res1;
    }

    public static List<Word> diagonal2(int[][] crossword, String word) { // снизу вверх слева на право
        List<Word> res2 = new ArrayList<Word>();
        Word wordW = null;
        char[] currentChar = word.toCharArray();

        boolean flag = false, flagR = false, flagReverse = false, flagReverseR = false, flagDiagonal = false;
        int tmpStartJ = -1, tmpStartI = -1, tmpStartReverseJ = -1, tmpStartReverseI = -1;
        int tmpStJ = -1, tmpStI = -1, tmpStRevJ = -1, tmpStRevI = -1;
        int jLoopReverse = crossword[0].length - 1;

        int iChar = 0, iReverse = currentChar.length - 1, iCharR = 0, iReverseR = currentChar.length - 1;
        // for loop
        int lineCounter = crossword[0].length - 1, lineCounterTmp = crossword[0].length - 1;
        int i = 0, j = 0;

        while (lineCounter > 0) { // сверху вниз
            if (i >= crossword.length | j >= crossword[0].length) { // инкрементеры декрементеры
                i = 0;
                lineCounter -= 1;
                j = lineCounterTmp - lineCounter;
                jLoopReverse = lineCounterTmp - j;
//                System.out.println();
            }
//            System.out.print((char) crossword[i][j] + " ");
//            System.out.print((char) crossword[i][jLoopReverse] + " ");
            ///////////////////////////////////////////////////////
            // В ОБРАТНОМ ПОРЯДКЕ
            if (!(Character.compare(currentChar[iReverseR], (char) crossword[i][jLoopReverse]) == 0) // CLOSE
                    | flagReverseR & Character.compare(currentChar[currentChar.length - 1], (char) crossword[i][j]) == 0) {
                iReverseR = currentChar.length - 1;
                flagReverseR = false;
            }
            if (Character.compare(currentChar[iReverseR], (char) crossword[i][jLoopReverse]) == 0) { // OPEN
                if (!flagReverseR) {
                    tmpStRevJ = jLoopReverse;
                    tmpStRevI = i;
                    flagReverseR = true;
                }
                if (iReverseR == 0 & flagReverseR) {
                    wordW = new Word(word);
                    wordW.setStartPoint(jLoopReverse, i);
                    wordW.setEndPoint(tmpStRevJ, tmpStRevI);
                    res2.add(wordW);
                    iReverseR = currentChar.length - 1;
                    flagReverseR = false;
                    System.out.println(2); // Good снизу вверх слева на право
                }
                iReverseR--;
            }
            ///////////////////////////////////////////////////////
            jLoopReverse--;
            i++;
            j++;
        }
        return res2;
    }

    public static List<Word> diagonal3(int[][] crossword, String word) { // сверху вниз слева на право
        List<Word> res3 = new ArrayList<Word>();
        Word wordW = null;
        char[] currentChar = word.toCharArray();

        boolean flag = false, flagR = false, flagReverse = false, flagReverseR = false, flagDiagonal = false;
        int tmpStartJ = -1, tmpStartI = -1, tmpStartReverseJ = -1, tmpStartReverseI = -1;
        int tmpStJ = -1, tmpStI = -1, tmpStRevJ = -1, tmpStRevI = -1;
        int jLoopReverse = crossword[0].length - 1;

        int iChar = 0, iReverse = currentChar.length - 1, iCharR = 0, iReverseR = currentChar.length - 1;

        // for loop
        int lineCounter = crossword[0].length - 1, lineCounterTmp = crossword[0].length - 1;
        int i = 0, j = 0;

        while (lineCounter > 0) { // сверху вниз
            if (i >= crossword.length | j >= crossword[0].length) { // инкрементеры декрементеры
                i = 0;
                lineCounter -= 1;
                j = lineCounterTmp - lineCounter;
                jLoopReverse = lineCounterTmp - j;
//                System.out.println();
            }
//            System.out.print((char) crossword[i][j] + " ");
//            System.out.print((char) crossword[i][jLoopReverse] + " ");
            ///////////////////////////////////////////////////////
            // для цикла по диагонали сверху вниз слева направо // ПО ПОРЯДКУ
            if (!(Character.compare(currentChar[iChar], (char) crossword[i][j]) == 0) // CLOSE
                    | flag & Character.compare(currentChar[0], (char) crossword[i][j]) == 0) {
                iChar = 0;
                flag = false;
            }
            if (Character.compare(currentChar[iChar], (char) crossword[i][j]) == 0) { // OPEN
                if (!flag) {
                    tmpStartJ = j;
                    tmpStartI = i;
                    flag = true;
                }
                if (iChar == currentChar.length - 1 & flag) {
                    wordW = new Word(word);
                    wordW.setStartPoint(tmpStartJ, tmpStartI);
                    wordW.setEndPoint(j, i);
                    res3.add(wordW);
                    iChar = 0;
                    flag = false;
                    System.out.println(3); // Good сверху вниз слева на право
                }
                iChar++;
            }
            ///////////////////////////////////////////////////////
            jLoopReverse--;
            i++;
            j++;
        }

        return res3;
    }

    public static List<Word> diagonal4(int[][] crossword, String word) { // снизу вверх справо на лево
        List<Word> res4 = new ArrayList<Word>();
        Word wordW = null;
        char[] currentChar = word.toCharArray();

        boolean flag = false, flagR = false, flagReverse = false, flagReverseR = false, flagDiagonal = false;
        int tmpStartJ = -1, tmpStartI = -1, tmpStartReverseJ = -1, tmpStartReverseI = -1;
        int tmpStJ = -1, tmpStI = -1, tmpStRevJ = -1, tmpStRevI = -1;
        int jLoopReverse = crossword[0].length - 1;

        int iChar = 0, iReverse = currentChar.length - 1, iCharR = 0, iReverseR = currentChar.length - 1;

        // for loop
        int lineCounter = crossword[0].length - 1, lineCounterTmp = crossword[0].length - 1;
        int i = 0, j = 0, k = 0;
        System.out.println("word is: " + word);
        while (k < (crossword.length * crossword[0].length)) { // сверху вниз
            if (lineCounter > 0) {
                lineCounter = crossword[0].length - 1;
                i++;
            }
            if (i >= crossword.length | j >= crossword[0].length) { // инкрементеры декрементеры
                i = 0;
                lineCounter -= 1;
                j = lineCounterTmp - lineCounter;
                jLoopReverse = lineCounterTmp - j;
                System.out.println();
            }
            System.out.print((char) crossword[i][j] + ", checked: " + currentChar[iReverse] + " _ ");
//            System.out.print((char) crossword[i][jLoopReverse] + " ");

            // В ОБРАТНОМ ПОРЯДКЕ
            if (!(Character.compare(currentChar[iReverse], (char) crossword[i][j]) == 0) // CLOSE
                    | flagReverse & Character.compare(currentChar[currentChar.length - 1], (char) crossword[i][j]) == 0) {
                // доп проверка если, две подряд повторяющиеся первые буквы
                iReverse = currentChar.length - 1;
                flagReverse = false;
            }
            if (Character.compare(currentChar[iReverse], (char) crossword[i][j]) == 0) { // OPEN
                if (!flagReverse) {
                    tmpStartReverseJ = j;
                    tmpStartReverseI = i;
                    flagReverse = true;
                }
                if (iReverse == 0 & flagReverse) {
                    wordW = new Word(word);
                    wordW.setStartPoint(j, i);
                    wordW.setEndPoint(tmpStartReverseJ, tmpStartReverseI);
                    res4.add(wordW);
                    iReverse = currentChar.length - 1;
                    flagReverse = false;
                    System.out.println(4); // снизу вверх справо на лево
                }
                iReverse--;
            }
            jLoopReverse--;
            i++;
            j++;
            k++;
        }
        System.out.println(res4.toString());
        return res4;
    }

    public static List<Word> checkVertical(int[][] crossword, String word) {
        List<Word> res = new ArrayList<Word>();

        char[] currentChar = word.toCharArray();
        boolean flag = false, flagReverse = false;
        Word wordV = null;
        int tmpStartJ = -1, tmpStartI = -1, tmpStartReverseJ = -1, tmpStartReverseI = -1,
                iChar = 0, iReverse = currentChar.length - 1;
        int i = 0, j = 0, k = 0;

        while (k < (crossword.length * crossword[0].length)) { // общее кол-во интераций
            if (i > crossword.length - 1) {
                i = 0;   // обнуление для след вертикалки
                j++;
            }

            // ПО ПОРЯДКУ
            if (!(Character.compare(currentChar[iChar], (char) crossword[i][j]) == 0) // CLOSE
                    | flag == true & Character.compare(currentChar[0], (char) crossword[i][j]) == 0) {
                // доп проверка если, две подряд повторяющиеся первые буквы
                iChar = 0;
                flag = false;
            }
            if (Character.compare(currentChar[iChar], (char) crossword[i][j]) == 0) { // OPEN
                if (!flag) {
                    tmpStartJ = j;
                    tmpStartI = i;
                    flag = true;
                }
                if (iChar == currentChar.length - 1 & flag) {
                    wordV = new Word(word);
                    wordV.setStartPoint(tmpStartJ, tmpStartI);
                    wordV.setEndPoint(j, i);
                    res.add(wordV);
                    iChar = 0;
                    flag = false;
//                    break; // если full последовательность прерываем
                }
                iChar++;
            }

            // В ОБРАТНОМ ПОРЯДКЕ
            if (!(Character.compare(currentChar[iReverse], (char) crossword[i][j]) == 0) // CLOSE
                    | flagReverse == true & Character.compare(currentChar[currentChar.length - 1], (char) crossword[i][j]) == 0) {
                iReverse = currentChar.length - 1;
                flagReverse = false;
            }
            if (Character.compare(currentChar[iReverse], (char) crossword[i][j]) == 0) { // OPEN
                if (!flagReverse) {
                    tmpStartReverseJ = j;
                    tmpStartReverseI = i;
                    flagReverse = true;
                }
                if (iReverse == 0 & flagReverse) {
                    wordV = new Word(word);
                    wordV.setStartPoint(j, i);
                    wordV.setEndPoint(tmpStartReverseJ, tmpStartReverseI);
                    res.add(wordV);
                    iReverse = currentChar.length - 1;
                    flagReverse = false;
//                    break; // если full последовательность прерываем
                }
                iReverse--;
            }
            i++;
            k++;
        }
        return res;
    }

    public static List<Word> checkOneLine(int mainI, int[] crossword, String word) {
        List<Word> res = new ArrayList<Word>();

        char[] currentChar = word.toCharArray();
        boolean flag = false, flagReverse = false;
        Word wordV = null;
        int tmpStartJ = -1, tmpStartReverseJ = -1, iChar = 0, iReverse = currentChar.length - 1;

        // по порядку
        for (int j = 0; j < crossword.length; j++) {
            // ПО ПОРЯДКУ
            // если найдено совпадение и последовательность сохраняется
            if (!(Character.compare(currentChar[iChar], (char) crossword[j]) == 0)
                    | // CLOSE
                    flag & Character.compare(currentChar[0], (char) crossword[j]) == 0) {
                // доп проверка если, две подряд повторяющиеся первые буквы
                iChar = 0;
                flag = false;
            }
            if (Character.compare(currentChar[iChar], (char) crossword[j]) == 0) { // OPEN
                if (!flag) {
                    tmpStartJ = j;
                    flag = true;
                }
                if (iChar == currentChar.length - 1 & flag) {
                    wordV = new Word(word);
                    wordV.setStartPoint(tmpStartJ, mainI);
                    wordV.setEndPoint(j, mainI);
                    res.add(wordV); // найденное добавляем в список и обнуляем iChar и flag
                    iChar = 0;
                    flag = false;
                }
                iChar++;
            }

            // В ОБРАТНОМ ПОРЯДКЕ
            if (!(Character.compare(currentChar[iReverse], (char) crossword[j]) == 0)
                    | // CLOSE
                    flagReverse & Character.compare(currentChar[currentChar.length - 1], (char) crossword[j]) == 0) {
                iReverse = currentChar.length - 1;
                flagReverse = false;
            }
            if (Character.compare(currentChar[iReverse], (char) crossword[j]) == 0) { // OPEN
                if (!flagReverse) {
                    tmpStartReverseJ = j;
                    flagReverse = true;
                }
                if (iReverse == 0 & flagReverse) {
                    wordV = new Word(word);
                    wordV.setStartPoint(j, mainI);
                    wordV.setEndPoint(tmpStartReverseJ, mainI);
                    res.add(wordV);
                    iReverse = currentChar.length - 1;
                    flagReverse = false;
                }
                iReverse--;
            }
        }
        return res;
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
