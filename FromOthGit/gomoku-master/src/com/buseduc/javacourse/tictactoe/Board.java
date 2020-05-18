package com.buseduc.javacourse.tictactoe;

import com.buseduc.javacourse.tictactoe.enums.Chip;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Board {

    private static final int CELL_SIZE = 50;
    private static final String PATH = System.getProperty("user.dir").concat("\\src\\com\\buseduc\\javacourse\\tictactoe");
    private GridPane outPane;
    private GridPane mainPane;
    private GridPane buttonsPane;
    private GridPane newGamePane;
    private int size;
    private Cell[][] boardCells;
    private int boardSize;

    public Board(int size) {
        this.size = size;
        boardCells = new Cell[size][size];
        boardSize = CELL_SIZE * size + 150;
    }

    public GridPane getOutPane() {
        return outPane;
    }

    public GridPane getNewGamePane() {
        return newGamePane;
    }

    public Cell[][] getBoardCells() {
        return boardCells;
    }

    public int getSize() {
        return size;
    }

    public GridPane render() {
        GridPane mainPane = new GridPane();
        this.mainPane = mainPane;
        for (int i = 0; i < 3; i++) {
            RowConstraints row = new RowConstraints();
            if (i == 0 || i == 2) row.setMinHeight(100);
            mainPane.getRowConstraints().add(row);
        }
        ColumnConstraints col = new ColumnConstraints();
        mainPane.getColumnConstraints().add(col);
        mainPane.setStyle("-fx-background-color: transparent; -fx-border-width:0; -fx-border-insets: 0; ");
        mainPane.setMinWidth((size + 2) * CELL_SIZE + 200);
        mainPane.setMinHeight((size + 2) * CELL_SIZE + 200);
        GridPane outerPane = initOuterPane();
        GridPane deskPane = initDeskPane();
        outerPane.add(deskPane, 1, 1, size, size);
        outerPane.setAlignment(Pos.BASELINE_CENTER);
        mainPane.add(outerPane, 0, 1);
        fillBoardCells();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                deskPane.add(boardCells[x][y], y, x);
            }
        }
        GridPane topButtons = initButtonsPane();
        mainPane.getColumnConstraints().get(0).setHalignment(HPos.RIGHT);
        mainPane.add(topButtons, 0, 0, 10, 1);
        outerPane.setStyle("-fx-background-color: transparent; -fx-border-width:0; -fx-border-insets: 0; ");
        initNewGameMenu();
        return mainPane;
    }

    private GridPane initOuterPane() {
        GridPane outerPane = new GridPane();
        outPane = outerPane;
        for (int i = 0; i < size + 2; i++) {
            ColumnConstraints column = new ColumnConstraints(CELL_SIZE);
            column.setHalignment(HPos.CENTER);
            RowConstraints row = new RowConstraints(CELL_SIZE);
            row.setValignment(VPos.CENTER);
            if (i == 0 || i == size + 1) {
                column.setMinWidth(35);
                column.setMaxWidth(35);
                row.setMinHeight(35);
                row.setMaxHeight(35);
            }
            outerPane.getColumnConstraints().add(column);
            outerPane.getRowConstraints().add(row);
        }
        try {
            fillVHLines(outerPane);
            fillCorners(outerPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outerPane;
    }

    private GridPane initDeskPane() {
        GridPane deskPane = new GridPane();
        deskPane.setAlignment(Pos.CENTER);
        for (int i = 0; i < size; i++) {
            ColumnConstraints column = new ColumnConstraints(CELL_SIZE);
            column.setHalignment(HPos.CENTER);
            deskPane.getColumnConstraints().add(column);
            RowConstraints row = new RowConstraints(CELL_SIZE);
            row.setValignment(VPos.CENTER);
            deskPane.getRowConstraints().add(row);
        }
        deskPane.setStyle("-fx-background-color: #dedede; -fx-border-width:0; -fx-border-insets: 0; ");
        return deskPane;
    }

    private void fillBoardCells() {
        Image cellBack = null;
        BackgroundPosition backPos = BackgroundPosition.CENTER;
        BackgroundSize backSize = new BackgroundSize(
                50,
                50,
                false,
                false,
                true,
                true);
        try {
            cellBack = new Image(new FileInputStream(PATH.concat("\\img\\cell_50x50.jpg")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Cell nextCell = new Cell(new int[]{x, y});
                nextCell.setBackground(new Background(new BackgroundImage(cellBack, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, backPos, backSize)));
                boardCells[x][y] = nextCell;
                nextCell.setArrayPos(new int[]{x, y});
            }
        }
    }

    private GridPane initButtonsPane() {
        GridPane topButtons = new GridPane();
        buttonsPane = topButtons;
        topButtons.getColumnConstraints().add(new ColumnConstraints(150));
        topButtons.getColumnConstraints().get(0).setMinWidth(150);
        topButtons.getColumnConstraints().add(new ColumnConstraints());
        topButtons.getColumnConstraints().get(1).setMinWidth(330);
        topButtons.getColumnConstraints().add(new ColumnConstraints(100));
        topButtons.getColumnConstraints().get(2).setMinWidth(100);
        topButtons.getRowConstraints().add(new RowConstraints(100));
        iniButton(100, 100, 2, 0,
                "exit.png", "exitOn.png", event -> System.exit(0));
        iniButton(150, 100, 0, 0,
                "menu.png", "menuOn.png", event -> mainMenu());
        return topButtons;
    }

    private void initNewGameMenu() {
        GridPane newGame = new GridPane();
        newGame.setId("newGameMenu");
        newGamePane = newGame;
        newGame.setAlignment(Pos.BASELINE_CENTER);
        for (int i = 0; i < 3; i++) {
            if (i == 0) newGame.getColumnConstraints().add(new ColumnConstraints(400, 400, 400));
            newGame.getRowConstraints().add(new RowConstraints(100, 100, 100));
        }
        Label chsMode = new Label();
        chsMode.setMinWidth(400);
        chsMode.setMinHeight(100);
        chsMode.setAlignment(Pos.BASELINE_CENTER);
        chsMode.setText("CHOOSE MODE:");
        chsMode.setFont(Font.font("Comic Sans MS", 40));
        newGame.add(chsMode, 0, 0);
        Label vsCompL = new Label();
        vsCompL.setMinWidth(400);
        vsCompL.setMinHeight(100);
        vsCompL.setAlignment(Pos.BASELINE_CENTER);
        vsCompL.setText("VS COMPUTER");
        vsCompL.setFont(Font.font("Comic Sans MS", 40));
        vsCompL.setOnMouseEntered(event -> vsCompL.setTextFill(Color.valueOf("#6d6d6a")));
        vsCompL.setOnMouseExited(event -> vsCompL.setTextFill(Color.valueOf("#333333")));
        vsCompL.setOnMouseClicked(event -> {

            outPane.getChildren().remove(newGame);
            initCompLevelMenu();
        });
        newGame.add(vsCompL, 0, 1);
        Label twoPlayersL = new Label();
        twoPlayersL.setMinWidth(400);
        twoPlayersL.setMinHeight(100);
        twoPlayersL.setAlignment(Pos.BASELINE_CENTER);
        twoPlayersL.setText("2 PLAYERS");
        twoPlayersL.setFont(Font.font("Comic Sans MS", 40));
        twoPlayersL.setOnMouseEntered(event -> twoPlayersL.setTextFill(Color.valueOf("#6d6d6a")));
        twoPlayersL.setOnMouseExited(event -> twoPlayersL.setTextFill(Color.valueOf("#333333")));
        twoPlayersL.setOnMouseClicked(event -> {
            Game.getGameState().setTwoPlayers(true);
            Game.getGameState().setActivePlayer(new Player(Chip.X));
            Game.getGameState().getPlayers().add(Game.getGameState().getActivePlayer());
            Game.getGameState().getPlayers().add(new Player(Chip.O));
            outPane.getChildren().remove(newGame);
        });
        newGame.add(twoPlayersL, 0, 2);
        newGame.setStyle("-fx-background-color: #dedede; -fx-border-width:0; -fx-border-insets: 0;  -fx-border-color: black; -fx-grid-lines-visible: true");
        outPane.setAlignment(Pos.BOTTOM_CENTER);
        outPane.add(newGame, 2, 3, 8, 6);
    }

    private void fillVHLines(GridPane outerPane) {
        for (int x = 1; x <= size; x++) {
            fillOutLineImg(outerPane, x, 0, "-fx-background-image: url(\"com/buseduc/javacourse/tictactoe/img/top_50x35.png\");", CELL_SIZE, 35);
            fillOutLineImg(outerPane, x, size + 1, "-fx-background-image: url(\"com/buseduc/javacourse/tictactoe/img/bot_50x35.png\");", CELL_SIZE, 35);
            fillOutLineImg(outerPane, size + 1, x, "-fx-background-image: url(\"com/buseduc/javacourse/tictactoe/img/right_35x50.jpg\");", 35, CELL_SIZE);
            fillOutLineImg(outerPane, 0, x, "-fx-background-image: url(\"com/buseduc/javacourse/tictactoe/img/left_35x50.jpg\");", 35, CELL_SIZE);
        }
    }

    private void fillCorners(GridPane outerPane) throws IOException {
        Image image;
        image = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/top_left_35x35.png"))));
        outerPane.add(new ImageView(image), 0, 0);
        image = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/top_right_35x35.png"))));
        outerPane.add(new ImageView(image), size + 1, 0);
        image = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/bot_left_35x35.png"))));
        outerPane.add(new ImageView(image), 0, size + 1);
        image = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/bot_right_35x35.png"))));
        outerPane.add(new ImageView(image), size + 1, size + 1);
    }

    private void iniButton(int width, int height, int colIdx, int rowIdx, String fileName, String fileNameOn, EventHandler handler) {
        Image img = null;
        Image imgOn = null;
        try {
            img = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/" + fileName))));
            imgOn = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/" + fileNameOn))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Label nextLabel = new Label();
        nextLabel.setMinHeight(height);
        nextLabel.setMinWidth(width);
        nextLabel.setGraphic(new ImageView(img));
        Image finalImgOn = imgOn;
        nextLabel.setOnMouseEntered(event -> nextLabel.setGraphic(new ImageView(finalImgOn)));
        Image finalImg = img;
        nextLabel.setOnMouseExited(event -> nextLabel.setGraphic(new ImageView(finalImg)));
        nextLabel.setOnMouseClicked(handler);
        buttonsPane.add(nextLabel, colIdx, rowIdx);
    }

    private void mainMenu() {
        GridPane menuPane = new GridPane();
        menuPane.setId("mainMenu");
        menuPane.setAlignment(Pos.BASELINE_CENTER);
        for (int i = 0; i < 3; i++) {
            if (i == 0) menuPane.getColumnConstraints().add(new ColumnConstraints(400, 400, 400));
            menuPane.getRowConstraints().add(new RowConstraints(100, 100, 100));
        }
        Label newGameL = new Label();
        newGameL.setMinWidth(400);
        newGameL.setMinHeight(100);
        newGameL.setAlignment(Pos.BASELINE_CENTER);
        newGameL.setText("NEW GAME");
        newGameL.setFont(Font.font(40));
        newGameL.setOnMouseEntered(event -> newGameL.setTextFill(Color.valueOf("#6d6d6a")));
        newGameL.setOnMouseExited(event -> newGameL.setTextFill(Color.valueOf("#333333")));
        newGameL.setOnMouseClicked(event -> Game.newGame());
        menuPane.add(newGameL, 0, 0);
        Label restartL = new Label();
        restartL.setMinWidth(400);
        restartL.setMinHeight(100);
        restartL.setAlignment(Pos.BASELINE_CENTER);
        restartL.setText("RESTART");
        restartL.setFont(Font.font(40));
        if (Game.getGameState().getActivePlayer() != null) {
            restartL.setOnMouseEntered(event -> restartL.setTextFill(Color.valueOf("#6d6d6a")));
            restartL.setOnMouseExited(event -> restartL.setTextFill(Color.valueOf("#333333")));
            restartL.setOnMouseClicked(event -> Game.reloadGame());
        } else restartL.setTextFill(Color.valueOf("#b8b8b8"));
        menuPane.add(restartL, 0, 1);
        Label returnL = new Label();
        returnL.setMinWidth(400);
        returnL.setMinHeight(100);
        returnL.setAlignment(Pos.BASELINE_CENTER);
        returnL.setText("RESUME");
        returnL.setFont(Font.font(40));
        returnL.setOnMouseClicked(event -> outPane.getChildren().remove(menuPane));
        returnL.setOnMouseEntered(event -> returnL.setTextFill(Color.valueOf("#6d6d6a")));
        returnL.setOnMouseExited(event -> returnL.setTextFill(Color.valueOf("#333333")));
        menuPane.add(returnL, 0, 2);
        menuPane.setStyle("-fx-background-color: #dedede; -fx-border-width:0; -fx-border-insets: 0;  -fx-border-color: black; -fx-grid-lines-visible: true");
        outPane.setAlignment(Pos.BOTTOM_CENTER);
        outPane.add(menuPane, 2, 3, 8, 6);
    }

    private void initCompLevelMenu() {
        GridPane levelMenuPane = new GridPane();
        levelMenuPane.setId("levelMenu");
        levelMenuPane.setAlignment(Pos.BASELINE_CENTER);
        for (int i = 0; i < 3; i++) {
            if (i == 0) levelMenuPane.getColumnConstraints().add(new ColumnConstraints(400, 400, 400));
            levelMenuPane.getRowConstraints().add(new RowConstraints(100, 100, 100));
        }
        Label easyL = new Label();
        easyL.setMinWidth(400);
        easyL.setMinHeight(100);
        easyL.setAlignment(Pos.BASELINE_CENTER);
        easyL.setText("EASY");
        easyL.setFont(Font.font(40));
        easyL.setOnMouseEntered(event -> easyL.setTextFill(Color.valueOf("#6d6d6a")));
        easyL.setOnMouseExited(event -> easyL.setTextFill(Color.valueOf("#333333")));
        easyL.setOnMouseClicked(event -> {
            try {
                Game.setLevel(Computer.class.getMethod("actionALevel"));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            Game.getGameState().setTwoPlayers(false);
            Game.getGameState().setActivePlayer(new Player(Chip.X));
            Game.getGameState().getPlayers().add(Game.getGameState().getActivePlayer());
            if (Game.isIsFirstGame()) Game.getGameState().getPlayers().add(Computer.getInstance());
            else Game.getGameState().getPlayers().add(Computer.reloadInstance());
            outPane.getChildren().remove(levelMenuPane);
        });
        levelMenuPane.add(easyL, 0, 0);
        Label normL = new Label();
        normL.setMinWidth(400);
        normL.setMinHeight(100);
        normL.setAlignment(Pos.BASELINE_CENTER);
        normL.setText("NORMAL");
        normL.setFont(Font.font(40));
        normL.setOnMouseEntered(event -> normL.setTextFill(Color.valueOf("#6d6d6a")));
        normL.setOnMouseExited(event -> normL.setTextFill(Color.valueOf("#333333")));
        normL.setOnMouseClicked(event -> {
            try {
                Game.setLevel(Computer.class.getMethod("actionBLevel"));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            Game.getGameState().setTwoPlayers(false);
            Game.getGameState().setActivePlayer(new Player(Chip.X));
            Game.getGameState().getPlayers().add(Game.getGameState().getActivePlayer());
            if (Game.isIsFirstGame()) Game.getGameState().getPlayers().add(Computer.getInstance());
            else Game.getGameState().getPlayers().add(Computer.reloadInstance());
            outPane.getChildren().remove(levelMenuPane);
        });

        levelMenuPane.add(normL, 0, 1);
        Label hardL = new Label();
        hardL.setMinWidth(400);
        hardL.setMinHeight(100);
        hardL.setAlignment(Pos.BASELINE_CENTER);
        hardL.setText("HARD");
        hardL.setFont(Font.font(40));
        hardL.setOnMouseEntered(event -> hardL.setTextFill(Color.valueOf("#6d6d6a")));
        hardL.setOnMouseExited(event -> hardL.setTextFill(Color.valueOf("#333333")));
        hardL.setOnMouseClicked(event -> {
            try {
                Game.setLevel(Computer.class.getMethod("actionCLevel"));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            Game.getGameState().setTwoPlayers(false);
            Game.getGameState().setActivePlayer(new Player(Chip.X));
            Game.getGameState().getPlayers().add(Game.getGameState().getActivePlayer());
            if (Game.isIsFirstGame()) Game.getGameState().getPlayers().add(Computer.getInstance());
            else Game.getGameState().getPlayers().add(Computer.reloadInstance());
            outPane.getChildren().remove(levelMenuPane);
        });
        levelMenuPane.add(hardL, 0, 2);
        levelMenuPane.setStyle("-fx-background-color: #dedede; -fx-border-width:0; -fx-border-insets: 0;  -fx-border-color: black; -fx-grid-lines-visible: true");
        outPane.setAlignment(Pos.BOTTOM_CENTER);
        outPane.add(levelMenuPane, 2, 3, 8, 6);
    }

    private void fillOutLineImg(GridPane outerPane, int x, int y, String url, int w, int h) {
        Label label = new Label();
        label.setStyle(url);
        label.setMinWidth(w);
        label.setMinHeight(h);
        outerPane.add(label, x, y);
    }

    public void drawLine(List<Cell> winLine) throws IOException {
        Image whiteSt = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/winWhiteSt.png"))));
        Image blackSt = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/winBlackSt.png"))));
        for (Cell x : winLine) {
            if (x.getChip().equals(Chip.X))
                x.setGraphic(new ImageView(whiteSt));
            else
                x.setGraphic(new ImageView(blackSt));
        }
        GameState gs = Game.getGameState();
        Player player = gs.getPlayers().stream().filter(p -> p.equals(gs.getActivePlayer())).findFirst().get();
        Image image = null;
        if (player.getName().equals("Player 1")) {
            image = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/player1.png"))));
        } else if (player.getName().equals("Player 2")) {
            image = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/player2.png"))));
        } else if (player.getName().equals("Computer")) {
            image = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/comp.png"))));
        } else if (gs.getEndMsg() != null) {
            image = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/draw.png"))));
        }
        ImageView iv = new ImageView(image);
        if (image.getWidth() > outPane.getColumnConstraints().size() * CELL_SIZE)
            iv.setFitWidth(outPane.getColumnConstraints().size() * CELL_SIZE - CELL_SIZE);
        outPane.add(iv, 0, 0, outPane.getColumnConstraints().size(), outPane.getColumnConstraints().size());
    }

    public void drawLine() throws IOException {
        Image image = new Image(Files.newInputStream(Paths.get(PATH.concat("/img/draw.png"))));
        ImageView iv = new ImageView(image);
        if (image.getWidth() > outPane.getColumnConstraints().size() * CELL_SIZE)
            iv.setFitWidth(outPane.getColumnConstraints().size() * CELL_SIZE - CELL_SIZE);
        outPane.add(iv, 0, 0, outPane.getColumnConstraints().size(), outPane.getColumnConstraints().size());
    }

}
