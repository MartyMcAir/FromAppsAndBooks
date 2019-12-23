Registering 2 same listeners for a component

import javax.swing.*;
import java.awt.event.*;

public class Test
    {
     boolean firstAdapterCalled = false;
     boolean secondAdapterCalled = false;
     MyFirstAdapter ma1;
     MySecondAdapter ma2;
     public Test()
         {
         JFrame frame = new JFrame ("Test");
         JButton butt = new JButton("Press Me");
         frame.getContentPane().add(butt);
         frame.pack();
         frame.setVisible(true);
         ma1 = new MyFirstAdapter();
         ma2 = new MySecondAdapter();
         butt.addMouseListener(ma1);
         butt.addMouseListener(ma2);
     }
     public static void main (String [] args)
         {
         Test t = new Test();
     }
    
     class MyFirstAdapter extends MouseAdapter
         {
         public void mouseClicked(MouseEvent e)
             {
             System.out.println("Called first adapter");
             firstAdapterCalled = true;
             ma2.mouseClicked(e);
         }
     }
     class MySecondAdapter extends MouseAdapter
         {
         public void mouseClicked(MouseEvent e)
             {
             if (!firstAdapterCalled)
                 {
                 System.out.println("First adapter not called yet...");
                 return;
             }
             System.out.println("Second adapter called");
             firstAdapterCalled = false;
         }
     }
}
