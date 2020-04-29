package z_OOP_BiG_Pack.Template_3712;

public abstract class Game {
    abstract void prepareForTheGame();

    abstract void playGame();

    abstract void congratulateWinner();

    public void run() {
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }
}
