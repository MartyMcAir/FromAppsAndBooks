package zz_pkg_Shildt_Book;

import java.util.ListResourceBundle;

public class SampleRB_de extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] resource = new Object[3][2];
        resource[0][0] = "title";
        resource[0][1] = "Mein Program";
        resource[1][0] = "StopText";
        resource[1][1] = "Anschlag";
        resource[2][0] = "StartText";
        resource[2][1] = "Anfang";
        return resource;
    }
}
