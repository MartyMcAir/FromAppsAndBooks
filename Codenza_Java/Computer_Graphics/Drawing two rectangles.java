Drawing two rectangles

package com.ack.gui.awt.geometry;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;

public class DrawingTwoRectangles extends Frame {
  public static void main( String[] argv ) {
    DrawingTwoRectangles myExample = new DrawingTwoRectangles( "Drawing rectangles using the 2D api" );
  }

  public DrawingTwoRectangles( String title ) {
    super( title );
    setSize( 300, 180 );
    addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        dispose();
        System.exit( 0 );
      }
    } );
    setVisible( true );
  }

  public void paint( Graphics g ) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor( Color.red );
    Rectangle2D rect1 = new Rectangle2D.Double( 32, 42, 100, 100 );
    Rectangle2D rect2 = new Rectangle2D.Double( 164, 42, 100, 100 );
    g2d.fill( rect1 );
    g2d.draw( rect2 );
  }
}
