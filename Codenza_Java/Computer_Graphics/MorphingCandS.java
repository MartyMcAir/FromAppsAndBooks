import java.awt.*;
import java.awt.geom.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.image.BufferedImage;

/**
* A simple example for transforming one triangulated image into another one.
* For the animation, the doube buffering technique is applied in the same way
* as in the clock example in the class DoubeBufferingClockExample.
*
* @author Frank Klawonn
* Last change 31.05.2005
*
* @see TriangulatedImage
* @see BufferImageDrawer
* @see DoubeBufferingClockExample
*/
public class MorphingCandS extends TimerTask
{

    //The window in which the transformation is shown.
    private BufferedImageDrawer buffid;

    //The two images to be transformed into each other will be scaled to
    //this size.
    private int width;
    private int height;

    //The number of steps (frames) for the transformation.
    private int steps;

    //The first triangulated image.
    private TriangulatedImage t1;

    //The second triangulated image.
    private TriangulatedImage t2;

    //This is used for generating/storing the intermediate images.
    private BufferedImage mix;

    //A variable which is increased stepwise from 0 to 1. It is needed
    //for the computation of the convex combinations.
    private double alpha;

    //The change of alpha in each step: deltAlpha = 1.0/steps
    private double deltaAlpha;


    /**
     * Constructor
     *
     * @param bid    The window in which the transformation is shown.
     */
    MorphingCandS(BufferedImageDrawer bid)
    {
        buffid = bid;
        width = 100;
        height = 150;
        steps = 100;
        deltaAlpha = 1.0/steps;
        alpha = 0;
        //This object is used for loading the two images.
        Image loadedImage;
        //Generating the first triangulated image:
        t1 = new TriangulatedImage();
        //Define the size.
        t1.bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //Generate the Graphics2D object.
        Graphics2D g2dt1 = t1.bi.createGraphics();
        //Load the image and draw it on the corresponding BufferedImage.
        loadedImage = new javax.swing.ImageIcon("image1.jpg").getImage();
        g2dt1.drawImage(loadedImage,0,0,null);
        //Definition of the points for the triangulation.
        t1.tPoints = new Point2D[9];
        t1.tPoints[0] = new Point2D.Double(0,0);
        t1.tPoints[1] = new Point2D.Double(0,110);
        t1.tPoints[2] = new Point2D.Double(0,150);
        t1.tPoints[3] = new Point2D.Double(50,150);
        t1.tPoints[4] = new Point2D.Double(100,150);
        t1.tPoints[5] = new Point2D.Double(100,110);
        t1.tPoints[6] = new Point2D.Double(100,0);
        t1.tPoints[7] = new Point2D.Double(50,0);
        t1.tPoints[8] = new Point2D.Double(50,110);
        //Definition of the triangles.
        t1.triangles = new int[8][3];
        for (int i=0; i<7; i++)
            {
                t1.triangles[i][0] = i;
                t1.triangles[i][1] = i+1;
                t1.triangles[i][2] = 8;
            }
        t1.triangles[7][0] = 7;
        t1.triangles[7][1] = 0;
        t1.triangles[7][2] = 8;
        //The same for the second image.
        t2 = new TriangulatedImage();
        t2.bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dt2 = t2.bi.createGraphics();
        loadedImage = new javax.swing.ImageIcon("image2.jpg").getImage();
        g2dt2.drawImage(loadedImage,0,0,null);
        t2.tPoints = new Point2D[9];
        t2.tPoints[0] = new Point2D.Double(0,0);
        t2.tPoints[1] = new Point2D.Double(0,40);
        t2.tPoints[2] = new Point2D.Double(0,150);
        t2.tPoints[3] = new Point2D.Double(55,150);
        t2.tPoints[4] = new Point2D.Double(100,150);
        t2.tPoints[5] = new Point2D.Double(100,40);
        t2.tPoints[6] = new Point2D.Double(100,0);
        t2.tPoints[7] = new Point2D.Double(55,0);
        t2.tPoints[8] = new Point2D.Double(55,40);
        //The indexing for the triangles must be the same as in the
        //the first image.
        t2.triangles = t1.triangles;
    }


    //This method is called in regular intervals. This method computes
    //the updated image/frame and calls the repaint method to draw the
    //updated image on the window.
    public void run()
    {
        //Since this method is called arbitrarily often, interpolation must only
        //be carred out while alpha is between 0 and 1.
        if (alpha>=0 && alpha<=1)
            {
                //Generate the interpolated image.
                mix = t1.mixWith(t2,alpha);
                //Draw the interpolated image on the BufferedImage.
                buffid.g2dbi.drawImage(mix,50,50,null);
                //Call the method for updating the window.
                buffid.repaint();
            }
        //Increment alpha.
        alpha = alpha+deltaAlpha;
    }


    public static void main(String[] argv)
    {
        //Width of the window.
        int width = 200;
        //Height of the window.
        int height = 250;
        //Specifies (in milliseconds) when the frame should be updated.
        int delay = 50;
        //The BufferedImage to be drawn in the window.
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //The window in which everything is drawn.
        BufferedImageDrawer bid = new BufferedImageDrawer(bi,width,height);
        bid.setTitle("Transforming shape and colour");
        //The TimerTask in which the repeated computations for drawing take place.
        MorphingCandS mcs = new MorphingCandS(bid);
        Timer t = new Timer();
        t.scheduleAtFixedRate(mcs,0,delay);
    }

}

