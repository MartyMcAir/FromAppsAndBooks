package z_OOP_BiG_Pack.MVC_Simple_3601;

import java.util.List;

public class Controller {
    public List<String> onShowDataList() {
        return new Model().getStringDataList();
    }
}
