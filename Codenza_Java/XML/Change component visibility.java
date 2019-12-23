Change component visibility

package com.ack.gui.awt.simple;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChangeComponentVisibility extends Frame {

  Panel tp, bp, cp;
  Button b1;
  TextField tf;

  public ChangeComponentVisibility( String s ) {
    super( s );
    init();
  }

  public void init() {
    setLayout( new BorderLayout() );
    tp = new Panel();
    bp = new Panel();
    cp = new Panel();
    b1 = new Button( "Change Visibility" );
    bp.add( b1 );
    MyActionListener mal = new MyActionListener();
    b1.addActionListener( mal );
    add( "North", tp );
    add( "South", bp );
    add( "Center", cp );
    addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        dispose();
        System.exit( 0 );
      }

    } );
    tf = new TextField( "MyLabel", 60 );
    cp.add( tf );
    pack();
    setVisible( true );
  }

  public static void main( String[] argv ) {
    ChangeComponentVisibility it =
        new ChangeComponentVisibility( "Change Component Visibility" );
  }

  class MyActionListener implements ActionListener {
    public void actionPerformed( ActionEvent ae ) {
      boolean b = tf.isVisible();
      if( b ) {
        tf.setVisible( false );
      }
      else {
        tf.setVisible( true );
      }
    }
  }
}
