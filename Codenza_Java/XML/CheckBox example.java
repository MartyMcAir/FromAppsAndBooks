CheckBox example

package com.ack.gui.awt.simple;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckBoxExample {
  public CheckBoxExample() {
    Frame f = new Frame( "CheckBox Example" );
    f.setLayout( new FlowLayout() );
    for( int i = 0; i < 18; i++ ) {
      Checkbox cb = new Checkbox( "checkbox " + i, false );
      f.add( cb );
    }
    f.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        System.exit( 0 );
      }
    } );
    f.pack();
    f.setVisible( true );
  }

  public static void main( String[] args ) {
    CheckBoxExample myCheckboxExample = new CheckBoxExample();
  }
}
