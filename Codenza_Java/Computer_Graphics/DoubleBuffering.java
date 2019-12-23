import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.util.Date;


/* A simple demonstration for the use of double buffering on the basis of the
   earlier geometric transforms example. In addition to the rotating and
   changing rectangle, we have a static blue ellipse in the background.
*/
public class DoubleBuffering extends Frame
{

    //This buffered image will contain the background that remains unchanged.
    //Note that the package java.awt.image.* is needed.
    private BufferedImage theBackground;

    //On this buffered image we will first paint the background and then
    //the moving shape (the rectangle). Finally we draw this image on the
    //actual screen.
    private BufferedImage theImage;
    private Graphics2D g2dBackground;
    private Graphics2D g2dImage;




    public DoubleBuffering()
    {
        addWindowListener(new MyFinishWindow());
        initialiseTheBackgroundAndTheImage();
    }



    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        int xul, yul, xwidth, yheight;
        xul = 200;  //x-coordinate of the upper left corner of the rectangle
        yul = 300;  //y-coordinate of the upper left corner of the rectangle
        xwidth = 100; //width of the rectangle
        yheight = 20; //height of the rectangle
        //midpoint of the rectangle
        double xmid = xul+xwidth/2.0;
        double ymid = yul+yheight/2.0;
        //stretching/shrinking factors
        double xstretch = 1.005;
        double ystretch = 0.995;
        //number of (rotation/stretching) steps to be carried out
        int steps = 360;
        //this shape will contain the transformed rectangle
        Shape s;
        //create the rectangle
        Rectangle2D.Double rect = new Rectangle2D.Double(xul,yul,xwidth,yheight);
        AffineTransform id = new AffineTransform();
        AffineTransform rotateBy1Degree = new AffineTransform();
        rotateBy1Degree.rotate(Math.PI/180,xmid,ymid);
        //this transform will contain the accumulated rotation
        AffineTransform accRotation = new AffineTransform();
        AffineTransform stretch = scalingWRTXY(xmid,ymid,xstretch,ystretch);
        //this transform will contain the accumulated scaling
        AffineTransform accStretch = new AffineTransform();
        //draw the initial rectangle
        s = id.createTransformedShape(rect);
        //first draw the background on the buffered image
        g2dImage.drawImage(theBackground,0,0,null);
        //then draw the actual rectangle on the buffered image
        g2dImage.fill(s);
        //finally draw the buffered image on the screen
        g2d.drawImage(theImage,0,0,null);
        //wait for some time
        sustain(1000);
        for (int i=0; i<steps; i++)
            {
                accStretch.concatenate(stretch);
                //scale the rectangle
                s = accStretch.createTransformedShape(rect);
                accRotation.concatenate(rotateBy1Degree);
                //rotate the scaled rectangle
                s = accRotation.createTransformedShape(s);
                //wait some time
                sustain(100);
                //draw the background on the buffered image
                g2dImage.drawImage(theBackground,0,0,null);
                //draw the transformed rectangle on the buffered image
                g2dImage.fill(s);
                //draw the buffered image on the screen
                g2d.drawImage(theImage,0,0,null);
            }
    }




    public static void clearWindow(Graphics2D g)
    {
        g.setPaint(Color.white);
        g.fill(new Rectangle(0,0,600,600));
        g.setPaint(Color.black);
    }


    // returns a scaling by xs and ys w.r.t. to the centre point (x,y)
    public static AffineTransform scalingWRTXY(double x, double y, double xs, double ys)
    {
        AffineTransform at = new AffineTransform();
        at.translate(x,y);
        at.scale(xs,ys);
        at.translate(-x,-y);
        return(at);
    }


    //a simple method, suspending the process for t milliseconds
    public static void sustain(long t)
    {
        long finish = (new Date()).getTime() + t;
        while( (new Date()).getTime() < finish ) {}
    }



    //initialises the background and the buffered image
    private void initialiseTheBackgroundAndTheImage()
    {
        int w = 600;
        int h = 600;
        theImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        g2dImage = theImage.createGraphics();
        g2dImage.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        clearWindow(g2dImage);
        theBackground = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        g2dBackground = theBackground.createGraphics();
        g2dBackground.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        clearWindow(g2dBackground);
        //in order to have a simple constant background, we draw a blue oval
        g2dBackground.setPaint(Color.blue);
        g2dBackground.fillOval(50,200,200,250);
    }

}

