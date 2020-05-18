package com.buseduc.javacourse.tictactoe;

import com.buseduc.javacourse.tictactoe.enums.Chip;
import javafx.application.Application;

import java.lang.reflect.Method;

public class Game {

    private static final int WIN_LINE = 5; //Made for this size
    private static final int BOARD_SIZE = 10; //Made for this size
    private static Board board;
    private static GameState gameState;
    private static Method level;
    private static boolean isFirstGame = true;

    static {
        board = new Board(BOARD_SIZE);
        gameState = new GameState(board, WIN_LINE);
    }

    public Game() {

    }

    public static void main(String[] args) {
        Application.launch(RenderFX.class, args);
    }

    public static void reloadGame() {
        isFirstGame = false;
        boolean isTwoPlayers = gameState.isTwoPlayers();
        board = new Board(BOARD_SIZE);
        gameState = new GameState(board, WIN_LINE);
        gameState.setActivePlayer(new Player(Chip.X));
        gameState.getPlayers().add(gameState.getActivePlayer());
        if (isTwoPlayers) {
            gameState.getPlayers().add(new Player());
            gameState.setTwoPlayers(true);
        } else {
            gameState.getPlayers().add(Computer.reloadInstance());
            gameState.setTwoPlayers(false);
        }
        RenderFX.reloadScene();
        board.getOutPane().getChildren().remove(board.getNewGamePane());
    }

    public static void newGame() {
        gameState.setTwoPlayers(false);
        isFirstGame = false;
        gameState.getPlayers().clear();
        gameState.setActivePlayer(null);
        board = new Board(BOARD_SIZE);
        gameState = new GameState(board, WIN_LINE);
        RenderFX.reloadScene();
    }

    public static Board getBoard() {
        return board;
    }

    public static GameState getGameState() {
        return gameState;
    }

    public static int getWinLine() {
        return WIN_LINE;
    }

    public static int getBoardSize() {
        return BOARD_SIZE;
    }

    public static Method getLevel() {
        return level;
    }

    public static void setLevel(Method level) {
        Game.level = level;
    }

    public static boolean isIsFirstGame() {
        return isFirstGame;
    }

}
