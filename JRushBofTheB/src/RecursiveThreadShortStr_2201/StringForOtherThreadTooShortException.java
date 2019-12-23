package RecursiveThreadShortStr_2201;

public class StringForOtherThreadTooShortException extends RuntimeException {
    public StringForOtherThreadTooShortException(String msg, Throwable cause) {
        super(msg, cause);
    }

//    public StringForOtherThreadTooShortException(String msg) {
//        super(msg);
//    }

    @Override
    public synchronized Throwable getCause() {
        return new StringIndexOutOfBoundsException("String index out of range: -1");
    }

}
