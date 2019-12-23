import java.awt.*;
import java.awt.geom.*;

/**
* This class provides an example for drawing a line segment, a quadratic
* and a cubic curve. For illustration purposes, the initial, the end-
* and also control points are indicated by small squares.
* Furthermore, for the quadratic and cubic curve the tangents in the initial and the
* endpoint are also drawn.
*
* @author Frank Klawonn
* Last change 07.01.2005
*/
public class CurveDemo extends Frame
{
    //Constructor
    public CurveDemo()
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
        //Coordinates for the line segment
        int lx1 = 200;
        int ly1 = 200;
        int lx2 = 300;
        int ly2 = 300;
        //Generating and drawing the line segment
        Line2D.Double line = new Line2D.Double(lx1,ly1,lx2,ly2);
        g2d.draw(line);
        //Mark the initial point in blue.
        g2d.setPaint(Color.blue);
        drawSmallSquare(lx1,ly1,g2d);
        //Mark the endpoint in red.
        g2d.setPaint(Color.red);
        drawSmallSquare(lx2,ly2,g2d);
        //Coordinates for the quadratic curve
        int qcx1    = 300;
        int qcy1    =  50;
        int qcctrlx = 500;
        int qcctrly = 500;
        int qcx2    = 550;
        int qcy2    = 100;
        //Generate and draw the quadratic curve.
        QuadCurve2D.Double qc = new QuadCurve2D.Double(qcx1,qcy1,qcctrlx,qcctrly,
                qcx2,qcy2);
        g2d.setPaint(Color.black);
        g2d.draw(qc);
        //Mark the initial point in blue.
        g2d.setPaint(Color.blue);
        drawSmallSquare(qcx1,qcy1,g2d);
        //Draw the line connecting the initial point and the control point.
        g2d.drawLine(qcx1,qcy1,qcctrlx,qcctrly);
        //Mark the control point in green.
        g2d.setPaint(Color.green);
        drawSmallSquare(qcctrlx,qcctrly,g2d);
        //Mark the endpoint in red.
        g2d.setPaint(Color.red);
        drawSmallSquare(qcx2,qcy2,g2d);
        //Draw the line connecting the endpoint and the control point.
        g2d.drawLine(qcx2,qcy2,qcctrlx,qcctrly);
        //Coordinates for the cubic curve
        int ccx1 = 100;
        int ccy1 = 50;
        int ccctrlx1 = 150;
        int ccctrly1 = 100;
        int ccctrlx2 = 50;
        int ccctrly2 = 500;
        int ccx2 = 100;
        int ccy2 = 400;
        //Generate and draw the cubic curve.
        CubicCurve2D.Double cc = new CubicCurve2D.Double(ccx1,ccy1,
                ccctrlx1,ccctrly1,
                ccctrlx2,ccctrly2,
                ccx2,ccy2);
        g2d.setPaint(Color.black);
        g2d.draw(cc);
        //Mark the initial point in blue.
        g2d.setPaint(Color.blue);
        drawSmallSquare(ccx1,ccy1,g2d);
        //Draw the line connecting the initial point and the first control point.
        g2d.drawLine(ccx1,ccy1,ccctrlx1,ccctrly1);
        //Mark the first control point in green.
        g2d.setPaint(Color.green);
        drawSmallSquare(ccctrlx1,ccctrly1,g2d);
        //Mark the second control point in magenta.
        g2d.setPaint(Color.magenta);
        drawSmallSquare(ccctrlx2,ccctrly2,g2d);
        //Mark the endpoint in red.
        g2d.setPaint(Color.red);
        drawSmallSquare(ccx2,ccy2,g2d);
        //Draw the line connecting the end point and the control point.
        g2d.drawLine(ccctrlx2,ccctrly2,ccx2,ccy2);
    }


    /**
    * Draws a square with sides of length 4 around the centre (x,y).
    *
    * @param x        x-coordinate of the centre
    * @param y        y-coordinate of the centre
    * @param g2d      Graphics2D object for drawing
    */
    public static void drawSmallSquare(double x, double y, Graphics2D g2d)
    {
        Rectangle2D.Double rect = new Rectangle2D.Double(x-2,y-2,4,4);
        g2d.fill(rect);
    }



    public static void main(String[] argv)
    {
        CurveDemo f = new CurveDemo();
        f.setTitle("A cubic curve, a line segment and a quadratic curve");
        f.setSize(600,600);
        f.setVisible(true);
    }

}

