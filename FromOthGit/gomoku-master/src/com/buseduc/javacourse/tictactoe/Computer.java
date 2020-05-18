package com.buseduc.javacourse.tictactoe;

import com.buseduc.javacourse.tictactoe.enums.Chip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Computer extends Player {

    private static final String NAME = "Computer";
    private static final String PATH = System.getProperty("user.dir").concat("\\src\\com\\buseduc\\javacourse\\tictactoe");
    private static Computer instance;
    private static Board board;
    private static GameState gameState;
    private static List<List<Cell>> winLinesList;
    private static int boardSize;
    private static int winLineSize;

    private Computer() {
        super(getOtherChip());
    }

    private static Chip getOtherChip() {
        Chip chip = Game.getGameState().getActivePlayer().getChip();
        Chip otherChip;
        if (chip.equals(Chip.X)) otherChip = Chip.O;
        else otherChip = Chip.X;
        return otherChip;
    }

    public static Computer reloadInstance() {
        winLinesList = null;
        instance = new Computer();
        board = Game.getBoard();
        gameState = Game.getGameState();
        boardSize = Game.getBoardSize();
        winLineSize = Game.getWinLine();
        return instance;
    }

    @Override
    public String getName() {
        return NAME;
    }

    public static Computer getInstance() {
        if (instance == null) {
            instance = new Computer();
            board = Game.getBoard();
            gameState = Game.getGameState();
            boardSize = Game.getBoardSize();
            winLineSize = Game.getWinLine();
            fillWinLines();
        }
        return instance;
    }

    public static void fillWinLines() {
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if ((boardSize - x) >= winLineSize && boardSize - y >= winLineSize) {
                    for (int a = 0; a < winLineSize; a++) {
                        List<Cell> line = new ArrayList<>();
                        for (int b = 0; b < winLineSize; b++) line.add(board.getBoardCells()[b + x][a + y]);
                        if (winLineNotExistInWinLinesList(line)) winLinesList.add(new ArrayList<>(line));
                        line.clear();
                        for (int b = 0; b < winLineSize; b++) line.add(board.getBoardCells()[a + x][b + y]);
                        if (winLineNotExistInWinLinesList(line)) winLinesList.add(new ArrayList<>(line));
                        line.clear();
                        for (int b = 0; b < winLineSize; b++) line.add(board.getBoardCells()[b + x][b + y]);
                        if (winLineNotExistInWinLinesList(line)) winLinesList.add(new ArrayList<>(line));
                        line.clear();
                        for (int b = 0; b < winLineSize; b++)
                            line.add(board.getBoardCells()[winLineSize - b + x - 1][b + y]);
                        if (winLineNotExistInWinLinesList(line)) winLinesList.add(new ArrayList<>(line));
                        line.clear();
                    }
                }
            }
        }
    }

    private static boolean winLineNotExistInWinLinesList(List<Cell> line) {
        if (winLinesList == null) {
            winLinesList = new ArrayList<>();
            return true;
        }
        List<Boolean> outList = new ArrayList<>();
        for (List<Cell> list : winLinesList) {
            List<Boolean> outComeList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                outComeList.add(Arrays.equals(list.get(i).getArrayPos(), line.get(i).getArrayPos()));
            }
            if (outComeList.stream().allMatch(c -> c.equals(true))) {
                outList.add(true);
            } else outList.add(false);
        }
        return !outList.contains(true);
    }

    public void actionBLevel() {
        if (winLinesList == null) fillWinLines();
        if (checkForBlockNeeded()) return;
        actionALevel();
    }

    private boolean checkForBlockNeeded() {
        for (List<Cell> line : winLinesList) {
            if (line.stream().map(Cell::getChip).noneMatch(chip -> chip == this.getChip())) {
                if (line.stream().map(Cell::getChip)
                        .filter(chip -> chip == getOtherChip()).count() == (winLineSize - 1)) {
                    Cell cellForBlock = line.stream().filter(cell -> cell.getChip() == null).findAny().get();
                    actionsWhenChipChosen(cellForBlock.getArrayPos()[0], cellForBlock.getArrayPos()[1]);
                    return true;
                } else if (line.stream().map(Cell::getChip)
                        .filter(chip -> chip != this.getChip())
                        .filter(chip -> chip == getOtherChip()).count() == (winLineSize - 2)) {
                    Cell cellForBlock;
                    if (line.get(0).getChip() == null && line.get(1).getChip() == null) {
                        cellForBlock = line.get(1);
                        actionsWhenChipChosen(cellForBlock.getArrayPos()[0], cellForBlock.getArrayPos()[1]);
                        return true;
                    } else if (line.get(winLineSize - 2).getChip() == null && line.get(winLineSize - 1).getChip() == null) {
                        cellForBlock = line.get(winLineSize - 2);
                        actionsWhenChipChosen(cellForBlock.getArrayPos()[0], cellForBlock.getArrayPos()[1]);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void actionALevel() {
        List<Cell> availableCells = new ArrayList<>();
        for (Cell[] line : board.getBoardCells()) {
            Arrays.stream(line).filter(cell -> !cell.isClicked()).forEach(availableCells::add);
        }
        Random rand = new Random();
        Cell randCell = availableCells.get(rand.nextInt((availableCells.size() - 1) + 1));
        actionsWhenChipChosen(randCell.getArrayPos()[0], randCell.getArrayPos()[1]);
    }

    private void actionsWhenChipChosen(int x, int y) {
        if (!Game.getBoard().getBoardCells()[x][y].isClicked()) {
            board.getBoardCells()[x][y].setChip(this.getChip());
            board.getBoardCells()[x][y].setClicked(true);
            Image image = null;
            if (board.getBoardCells()[x][y].getChip().equals(Chip.X)) {
                try {
                    image = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/whiteSt.png"))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (board.getBoardCells()[x][y].getChip().equals(Chip.O)) {
                try {
                    image = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/blackSt.png"))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            board.getBoardCells()[x][y].setGraphic(new ImageView(image));
            gameState.hasPlayerWinPoss(gameState.getActivePlayer());
            gameState.isDeadHeat();
            if (gameState.isFinished()) {
                System.out.println(gameState.getEndMsg());
            }
            gameState.setActivePlayer(gameState.getPlayers().get(0));
        }
    }

    public void actionCLevel() {
        int[] m = MiniMax.calculateNextMove(winLineSize, 3, getConvertedBoard(board.getBoardCells()));
        actionsWhenChipChosen(m[0], m[1]);
    }

    public static int[][] getConvertedBoard(Cell[][] currentBoard) {
        int[][] convertedBoard = new int[currentBoard.length][currentBoard.length];
        for (int i = 0; i < currentBoard.length; i++) {
            for (int n = 0; n < currentBoard.length; n++) {
                if (currentBoard[i][n].getChip() == null) {
                    convertedBoard[i][n] = 0;
                } else if (currentBoard[i][n].getChip().equals(Chip.O)) {
                    convertedBoard[i][n] = 1;
                } else {
                    convertedBoard[i][n] = 2;
                }
            }
        }
        return convertedBoard;
    }

}
