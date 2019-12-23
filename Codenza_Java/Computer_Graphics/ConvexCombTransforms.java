import java.awt.*;
import java.awt.geom.*;
import java.util.Date;

/**
* An example for an animation based on convex combinations of two
* geometric transformations. An ellipse in the upper left corner of
* the window is transformed stepwise into another ellipse
* in the lower right corner of the window.
*
* @author Frank Klawonn
* Last change 21.01.2005
*/
public class ConvexCombTransforms extends Frame
{

    //Constructor
    public ConvexCombTransforms()
    {
        //Enables the closing of the window.
        addWindowListener(new MyFinishWindow());
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //Use of antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        int xul, yul, xwidth, yheight;
        xul = 20;     //x-coordinate for the definition of a bounding recatangle
        //for an ellipse
        yul = 40;     //y-coordinate the definition of the rectangle
        xwidth = 50;  //Width of the rectangle
        yheight = 20; //Height of the rectangle
        //Generating an ellipse from the rectangle.
        //This ellipse is used to construct the initial and the final ellipse.
        Ellipse2D.Double elli = new Ellipse2D.Double(xul,yul,xwidth,yheight);
        //Midpoint of the ellipse/rectangle
        double xmid = xul+xwidth/2.0;
        double ymid = yul+yheight/2.0;
        //Transformation for constructing the initial ellipse.
        AffineTransform initialTransform = new AffineTransform();
        initialTransform.setToRotation(Math.PI/6,xmid,ymid);
        //The matrix for the transformation of the initial ellipse.
        //The matrix is needed for the computation of the convex combinations.
        double[] initialMatrix = new double[6];
        initialTransform.getMatrix(initialMatrix);
        //Transformation for constructing the final ellipse.
        AffineTransform finalTransform = new AffineTransform();
        finalTransform.setToTranslation(500,200);
        finalTransform.concatenate(scalingWRTXY(xmid,ymid,2,0.5));
        finalTransform.rotate(3*Math.PI/4,xmid,ymid);
        //The matrix for the transformation of the final ellipse.
        //The matrix is needed for the computation of the convex combinations.
        double[] finalMatrix = new double[6];
        finalTransform.getMatrix(finalMatrix);
        //Number of steps/images/frames for the transformation of the
        //initial into the final eellipse.
        int steps = 200;
        //The initial ellipse
        Shape initialElli = initialTransform.createTransformedShape(elli);
        //The final ellipse
        Shape finalElli = finalTransform.createTransformedShape(elli);
        //This shape is used for drawing the intermediate ellipses.
        Shape s;
        //This transformation is used for the convex combinations of the
        //initial and the final transformations.
        AffineTransform intermediateTransform;
        double stepsDouble = steps; //Number of steps as a Double-value in order
        //to avoid repeated casting in the loop.
        for (int i=0; i<=steps; i++)
            {
                //Computation of the i-th convex combination.
                intermediateTransform = new AffineTransform(
                    convexCombination(initialMatrix,finalMatrix,i/stepsDouble));
                //Generate the intermediate ellipse.
                s = intermediateTransform.createTransformedShape(elli);
                //Wait a little bit before the next image (frame) is drawn.
                sustain(50);
                //Clear the whole window.
                clearWindow(g2d);
                //Draw the intermediate ellipse.
                g2d.fill(s);
                //Draw the initial ellipse in green.
                g2d.setPaint(Color.green);
                g2d.fill(initialElli);
                //Draw the final ellipse in red.
                g2d.setPaint(Color.red);
                g2d.fill(finalElli);
            }
    }


    /**
    * Conmputes the convex combination of two vectors/points (given as Java-ArraysC).
    *
    * @param a       initial point
    * @param b       endpoint (must have the same length as the array a)
    * @param alpha   Proportion that the initial point contributes to the convex combination.
    *                soll. 0<=alpha<=1 must hold.
    *
    * @return        The convex combination (1-alpha)*a + alpha*b of the two points.
    */
    public static double[] convexCombination(double[] a, double[] b, double alpha)
    {
        double[] result = new double[a.length];
        for (int i=0; i<result.length; i++)
            {
                result[i] = (1-alpha)*a[i] + alpha*b[i];
            }
        return(result);
    }



    /**
    * A method for clearing a window (drawing all white) of fixed size (600x300).
    *
    * @param g2d      Graphics2D object used for drawing.
    */
    public static void clearWindow(Graphics2D g)
    {
        g.setPaint(Color.white);
        g.fill(new Rectangle(0,0,600,300));
        g.setPaint(Color.black);
    }


    /**
    * Computes a scaling with the scaling factors xs and ys
    * w.r.t. the point/centre (x,y).
    *
    * @param x       x-coordinate of the centre
    * @param y       y-coordinate of the centre
    * @param xs      scaling factor in x-direction
    * @param ys      scaling factor in y-direction
    *
    * @return        The corresponding scaling
    */
    public static AffineTransform scalingWRTXY(double x, double y,
            double xs, double ys)
    {
        AffineTransform at = new AffineTransform();
        at.translate(x,y);
        at.scale(xs,ys);
        at.translate(-x,-y);
        return(at);
    }


    /**
    * A method for a delay of t milliseconds.
    * This method is used here only to keep the program simple.
    * This method involves active waiting, consuming unnecessary processor capicity.
    * For real applications threads should be used.
    *
    * @param t      Waiting time in milliseconds
    */
    public static void sustain(long t)
    {
        long finish = (new Date()).getTime() + t;
        while( (new Date()).getTime() < finish ) {}
    }


    public static void main(String[] argv)
    {
        ConvexCombTransforms f = new ConvexCombTransforms();
        f.setTitle("Animation via convex combinations of transformations");
        f.setSize(600,300);
        f.setVisible(true);
    }

}

