Printing an unsigned integer in bits

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PrintBits extends JFrame 
     {
    
     public PrintBits()
         {
         super( "Printing bit representations for numbers" );
        
         Container c = getContentPane();
         c.setLayout( new FlowLayout() );
         c.add( new JLabel( "Enter an integer " ) );
         final JTextField output = new JTextField( 33 );
         JTextField input = new JTextField( 10 );
         input.addActionListener( new ActionListener() 
             {
             public void actionPerformed( ActionEvent e )
                 {
                 int val = Integer.parseInt( e.getActionCommand() );
                 output.setText( getBits( val ) );
             }
         });
         c.add( input );
        
         c.add( new JLabel( "The integer in bits is" ) );
         output.setEditable( false );
         c.add( output );
        
         setSize( 720, 70 );
         show();
     }
    
     private String getBits( int value )
         {
         int displayMask = 1 << 31;
         StringBuffer buf = new StringBuffer( 35 );
        
         for ( int c = 1; c <= 32; c++ ) 
             {
             buf.append( ( value & displayMask ) == 0 ? '0' : '1' );
             value <<= 1;
            
             if ( c % 8 == 0 )
             buf.append( ' ' );
         }
        
         return buf.toString();
     }
    
     public static void main( String args[] )
         {
         PrintBits app = new PrintBits();
         app.addWindowListener( new WindowAdapter() 
             {
             public void windowClosing( WindowEvent e )
                 {
                 System.exit( 0 );
             }
         } );
     }
}
