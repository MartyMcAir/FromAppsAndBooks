package b_BigTusks.Game_2048_3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model_My3 {
    private static final int FIELD_WIDTH = 3; // 4
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    public int score = 0; // текущий счет
    public int maxTile = 0; // максимальный вес плитки на игровом поле
    private boolean isSaveNeeded = true;

    public Model_My3() {
        resetGameTiles();
    }

    public static void main(String[] args) {
        Model_My3 m = new Model_My3();
        Tile[] tileArr = new Tile[]{new Tile(4), new Tile(2), new Tile(0), new Tile(4)};
//        Tile[][] gTiles = new Tile[][]{
//                {new Tile(4), new Tile(4), new Tile(2), new Tile(0)}, // 8 2
//                {new Tile(4), new Tile(2), new Tile(0), new Tile(4)}, // 4 2 4
//                {new Tile(4), new Tile(4), new Tile(4), new Tile(0)}, // 8 4
//                {new Tile(4), new Tile(4), new Tile(4), new Tile(4)}}; // 8 8
        Tile[][] gTiles = new Tile[][]{
                {new Tile(1), new Tile(2), new Tile(3),},
                {new Tile(4), new Tile(5), new Tile(6),},
                {new Tile(7), new Tile(8), new Tile(9),}};
        m.gameTiles = gTiles;
        // Input
        // 1  2  3
        // 4  5  6
        // 7  8  9

        // Output:
        // 3  6  9
        // 2  5  8
        // 1  4  7
        for (int i = 0; i < gTiles.length; i++) {
//            m.mergeTiles(gTiles[i]);
//            m.compressTiles(gTiles[i]); // комментим чтоб не сбиваться
        }
//        System.out.println(Arrays.toString(tileArr));

        m.left();   // закоммментили addTile() - в left() _ -чтоб при проверке не добавлялась плитка
//        m.rotate();
        m.rotateMy();
        Arrays.stream(m.gameTiles).forEach(v -> System.out.println(Arrays.toString(v)));
//        for (int i = 0; i < gTiles.length; i++) {
//            for (int j = 0; j < gTiles[i].length; j++) {
//                System.out.print(gTiles[i][j] + ", ");
//            }
//            System.out.println();
//        }
    }

    private void rotate() {
        int length = FIELD_WIDTH; // gameTiles.length

        // при первой интерации [0 0] -> [0 2] -> [2 2] -> [2 0] -> [0 0]
        // при второй интерации [0 1] -> [1 2] -> [2 1] -> [1 0] -> [0 1]
        // Consider all squares one by one
        for (int i = 0; i < length / 2; i++) {
            // Consider elements in group of 4 in current square
            for (int j = i; j < length - i - 1; j++) {
                // store current cell in temp variable
                Tile temp = gameTiles[i][j]; // [0 0] _ [0 1]

                // move values from right to top
                // [0 0] = [0 2] _ [0 1] = [1 2]
                gameTiles[i][j] = gameTiles[j][length - 1 - i];

                // move values from bottom to right
                // [0 2] = [2 2] _ [1 2] = [2 1]
                gameTiles[j][length - 1 - i] = gameTiles[length - 1 - i][length - 1 - j];

                // move values from left to bottom
                // [2 2] = [2 0] _ [2 1] = [1 0]
                gameTiles[length - 1 - i][length - 1 - j] = gameTiles[length - 1 - j][i];

                // assign temp to left
                gameTiles[length - 1 - j][i] = temp; // [2 0] = [0 0] _ [1 0] = [0 1]
            }
        }
    }

    // Input
    // 1[0 0]  2[0 1]  3[0 2]
    // 4[1 0]  5[1 1]  6[1 2]
    // 7[2 0]  8[2 1]  9[2 2]

    // Output:
    // 3[0 0]  6[0 1]  9[0 2]
    // 2[1 0]  5[1 1]  8[1 2]
    // 1[2 0]  4[2 1]  7[2 2]

    // смена индексов
    // [0 0] -> [2 0]   _   [0 1]=>[1 0]
    // [2 0] -> [2 2]   _   [2 1]=>[1 2]
    // [2 2] -> [0 2]   _   [2 1]=>[1 2]
    // [0 2] -> [0 0]   _   [0 1]=>[1 0]
    private void rotateMy() {
        //        gameTiles
        Tile tmp1, tmp2, tmp3, tmp4;
        int outerDown = gameTiles.length - 1;
        int outerUp = 0;
        for (int i = 0; i < gameTiles.length; i++) {

            for (int j = 0, k = gameTiles[i].length - 1; j < gameTiles[i].length; j++, k--) {
                int innerDown = gameTiles[i].length - 1;
                int innerUp = 0;

                tmp1 = gameTiles[outerUp][innerUp]; // [0 0]=1
                tmp2 = gameTiles[outerDown][innerUp]; // [2 0]=7
                tmp3 = gameTiles[outerDown][innerDown]; // [2 2]=9
                tmp4 = gameTiles[outerUp][innerDown]; // [0 2]=3

                // 1 swap 7
                gameTiles[outerUp][innerUp] = tmp2;     // [0 0] -> [2 0]
                // 7 swap 9
                gameTiles[outerDown][innerUp] = tmp3;     // [2 0] -> [2 2]
                // 7 swap 3
                gameTiles[outerDown][innerDown] = tmp4;     // [2 2] -> [0 2]
                // 3 swap 1
                gameTiles[outerUp][innerDown] = tmp1;     // [0 2] -> [0 0]

                innerDown--;
                innerUp++;
            }
            outerDown--;
            outerUp++;
        }
    }

    // Метод resetGameTiles должен заполнять массив gameTiles новыми плитками и менять значение
    // двух из них с помощью двух вызовов метода addTile.
    public void resetGameTiles() {
        this.maxTile = 0;
        this.score = 0;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private List<Tile> getEmptyTiles() { // Метод getEmptyTiles должен возвращать список пустых плиток в массиве gameTiles.
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    list.add(gameTiles[i][j]);
                }
            }
        }
        return list;
    }

    public void down() {
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void right() {
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void up() {
        // Метод up НЕ должен изменять массив gameTiles если перемещение вверх невозможно.
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    // аждой строки массива gameTiles вызывать методы compressTiles и mergeTiles и добавлять одну плитку
    // с помощью метода addTile в том случае, если это необходимо.
    public void left() {
//        for (int i = 0; i < gameTiles.length; i++) {
//        for (int j = 0; j < FIELD_WIDTH; j++) { // мое не принимает
//            if (mergeTiles(gameTiles[j]) | compressTiles(gameTiles[j])) { // если сдвиг внес изменения
//                addTile();
//            }
//        }
//        }

        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged) {
//            addTile();
            isSaveNeeded = true;
        }
    }


    private boolean compressTiles(Tile[] tiles) { // сдвигаем цифры влево - убирая, все нули.., по типу счетчика
        Tile current, next;
        boolean flag = false;
        for (int k = 0, m = 1, counter = 0; k < tiles.length - 1; k++, m++) {
            current = tiles[k];
            next = tiles[m];
            if (current.value > 0) {
                tiles[counter].setValue(current.value);
                if (counter != k) { // если индекс counter не равен текущему т.е. i
                    current.setValue(0); // а иначе, сам бы себя обнулял
                    flag = true;
                }
                counter++;
            }
            if (current.value == 0 & m == tiles.length - 1 & next.value > 0) { // на последнем элементе
                tiles[counter].setValue(next.value);
                next.setValue(0);
                flag = true;
            }
        }
        return flag;
    }

    private boolean mergeTiles(Tile[] tiles) {
        Tile current, next;
        // new Tile[]{new Tile(2), new Tile(4), new Tile(4), new Tile(4)};
        boolean flag = false, ischange = false;
        int count = 0;
        while (!flag & count < 1) {
//        while (!flag & count < (tiles.length / 4)) {
            flag = true;
            for (int i = 0, j = 1; i < tiles.length - 1; j++, i++) {
                current = tiles[i];
                next = tiles[j];
                if (current.value == next.value & current.value != 0) {
                    current.setValue(current.value + next.value);
                    next.setValue(0);
                    flag = false; // даем знать что была перестановка
                    ischange = true;
                    this.score += tiles[i].getValue(); // и обновляем score
                }
            }
            ///--------------------------/// ___ после всех операций
            if (compressTiles(tiles)) { // сдвигаем цифры влево - убирая, все нули.., по типу счетчика
                ischange = true; // выставляем что были изменения
            }
            ///--------------------------///
            count++;
        }

        for (int i = 0; i < tiles.length; i++) { // вычисляем максмал значение
            if (tiles[i].value > maxTile) {
                this.maxTile = tiles[i].value; // сеттим если, нов. значение больше предыдущего
            }
        }
        return ischange;
    }


    private void addTile() {
        List<Tile> list = getEmptyTiles();
        if (list != null && list.size() != 0) { // про setValue - не сказано
            list.get((int) (list.size() * Math.random())).setValue(Math.random() < 0.9 ? 2 : 4);
        }
    }

}
