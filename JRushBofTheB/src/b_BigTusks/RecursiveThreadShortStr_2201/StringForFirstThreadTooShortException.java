package b_BigTusks.RecursiveThreadShortStr_2201;

public class StringForFirstThreadTooShortException extends RuntimeException {

    public StringForFirstThreadTooShortException(String str, Throwable thr) {
        super(str, thr);
    }

    @Override
    public synchronized Throwable getCause() {
        return new StringIndexOutOfBoundsException("String index out of range: -1");
    }
}
