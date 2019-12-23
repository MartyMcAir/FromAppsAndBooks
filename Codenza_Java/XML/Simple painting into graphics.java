Simple painting into graphics
  
 

package com.ack.gui.awt.simple;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimplePaintingIntoGraphics extends Frame {
  private Font myFont;

  SimplePaintingIntoGraphics( String str ) {
    super( str );
    myFont = new Font( "Helvetica", Font.BOLD, 36 );
    addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        System.exit( 0 );
      }
    } );
  }

  public static void main( String[] argv ) {
    SimplePaintingIntoGraphics sa = new SimplePaintingIntoGraphics( "Simple Painting Into Graphics" );
    sa.setSize( 400, 300 );
    sa.show();
  }

  public void paint( Graphics g ) {
    g.setColor( Color.black );
    g.setFont( myFont );
    g.drawRect( 20, 30, 50, 80 ); // (x,y,width,height)
    g.fillRect( 20, 130, 50, 80 );
    g.drawLine( 80, 30, 120, 120 );
    int[] xPoints = {80, 100, 120, 130, 120};
    int[] yPoints = {130, 140, 160, 180, 140};
    g.drawPolyline( xPoints, yPoints, 5 );
    g.drawRoundRect( 150, 30, 50, 80, 30, 30 );
    g.fillRoundRect( 150, 130, 50, 80, 30, 30 );
    g.drawOval( 220, 30, 50, 80 );
    g.fillOval( 220, 130, 50, 80 );
    g.drawArc( 290, 30, 50, 80, 100, 100 );
    g.fillArc( 290, 130, 50, 80, 100, 100 );
    g.drawString( "Hello", 160, 260 );

  }
}
