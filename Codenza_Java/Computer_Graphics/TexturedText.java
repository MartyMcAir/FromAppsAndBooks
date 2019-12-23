TexturedText
  
 

package com.ack.gui.awt.geometry;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class TexturedText extends Frame {
  public static void main( String[] argv ) {
    TexturedText myExample = new TexturedText( "Using Text Textures" );
  }

  public TexturedText( String title ) {
    super( title );
    setSize( 450, 180 );
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
    FontRenderContext frc = g2d.getFontRenderContext();
    Font font = new Font( "Helvetica", Font.ITALIC | Font.BOLD, 72 );
    TextLayout tl = new TextLayout( "Excellent!", font, frc );
    Shape myShape =
        tl.getOutline( AffineTransform.getTranslateInstance( 50, 100 ) );
    Paint myPaint = loadTextureResource( "1.gif" );
    g2d.setPaint( myPaint );
    g2d.fill( myShape );
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
