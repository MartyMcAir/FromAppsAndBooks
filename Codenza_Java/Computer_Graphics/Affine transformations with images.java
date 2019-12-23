Affine transformations with images

package com.ack.gui.awt.geometry;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;

public class AffineTransformationsWithImages extends Frame {

  Dimension size = new Dimension( 600, 600 );
  Image image;
  Point origin = new Point( size.width / 2, size.height / 2 );
  AffineTransform tx = new AffineTransform();
  float scalingFactor = 1.0f;

  public AffineTransformationsWithImages( String title ) {
    super( title );
    setSize( size );
    addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        dispose();
        System.exit( 0 );
      }
    } );
    setVisible( true );
    image = Toolkit.getDefaultToolkit().getImage( "3.gif" );
    tx.translate( origin.x, origin.y );
    for( int x = 0; x < 100; x++ ) {
      scalingFactor += 0.0003;
      pause( 50 );
      tx.scale( scalingFactor, scalingFactor );
      tx.rotate( scalingFactor );
      repaint();
    }
  }

  public static void main( String[] args ) {
    AffineTransformationsWithImages affineTransformationsWithImages1 =
        new AffineTransformationsWithImages( "Affine Transformations With Images Example" );
  }

  public void update( Graphics g ) {
    paint( g );
  }

  public void paint( Graphics g ) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.drawImage( image, tx, this );
  }

  private void pause( int mil ) {
    try {
      Thread.currentThread().sleep( mil );
    }
    catch( Exception ex ) {
      ex.printStackTrace();
    }
  }

}
