Using JLabel

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabelTest extends JFrame
     {
     private JLabel label1, label2, label3;
    
     public LabelTest()
         {
         super( "Testing JLabel" );
        
         Container c = getContentPane();
         c.setLayout( new FlowLayout() );
        
         // JLabel constructor with a string argument
         label1 = new JLabel( "Label with text" );
         label1.setToolTipText( "This is label1" );
         c.add( label1 );
        
         // JLabel constructor with string, Icon and
         // alignment arguments
         Icon bug = new ImageIcon( "bug1.gif" );
         label2 = new JLabel( "Label with text and icon",
         bug, SwingConstants.LEFT );
         label2.setToolTipText( "This is label2" );
         c.add( label2 );
        
         // JLabel constructor no arguments
         label3 = new JLabel();
         label3.setText( "Label with icon and text at bottom" );
         label3.setIcon( bug );
         label3.setHorizontalTextPosition( SwingConstants.CENTER );
         label3.setVerticalTextPosition( SwingConstants.BOTTOM );
         label3.setToolTipText( "This is label3" );
         c.add( label3 );
        
         setSize( 275, 170 );
         show();
     }
    
     public static void main( String args[] )
         {
         LabelTest app = new LabelTest();
        
         app.addWindowListener( new WindowAdapter()
             {
             public void windowClosing( WindowEvent e )
                 {
                 System.exit( 0 );
             }
         });
     }
}
