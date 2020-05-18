package z_OOP_BiG_Pack.MVC_Simple_3601;

import java.util.List;

public class Model {
    public List<String> getStringDataList() {
        return new Service().getData();
    }
}
