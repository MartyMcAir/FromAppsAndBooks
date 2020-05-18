package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp;

import java.io.IOException;

public class CheckMaxSize extends ChainCommon { // подкласс базового класса цепи
    private MyVisitChain_V3 objForCheck; // объект что надо проверять

    CheckMaxSize(MyVisitChain_V3 objForCheck) {
        this.objForCheck = objForCheck;
    }

    @Override
    public boolean check() throws IOException {
        if (objForCheck.getMaxSize() > 0)
            return objForCheck.getContentLength() < objForCheck.getMaxSize();
        return true;
    }
}

