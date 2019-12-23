Simple swing buttons
  
 

package com.ack.gui.swing.simple;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class SimpleSwingButtons extends JFrame {
  public static void main( String[] argv ) {
    SimpleSwingButtons myExample = new SimpleSwingButtons( "Simple Swing Buttons" );
  }

  public SimpleSwingButtons( String title ) {
    super( title );
    setSize( 150, 150 );
    addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        dispose();
        System.exit( 0 );
      }
    } );
    init();
    setVisible( true );
  }

  private void init() {
    JPanel my_panel = new JPanel();
    my_panel.setLayout( new GridLayout( 3, 3 ) );
    for( int i = 1; i < 10; i++ ) {
      ImageIcon icon = new ImageIcon( i + ".gif" );
      JButton jb = new JButton( icon );
      jb.setToolTipText( i + ".gif" );
      my_panel.add( jb );
    }
    getContentPane().add( my_panel );
    my_panel.setBorder( BorderFactory.createEtchedBorder() );
  }
}
