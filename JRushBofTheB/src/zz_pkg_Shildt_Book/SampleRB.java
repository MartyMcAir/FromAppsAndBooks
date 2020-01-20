package zz_pkg_Shildt_Book;

import java.util.ListResourceBundle;
// по умолчанию програ считается ENG
public class SampleRB extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] resource = new Object[3][2];
        resource[0][0] = "title";
        resource[0][1] = "My Program";
        resource[1][0] = "StopText";
        resource[1][1] = "Stop";
        resource[2][0] = "StartText";
        resource[2][1] = "Start";
        return resource;
    }
}
