GeneralPaths

package com.ack.gui.awt.geometry;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class GeneralPaths extends Frame {
  public static void main( String[] argv ) {
    GeneralPaths myExample = new GeneralPaths( "General Paths" );
  }

  public GeneralPaths( String title ) {
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
    GeneralPath gp1 = new GeneralPath( GeneralPath.WIND_EVEN_ODD );
    GeneralPath gp2 = new GeneralPath( GeneralPath.WIND_EVEN_ODD );
    gp1.moveTo( 20, 30 );
    gp1.lineTo( 150, 30 );
    gp1.lineTo( 150, 130 );
    gp1.closePath();
    gp2.moveTo( 180, 30 );
    gp2.lineTo( 290, 30 );
    gp2.quadTo( 200, 75, 180, 130 );
    gp2.curveTo( 110, 50, 220, 100, 180, 30 );
    g2d.setPaint( loadTextureResource( "1.gif" ) );
    g2d.fill( gp1 );
    g2d.fill( gp2 );

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
