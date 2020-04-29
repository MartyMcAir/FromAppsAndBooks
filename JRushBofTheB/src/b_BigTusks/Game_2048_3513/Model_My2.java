package b_BigTusks.Game_2048;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model_My2 {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    public int score = 0; // текущий счет
    public int maxTile = 0; // максимальный вес плитки на игровом поле
    private boolean isSaveNeeded = true;

    public Model_My2() {
        resetGameTiles();
    }

    public static void main(String[] args) {
        Model_My2 m = new Model_My2();
        m.gameTiles = new Tile[][]{{new Tile(4), new Tile(4), new Tile(2), new Tile(0)},
                {new Tile(4), new Tile(2), new Tile(0), new Tile(4)},
                {new Tile(4), new Tile(4), new Tile(4), new Tile(0)},
                {new Tile(4), new Tile(4), new Tile(4), new Tile(4)}};

//        Tile[] tileArr = new Tile[]{new Tile(2), new Tile(2), new Tile(2), new Tile(0)};
        Tile[] tileArr = new Tile[]{new Tile(4), new Tile(4), new Tile(4),
                new Tile(0)};
        m.mergeTiles(tileArr);
        System.out.println(Arrays.toString(tileArr));
    }
    // _ 2 4 4 4
    //   2 8 4
    // _ 0 2 2 4
    //   4 4

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
            addTile();
            isSaveNeeded = true;
        }
    }


    // https://www.geeksforgeeks.org/move-zeroes-end-array/ - еще другое решение
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
