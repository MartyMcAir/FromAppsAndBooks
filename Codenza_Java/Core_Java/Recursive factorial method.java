Recursive factorial method

import java.awt.*;
import javax.swing.*;
public class FactorialTest extends JApplet
     {
     JTextArea outputArea;
     public void init()
         {
         outputArea = new JTextArea();
        
         Container c = getContentPane();
         c.add( outputArea );
        
         // calculate the factorials of 0 through 10
         for ( long i = 0; i <= 10; i++ )
         outputArea.append( i + "! = " + factorial( i ) + "\n" );
     }
    
    
     // Recursive definition of method factorial
     public long factorial( long number )
         {
         if ( number <= 1 ) // base case
         return 1;
         else
         return number * factorial( number - 1 );
     }
}
