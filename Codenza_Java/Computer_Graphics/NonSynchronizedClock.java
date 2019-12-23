import java.awt.*;
import java.awt.geom.*;
import java.util.Date;


/**
* An example for an animation based on combined stepwise transformations.
* A square-shaped clock with a seconds hand moves over the window.
* The second hand turns, but not in seconds.
* This example does not use the double buffering technique, so that
* interrupting the program is difficult and flickering might occur.
*
* @author Frank Klawonn
* Last change 22.01.2005
*/
public class NonSynchronizedClock extends Frame
{

    private int windowWidth;
    private int windowHeight;

    /**
    * Constructor
    *
    * @param width   The width of the window.
    * @param height  The height of the window.
    */
    NonSynchronizedClock(int width, int height)
    {
        //Enables the closing of the window.
        addWindowListener(new MyFinishWindow());
        windowWidth = width;
        windowHeight = height;
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //The lines should have a thickness of 3.0 instead of 1.0.
        g2d.setStroke(new BasicStroke(3.0f));
        //Use of antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        /*yUp defines a translation allowing the specification of objects in "real"
          coordinates where the y-axis points upwards and the origin of the coordinate
          system is located in the lower left corner of the window.
        */
        AffineTransform yUp = new AffineTransform();
        yUp.setToScale(1,-1);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(0,windowHeight);
        yUp.preConcatenate(translate);
        //Apply the transformation to the Graphics2D object to draw everything
        //in "real" coordinates.
        g2d.transform(yUp);
        //This rectangle serves as a background, framing the whole scene.
        Rectangle2D.Double windowFrame = new Rectangle2D.Double(50,50,
                windowWidth-100,
                windowHeight-100);
        //Height and width of the clock.
        double frameSize = 100;
        //Length of the second hand.
        double handLength = 40;
        //Width of the second hand.
        double handWidth = 5;
        //Generate the frame of the clock in the centred around the origin.
        Rectangle2D.Double clockFrame = new Rectangle2D.Double(-frameSize/2,
                -frameSize/2,
                frameSize,
                frameSize);
        //Generate the second hand starting at the origin and pointing upwards
        //in the beginning.
        Rectangle2D.Double clockHand = new Rectangle2D.Double(-handWidth/2,
                0,
                handWidth,
                handLength);
        //This rotation specifies, how far the second hand should be turned
        //in each step.
        AffineTransform singleRotation = new AffineTransform();
        singleRotation.setToRotation(-Math.PI/180);
        //This transformation is for accumulating the single step rotations.
        AffineTransform accumulatedRotation = new AffineTransform();
        //This translation specifies, how far the clock should move
        //in each step.
        AffineTransform singleTranslation = new AffineTransform();
        singleTranslation.setToTranslation(2,1);
        //This transformation is for accumulating the single step translations.
        AffineTransform accumulatedTranslation = new AffineTransform();
        //In order to position the clock inside the window in the beginning
        //of the animation, the translation incorporates already a shift
        //to the right and upwards.
        accumulatedTranslation.setToTranslation(150,150);
        //Accumulated transformation of the second hand: First rotate, then translate.
        AffineTransform handTransform = new AffineTransform();
        //In this loop, the positions of the clock and the second hand
        //are updated and the updated image is drawn.
        for (int i=0; i<250; i++)
            {
                //Accumulated transformation of the second hand: First rotate, then translate.
                handTransform.setTransform(accumulatedRotation);
                handTransform.preConcatenate(accumulatedTranslation);
                //Clear the window.
                clearWindow(g2d);
                //Draw the background rectangle.
                g2d.draw(windowFrame);
                //Draw the frame of the clock.
                g2d.draw(accumulatedTranslation.createTransformedShape(clockFrame));
                //Draw the second hand.
                g2d.fill(handTransform.createTransformedShape(clockHand));
                //Computation of the accumulated translation of the clock.
                accumulatedTranslation.preConcatenate(singleTranslation);
                //Computation of the accumulated rotation of the second hand.
                accumulatedRotation.preConcatenate(singleRotation);
                //A short waiting time until the next frame is drawn.
                sustain(100);
            }
    }


    /**
    * A method for clearing a window (drawing all white) of windowWidth x windowHeight.
    *
    * @param g2d      Graphics2D object used for drawing.
    */
    public void clearWindow(Graphics2D g)
    {
        g.setPaint(Color.white);
        g.fill(new Rectangle(0,0,windowWidth,windowWidth));
        g.setPaint(Color.black);
    }


    /**
    * A method for a delay of t milliseconds.
    * This method is used here only to keep the program simple.
    * This method involves active waiting, consuming unnecessary processor capicity.
    * For real applications threads should be used.
    *
    * @param t      Waiting time in milliseconds.
    */
    public void sustain(long t)
    {
        long finish = (new Date()).getTime() + t;
        while( (new Date()).getTime() < finish ) {}
    }



    public static void main(String[] argv)
    {
        int width = 780;
        int height = 530;
        NonSynchronizedClock f = new NonSynchronizedClock(width,height);
        f.setTitle("Animation based on geometric transformations");
        f.setSize(width,height);
        f.setVisible(true);
    }


}


