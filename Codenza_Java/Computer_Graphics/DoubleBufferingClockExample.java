import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.image.BufferedImage;

/**
* An example for the application of doube buffering.
* The example with the clock in the class NonSynchronizedClockExample
* is re-implemented using double buffering.
*
* @author Frank Klawonn
* Last change 27.05.2005
*
* @see NonSynchronizedClockExample
* @see BufferedImageDrawer
*/
public class DoubleBufferingClockExample extends TimerTask
{
    //The window in which everything is shown.
    private BufferedImageDrawer buffid;

    //The background image
    private BufferedImage bg;

    //Length/width of the clock frame
    private double frameSize;

    //Length of the second hand
    private double handLength;

    //Width of the second hand
    private double handWidth;

    //The frame of the clock centred in the origin
    private Rectangle2D.Double clockFrame;

    //Second hand, standing on the origin
    private Rectangle2D.Double clockHand;

    //This rotation specifies the angle of rotation for the second hand
    //in each step.
    private AffineTransform singleRotation;

    //The single step rotations are accumulated in this transformation.
    private AffineTransform accumulatedRotation;

    //This translation defines, how far the clock should move in
    //each single step.
    private AffineTransform singleTranslation;

    //The single translations are accumulated in this transformation.
    private AffineTransform accumulatedTranslation;

    //This transformation is to combine the single transformations
    //(rotation and translation) of the second hand.
    private AffineTransform handTransform;


    /**
    * Constructor
    *
    * @param bid          The buffered image to be drawn
    * @param backGround   The background (buffered) image
    * @param height       Width of the window
    * @param delay        Defines after how many milliseconds the image/frame is
    *                     is updated (needed for the synchronisation of the clock).
    */
    DoubleBufferingClockExample(BufferedImageDrawer bid, BufferedImage backGround,
                                int height,int delay)
    {
        buffid = bid;
        //The lines should have a thickness of 3.0 instead of 1.0.
        buffid.g2dbi.setStroke(new BasicStroke(3.0f));
        //Use of antialiasing to have nicer lines.
        buffid.g2dbi.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                      RenderingHints.VALUE_ANTIALIAS_ON);
        /*yUp defines a translation allowing the specification of objects in "real"
          coordinates where the y-axis points upwards and the origin of the coordinate
          system is located in the lower left corner of the window.
        */
        AffineTransform yUp = new AffineTransform();
        yUp.setToScale(1, -1);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(0, height);
        yUp.preConcatenate(translate);
        //Apply the transformation to the Graphics2D object to draw everything
        //in "real" coordinates.
        buffid.g2dbi.transform(yUp);
        buffid.g2dbi.setPaint(Color.black);
        bg = backGround;
        //Specification of the size parameters for drawing
        frameSize = 100;
        handLength = 40;
        handWidth = 5;
        clockFrame = new Rectangle2D.Double(-frameSize/2,-frameSize/2,
                                            frameSize,frameSize);
        clockHand = new Rectangle2D.Double(-handWidth/2,0,
                                           handWidth,handLength);
        singleRotation = new AffineTransform();
        singleRotation.setToRotation(-delay*Math.PI/30000);
        accumulatedRotation = new AffineTransform();
        singleTranslation = new AffineTransform();
        singleTranslation.setToTranslation(2,1);
        accumulatedTranslation = new AffineTransform();
        //In order to position the clock inside the window in the beginning
        //of the animation, the translation incorporates already a shift
        //to the right and upwards.
        accumulatedTranslation.setToTranslation(150,150);
        handTransform = new AffineTransform();
    }


    //This method is called in regular intervals. This method computes
    //the updated image/frame and calls the repaint method to draw the
    //updated image on the window.
    public void run()
    {
        //Accumulated transformation of the second hand: First rotate, then translate.
        handTransform.setTransform(accumulatedRotation);
        handTransform.preConcatenate(accumulatedTranslation);
        //Draw the background.
        buffid.g2dbi.drawImage(bg,0,0,null);
        //Draw the frame of the clock.
        buffid.g2dbi.draw(accumulatedTranslation.createTransformedShape(clockFrame));
        //Draw the second hand.
        buffid.g2dbi.fill(handTransform.createTransformedShape(clockHand));
        //This will update the image/frame in the window.
        buffid.repaint();
        //Computation of the accumulated translation of the clock.
        accumulatedTranslation.preConcatenate(singleTranslation);
        //Computation of the accumulated rotation of the second hand.
        accumulatedRotation.preConcatenate(singleRotation);
    }



    public static void main(String[] argv)
    {
        //Width of the window
        int width = 780;
        //Height of the window
        int height = 530;
        //Specifies (in milliseconds) when the frame should be updated.
        int delay = 50;
        //The BufferedImage to be drawn in the window.
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //The background.
        BufferedImage backGround = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dBackGround = backGround.createGraphics();
        //The lines should have a thickness of 3.0 instead of 1.0.
        g2dBackGround.setStroke(new BasicStroke(3.0f));
        //The background is painted white first.
        g2dBackGround.setPaint(Color.white);
        g2dBackGround.fill(new Rectangle(0,0,width,height));
        //This background rectangle serves as background (frame) for the whole image.
        Rectangle2D.Double windowFrame = new Rectangle2D.Double(50,50,
                width-100,
                height-100);
        g2dBackGround.setPaint(Color.black);
        g2dBackGround.draw(windowFrame);
        //The window in which everything is drawn.
        BufferedImageDrawer bid = new BufferedImageDrawer(bi,width,height);
        //The TimerTask in which the repeated computations drawing take place.
        DoubleBufferingClockExample dbce = new DoubleBufferingClockExample(bid,
                backGround,
                height,
                delay);
        Timer t = new Timer();
        t.scheduleAtFixedRate(dbce,0,delay);
    }


}


