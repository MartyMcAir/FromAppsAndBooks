package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp.exp1;

import z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp.chainCommon.checkers.ChainCommon;

import java.io.IOException;

public class TestServer3 {
    private int contentLength, minSize, maxSize;
    private boolean odd;
    private ChainCommon chainCommon;

    public void setChainCommon(ChainCommon chainCommon) {
        this.chainCommon = chainCommon;
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
