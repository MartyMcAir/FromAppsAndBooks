package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp;

import java.io.IOException;

public class CheckMinSize extends ChainCommon {
    private MyVisitChain_V3 objForCheck; // сеттим сервер что надо проверять

    CheckMinSize(MyVisitChain_V3 objForCheck) {
        this.objForCheck = objForCheck;
    }

    @Override
    public boolean check() throws IOException {
        if (objForCheck.getMinSize() > 0)
            return (objForCheck.getContentLength() > objForCheck.getMinSize());
        return true;
    }

}
