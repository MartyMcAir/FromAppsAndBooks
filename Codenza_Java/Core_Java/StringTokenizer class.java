StringTokenizer class

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class TokenTest extends JFrame
     {
     private JLabel prompt;
     private JTextField input;
     private JTextArea output;
    
     public TokenTest()
         {
         super( "Testing Class StringTokenizer" );
        
         Container c = getContentPane();
         c.setLayout( new FlowLayout() );
        
         prompt = new JLabel( "Enter a sentence and press Enter" );
         c.add( prompt );
        
         input = new JTextField( 20 );
         input.addActionListener( new ActionListener()
             {
             public void actionPerformed( ActionEvent e )
                 {
                 String stringToTokenize = e.getActionCommand();
                 StringTokenizer tokens = new StringTokenizer( stringToTokenize );
                
                 output.setText( "Number of elements: " + tokens.countTokens() + "\nThe tokens are:\n" );
                
                 while ( tokens.hasMoreTokens() )
                 output.append( tokens.nextToken() + "\n" );
             }
         });
         c.add( input );
        
         output = new JTextArea( 10, 20 );
         output.setEditable( false );
         c.add( new JScrollPane( output ) );
        
         setSize( 275, 260 ); // set the window size
         show(); // show the window
     }
    
     public static void main( String args[] )
         {
         TokenTest app = new TokenTest();
        
         app.addWindowListener( new WindowAdapter()
             {
             public void windowClosing( WindowEvent e )
                 {
                 System.exit( 0 );
             }
         });
     }
}
