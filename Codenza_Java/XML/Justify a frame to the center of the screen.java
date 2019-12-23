Justify a frame to the center of the screen
  
 

package com.ack.gui.awt.simple;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JustifyAFrameToTheCenterOfTheScreen implements ActionListener {
  private Frame f;
  private Button b1, b2;

  public static void main( String[] args ) {
    JustifyAFrameToTheCenterOfTheScreen justifyAFrameToTheCenterOfTheScreenExample =
        new JustifyAFrameToTheCenterOfTheScreen();
    justifyAFrameToTheCenterOfTheScreenExample.go();
  }

  public void go() {
    f = new Frame( "Centered Gui Example" );
    f.setLayout( new FlowLayout() );

    b1 = new Button( "Button 1" );
    b1.addActionListener( this );
    f.add( b1 );

    b2 = new Button( "Button 2" );
    b2.addActionListener( this );
    f.add( b2 );

    f.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        System.exit( 0 );
      }
    } );
    f.pack();
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension ssize = toolkit.getScreenSize();
    Dimension framesize = f.getSize();
    int x = (int) ( ssize.getWidth() - f.getWidth() ) / 2;
    int y = (int) ( ssize.getHeight() - f.getHeight() ) / 2;
    f.setLocation( x, y );
    f.setVisible( true );
  }

  public void actionPerformed( ActionEvent ae ) {
    if( (Button) ae.getSource() == b1 )
      System.out.println( "First Button was pressed!" );
    if( (Button) ae.getSource() == b2 )
      System.out.println( "Second Button was pressed!" );
  }
}
