Using the bitwise shift operators

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BitShift extends JFrame
     {
    
     public BitShift()
         {
         super( "Shifting bits" );
        
         Container c = getContentPane();
         c.setLayout( new FlowLayout() );
         final JTextField bits = new JTextField( 33 );
         c.add( new JLabel( "Integer to shift " ) );
        
         final JTextField value = new JTextField( 12 );
         value.addActionListener( new ActionListener()
             {
             public void actionPerformed( ActionEvent e )
                 {
                 int val = Integer.parseInt( value.getText() );
                 bits.setText( getBits( val ) );
             }
         } );
         c.add( value );
        
         bits.setEditable( false );
         c.add( bits );
        
         JButton left = new JButton( "<<" );
         left.addActionListener( new ActionListener()
             {
             public void actionPerformed( ActionEvent e )
                 {
                 int val = Integer.parseInt( value.getText() );
                 val <<= 1;
                 value.setText( Integer.toString( val ) );
                 bits.setText( getBits( val ) );
             }
         } );
         c.add( left );
        
         JButton rightSign = new JButton( ">>" );
         rightSign.addActionListener( new ActionListener()
             {
             public void actionPerformed( ActionEvent e )
                 {
                 int val = Integer.parseInt( value.getText() );
                 val >>= 1;
                 value.setText( Integer.toString( val ) );
                 bits.setText( getBits( val ) );
             }
         } );
         c.add( rightSign );
        
         JButton rightZero = new JButton( ">>>" );
         rightZero.addActionListener( new ActionListener()
             {
             public void actionPerformed( ActionEvent e )
                 {
                 int val = Integer.parseInt( value.getText() );
                 val >>>= 1;
                 value.setText( Integer.toString( val ) );
                 bits.setText( getBits( val ) );
             }
         } );
         c.add( rightZero );
        
         setSize( 400, 120 );
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
         BitShift app = new BitShift();
         app.addWindowListener( new WindowAdapter()
             {
             public void windowClosing( WindowEvent e )
                 {
                 System.exit( 0 );
             }
         } );
     }
}
