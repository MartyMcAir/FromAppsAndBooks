import java.awt.*;
import java.awt.geom.*;

/**
* Transformation of a rectangle: translation
*
* @author Frank Klawonn
* Letzte Aenderung 07.01.2005
* @see TransformationOrderExample
* @see TransformationOrderExampleR
* @see TransformationOrderExampleT
* @see TransformationOrderExampleRT
*/
public class TransformationOrderExampleT extends Frame
{
    private int windowHeight;

    /**
    * Constructor
    *
    * @param height  The window height.
    */
    TransformationOrderExampleT(int height)
    {
        //Enables the closing of the window.
        addWindowListener(new MyFinishWindow());
        windowHeight = height;
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        /*yUp defines a translation allowing the specification of objects in "real"
          coordinates where the y-axis points upwards and the origin of the coordinate
          system is located in the lower left corner of the window.
        */
        AffineTransform yUp = new AffineTransform();
        yUp.setToScale(1,-1);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(120,windowHeight-130);
        yUp.preConcatenate(translate);
        //Apply the transformation to the Graphics2D object to draw everything
        //in "real" coordinates.
        g2d.transform(yUp);
        //The lines should have a thickness of 3.0 instead of 1.0.
        g2d.setStroke(new BasicStroke(3.0f));
        //Generate a rectangle which will transformed later on.
        Rectangle2D.Double rect = new Rectangle2D.Double(-40,-20,80,40);
        //Define a translation.
        AffineTransform translation = new AffineTransform();
        translation.setToTranslation(40,20);
        //Draw the transformed rectangle.
        g2d.draw(translation.createTransformedShape(rect));
        g2d.setStroke(new BasicStroke(1.0f));
        //Draw a coordinate system.
        drawSimpleCoordinateSystem(80,80,g2d);
    }


    /**
    * Draws a coordinate system.
    *
    * @param xmax     x-coordinate to which the x-axis should extend.
    * @param ymax     y-coordinate to which the y-axis should extend.
    * @param g2d      Graphics2D object for drawing.
    */
    public static void drawSimpleCoordinateSystem(int xmax, int ymax,
            Graphics2D g2d)
    {
        int xOffset = -100;
        int yOffset = -100;
        int step = 20;
        String s;
        //Remember the actual font.
        Font fo = g2d.getFont();
        //Use a small font.
        int fontSize = 13;
        Font fontCoordSys = new Font("serif",Font.PLAIN,fontSize);
        /*
          Unfortunately, the transformation yUp applied to the Graphics2D object
          will cause the letters to occur upside down. Therefore, generate an
          upside down font which will appear correctly when drawn upside down.
        */
        //To make the font upside down, a reflection w.r.t. the x-axis is needed.
        AffineTransform flip = new AffineTransform();
        flip.setToScale(1,-1);
        //Shift the font back to the baseline after reflection.
        AffineTransform lift = new AffineTransform();
        lift.setToTranslation(0,fontSize);
        flip.preConcatenate(lift);
        //Generate the font with the letters upside down.
        Font fontUpsideDown = fontCoordSys.deriveFont(flip);
        g2d.setFont(fontUpsideDown);
        //x-axis
        g2d.drawLine(xOffset,0,xmax,0);
        //Marks and labels for the x-axis.
        for (int i=xOffset+step; i<=xmax; i=i+step)
            {
                g2d.drawLine(i,-2,i,2);
                if (i!=0)
                    {
                        g2d.drawString(String.valueOf(i),i-7,-30);
                    }
            }
        //y-axis.
        g2d.drawLine(0,yOffset,0,ymax);
        //Marks and labels for the y-axis.
        for (int i=yOffset+step; i<=ymax; i=i+step)
            {
                g2d.drawLine(-2,i,2,i);
                //for indention of numbers
                if (Math.abs(i)>99)
                    {
                        s="";
                    }
                else
                    {
                        if (Math.abs(i)>9)
                            {
                                s="  ";
                            }
                        else
                            {
                                s="    ";
                            }
                    }
                if (i>=0)
                    {
                        s = s+" ";
                    }
                if (i!=0)
                    {
                        g2d.drawString(s+String.valueOf(i),-25,i-20);
                    }
            }
        //Reset to the original font.
        g2d.setFont(fo);
    }


    public static void main(String[] argv)
    {
        int height = 260;
        TransformationOrderExampleT f = new TransformationOrderExampleT(height);
        f.setTitle("Only translation");
        f.setSize(230,height);
        f.setVisible(true);
    }


}


