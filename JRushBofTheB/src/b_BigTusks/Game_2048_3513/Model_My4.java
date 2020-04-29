package b_BigTusks.Game_2048;

import java.util.ArrayList;
import java.util.List;

public class Model_My4 {
    private static final int FIELD_WIDTH = 4; // 4
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    public int score = 0; // текущий счет
    public int maxTile = 0; // максимальный вес плитки на игровом поле
    private boolean isSaveNeeded = true;

    public Model_My4() {
        resetGameTiles();
    }

    public static void main(String[] args) {
        Model_My4 m = new Model_My4();
        Tile[] tileArr = new Tile[]{new Tile(4), new Tile(2), new Tile(0), new Tile(4)};
//        Tile[][] gTiles = new Tile[][]{
////                {new Tile(4), new Tile(4), new Tile(2), new Tile(0)}, // 8 2
////                {new Tile(4), new Tile(2), new Tile(0), new Tile(4)}, // 4 2 4
////                {new Tile(4), new Tile(4), new Tile(4), new Tile(0)}, // 8 4
////                {new Tile(4), new Tile(4), new Tile(4), new Tile(4)}}; // 8 8

        Tile[][] gTiles = new Tile[][]{
                {new Tile(2), new Tile(4), new Tile(2), new Tile(4)},
                {new Tile(4), new Tile(2), new Tile(4), new Tile(2)},
                {new Tile(2), new Tile(4), new Tile(2), new Tile(4)},
                {new Tile(4), new Tile(2), new Tile(4), new Tile(2)},
        };

//        Tile[][] gTiles = new Tile[][]{
//                {new Tile(1), new Tile(2), new Tile(3),},
//                {new Tile(4), new Tile(5), new Tile(6),},
//                {new Tile(7), new Tile(8), new Tile(9),}};
        m.gameTiles = gTiles;

        for (int i = 0; i < gTiles.length; i++) {
//            m.mergeTiles(gTiles[i]);
//            m.compressTiles(gTiles[i]); // комментим чтоб не сбиваться
        }
//        System.out.println(Arrays.toString(tileArr));

//        m.left();   // закоммментили addTile() - в left() _ -чтоб при проверке не добавлялась плитка
//        m.rotate();
//        Arrays.stream(m.gameTiles).forEach(v -> System.out.println(Arrays.toString(v)));
        System.out.println(m.canMove());
    }

    public boolean canMove() {
// не прошло
//        Tile[][] tileArr = new Tile[FIELD_WIDTH][FIELD_WIDTH];
//        for (int i = 0; i < gameTiles.length; i++) {
//            for (int j = 0; j < gameTiles[i].length; j++) {
//                tileArr[i][j] = new Tile(gameTiles[i][j].value);
//            }
//        }
//
//        for (int i = 0; i < tileArr.length; i++) {
//            if (compressTiles(tileArr[i])) {
//                res = true;
//            }
//            if (mergeTiles(tileArr[i])) {
//                res = true;
//            }
//        }
///////////////
        // 1[0 0]  2[0 1]  3[0 2]
        // 4[1 0]  5[1 1]  6[1 2]
        // 7[2 0]  8[2 1]  9[2 2]

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0, k = 1; j < gameTiles[i].length - 1; j++, k++) {
//                if (gameTiles[i][j].getValue() == 0) { // проверка на нахождение 0
//                    return true;
//                }
                // проверка по горизонтали можно ли merge плитки
                // [0 0] _ [0 1] _ [0 2]
                if (gameTiles[i][j].getValue() == gameTiles[i][k].getValue() | gameTiles[i][j].getValue() == 0) {
                    return true;
                }
                // проверка по вертикали можно ли merge плитки
                // [0 0] _ [1 0] _ [2 0]
                if (gameTiles[j][i].getValue() == gameTiles[k][i].getValue()) {
                    return true;
                }
            }
        }

        return false;
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
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    // каждой строки массива gameTiles вызывать методы compressTiles и mergeTiles и добавлять одну плитку
    // с помощью метода addTile в том случае, если это необходимо.
    public void left() {
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
            isSaveNeeded = true;
        }
    }

    private boolean compressTiles(Tile[] tiles) { // сдвигаем цифры влево - убирая, все нули.., по типу счетчика
        Tile current, next;
        boolean flag = false;
        for (int k = 0, m = 1, counter = 0; k < tiles.length - 1; k++, m++) {
            current = tiles[k];
            next = tiles[m];
            if (current.getValue() > 0) {
                tiles[counter].setValue(current.getValue());
                if (counter != k) { // если индекс counter не равен текущему т.е. i
                    current.setValue(0); // а иначе, сам бы себя обнулял
                    flag = true;
                }
                counter++;
            }
            if (current.getValue() == 0 & m == tiles.length - 1 & next.getValue() > 0) { // на последнем элементе
                tiles[counter].setValue(next.getValue());
                next.setValue(0);
                flag = true;
            }
        }
        return flag;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
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
                if (current.getValue() == next.getValue() & current.getValue() != 0) {
                    current.setValue(current.getValue() + next.getValue());
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
            if (tiles[i].getValue() > maxTile) {
                this.maxTile = tiles[i].getValue(); // сеттим если, нов. значение больше предыдущего
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
