package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp;

import java.io.IOException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestServ4_LambdF {
    private int contentLength, minSize, maxSize;
    private boolean odd;
    private ChainCommon chainCommon;

    public void setChainCommon(ChainCommon chainCommon) {
        this.chainCommon = chainCommon;
    }

    public static void main(String[] args) {
        TestServ4_LambdF t4 = new TestServ4_LambdF();
        t4.setMinSize(3);
        t4.setContentLength(6);
        t4.setMaxSize(11);

        Predicate<TestServ4_LambdF> predicate = a -> a.getContentLength() > a.minSize;
        Predicate<TestServ4_LambdF> and = predicate.and(a -> a.getContentLength() < a.getMaxSize());
        boolean test = and.test(t4);
        if (test) {
            System.out.println("Who!");
        }


        Function<Integer, Boolean> fMax = (v -> v < t4.maxSize);
        Function<Integer, Boolean> fMin = (v -> v < t4.minSize);
//        System.out.println(compose(fMax, fMin));

        Predicate<Integer> predicateMax = (k) -> k < t4.maxSize;
        Predicate<Integer> predicateMin = (k) -> k > t4.minSize;


//        System.out.println(check(1, 2, (k, v) -> (boolean) (k > v)));
        System.out.println(findMatch(2, v -> v % 2 == 0));

        System.out.println(findMatch(2, v -> v % 2 == 0));

    }

    private static <T> Function<T, T> compose(Function<T, T>... functions) {
        Function<T, T> result = Function.identity();
        for (Function<T, T> f : functions) {
            result = result.andThen(f);
        }
        return result;
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
