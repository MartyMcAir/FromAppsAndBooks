Finding the maximum of three doubles

import java.awt.Container;
import javax.swing.*;
public class DoubleMax extends JApplet
     {
     public void init()
         {
         JTextArea outputArea = new JTextArea();
        
         String s1 = JOptionPane.showInputDialog( "Enter first floating-point value" );
         String s2 = JOptionPane.showInputDialog( "Enter second floating-point value" );
         String s3 = JOptionPane.showInputDialog( "Enter third floating-point value" );
        
         double number1 = Double.parseDouble( s1 );
         double number2 = Double.parseDouble( s2 );
         double number3 = Double.parseDouble( s3 );
        
         double max = maximum( number1, number2, number3 );
        
         outputArea.setText( "number1: " + number1 + "\nnumber2: " + number2 + "\nnumber3: " + number3 +
         "\nmaximum is: " + max );
        
         // get the applet's GUI component display area
         Container c = getContentPane();
        
         // attach outputArea to Container c
         c.add( outputArea );
     }
    
     // maximum method definition
     public double maximum( double x, double y, double z )
         {
         return Math.max( x, Math.max( y, z ) );
     }
}
