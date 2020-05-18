package z_OOP_BiG_Pack.ChainOfResponsobility_2912;

//public class FileLogger implements Logger {
public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    public void info(String message) {
        System.out.println("Logging to file: " + message);
    }
}