Paints and strokes
  

package com.ack.gui.awt.geometry;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;

public class PaintsAndStrokes extends Frame {
  public static void main( String[] argv ) {
    PaintsAndStrokes myExample = new PaintsAndStrokes( "Paints and strokes" );
  }

  public PaintsAndStrokes( String title ) {
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
    Paint gp = g2d.getPaint();
    g2d.setPaint( new GradientPaint( 32, 42, Color.red, 100, 100, Color.white, true ) );
    g2d.fill( rect1 );
    g2d.setPaint( gp );
    g2d.setStroke( new BasicStroke( 2f, BasicStroke.CAP_ROUND,
                                    BasicStroke.JOIN_ROUND, 3f, new float[]{10f}, 0f ) );
    g2d.draw( rect2 );
  }

}
