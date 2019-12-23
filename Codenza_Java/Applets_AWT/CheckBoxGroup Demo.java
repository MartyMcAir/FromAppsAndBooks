CheckBoxGroup Demo

import java.applet.Applet;
import java.awt.*;

public class CheckboxGroups extends Applet {
  public void init() {
    setLayout(new GridLayout(4, 2));
    setBackground(Color.lightGray);
    setFont(new Font("Serif", Font.BOLD, 16));
    add(new Label("Flavor", Label.CENTER));
    add(new Label("Toppings", Label.CENTER));
    CheckboxGroup flavorGroup = new CheckboxGroup();
    add(new Checkbox("Vanilla", flavorGroup, true));
    add(new Checkbox("Colored Sprinkles"));
    add(new Checkbox("Chocolate", flavorGroup, false));
    add(new Checkbox("Cashews"));
    add(new Checkbox("Strawberry", flavorGroup, false));
    add(new Checkbox("Kiwi"));
  }
}
/*
<APPLET CODE="CheckboxGroups.class" WIDTH=400 HEIGHT=150>
</APPLET>
*/
