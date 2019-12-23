import java.awt.*;
import java.awt.geom.*;

/**
* Examples for the use of different line endings and joins
* between lines.
*
* @author Frank Klawonn
* Last change 10.05.2005
*/
public class LineEndings extends Frame
{


    /**
    * Constructor
    */
    LineEndings()
    {
        //Enables the closing of the window.
        addWindowListener(new MyFinishWindow());
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //Use of antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //A polyline from (startx,starty) via (tipx,tipy) to (endx,endy) should be generated.
        int startx = 50;
        int starty = 100;
        int tipx = 150;
        int tipy = 250;
        int endx = 180;
        int endy = 100;
        //The polyline is defined as a GeneralPath.
        GeneralPath gp = new GeneralPath();
        gp.moveTo(startx,starty);
        gp.lineTo(tipx,tipy);
        gp.lineTo(endx,endy);
        //A BasicStroke is needed to modify the line endings and the
        //join at (tipx,tipy).
        BasicStroke bs;
        //The polyline should be drawn more than using variations of the
        //BasicStroke. offset specifies how much the next variant
        //of the polyline should be shifted to the right.
        int offSet = 180;
        int accumulatedOffset = 0;
        //This transformation shifts the polyline (even the whole
        //drawing object g2d to the right.
        AffineTransform translation = new AffineTransform();
        //In the first version the two line segments of the polyline are
        //drawn independently as single lines without taking  care of any
        //special kind of join.
        bs = new BasicStroke(30.0f);
        g2d.setStroke(bs);
        g2d.drawLine(startx,starty,tipx,tipy);
        g2d.drawLine(tipx,tipy,endx,endy);
        //Drawing the polyline using the default setting (except for the
        //exaggerated line thickness).
        accumulatedOffset = accumulatedOffset + offSet;
        translation.setToTranslation(accumulatedOffset,0);
        g2d.setTransform(translation);
        bs = new BasicStroke(30.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER);
        g2d.setStroke(bs);
        g2d.draw(gp);
        //Drawing the polyline with round endings and a cut-off join.
        accumulatedOffset = accumulatedOffset + offSet;
        translation.setToTranslation(accumulatedOffset,0);
        g2d.setTransform(translation);
        bs = new BasicStroke(30.0f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs);
        g2d.draw(gp);
        //Drawing the polyline with prolonged, cut-off endings and a round join.
        accumulatedOffset = accumulatedOffset + offSet;
        translation.setToTranslation(accumulatedOffset,0);
        g2d.setTransform(translation);
        bs = new BasicStroke(30.0f,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_ROUND);
        g2d.setStroke(bs);
        g2d.draw(gp);
    }




    public static void main(String[] argv)
    {
        LineEndings f = new LineEndings();
        f.setTitle("Line endings");
        f.setSize(800,350);
        f.setVisible(true);
    }


}


