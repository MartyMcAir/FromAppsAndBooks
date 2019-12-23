import java.awt.*;
import java.awt.geom.*;

/**
* The letter C is defined by a GeneralPath and the letter and the
* control points are drawn.
*
* @author Frank Klawonn
* Last change 01.02.2005
*/
public class SimpleLetterC extends Frame
{

    //Constructor
    public SimpleLetterC()
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
        int xc1 =  50;
        int yc1 = 250;
        int xc2 = 250;
        int yc2 =  50;
        int xc3 =  50;
        int yc3 =  50;
        int xc4 =  250;
        int yc4 =  450;
        int xc5 =  50;
        int yc5 = 450;
        //Definition and drawing of the two curves that define the letter.
        QuadCurve2D.Double d1 = new QuadCurve2D.Double(xc1,yc1,xc3,yc3,xc2,yc2);
        g2d.draw(d1);
        QuadCurve2D.Double d2 = new QuadCurve2D.Double(xc1,yc1,xc5,yc5,xc4,yc4);
        g2d.draw(d2);
        //Draw the control points.
        drawSmallRect(xc1,yc1,g2d);
        drawSmallRect(xc2,yc2,g2d);
        drawSmallRect(xc3,yc3,g2d);
        drawSmallRect(xc4,yc4,g2d);
        drawSmallRect(xc5,yc5,g2d);
        //Label the control points.
        g2d.setFont(new Font("serif",Font.PLAIN,24));
        g2d.drawString("P1'",xc1+10,yc1+5);
        g2d.drawString("P2'",xc2+10,yc2+10);
        g2d.drawString("P3'",xc3-35,yc3+4);
        g2d.drawString("P4'",xc4+10,yc4+10);
        g2d.drawString("P5'",xc5+10,yc5+10);
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
        SimpleLetterC f = new SimpleLetterC();
        f.setTitle("The letter C");
        f.setSize(420,500);
        f.setVisible(true);
    }


}
