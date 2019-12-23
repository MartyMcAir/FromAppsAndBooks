Moving label using arrow keys

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MoveLabel extends JFrame
    {
     JLabel label;
     public MoveLabel()
         {
         label = new JLabel(new ImageIcon("copy.gif"));
         label.setBounds(20,30,16,19);
         label.addKeyListener(new KeyAdapter()
             {
             public void keyPressed(KeyEvent ke)
                 {
                 if(ke.getKeyCode() == KeyEvent.VK_DOWN)
                     {
                     label.setLocation(label.getX(),label.getY()+1);
                     repaint();
                 }
                 if(ke.getKeyCode() == KeyEvent.VK_UP)
                     {
                     label.setLocation(label.getX(),label.getY()-1);
                     repaint();
                 }
                 if(ke.getKeyCode() == KeyEvent.VK_LEFT)
                     {
                     label.setLocation(label.getX()-1,label.getY());
                     repaint();
                 }
                 if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
                     {
                     label.setLocation(label.getX()+1,label.getY());
                     repaint();
                 }
             }
         });
         label.addMouseListener(new MouseAdapter()
             {
             public void mouseClicked(MouseEvent me)
                 {
                 if(me.getClickCount() == 1)
                     {
                     boolean dd = label.isOptimizedDrawingEnabled();
                     boolean ff = label.requestFocusInWindow();
                     repaint();
                 }
             }
            
         });
         JPanel p = new JPanel();
         p.setPreferredSize(new Dimension(2000,1000));
         p.setLayout(null);
         p.add(label);
         JScrollPane js = new JScrollPane(p);
         getContentPane().add(js);
     }
     public static void main(String args[])
         {
         MoveLabel frame = new MoveLabel();
         frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
         frame.setSize(300,300);
         frame.setVisible(true);
     }
}
