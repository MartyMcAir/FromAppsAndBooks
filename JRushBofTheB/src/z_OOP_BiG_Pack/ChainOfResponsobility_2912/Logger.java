package z_OOP_BiG_Pack.ChainOfResponsobility_2912;

public interface Logger {
    void inform(String message, int level);

    void setNext(Logger next);

    void info(String message);
}