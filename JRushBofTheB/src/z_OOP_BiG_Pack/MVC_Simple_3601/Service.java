package z_OOP_BiG_Pack.MVC_Simple_3601;

import java.util.ArrayList;
import java.util.List;

public class Service {
    public List<String> getData() {
        List<String> data = new ArrayList<String>() {{
            add("First string");
            add("Second string");
            add("Third string");
        }};
        return data;
    }
}
