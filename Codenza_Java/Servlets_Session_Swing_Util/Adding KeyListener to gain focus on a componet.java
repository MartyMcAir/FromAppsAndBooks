Adding KeyListener to gain focus on a componet

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class FocusTest extends JFrame implements KeyListener
    {
     JTextField jtf1,jtf2,jtf3;
     JPanel p;
    
     public FocusTest()
         {
         jtf1 = new JTextField(10);
         jtf2 = new JTextField(10);
         jtf3 = new JTextField(10);
        
         jtf1.addKeyListener(this);
        
         p = new JPanel();
         p.add(jtf1);
         p.add(jtf2);
         p.add(jtf3);
        
         getContentPane().add(p);
     }
     public static void main(String dd[])
         {
         FocusTest ft = new FocusTest();
         ft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ft.setSize(200,200);
         ft.setVisible(true);
     }
     public void keyPressed(KeyEvent ke)
         {
         if(ke.getKeyCode() == KeyEvent.VK_ENTER)
             {
             System.out.println("ll");
             jtf3.requestFocus();
         }
     }
     public void keyReleased(KeyEvent ke)
     {}
     public void keyTyped(KeyEvent ke)
     {}
}
