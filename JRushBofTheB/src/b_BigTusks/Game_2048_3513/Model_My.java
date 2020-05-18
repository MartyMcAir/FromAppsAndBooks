package b_BigTusks.Game_2048_3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model_My {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    public int score = 0; // текущий счет
    public int maxTile = 0; // максимальный вес плитки на игровом поле

    public Model_My() {
        resetGameTiles();
    }

    public static void main(String[] args) {
        Model_My m = new Model_My();
        m.gameTiles = new Tile[][]{{new Tile(4), new Tile(4), new Tile(2), new Tile(0)},
                {new Tile(4), new Tile(2), new Tile(0), new Tile(4)},
                {new Tile(4), new Tile(4), new Tile(4), new Tile(0)},
                {new Tile(4), new Tile(4), new Tile(4), new Tile(4)}};

//        Tile[] tileArr = new Tile[]{new Tile(2), new Tile(2), new Tile(2), new Tile(0)};
        Tile[] tileArr = new Tile[]{
                new Tile(4), new Tile(4),
                new Tile(4), new Tile(4),
                new Tile(4), new Tile(4),
        };
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

    // List<Tile>
    // Метод getEmptyTiles должен возвращать список пустых плиток в массиве gameTiles.
    private List<Tile> getEmptyTiles() {
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

    private void compressTiles(Tile[] tiles) { // сдвигаем цифры влево - убирая, все нули.., по типу счетчика
        Tile current, next;
        for (int k = 0, m = 1, counter = 0; k < tiles.length - 1; k++, m++) {
            current = tiles[k];
            next = tiles[m];
            if (current.value > 0) {
                tiles[counter].setValue(current.value);
                if (counter != k) { // если индекс counter не равен текущему т.е. i
                    current.setValue(0); // а иначе, сам бы себя обнулял
                }
                counter++;
            }
            if (current.value == 0 & m == tiles.length - 1 & next.value > 0) { // на последнем элементе
                tiles[counter].setValue(next.value);
                next.setValue(0);
            }
        }
    }

    private void mergeTiles(Tile[] tiles) {
        Tile current, next;
        // new Tile[]{new Tile(2), new Tile(4), new Tile(4), new Tile(4)};
        boolean flag = false;
        int count = 0, barier = 1;
        while (!flag & count <= barier) {
//        while (!flag & count < (tiles.length / 4)) {
            flag = true;
            for (int i = 0, j = 1; i < tiles.length - 1; j++, i++) {
                current = tiles[i];
                next = tiles[j];
                if (current.value == next.value & current.value != 0) {
                    current.setValue(current.value + next.value);
                    next.setValue(0);
                    flag = false; // даем знать что была перестановка
                    this.score += tiles[i].getValue(); // и обновляем score
                    barier--;
                }
            }
            barier++;
            ///--------------------------/// ___ после всех операций
            compressTiles(tiles); // сдвигаем цифры влево - убирая, все нули.., по типу счетчика
            ///--------------------------///
            count++;
        }

        for (int i = 0; i < tiles.length; i++) { // вычисляем максмал значение
            if (tiles[i].value > maxTile) {
                this.maxTile = tiles[i].value; // сеттим если, нов. значение больше предыдущего
            }
        }
    }

    // который будет смотреть какие плитки пустуют и, если такие имеются,
    //менять вес одной из них, выбранной случайным образом, на 2 или 4 (на 9 двоек должна приходиться 1 четверка).
    // Для вычисления веса новой плитки используй выражение (Math.random() < 0.9 ? 2 : 4).

    // Метод addTile должен изменять значение случайной пустой плитки в массиве gameTiles н
    // а 2 или 4 с вероятностью 0.9 и 0.1 соответственно.

    // Проверь, что метод addTile ничего не изменяет, если метод getEmptyTiles возвращает пустой список.
    // Метод addTile должен изменять значение случайной пустой плитки в массиве gameTiles на 2 или 4
    // с вероятностью 0.9 и 0.1 соответственно.
    private void addTile() {
//        int rnd = gameTiles.length * new Random().nextInt(1);
//        if (!getEmptyTiles().isEmptyFirst()) {
//            for (int i = 0; i < gameTiles.length; i++) {
//                for (int j = 0; j < gameTiles[0].length; j++) {
//                    gameTiles[i][j] = new Tile(Math.random() < 0.9 ? 2 : 4);
//                }
//            }
//        }
        List<Tile> list = getEmptyTiles();
        if (list != null && list.size() != 0) { // про setValue - не сказано
            list.get((int) (list.size() * Math.random())).setValue(Math.random() < 0.9 ? 2 : 4);
        }
    }

}
