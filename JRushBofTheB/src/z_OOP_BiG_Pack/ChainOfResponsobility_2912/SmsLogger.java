package z_OOP_BiG_Pack.ChainOfResponsobility_2912;

//public class SmsLogger implements Logger {
public class SmsLogger extends AbstractLogger {
    public SmsLogger(int level) {
        this.level = level;
    }

    @Override
    public void info(String message) {
        System.out.println("Send SMS to CEO: " + message);
    }
}