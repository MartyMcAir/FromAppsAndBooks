import java.awt.*;
import java.awt.geom.*;


public class AreaExamples extends Frame
{

    AreaExamples()
    {
        addWindowListener(new MyFinishWindow());
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        int radius = 50;
        int startx = 100;
        int starty = 100;
        int rectshiftx = -10;
        int rectshifty = 10;
        int width = 70;
        int height = 100;
        int xshift = 250;
        int yshift = 250;
        //add
        Ellipse2D.Double circle1 = circleDouble(startx,starty,radius);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(startx+rectshiftx,
                starty+rectshifty,
                width,
                height);
        Area c1 = new Area(circle1);
        Area r1 = new Area(rect1);
        c1.add(r1);
        g2d.setPaint(Color.green);
        g2d.fill(c1);
        //intersect
        Ellipse2D.Double circle2 = circleDouble(startx+xshift,starty,radius);
        Rectangle2D.Double rect2 = new Rectangle2D.Double(startx+rectshiftx+xshift,
                starty+rectshifty,
                width,
                height);
        Area c2 = new Area(circle2);
        Area r2 = new Area(rect2);
        c2.intersect(r2);
        g2d.setPaint(Color.red);
        g2d.fill(c2);
        //subtract
        Ellipse2D.Double circle3 = circleDouble(startx,starty+yshift,radius);
        Rectangle2D.Double rect3 = new Rectangle2D.Double(startx+rectshiftx,
                starty+rectshifty+yshift,
                width,
                height);
        Area c3 = new Area(circle3);
        Area r3 = new Area(rect3);
        c3.subtract(r3);
        g2d.setPaint(Color.blue);
        g2d.fill(c3);
        //XOR
        Ellipse2D.Double circle4 = circleDouble(startx+xshift,starty+yshift,radius);
        Rectangle2D.Double rect4 = new Rectangle2D.Double(startx+rectshiftx+xshift,
                starty+rectshifty+yshift,
                width,
                height);
        Area c4 = new Area(circle4);
        Area r4 = new Area(rect4);
        c4.exclusiveOr(r4);
        g2d.setPaint(Color.yellow);
        g2d.fill(c4);
    }


    public Ellipse2D.Double circleDouble(double x, double y, double radius)
    {
        return(new Ellipse2D.Double(x-radius,y-radius,2*radius,2*radius));
    }


    public static void main(String[] argv)
    {
        AreaExamples f = new AreaExamples();
        f.setTitle("Area example");
        f.setSize(600,600);
        f.setVisible(true);
    }

}

