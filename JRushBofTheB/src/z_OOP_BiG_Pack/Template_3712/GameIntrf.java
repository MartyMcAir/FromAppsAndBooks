package z_OOP_BiG_Pack.Template_3712;

public interface GameIntrf {
    // так тож работает, но вале нужен абстрактный класс parent
    void prepareForTheGame();

    void playGame();

    void congratulateWinner();

    default void run() {
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }
}
