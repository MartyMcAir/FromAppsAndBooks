Placing an icon to a frame
  
 

package com.ack.gui.awt.simple;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class PlacingAnIconToAFrame {
  private Frame frame;

  public static void main( String[] args ) {
    PlacingAnIconToAFrame myExample = new PlacingAnIconToAFrame();
    myExample.go();
  }

  public void go() {
    frame = new Frame( "First Gui Example" );
    ImageIcon icon = new ImageIcon( "1.gif" );
    frame.setIconImage( icon.getImage() );
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        System.exit( 0 );
      }
    } );
    frame.pack();
    frame.setVisible( true );
  }
}
