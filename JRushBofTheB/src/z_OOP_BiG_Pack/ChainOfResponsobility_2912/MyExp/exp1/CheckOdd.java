package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp.exp1;

import z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp.chainCommon.checkers.ChainCommon;
import z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp.exp1.TestServer3;

import java.io.IOException;

public class CheckOdd extends ChainCommon {
    private TestServer3 objForCheck;

    public CheckOdd(TestServer3 objForCheck) {
        this.objForCheck = objForCheck;
    }

    @Override
    public boolean check() throws IOException {
        System.out.println("+++CheckOdd");
        if (!((objForCheck.getContentLength() % 2) == 0)) {
            return false;
        }
        return false;
//        return checkNext();
    }

    @Override
    public String toString() {
        return "CheckOdd{" +
                "objForCheck=" + objForCheck +
                '}';
    }
}
