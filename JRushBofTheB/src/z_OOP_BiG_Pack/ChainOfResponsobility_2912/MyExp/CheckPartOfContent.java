package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CheckPartOfContent extends ChainCommon {
    private MyVisitChain_V3 objForCheck; // сеттим сервер что надо проверять

    CheckPartOfContent(MyVisitChain_V3 objForCheck) {
        this.objForCheck = objForCheck;
    }

    @Override
    public boolean check() throws IOException {
        if (objForCheck.getPartOfContent() != null) {
            boolean res = false;
            List<String> list = Files.readAllLines(objForCheck.getFilePath());
            for (String item : list) {
                if (item.contains(objForCheck.getPartOfContent())) {
                    res = true;
                }
            }
            if (!res) { // если не валидно
                return false;
            }
        }
        return true;
    }
}
