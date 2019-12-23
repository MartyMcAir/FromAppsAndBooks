Scaled Image

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ScaledImage extends JFrame implements ActionListener
    {
     JButton jb;
     String file="copy.gif";
     ImageIcon icon=null;
     Image image = null;
     JLabel button;
    
     public ScaledImage()
         {
         jb = new JButton("Select Image");
         jb.addActionListener(this);
        
         icon = new ImageIcon( file );
         image = icon.getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH);
         button = new JLabel( new ImageIcon( image ) );
         getContentPane().add( button, BorderLayout.CENTER );
         getContentPane().add( jb, BorderLayout.SOUTH );
     }
     public static void main(String[] args)
         {
         ScaledImage frame = new ScaledImage();
         frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
         frame.setSize(300,300);
         frame.setVisible(true);
     }
     public void actionPerformed(ActionEvent ae)
         {
         JFileChooser fc = new JFileChooser();
        
         int returnVal = fc.showOpenDialog(this);
         if(returnVal == JFileChooser.APPROVE_OPTION)
             {
             file = fc.getSelectedFile().getName();
         }
        
         icon = new ImageIcon( file );
         image = icon.getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH);
         button.setIcon(new ImageIcon(image));
         button.repaint();
     }
}
