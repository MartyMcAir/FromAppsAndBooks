Using JTextArea

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextAreaDemo extends JFrame 
     {
     private JTextArea t1, t2;
     private JButton copy;
    
     public TextAreaDemo()
         {
         super( "TextArea Demo" );
        
         Box b = Box.createHorizontalBox();
        
         String s = "This is a demo string to\n" +
         "illustrate copying text\n" +
         "from one TextArea to \n" +
         "another TextArea using an\n"+
         "external event\n";
        
         t1 = new JTextArea( s, 10, 15 );
         b.add( new JScrollPane( t1 ) );
        
         copy = new JButton( "Copy >>>" );
         copy.addActionListener( new ActionListener() 
             {
             public void actionPerformed( ActionEvent e )
                 {
                 t2.setText( t1.getSelectedText() );
             }
         } );
         b.add( copy );
        
         t2 = new JTextArea( 10, 15 );
         t2.setEditable( false );
         b.add( new JScrollPane( t2 ) );
        
         Container c = getContentPane();
         c.add( b ); // Box placed in BorderLayout.CENTER
         setSize( 425, 200 );
         show();
     }
    
     public static void main( String args[] )
         {
         TextAreaDemo app = new TextAreaDemo();
        
         app.addWindowListener( new WindowAdapter() 
             {
             public void windowClosing( WindowEvent e )
                 {
                 System.exit( 0 );
             }
         } );
     }
}
