Create a Draggable JWindow

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ab extends JWindow
    {
    
     private int X=0;
     private int Y=0;
    
     public ab()
         {
        
         setBounds(50,50,200,200);
        
         addWindowListener(new WindowAdapter()
             {
             public void windowClosing(WindowEvent e)
                 {
                 System.exit(0);
             }
         });
        
         addMouseListener(new MouseAdapter()
             {
             public void mousePressed(MouseEvent e)
                 {
                 X=e.getX();
                 Y=e.getY();
             }
         });
        
         addMouseMotionListener(new MouseMotionAdapter()
             {
             public void mouseDragged(MouseEvent e)
                 {
                 setLocation(getLocation().x+(e.getX()-X),getLocation().y+(e.getY()-Y));
             }
         });
        
         setVisible(true);
     }
     public static void main(String[] args)
         {
         new ab();
     }
}
