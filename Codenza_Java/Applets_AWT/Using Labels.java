Using Labels

import java.applet.Applet;
import java.awt.*;

public class Labels extends Applet {
  public void init() {
    setLayout(new GridLayout(4,1));
    Label label1, label2, label3, label4;
    label1 = new Label("Label 1");
    label2 = new Label("Label 2", Label.LEFT);
    label3 = new Label("Label 3", Label.RIGHT);
    label4 = new Label("Label 4", Label.CENTER);
    Font bigFont = new Font("SanSerif", Font.BOLD, 25);
    label2.setFont(bigFont);
    label3.setFont(bigFont);
    label4.setFont(bigFont);
    add(label1);
    add(label2);
    add(label3);
    add(label4);
  }
}
/*
<APPLET CODE="Labels.class" WIDTH=250 HEIGHT=120>
</APPLET>
*/
