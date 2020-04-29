package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp;

import java.io.IOException;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class TestServer4Lambda {
    private int contentLength, minSize, maxSize;
    private boolean odd;
    private ChainCommon chainCommon;

    public void setChainCommon(ChainCommon chainCommon) {
        this.chainCommon = chainCommon;
    }

    public static void main(String[] args) {
        TestServer4Lambda t4 = new TestServer4Lambda();
        t4.setMinSize(3);
        t4.setContentLength(6);
        t4.setMaxSize(11);

//        System.out.println(check(1, 2, (k, v) -> (k >= v)));
        System.out.println(findMatch(2, v -> v % 2 == 0));

    }

    private static <T, U> boolean findMatch(T e, Predicate<T> predicateFunction) {
        return predicateFunction.test(e);
    }

    public static <T, U, Boolean> Boolean check(T n1, U n2, BiFunction<T, U, Boolean> function) {
        return function.apply(n1, n2);
    }

    public boolean runAllCheck() throws IOException {
        if (chainCommon.check()) {
            return true;
        }
        return false;
//        return chainCommon.check();
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isOdd() {
        return odd;
    }

    public void setOdd(boolean odd) {
        this.odd = odd;
    }
}
