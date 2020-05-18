package com.buseduc.javacourse.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RenderFX extends Application {

    private static Board board;
    private static Stage primStage;

    static {
        board = Game.getBoard();
    }

    public RenderFX() {
    }

    public static void reloadScene() {
        board = Game.getBoard();
        Scene scene = new Scene(board.render());
        scene.setFill(Color.TRANSPARENT);
        primStage.setScene(scene);
    }

    @Override
    public void start(Stage primaryStage) {
        primStage = primaryStage;
        primStage.initStyle(StageStyle.TRANSPARENT);
        primStage.setResizable(false);
        Scene scene = new Scene(board.render());
        scene.setFill(Color.TRANSPARENT);
        primStage.setScene(scene);
        primStage.show();
    }

}
