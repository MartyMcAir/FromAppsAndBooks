package b_BigTusks.Game_2048_3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4; // 4
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    public int score = 0; // текущий счет
    public int maxTile = 0; // максимальный вес плитки на игровом поле
    private Stack<Tile[][]> previousStates = new Stack<Tile[][]>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public void autoMove() {
        // Collections.reverseOrder() (для того, чтобы вверху очереди всегда был максимальный элемент)
        // и размером равным четырем.
        // Collections - способ определения приоритета _ и походу реализ Comparable была для него
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.peek().getMove().move();
    }

    // возвращает объект типа MoveEfficiency описывающий эффективность переданного хода.
    // б) в случае, если ход не меняет состояние игрового поля, количество пустых плиток и счет у объекта
    // MoveEfficiency сделай равными -1 и 0 соответственно;
    // ..можно было бы и реализовать по проще зачем, еще создавать доп сущности и методы _ если уже есть
    // методы что возвращ boolean в случае изменений..

    // Смысл объекта класса MoveEfficiency в том, что в этом объекте у нас хранится:
    //1) Ход (который move).
    //2) Количество пустых плиток, которое будет на поле после этого хода.
    //3) Счет, который будет после этого хода.

    //Соответственно, метод getMoveEfficiency() принимает ход move и выдает объект moveEfficiency,
    // который описывает состояние игры после этого хода.
    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
//        int zeroCounter = 0;
//        for (int i = 0; i < FIELD_WIDTH; i++) {
//            for (int j = 0; j < FIELD_WIDTH; j++) {
//                if (gameTiles[i][j].getValue() == 0) {
//                    zeroCounter++;
//                }
//            }
//        }

        if (hasBoardChanged()) { // забыл, что уже есть метод getEmptyTiles
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        } else {
            moveEfficiency = new MoveEfficiency(-1, score, move);
        }
        rollback(); // возвращаем все назад после хода
        return moveEfficiency;
    }

    //  true, в случае, если вес плиток в массиве gameTiles отличается от веса плиток в верхнем массиве
    //  стека previousStates.
    // а в предыдущ задании писалось, что будем считать,
    // чем больше кол-во пустых полей тем = считать эффективнее такой счет..
    public boolean hasBoardChanged() {
        boolean res = false;
        Tile[][] tileArr = previousStates.peek();
        int currentTileWeight = 0, previousTileWeight = 0;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                currentTileWeight += gameTiles[i][j].getValue();
            }
        }
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                previousTileWeight += tileArr[i][j].getValue();
            }
        }
        if (currentTileWeight != previousTileWeight) {
            res = true;
        }
        return res;
    }

    private void saveState(Tile[][] tiles) { // сохраняет состояние в стек
        this.isSaveNeeded = false;
        // делаем клона массива с нов ссылками на нов объект, но с темиже значениями
        Tile[][] tilesForSave = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tilesForSave[i][j] = new Tile(tiles[i][j].getValue());
            }
        }
        previousStates.push(tilesForSave);
        previousScores.push(score);
    }

    public void rollback() { // откат на один ход назад
        if (!previousStates.isEmpty() & !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                up();
                break;
            case 1:
                down();
                break;
            case 2:
                left();
                break;
            case 3:
                right();
                break;
        }
    }

    public boolean canMove() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0, k = 1; j < FIELD_WIDTH - 1; j++, k++) {
                // проверка по горизонтали можно ли merge плитки и на 0
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
        // при первой интерации [0 0] -> [0 2] -> [2 2] -> [2 0] -> [0 0]
        // при второй интерации [0 1] -> [1 2] -> [2 1] -> [1 0] -> [0 1]
        // Consider all squares one by one
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            // Consider elements in group of 4 in current square
            for (int j = i; j < FIELD_WIDTH - i - 1; j++) {
                // store current cell in temp variable
                Tile temp = gameTiles[i][j]; // [0 0] _ [0 1]
                // move values from right to top
                // [0 0] = [0 2] _ [0 1] = [1 2]
                gameTiles[i][j] = gameTiles[j][FIELD_WIDTH - 1 - i];
                // move values from bottom to right
                // [0 2] = [2 2] _ [1 2] = [2 1]
                gameTiles[j][FIELD_WIDTH - 1 - i] = gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j];
                // move values from left to bottom
                // [2 2] = [2 0] _ [2 1] = [1 0]
                gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j] = gameTiles[FIELD_WIDTH - 1 - j][i];
                // assign temp to left
                gameTiles[FIELD_WIDTH - 1 - j][i] = temp; // [2 0] = [0 0] _ [1 0] = [0 1]
            }
        }
    }

    // Метод resetGameTiles должен заполнять массив gameTiles новыми плитками и менять значение
    // двух из них с помощью двух вызовов метода addTile.
    public void resetGameTiles() {
        this.maxTile = 0;
        this.score = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private List<Tile> getEmptyTiles() { // Метод getEmptyTiles должен возвращать список пустых плиток в массиве gameTiles.
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    list.add(gameTiles[i][j]); // именно ссылка на объект, что пустой
                }
            }
        }
        return list;
    }

    public void down() {
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void right() {
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void up() {
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    // каждой строки массива gameTiles вызывать методы compressTiles и mergeTiles и добавлять одну плитку
    // с помощью метода addTile в том случае, если это необходимо.
    public void left() {
        if (isSaveNeeded) { // не понял зачем делать вызов saveState(..) в up() down().. если все они раб. через left()
            saveState(gameTiles);
            isSaveNeeded = false;
        }
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
            // После выполнения сдвига влево устанавливаем флаг isSaveNeeded равным true
            isSaveNeeded = true;
        }
    }

    private boolean compressTiles(Tile[] tiles) { // сдвигаем цифры влево - убирая, все нули.., по типу счетчика
        Tile current, next;
        boolean flag = false;
        for (int k = 0, m = 1, counter = 0; k < FIELD_WIDTH - 1; k++, m++) {
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
            if (current.getValue() == 0 & m == FIELD_WIDTH - 1 & next.getValue() > 0) { // на последнем элементе
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
//        while (!flag & count < (FIELD_WIDTH / 4)) {
            flag = true;
            for (int i = 0, j = 1; i < FIELD_WIDTH - 1; j++, i++) {
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

        for (int i = 0; i < FIELD_WIDTH; i++) { // вычисляем максмал значение
            if (tiles[i].getValue() > maxTile) {
                this.maxTile = tiles[i].getValue(); // сеттим если, нов. значение больше предыдущего
            }
        }
        return ischange;
    }

    private void addTile() { // рандомное добавление плитки в пустую яйчейку
        List<Tile> list = getEmptyTiles();
        if (list != null && list.size() != 0) { // про setValue - не сказано
            list.get((int) (list.size() * Math.random())).setValue(Math.random() < 0.9 ? 2 : 4);
        }
    }

}
