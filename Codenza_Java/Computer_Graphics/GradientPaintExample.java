import java.awt.*;
import java.awt.geom.*;


/**
* An example for the use of GradientPaint (colour interpolation)
*
* @author Frank Klawonn
* Last change 27.05.2005
*/
public class GradientPaintExample extends Frame
{

    /**
    * Constructor
    */
    public GradientPaintExample()
    {
        //Enables the closing of the window.
        addWindowListener(new MyFinishWindow());
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //A square to be filled by colour interpolation without repetition.
        Rectangle2D.Double rect1 = new Rectangle2D.Double(50,50,300,300);
        //The two colours (red and green) for the gradient paint.
        Color c1 = new Color(1.0f,0.0f,0.0f);
        Color c2 = new Color(0.0f,1.0f,0.0f);
        //The gradient from red to green is parallel to the diagonal of the
        //square to be filled. The gradient does not start and end at the corners,
        //but inside the square. The colour gradient is not repeated so that the
        //the upper left part of the square is red and the lower right part is
        //green.
        GradientPaint gradPaint1 = new GradientPaint(150,150,c1,250,250,c2,false);
        g2d.setPaint(gradPaint1);
        g2d.fill(rect1);
        //A square to be filled by repeated colour interpolation.
        Rectangle2D.Double rect2 = new Rectangle2D.Double(400,50,300,300);
        //The colour gradient is defined in the same way as for the first square.
        //However, this time the colour gradient is applied repeatedly.
        GradientPaint gradPaint2 = new GradientPaint(500,150,c1,600,250,c2,true);
        g2d.setPaint(gradPaint2);
        g2d.fill(rect2);
    }

    public static void main(String[] argv)
    {
        GradientPaintExample f = new GradientPaintExample();
        f.setTitle("Colour gradient");
        f.setSize(800,500);
        f.setVisible(true);
    }

}

