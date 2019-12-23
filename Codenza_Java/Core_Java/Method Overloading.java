Method Overloading

import java.awt.Container;
import javax.swing.*;
public class MethodOverload extends JApplet
     {
     JTextArea outputArea;
     public void init()
         {
         outputArea = new JTextArea( 2, 20 );
         Container c = getContentPane();
         c.add( outputArea );
        
         outputArea.setText(
         "The square of integer 7 is " + square( 7 ) +
         "\nThe square of double 7.5 is " + square( 7.5 ) );
     }
    
     public int square( int x )
         {
         return x * x;
     }
    
     public double square( double y )
         {
         return y * y;
     }
}
