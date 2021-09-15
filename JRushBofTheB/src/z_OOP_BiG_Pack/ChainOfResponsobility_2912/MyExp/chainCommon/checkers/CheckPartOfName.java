package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp.chainCommon.checkers;

import z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp.chainCommon.MyVisitChain_V3;

import java.io.File;
import java.io.IOException;

public class CheckPartOfName extends ChainCommon {
    private MyVisitChain_V3 objForCheck; // сеттим сервер что надо проверять

    public CheckPartOfName(MyVisitChain_V3 objForCheck) {
        this.objForCheck = objForCheck;
    }

    @Override
    public boolean check() throws IOException {
        if (objForCheck.getPartOfName() != null)
            return new File(objForCheck.getFilePath().toString()).getName().contains(objForCheck.getPartOfName());
        return true;
    }
}
