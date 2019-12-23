Changing container at runtime

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelChange extends JFrame implements ActionListener,MouseListener
    {
    
     JPanel panel1 = new JPanel();
     JPanel panel2 = new JPanel();
     JLabel label = new JLabel("This is label");
     JButton but = new JButton("This is button");
    
     public PanelChange()
         {
         panel1.add(label);
         panel2.add(but);
        
        
         but.addActionListener(this);
         label.addMouseListener(this);
        
         getContentPane().add(panel2);
     }
    
     public void mouseClicked(MouseEvent me)
         {
         if(me.getClickCount() == 1)
             {
             panel1.setVisible(false);
             getContentPane().add(panel2);
             panel2.setVisible(true);
         }
     }
     public void mousePressed(MouseEvent me){}
     public void mouseReleased(MouseEvent me){}
     public void mouseEntered(MouseEvent me){}
     public void mouseExited(MouseEvent me){}
    
     public void actionPerformed(ActionEvent ae)
         {
         if(ae.getSource() == but)
             {
             panel2.setVisible(false);
             getContentPane().add(panel1);
             panel1.setVisible(true);
         }
     }
    
     public static void main(String args[])
         {
         PanelChange pc = new PanelChange();
         pc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         pc.setSize(200,200);
         pc.setVisible(true);
     }
    
    
}
