package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp;

import z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp2.LinkedChain;

import java.io.IOException;

// ___ Базовый стартовый класс цепочки
public abstract class ChainCommon {
    private ChainCommon firstChain, nextChain;

    public abstract boolean check() throws IOException;

    ChainCommon linkWith(ChainCommon linkedChain) { // метод постройки цепей
        if (firstChain == null) {
            firstChain = this;
        }
        nextChain = linkedChain;
        return linkedChain;
    }

    public boolean foolCheck() throws IOException {
        boolean res = true;
        ChainCommon tmp = firstChain;
        while (tmp != null) {
            if (!tmp.check())
                return false;
            tmp = tmp.nextChain;
        }
        return res;
    }
}
