import java.awt.*;
import java.awt.geom.*;

/**
* The letter D is defined by a GeneralPath and the letter and the
* control points are drawn.
*
* @author Frank Klawonn
* Last change 01.02.2005
*/
public class SimpleLetterD extends Frame
{

    //Constructor
    public SimpleLetterD()
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
        //The control points for defining the letter.
        int xd1 =  50;
        int yd1 =  50;
        int xd2 =  50;
        int yd2 = 450;
        int xd3 = 400;
        int yd3 = 250;
        int xd4 =  50;
        int yd4 = 450;
        int xd5 =  50;
        int yd5 = 250;
        //Definition and drawing of the two curves that define the letter.
        QuadCurve2D.Double d1 = new QuadCurve2D.Double(xd1,yd1,xd3,yd3,xd2,yd2);
        g2d.draw(d1);
        QuadCurve2D.Double d2 = new QuadCurve2D.Double(xd1,yd1,xd5,yd5,xd4,yd4);
        g2d.draw(d2);
        //Draw the control points.
        drawSmallRect(xd1,yd1,g2d);
        drawSmallRect(xd2,yd2,g2d);
        drawSmallRect(xd3,yd3,g2d);
        drawSmallRect(xd4,yd4,g2d);
        drawSmallRect(xd5,yd5,g2d);
        //Label the control points.
        g2d.setFont(new Font("serif",Font.PLAIN,24));
        g2d.drawString("P1",xd1+5,yd1);
        g2d.drawString("P2",xd2-40,yd2+10);
        g2d.drawString("P3",xd3-35,yd3+4);
        g2d.drawString("P4",xd4+20,yd4+10);
        g2d.drawString("P5",xd5+10,yd5+10);
    }


    /**
    * Draws a small square around the centre (x,y).
    *
    * @param x        x-coordinate of the centre
    * @param y        y-coordinate of the centre
    * @param g2d      Graphics2D object for drawing
    */
    public static void drawSmallRect(int x, int y, Graphics2D g2d)
    {
        Rectangle rect = new Rectangle(x-4,y-3,8,8);
        g2d.fill(rect);
    }


    public static void main(String[] argv)
    {
        SimpleLetterD f = new SimpleLetterD();
        f.setTitle("The letter D");
        f.setSize(420,500);
        f.setVisible(true);
    }


}

