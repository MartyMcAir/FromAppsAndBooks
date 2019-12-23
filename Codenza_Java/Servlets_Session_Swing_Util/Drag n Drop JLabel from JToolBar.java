Drag n Drop JLabel from JToolBar

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.dnd.*;
import javax.swing.border.*; 

public class DragDrop1 extends JFrame
    { 
     JPanel tpan = new JPanel(); 
     JToolBar fpan = new JToolBar(); 
    
     Cursor dc = new Cursor(Cursor.DEFAULT_CURSOR); 
     Cursor yd = DragSource.DefaultMoveDrop; 
     Point mp;
    
    public DragDrop1() 
        { 
         super(" From .......> To"); 
         addWindowListener(new WindowAdapter()
             { 
             public void windowClosing(WindowEvent ev)
                 { 
                 dispose(); 
                 System.exit(0);
             }
         }); 
         setBounds(10,10,650,450); 
         fpan.setPreferredSize(new Dimension(1,26));
         fpan.setBorder(BorderFactory.createRaisedBevelBorder());
         tpan.setLayout(null); 
         getContentPane().add("North",fpan); 
         getContentPane().add("Center",tpan); 
         add_comp(new JLabel(" D1 "),Color.red);
         add_comp(new JLabel(" D2 "),Color.green);
         setVisible(true);
    } 
    
    private void add_comp(JLabel l, Color c)
        { 
         fpan.addSeparator();
         l.setOpaque(true);
         l.setHorizontalAlignment(SwingConstants.CENTER);
         l.setForeground(Color.black); 
         l.setBackground(c); 
         fpan.add(l); 
         mak_lis(l); 
    }
    private void mak_lis(final JLabel l)
        { 
         l.addMouseListener(new MouseAdapter() 
             { 
             public void mousePressed(MouseEvent m) 
                 { 
                 setCursor(yd);
                 l.setBorder(new MatteBorder(1,1,1,1,Color.black)); 
             } 
             public void mouseReleased(MouseEvent m) 
                 { 
                 l.setBorder(null); 
                 setCursor(dc);
                 int x = m.getX()+l.getX();
                 int y = m.getY()+l.getY()-tpan.getY(); 
                 if (y > 0 && x > 0 && y < tpan.getHeight() && x < tpan.getWidth()) 
                     { 
                     tpan.add(new_lab(l,x,y)); 
                     tpan.repaint(); 
                 }
             }
         }); 
    }
    private Component new_lab(JLabel co, int x, int y) //function to draw label in new posn
        {
         JLabel label = new JLabel(co.getText());
         label.setOpaque(true);
         label.setHorizontalAlignment(SwingConstants.CENTER);
         label.setForeground(co.getForeground());
         label.setBackground(co.getBackground());
         label.setBounds(x,y,co.getWidth(),co.getHeight());
         return(label); 
    }
    public static void main (String[] args) 
        {
         new DragDrop1();
    }
    
}
