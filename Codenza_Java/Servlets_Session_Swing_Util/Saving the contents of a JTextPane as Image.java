Saving the contents of a JTextPane as Image

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
public class RobotImage extends javax.swing.JDialog
    {
     public RobotImage(java.awt.Frame parent, boolean modal)
         {
         super(parent, modal);
         initComponents();
         jTextPane.getCaret().setBlinkRate(0);
     }
     private void initComponents()
         {
         jTextPane = new javax.swing.JTextPane();
         addWindowListener(new java.awt.event.WindowAdapter()
             {
             public void windowClosing(java.awt.event.WindowEvent evt)
                 {
                 closeDialog(evt);
             }
         });
         getContentPane().add(jTextPane, java.awt.BorderLayout.CENTER);
         pack();
     }
     private void closeDialog(java.awt.event.WindowEvent evt)
         {
         try
             {
             jTextPane.getCaret().setVisible(false);
             jTextPane.paintImmediately(jTextPane.getBounds());
             BufferedImage bi = new Robot().createScreenCapture(this.getBounds());
             ImageIO.write(bi, "jpg", new File("t.jpg"));
         }
         catch (Exception ex)
             {
             // nothing
         }
         setVisible(false);
         dispose();
     }
     public static void main(String args[])
         {
         new RobotImage(new javax.swing.JFrame(), true).show();
     }
     private javax.swing.JTextPane jTextPane;
}
