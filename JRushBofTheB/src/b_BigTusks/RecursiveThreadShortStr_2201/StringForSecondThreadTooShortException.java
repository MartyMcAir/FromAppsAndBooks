package b_BigTusks.RecursiveThreadShortStr_2201;

public class StringForSecondThreadTooShortException extends RuntimeException {
    public StringForSecondThreadTooShortException(String msg, Throwable cause) {
        super(msg, cause);
    }
//
//    public StringForSecondThreadTooShortException(String msg) {
//        super(msg);
//    }
    @Override
    public synchronized Throwable getCause() {
        return new StringIndexOutOfBoundsException("String index out of range: -1");
    }
}
