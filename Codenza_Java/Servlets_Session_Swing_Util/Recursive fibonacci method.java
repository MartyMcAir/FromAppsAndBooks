Recursive fibonacci method

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FibonacciTest extends JApplet implements ActionListener
     {
     JLabel numLabel, resultLabel;
     JTextField num, result;
    
     public void init()
         {
         Container c = getContentPane();
         c.setLayout( new FlowLayout() );
        
         numLabel = new JLabel( "Enter an integer and press Enter" );
         c.add( numLabel );
        
         num = new JTextField( 10 );
         num.addActionListener( this );
         c.add( num );
        
         resultLabel = new JLabel( "Fibonacci value is" );
         c.add( resultLabel );
        
         result = new JTextField( 15 );
         result.setEditable( false );
         c.add( result );
     }
    
     public void actionPerformed( ActionEvent e )
         {
         long number, fibonacciValue;
        
         number = Long.parseLong( num.getText() );
         showStatus( "Calculating ..." );
         fibonacciValue = fibonacci( number );
         showStatus( "Done." );
         result.setText( Long.toString( fibonacciValue ) );
     }
    
     // Recursive definition of method fibonacci
     public long fibonacci( long n )
         {
         if ( n == 0 || n == 1 ) // base case
         return n;
         else
         return fibonacci( n - 1 ) + fibonacci( n - 2 );
     }
}
