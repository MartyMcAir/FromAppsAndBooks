Getting x and y positions of JFrame

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ab extends JFrame implements MouseListener
    {
     JPanel jpanel;
     JTextField jtf;
     int x,y;
     String str;
     public ab()
         {
         jtf = new JTextField();
         getContentPane().add(jtf,BorderLayout.SOUTH);
         getContentPane().addMouseListener(this);
     }
     public static void main(String[] args)
         {
         JFrame.setDefaultLookAndFeelDecorated(true);
         ab frame = new ab();
         frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
         frame.setSize(300,300);
         frame.setVisible(true);
     }
     public void paint(Graphics g)
         {
         super.paintComponents(g);
         str = "X:"+x+" "+"Y:"+y;
         jtf.setText(str);
     }
     public void mousePressed(MouseEvent me)
     {}
     public void mouseReleased(MouseEvent me)
     {}
     public void mouseEntered(MouseEvent me)
     {}
     public void mouseExited(MouseEvent me)
     {}
     public void mouseClicked(MouseEvent me)
         {
         x = me.getX();
         y = me.getY();
         repaint();
     }
}
