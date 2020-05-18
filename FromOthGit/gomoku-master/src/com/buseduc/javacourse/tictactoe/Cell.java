package com.buseduc.javacourse.tictactoe;

import com.buseduc.javacourse.tictactoe.enums.Chip;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cell extends Label {

    private static final int TEXT_SIZE = 25;
    private static final int CELL_SIZE = 50;
    private static final String PATH = System.getProperty("user.dir").concat("\\src\\com\\buseduc\\javacourse\\tictactoe");
    private int[] arrayPos;
    private Chip chip;
    private boolean isClicked = false;

    public Cell(int[] arrayPos) {
        this.arrayPos = arrayPos;
        this.setFont(new Font(TEXT_SIZE));
        this.setMinWidth(CELL_SIZE);
        this.setMinHeight(CELL_SIZE);
        this.setAlignment(Pos.BASELINE_CENTER);
        this.setOnMousePressed(getEventHandler());
        this.setOnMouseReleased(getEventHandlerComp());
    }

    private EventHandler<MouseEvent> getEventHandler() {
        return e -> {
            if (Game.getGameState().getActivePlayer() == null) return;
            if (Game.getGameState().getActivePlayer().equals(Computer.getInstance())) return;
            List<String> childrenList = Game.getBoard().getOutPane().getChildren().stream()
                    .map(Node::getId)
                    .collect(Collectors.toList());
            if (childrenList.contains("levelMenu") ||
                    childrenList.contains("mainMenu") ||
                    childrenList.contains("newGameMenu")) return;
            if (isClicked) return;
            try {
                Cell.this.releasePlayersAction();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (Game.getGameState().isFinished()) {
                System.out.println(Game.getGameState().getEndMsg());
            }
        };
    }

    private EventHandler<MouseEvent> getEventHandlerComp() {
        return e -> {
            if (Game.getGameState().getActivePlayer() == null) return;
            List<String> childrenList = Game.getBoard().getOutPane().getChildren().stream()
                    .map(Node::getId)
                    .collect(Collectors.toList());
            if (childrenList.contains("levelMenu") ||
                    childrenList.contains("mainMenu") ||
                    childrenList.contains("newGameMenu")) return;
            GameState gs = Game.getGameState();
            if (!gs.getPlayers().contains(Computer.getInstance())) return;
            if (gs.getEndMsg() != null) return;
            if (Game.getGameState().getActivePlayer().equals(Computer.getInstance())) {
                new Thread(() -> {
                    try {
                        new ArrayList<>(Thread.getAllStackTraces().keySet()).get(0);
                        Thread.sleep(700);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    Platform.runLater(() -> {
                        try {
                            Game.getLevel().invoke(Computer.getInstance());
                        } catch (IllegalAccessException ex) {
                            ex.printStackTrace();
                        } catch (InvocationTargetException ex) {
                            ex.printStackTrace();
                        }
                    });
                }).start();
            }
        };
    }

    private void releasePlayersAction() throws IOException {
        GameState gs = Game.getGameState();
        if (gs.getEndMsg() != null) return;
        Cell.this.chip = gs.getActivePlayer().getChip();
        Image image = null;
        if (this.chip.equals(Chip.X))
            image = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/whiteSt.png"))));
        else if (this.chip.equals(Chip.O))
            image = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/blackSt.png"))));
        Cell.this.setGraphic(new ImageView(image));
        isClicked = true;
        gs.hasPlayerWinPoss(gs.getActivePlayer());
        gs.isDeadHeat();
        Player otherPlayer = gs.getPlayers().stream()
                .filter(player -> !player.equals(gs.getActivePlayer()))
                .findFirst().get();
        gs.setActivePlayer(otherPlayer);
    }

    public Chip getChip() {
        return chip;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public int[] getArrayPos() {
        return arrayPos;
    }

    public void setArrayPos(int[] arrayPos) {
        this.arrayPos = arrayPos;
    }

    @Override
    public String toString() {
        return "(" + arrayPos[0] + ", " + arrayPos[1] + ")";
    }

}
