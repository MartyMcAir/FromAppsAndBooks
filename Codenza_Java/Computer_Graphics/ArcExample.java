import java.awt.*;
import java.awt.geom.*;

/**
* Examples for the variants of ellipse arcs are shown in this program.
*
* @author Frank Klawonn
* Last change 07.01.2005
*/
public class ArcExample extends Frame
{
    //Constructor
    ArcExample()
    {
        //Enables the closing of the window
        addWindowListener(new MyFinishWindow());
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //Use of antialiasing to have nicer lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //Draw the ellipse arcs a little bit thicker, the enclosing rectangles a little bit thinner.
        BasicStroke bsThin = new BasicStroke(2.0f);
        BasicStroke bsThick = new BasicStroke(3.0f);
        //The enclosing rectangle of the first ellipse
        Rectangle2D.Double rect1 = new Rectangle2D.Double(50,50,200,100);
        g2d.setStroke(bsThin);
        g2d.draw(rect1);
        //An ellipse arc
        Arc2D.Double arcOpen = new Arc2D.Double(rect1,45,90,Arc2D.OPEN);
        g2d.setStroke(bsThick);
        g2d.draw(arcOpen);
        //The enclosing rectangle of the second ellipse
        Rectangle2D.Double rect2 = new Rectangle2D.Double(300,50,200,100);
        g2d.setStroke(bsThin);
        g2d.draw(rect2);
        //A sector of an ellipse
        Arc2D.Double arcPie = new Arc2D.Double(rect2,45,90,Arc2D.PIE);
        g2d.setStroke(bsThick);
        g2d.draw(arcPie);
        //The enclosing rectangle of the third ellipse
        Rectangle2D.Double rect3 = new Rectangle2D.Double(550,50,200,100);
        g2d.setStroke(bsThin);
        g2d.draw(rect3);
        //A segment of an ellipse
        Arc2D.Double arcChord = new Arc2D.Double(rect3,45,90,Arc2D.CHORD);
        g2d.setStroke(bsThick);
        g2d.draw(arcChord);
    }



    public static void main(String[] argv)
    {
        ArcExample f = new ArcExample();
        f.setTitle("Ellipse arc, section and segment");
        f.setSize(800,200);
        f.setVisible(true);
    }
}

