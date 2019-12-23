Compositing

package com.ack.gui.awt.geometry;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Compositing extends Frame {
  public static void main( String[] argv ) {
    Compositing myExample = new Compositing( "Compositing Shapes" );
  }

  public Compositing( String title ) {
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
    Rectangle2D rect1 = new Rectangle2D.Double( 32, 42, 200, 130 );
    Rectangle2D rect2 = new Rectangle2D.Double( 164, 42, 100, 100 );
    g2d.setColor( Color.cyan );
    g2d.fill( rect1 );
    g2d.setPaint( loadTextureResource( "1.gif" ) );
    g2d.setComposite( AlphaComposite.getInstance( AlphaComposite.SRC_OVER, .5f ) );
    g2d.fill( rect2 );

  }

  public TexturePaint loadTextureResource( String absfilename ) {
    MediaTracker tracker = new MediaTracker( this );
    Image imtexture = Toolkit.getDefaultToolkit().getImage( absfilename );
    tracker.addImage( imtexture, 0 );
    try {
      tracker.waitForID( 0 );
      int width = imtexture.getWidth( this );
      int height = imtexture.getHeight( this );
      System.out.println( "width" + width + " height =" + height );
      BufferedImage buffImg = new
          BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );
      Graphics g = buffImg.getGraphics();
      g.drawImage( imtexture, 0, 0, this );
      return new TexturePaint( buffImg, new Rectangle2D.Double( 0, 0, width, height ) );
    }
    catch( Exception e ) {
      System.out.println( "Exception on Image-Texture Loading" );
    }
    return null;
  }
}
