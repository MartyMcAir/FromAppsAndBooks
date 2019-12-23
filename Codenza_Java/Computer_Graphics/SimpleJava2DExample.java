import java.awt.*;


/**
* This class shows how to use the Java 2D API in a very
* simple manner.
*
* @author Frank Klawonn
* Last change 07.01.2005
* @see MyFinishWindow
*/
public class SimpleJava2DExample extends Frame
{

    //Constructor
    SimpleJava2DExample()
    {
        //Enables the closing of the window.
        addWindowListener(new MyFinishWindow());
    }



    public void paint(Graphics g)
    {
        //In order to use Java 2D, it is necessary to cast the Graphics object
        //into a Graphics2D object.
        Graphics2D g2d = (Graphics2D) g;
        //Now all methods for drawing in the window should be applied to the Graphics2D
        //and not to the Graphics object any more.
        //Write the text "Hello world" at the window coordinates (30,50)
        g2d.drawString("Hello world!",30,50);
    }



    public static void main(String[] argv)
    {
        //Generate the window.
        SimpleJava2DExample f = new SimpleJava2DExample();
        //Define a title for the window.
        f.setTitle("The first Java 2D program");
        //Definition of the window size in pixels
        f.setSize(250,80);
        //Show the window on the screen.
        f.setVisible(true);
    }
}

