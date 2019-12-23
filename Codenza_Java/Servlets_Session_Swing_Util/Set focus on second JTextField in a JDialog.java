Set focus on second JTextField in a JDialog

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestFocus extends JFrame
    { 
     JButton button; public TestFocus() 
         { 
         JPanel panel = new JPanel(); 
         setContentPane( panel ); 
         panel.add( new JTextField( "Focus is on Click Me button", 20 ) ); 
         button = new JButton( "Click Me" ); 
         button.addActionListener( new ActionListener() 
             { 
             public void actionPerformed(ActionEvent e) 
                 { 
                 JDialog dialog = new JDialog1(); 
             } 
         }); 
         panel.add( button ); 
         // Listen for windowOpened event to set focus 
         addWindowListener( new WindowAdapter() 
             { 
             public void windowOpened( WindowEvent e ) 
                 { 
                 button.requestFocus(); 
             } 
         }); 
     } 
     public static void main(String[] args) 
         { 
         TestFocus frame = new TestFocus(); 
         frame.setDefaultCloseOperation( EXIT_ON_CLOSE ); 
         frame.pack(); 
         frame.setVisible(true);
         // frame.button.requestFocus(); 
     } 
     class JDialog1 extends JDialog 
         { 
         public JDialog1() 
             { 
             JPanel panel = new JPanel(); 
             setContentPane( panel); 
             panel.add( new JTextField( "Focus is on next Text Field", 20) ); 
             final JTextField tf1 = new JTextField(9); 
             panel.add( tf1 ); 
             pack(); 
             // Use invokeLater AFTER the dialog is shown 
             setVisible( true ); 
             SwingUtilities.invokeLater( new Runnable() 
                 { 
                 public void run() 
                     { 
                     tf1.requestFocus(); 
                 } 
             }); 
         } 
     }
}
