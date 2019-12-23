import java.awt.*;
import java.awt.geom.*;

/**
* An example for the use of dash patterns.
*
* @author Frank Klawonn
* Last change 01.05.2005
*/
public class StrokingExample extends Frame
{
    private int windowHeight;

    /**
    *Constructor
    */
    StrokingExample()
    {
        //Enables the closing of the window.
        addWindowListener(new MyFinishWindow());
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //Draw a line with a thickness of 3 (pixels)
        BasicStroke bsThickLine = new BasicStroke(3.0f);
        g2d.setStroke(bsThickLine);
        g2d.drawLine(30,50,30,250);
        //Array for the description of a dash pattern.
        float[] dashPattern;
        //Offset where the dash pattern should start.
        float dashPhase = 0.0f;
        //A dash pattern with gaps of constant length (6 pixels) between the single
        //dashes. The dash length increases in steps of 2 from a minimum length of 4
        //to a maximium length of 12, then starting again with length 4.
        dashPattern = new float[10];
        dashPattern[0] = 4.0f;
        dashPattern[1] = 5.0f;
        dashPattern[2] = 8.0f;
        dashPattern[3] = 5.0f;
        dashPattern[4] = 12.0f;
        dashPattern[5] = 5.0f;
        dashPattern[6] = 16.0f;
        dashPattern[7] = 5.0f;
        dashPattern[8] = 20.0f;
        dashPattern[9] = 5.0f;
        //Definition of a corresponding BasicStroke.
        BasicStroke bsIncreasing = new BasicStroke(3.0f,BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_BEVEL,2.0f,
                dashPattern,dashPhase);
        g2d.setStroke(bsIncreasing);
        //Draw a line with this dash pattern.
        g2d.drawLine(60,50,60,250);
        //A simple dash pattern with dashes of length 20 and
        //gaps of length 10.
        dashPattern = new float[2];
        dashPattern[0] = 20;
        dashPattern[1] = 10;
        //Definition of a corresponding BasicStroke.
        BasicStroke bsDashed = new BasicStroke(3.0f,BasicStroke.CAP_BUTT,
                                               BasicStroke.JOIN_BEVEL,2.0f,
                                               dashPattern,dashPhase);
        g2d.setStroke(bsDashed);
        //Draw a (vertical) line with this dash pattern.
        g2d.drawLine(120,50,120,250);
        //Draw a (diagonalen) line with this dash pattern.
        g2d.drawLine(150,50,350,250);
        //Use the same dash pattern as before, but with an
        //offset of 10
        dashPhase = 10.0f;
        //Definition of a corresponding BasicStroke.
        BasicStroke bsDashedShifted = new BasicStroke(3.0f,BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_BEVEL,2.0f,
                dashPattern,dashPhase);
        //Draw a (vertical) line with this dash pattern.
        g2d.setStroke(bsDashedShifted);
        g2d.drawLine(90,50,90,250);
    }





    public static void main(String[] argv)
    {
        StrokingExample f = new StrokingExample();
        f.setTitle("Examples for dash patterns");
        f.setSize(400,300);
        f.setVisible(true);
    }
}

