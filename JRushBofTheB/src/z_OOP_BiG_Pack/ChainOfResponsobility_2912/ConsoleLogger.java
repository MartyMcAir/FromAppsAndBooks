package z_OOP_BiG_Pack.ChainOfResponsobility_2912;

//public class ConsoleLogger implements Logger {
public class ConsoleLogger extends AbstractLogger {
//    int level;
//    Logger next;
//
//    @Override
//    public void inform(String message, int level) {
//        if (this.level <= level) {
//            info(message);
//        }
//        if (next != null) {
//            next.inform(message, level);
//        }
//    }
//    @Override
//    public void setNext(Logger next) {
//        this.next = next;
//    }

    public ConsoleLogger(int level) {
        this.level = level;
    }
    @Override
    public void info(String message) {
        System.out.println("Logging to console: " + message);
    }
}