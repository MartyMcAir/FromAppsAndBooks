Working with LookAndFeel

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LookAndFeelDemo extends JFrame 
     {
     private String strings[] = { "Metal", "Motif", "Windows" };
     private UIManager.LookAndFeelInfo looks[];
     private JRadioButton radio[];
     private ButtonGroup group;
     private JButton button;
     private JLabel label;
     private JComboBox comboBox;
    
     public LookAndFeelDemo()
         {
         super( "Look and Feel Demo" );
        
         Container c = getContentPane();
        
         JPanel northPanel = new JPanel();
         northPanel.setLayout( new GridLayout( 3, 1, 0, 5 ) );
         label = new JLabel( "This is a Metal look-and-feel", SwingConstants.CENTER );
         northPanel.add( label );
         button = new JButton( "JButton" );
         northPanel.add( button );
         comboBox = new JComboBox( strings );
         northPanel.add( comboBox );
        
         c.add( northPanel, BorderLayout.NORTH );
        
         JPanel southPanel = new JPanel();
         radio = new JRadioButton[ strings.length ];
         group = new ButtonGroup();
         ItemHandler handler = new ItemHandler();
         southPanel.setLayout( new GridLayout( 1, radio.length ) );
        
         for ( int i = 0; i < radio.length; i++ ) 
             {
             radio[ i ] = new JRadioButton( strings[ i ] );
             radio[ i ].addItemListener( handler );
             group.add( radio[ i ] );
             southPanel.add( radio[ i ] );
         }
        
         c.add( southPanel, BorderLayout.SOUTH );
        
         // get the installed look-and-feel information
         looks = UIManager.getInstalledLookAndFeels();
        
         setSize( 300, 200 );
         show();
        
         radio[ 0 ].setSelected( true );
     }
    
     private void changeTheLookAndFeel( int value )
         {
         try 
             {
             UIManager.setLookAndFeel( looks[ value ].getClassName() );
             SwingUtilities.updateComponentTreeUI( this );
         }
         catch ( Exception e ) 
             {
             e.printStackTrace();
         }
     }
    
     public static void main( String args[] )
         {
         LookAndFeelDemo dx = new LookAndFeelDemo();
        
         dx.addWindowListener( new WindowAdapter() 
             {
             public void windowClosing( WindowEvent e )
                 {
                 System.exit( 0 );
             }
         } );
     }
    
     private class ItemHandler implements ItemListener 
         {
         public void itemStateChanged( ItemEvent e )
             {
             for ( int i = 0; i < radio.length; i++ )
             if ( radio[ i ].isSelected() ) 
                 {
                 label.setText( "This is a " + strings[ i ] + " look-and-feel" );
                 comboBox.setSelectedIndex( i );
                 changeTheLookAndFeel( i );
             }
         }
     }
}
