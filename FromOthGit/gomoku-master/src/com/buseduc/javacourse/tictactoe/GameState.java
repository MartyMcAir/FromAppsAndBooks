package com.buseduc.javacourse.tictactoe;

import com.buseduc.javacourse.tictactoe.enums.Chip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameState {

    private int winLineSize;
    private boolean isWinningPos;
    private boolean isDeadHeat;
    private boolean twoPlayers;
    private String endMsg;
    private List<List<Cell>> deadHeats;
    private Board board;
    private Player activePlayer;
    private List<Player> Players = new ArrayList<>();

    public GameState(Board board, int winLineSize) {
        this.board = board;
        this.winLineSize = winLineSize;
        deadHeats = new ArrayList<>();
    }

    public boolean isTwoPlayers() {
        return twoPlayers;
    }

    public void setTwoPlayers(boolean twoPlayers) {
        this.twoPlayers = twoPlayers;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public List<Player> getPlayers() {
        return Players;
    }

    //PUBLIC. Checks whether given player is a winner
    public boolean isFinished() {
        if (isWinningPos || isDeadHeat)
            Arrays.stream(board.getBoardCells())
                    .map(Arrays::asList)
                    .forEach(l -> l.stream().forEach(cell -> cell.setClicked(true)));
        return (isWinningPos || isDeadHeat);
    }

    //PUBLIC. Checks for dead heat
    public boolean isDeadHeat() {
        checkWholeBoardForDeadHeat();
        return isDeadHeat;
    }

    //Main checking for dead heat
    private void checkWholeBoardForDeadHeat() {
        //Checks whether all cells are filled
        this.isDeadHeat = !Arrays.stream(board.getBoardCells())
                .anyMatch(list ->
                        Arrays.stream(list)
                                .map(Cell::getChip)
                                .anyMatch(Objects::isNull)
                );
        if (isDeadHeat && endMsg == null) {
            endMsg = "Dead heat! All cells are filled.";
            try {
                board.drawLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Checks whether all win positions count equals already made dead heat lines count
        this.isDeadHeat = deadHeats.size() == getNumOfWinLines();
        if (isDeadHeat && endMsg == null) {
            endMsg = "Dead heat! There is no more winning positions.";
            try {
                board.drawLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Counts num of non-repeatable win positions
    private int getNumOfWinLines() {
        /*If whole board size > win line
        Counts number of non-repeatable win lines on whole board (without diagonals)*/
        int a = board.getSize() * (board.getSize() - winLineSize + 1) * 2;
        /*If whole board size equals win line
        Counts number of non-repeatable win lines on whole board (without diagonals)*/
        int a2 = board.getSize() * 2;
        //Counts sized squares on whole board
        int b = (board.getSize() - winLineSize + 1) * (board.getSize() - winLineSize + 1);
        //Counts win diagonal lines on whole board
        int c = b * 2;
        return (board.getSize() == winLineSize ? a2 : a) + c;
    }

    //Returns a field that contains information about the end of the game.
    public String getEndMsg() {
        return endMsg;
    }

    //PUBLIC. Checks whether given player is a winner
    public boolean hasPlayerWinPoss(Player player) {
        checkWholeBoardForWinPos(player);
        return isWinningPos;
    }

    //Checks whether hole board has winning positions for certain chip
    private void checkWholeBoardForWinPos(Player player) {
        int holeSize = board.getSize();
        for (int x = 0; x < holeSize; x++) {
            for (int y = 0; y < holeSize; y++) {
                if ((holeSize - x) >= winLineSize && holeSize - y >= winLineSize) {
                    checkSizedSquare(x, y, player.getChip());
                }
            }
        }
        if (isWinningPos) endMsg = player.getName() + " wins!";
    }

    //Checks whether sized square has winning positions for certain chip
    private void checkSizedSquare(int xt, int yt, Chip chip) {
        Cell[][] cells = board.getBoardCells();
        try {
            checkDiagonals(xt, yt, chip, cells);
            checkVH(xt, yt, chip, cells);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Checks whether sized square has winning positions by verticals and horizontals for certain chip
    //Also calls addDeadHeatLineIfItIs
    private void checkVH(int xt, int yt, Chip chip, Cell[][] cells) throws IOException {
        for (int x = 0; x < winLineSize; x++) {
            List<Cell> line = new ArrayList<>();
            for (int y = 0; y < winLineSize; y++) line.add(cells[y + xt][x + yt]);
            if (line.stream().allMatch(cell -> cell.getChip() == chip)) {
                this.isWinningPos = true;
                board.drawLine(line);
                return;
            }
            addDeadHeatLineIfItIs(chip, line); //Calling adding to dead heat list
            line.clear();
            for (int y = 0; y < winLineSize; y++) line.add(cells[x + xt][y + yt]);
            if (line.stream().allMatch(cell -> cell.getChip() == chip)) {
                this.isWinningPos = true;
                board.drawLine(line);
                return;
            }
            addDeadHeatLineIfItIs(chip, line); //Calling adding to dead heat list
            line.clear();
        }
    }

    //Checks whether sized square has winning positions by diagonals for certain chip
    //Also calls addDeadHeatLineIfItIs
    private void checkDiagonals(int xt, int yt, Chip chip, Cell[][] cells) throws IOException {
        List<Cell> line = new ArrayList<>();
        for (int x = 0; x < winLineSize; x++) line.add(cells[x + xt][x + yt]);
        if (line.stream().allMatch(cell -> cell.getChip() == chip)) {
            this.isWinningPos = true;
            board.drawLine(line);
            return;
        }
        addDeadHeatLineIfItIs(chip, line); //Calling adding to dead heat list
        line.clear();
        for (int x = 0; x < winLineSize; x++) line.add(cells[winLineSize - x + xt - 1][x + yt]);
        if (line.stream().allMatch(cell -> cell.getChip() == chip)) {
            this.isWinningPos = true;
            board.drawLine(line);
            return;
        }
        addDeadHeatLineIfItIs(chip, line); //Calling adding to dead heat list
    }

    //Checks whether line include both chips. Adds it to dead heat list if list doesn't contain it.
    private void addDeadHeatLineIfItIs(Chip chip, List<Cell> line) {
        Chip otherChip = getOtherChip(chip);
        boolean isDHLinesContainingNeededChips = isDHLinesContainingNeededChips(chip, line, otherChip);
        if (isDHLinesContainingNeededChips && !deadHeatListContains(line)) deadHeats.add(new ArrayList<>(line));
    }

    //Checks whether line is already exists in dead heat list
    private boolean deadHeatListContains(List<Cell> line) {
        List<Boolean> outList = new ArrayList<>();
        for (List<Cell> list : deadHeats) {
            List<Boolean> inList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                inList.add(Arrays.equals(list.get(i).getArrayPos(), line.get(i).getArrayPos()));
            }
            if (inList.stream().allMatch(c -> c.equals(true))) {
                outList.add(true);
            } else outList.add(false);
        }
        return outList.contains(true);
    }

    //Checks whether dead heat list contains only needed chips
    private boolean isDHLinesContainingNeededChips(Chip chip, List<Cell> line, Chip otherChip) {
        return line.stream()
                .map(Cell::getChip)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList(chip, otherChip));
    }

    //Gets other chip. If player has X, it returns O.
    private Chip getOtherChip(Chip chip) {
        Chip otherChip;
        if (chip.equals(Chip.X)) otherChip = Chip.O;
        else otherChip = Chip.X;
        return otherChip;
    }

}
