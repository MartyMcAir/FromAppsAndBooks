UsingTextures
  
 

package com.ack.gui.awt.geometry;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class UsingTextures extends Frame {
  public static void main( String[] argv ) {
    UsingTextures myExample = new UsingTextures( "Using Textures" );
  }

  public UsingTextures( String title ) {
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
    Rectangle2D rect1 = new Rectangle2D.Double( 32, 42, 100, 100 );
    Rectangle2D rect2 = new Rectangle2D.Double( 164, 42, 100, 100 );
    g2d.setPaint( loadTextureResource( "1.gif" ) );
    g2d.fill( rect1 );
    g2d.setStroke( new BasicStroke( 10f, BasicStroke.CAP_ROUND,
                                    BasicStroke.JOIN_MITER, 2f, new float[]{12f}, 0f ) );
    g2d.draw( rect2 );
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
