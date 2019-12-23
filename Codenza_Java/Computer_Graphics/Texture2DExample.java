import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

/**
* An example for the use of textures.
*
* @author Frank Klawonn
* Last change 27.05.2005
*/
public class Texture2DExample extends Frame
{

    //The loaded image is saved in this object.
    private Image theImage;

    //The required TexturePaint.
    private BufferedImage buffi;


    /**
    * Constructor
    */
    public Texture2DExample()
    {
        //Enables the closing of the window.
        addWindowListener(new MyFinishWindow());
        //Here the JPEG-image for the texture is loaded to the Image object.
        theImage = new javax.swing.ImageIcon("image1.jpg").getImage();
        //TexturePaint requires a BufferedImage. Therefore, the Image
        //must be drawn onto a BufferedImage.
        buffi = new BufferedImage(theImage.getWidth(null),
                                  theImage.getHeight(null),
                                  BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dbuffi = buffi.createGraphics();
        g2dbuffi.drawImage(theImage,0,0,null);
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //The texture should be drawn once within this rectangle.
        Rectangle2D.Double rect = new Rectangle2D.Double(50,90,80,200);
        //Save the original clipping area.
        Shape clipShape = g2d.getClip();
        //Clipping w.r.t. to the rectangle.
        g2d.setClip(rect);
        //Fill the rectangle with the texture.
        //The small texture does not fill the rectangle completely.
        g2d.drawImage(theImage,50,50,null);
        //Reset the original clipping area.
        g2d.setClip(clipShape);
        //For illustration purposes the sides of the rectangle are drawn.
        //The rectangle is not filled completely by the texture.
        g2d.setStroke(new BasicStroke(3.0f));
        g2d.draw(rect);
        //Fill an ellipse repeatedly by a texture.
        TexturePaint tp = new TexturePaint(buffi,new Rectangle(0,0,
                                           buffi.getWidth(),
                                           buffi.getHeight()));
        g2d.setPaint(tp);
        Ellipse2D.Double elli = new Ellipse2D.Double(250,50,300,500);
        g2d.fill(elli);
    }

    public static void main(String[] argv)
    {
        Texture2DExample f = new Texture2DExample();
        f.setTitle("Textures");
        f.setSize(600,600);
        f.setVisible(true);
    }

}

