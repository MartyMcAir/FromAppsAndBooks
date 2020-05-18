package z_OOP_BiG_Pack.ChainOfResponsobility_2912;

//public class PhoneLogger implements Logger {
public class PhoneLogger extends AbstractLogger {
    public PhoneLogger(int level) {
        this.level = level;
    }

    @Override
    public void info(String message) {
        System.out.println("Call to director: " + message);
    }
}