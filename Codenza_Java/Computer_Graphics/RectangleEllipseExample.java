import java.awt.*;
import java.awt.geom.*;

/**
* An example for drawing rectangles and ellipses.
*
* @author Frank Klawonn
* Last change 07.01.2005
*/
public class RectangleEllipseExample extends Frame
{
    //Constructor
    RectangleEllipseExample()
    {
        //Enables the closing of the window.
        addWindowListener(new MyFinishWindow());
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //Use of antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //The lines should have a thickness of 3.0 instead of 1.0.
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);
        //Generating and drawing a rectangle.
        Rectangle2D.Double r2d = new Rectangle2D.Double(50,60,150,100);
        g2d.draw(r2d);
        //Generating and drawing an ellipse.
        Ellipse2D.Double elli = new Ellipse2D.Double(250,60,150,100);
        g2d.draw(elli);
        g2d.setStroke(new BasicStroke(1.0f));
        //Drawing the rectangle which defines the ellipse (with thinner lines).
        Rectangle2D.Double r2delli = new Rectangle2D.Double(250,60,150,100);
        g2d.draw(r2delli);
        //Draw a coordinate system.
        drawSimpleCoordinateSystem(430,180,g2d);
    }

    /**
    * Draws a coordinate system (according to the window coordinates).
    *
    * @param xmax     x-coordinate to which the x-axis should extend.
    * @param ymax     y-coordinate to which the y-axis should extend.
    * @param g2d      Graphics2D object for drawing.
    */
    public static void drawSimpleCoordinateSystem(int xmax, int ymax,
            Graphics2D g2d)
    {
        int xOffset = 30;
        int yOffset = 50;
        int step = 20;
        String s;
        //Remember the actual font.
        Font fo = g2d.getFont();
        //Use a small font.
        g2d.setFont(new Font("serif",Font.PLAIN,9));
        //x-axis
        g2d.drawLine(xOffset,yOffset,xmax,yOffset);
        //Marks and labels for the x-axis.
        for (int i=xOffset+step; i<=xmax; i=i+step)
            {
                g2d.drawLine(i,yOffset-2,i,yOffset+2);
                g2d.drawString(String.valueOf(i),i-7,yOffset-7);
            }
        //y-axis
        g2d.drawLine(xOffset,yOffset,xOffset,ymax);
        //Marks and labels for the y-axis.
        s="  "; //for indention of numbers < 100
        for (int i=yOffset+step; i<=ymax; i=i+step)
            {
                g2d.drawLine(xOffset-2,i,xOffset+2,i);
                if (i>99)
                    {
                        s="";
                    }
                g2d.drawString(s+String.valueOf(i),xOffset-25,i+5);
            }
        //Reset to the original font.
        g2d.setFont(fo);
    }


    public static void main(String[] argv)
    {
        RectangleEllipseExample f = new RectangleEllipseExample();
        f.setTitle("Rectangle and ellipse");
        f.setSize(450,200);
        f.setVisible(true);
    }
}

