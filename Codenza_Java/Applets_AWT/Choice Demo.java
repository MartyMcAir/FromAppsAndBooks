Choice Demo

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class ChoiceTest2 extends Applet 
                         implements ItemListener {
  private Choice choice;

  public void init() {
    setFont(new Font("SansSerif", Font.BOLD, 36));
    choice = new Choice();
    choice.addItem("Choice 1");
    choice.addItem("Choice 2");
    choice.addItem("Choice 3");
    choice.addItemListener(this);
    add(choice);
  }

  public void itemStateChanged(ItemEvent event) {
    Choice choice = (Choice)event.getSource();
    String selection = choice.getSelectedItem();
    if (selection.equals("Choice 1")) {
      doChoice1Action();
    } else if (selection.equals("Choice 2")) {
      doChoice2Action();
    } else if (selection.equals("Choice 3")) {
      doChoice3Action();
    }
  }

  private void doChoice1Action() {
    System.out.println("Choice 1 Action");
  }

  private void doChoice2Action() {
    System.out.println("Choice 2 Action");
  }

  private void doChoice3Action() {
    System.out.println("Choice 3 Action");
  }
}
/*
<APPLET CODE="ChoiceTest2.class" WIDTH=275 HEIGHT=150>
</APPLET>
*/
