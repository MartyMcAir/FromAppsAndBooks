package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp.chainCommon.checkers;

import z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp.chainCommon.MyVisitChain_V3;

import java.io.IOException;

public class CheckMinSize extends ChainCommon {
    private MyVisitChain_V3 objForCheck; // сеттим сервер что надо проверять

    public CheckMinSize(MyVisitChain_V3 objForCheck) {
        this.objForCheck = objForCheck;
    }

    @Override
    public boolean check() throws IOException {
        if (objForCheck.getMinSize() > 0)
            return (objForCheck.getContentLength() > objForCheck.getMinSize());
        return true;
    }

}
