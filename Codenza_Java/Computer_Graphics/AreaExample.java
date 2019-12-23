import java.awt.*;
import java.awt.geom.*;

/**
* This class demonstrates the use of union, intersection, difference and symmetric difference for
* Shape objects.
* Die Operationen werden auf einen und ein Rechteck angewendet.
*
* @author Frank Klawonn
* Last change 07.01.2005
*/
public class AreaExample extends Frame
{
    //Constructor
    AreaExample()
    {
        //Enables the closing of the window
        addWindowListener(new MyFinishWindow());
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //Use of antialiasing to have nicer lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //Radius of the circle
        int radius = 50;
        //Position of the circle
        int startx = 100;
        int starty = 100;
        //Size of the rectangle
        int width = 70;
        int height = 100;
        //Positioning of the rectangle relative to the circle
        int rectshiftx = -10;
        int rectshifty = 10;
        //Translation of the rectangle and the circle to the right,
        //when one of the set-theoretic operations is carried out.
        int xshift = 140;
        //Union: add
        //Generate a circle and a rectangle.
        Ellipse2D.Double circle1 = circleDouble(startx,starty,radius);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(startx+rectshiftx,
                starty+rectshifty,
                width,
                height);
        //Change the circle and the rectangle into Area objects.
        Area c1 = new Area(circle1);
        Area r1 = new Area(rect1);
        //Compute their union.
        c1.add(r1);
        //Draw the union.
        //g2d.setPaint(Color.green);
        g2d.fill(c1);
        //Intersection
        //Generate a circle and a rectangle (shifted to the right).
        Ellipse2D.Double circle2 = circleDouble(startx+xshift,starty,radius);
        Rectangle2D.Double rect2 = new Rectangle2D.Double(startx+rectshiftx+xshift,
                starty+rectshifty,
                width,
                height);
        //Change the circle and the rectangle into Area objects.
        Area c2 = new Area(circle2);
        Area r2 = new Area(rect2);
        //Compute their intersection.
        c2.intersect(r2);
        //Draw the intersection.
        //g2d.setPaint(Color.red);
        g2d.fill(c2);
        //Difference
        //Generate a circle and a rectangle (shifted to the right).
        Ellipse2D.Double circle3 = circleDouble(startx+2*xshift,starty,radius);
        Rectangle2D.Double rect3 = new Rectangle2D.Double(startx+rectshiftx+2*xshift,
                starty+rectshifty,
                width,
                height);
        //Change the circle and the rectangle into Area objects.
        Area c3 = new Area(circle3);
        Area r3 = new Area(rect3);
        //Compute their difference.
        c3.subtract(r3);
        //Draw the difference.
        //g2d.setPaint(Color.blue);
        g2d.fill(c3);
        //Symmetric difference: XOR
        //Generate a circle and a rectangle (shifted to the right).
        Ellipse2D.Double circle4 = circleDouble(startx+3*xshift,starty,radius);
        Rectangle2D.Double rect4 = new Rectangle2D.Double(startx+rectshiftx+3*xshift,
                starty+rectshifty,
                width,
                height);
        //Change the circle and the rectangle into Area objects.
        Area c4 = new Area(circle4);
        Area r4 = new Area(rect4);
        //Compute their symmetric difference.
        c4.exclusiveOr(r4);
        //Draw their symmetric difference.
        //g2d.setPaint(Color.yellow);
        g2d.fill(c4);
    }



    /**
    * Erzeugt einen Kreis mit Radius radius und Mittelpunkt (x,y).
    *
    * @param x        x-Koordinate des Kreismittelpunktes
    * @param y        y-Koordinate des Kreismittelpunktes
    * @param radius   Der Radius des Kreises
    *
    * @return         Kreis mit Radius radius und Mittelpunkt (x,y)
    */
    public Ellipse2D.Double circleDouble(double x, double y, double radius)
    {
        return(new Ellipse2D.Double(x-radius,y-radius,2*radius,2*radius));
    }




    public static void main(String[] argv)
    {
        AreaExample f = new AreaExample();
        f.setTitle("Operations for combining areas");
        f.setSize(600,250);
        f.setVisible(true);
    }

}

