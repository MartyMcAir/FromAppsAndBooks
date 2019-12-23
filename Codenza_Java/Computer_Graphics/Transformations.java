Transformations
  
 

package com.ack.gui.awt.geometry;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class Transformations extends Frame {
  public static void main( String[] argv ) {
    Transformations myExample = new Transformations( "Transformations" );
  }

  public Transformations( String title ) {
    super( title );
    setSize( 600, 600 );
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
    Rectangle2D rect1 = new Rectangle2D.Double( 132, 42, 100, 100 );
    AffineTransform at = AffineTransform.getRotateInstance( ( 10 * Math.PI ) / 180 );
    at.concatenate( AffineTransform.getScaleInstance( 2, 2 ) );
    at.concatenate( AffineTransform.getShearInstance( 1, 0 ) );
    at.concatenate( AffineTransform.getTranslateInstance( -100, 0 ) );
    g2d.setTransform( at );
    g2d.setColor( Color.red );
    g2d.fill( rect1 );
  }

}
