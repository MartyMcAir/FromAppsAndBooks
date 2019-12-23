CheckBox Demo

import java.awt.*;

public class Checkboxes extends CloseableFrame {
  public static void main(String[] args) {
    new Checkboxes();
  }

  public Checkboxes() {
    super("Checkboxes");
    setFont(new Font("SansSerif", Font.BOLD, 18));
    setLayout(new GridLayout(0, 2));
    Checkbox box;
    for(int i=0; i<12; i++) {
      box = new Checkbox("Checkbox " + i);
      if (i%2 == 0) {
        box.setState(true);
      }
      add(box);
    }
    pack();
    setVisible(true);
  }
}
