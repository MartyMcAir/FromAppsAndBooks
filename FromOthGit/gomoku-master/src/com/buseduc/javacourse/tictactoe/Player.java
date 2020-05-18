package com.buseduc.javacourse.tictactoe;

import com.buseduc.javacourse.tictactoe.enums.Chip;

public class Player {

    private static Board board;
    private static GameState gameState;

    static {
        board = Game.getBoard();
        gameState = Game.getGameState();
    }

    private Chip chip;
    private String name;

    public Player(Chip chip) {
        this();
        this.chip = chip;
    }

    public Player() {
        this.name = setName();
        this.chip = setChip();
    }

    private String setName() {
        return "Player " + (Game.getGameState().getPlayers().size() + 1);
    }

    private Chip setChip() {
        if (gameState.getPlayers().size() == 0)
            return Chip.X;
        else return Chip.O;
    }

    public Chip getChip() {
        return chip;
    }

    public String getName() {
        return name;
    }

}
