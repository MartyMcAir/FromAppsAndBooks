import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;


/**
* An example for using text within Java 2D.
*
* @author Frank Klawonn
* Last change 27.05.2005
*/


public class TextExample extends Frame
{
    /**
    * Constructor
    */
    TextExample()
    {
        //Enables the closing of the window.
        addWindowListener(new MyFinishWindow());
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //Drawing a text with a chosen font.
        Font f1 = new Font("Lucida Bright",Font.BOLD,20);
        g2d.setFont(f1);
        g2d.drawString("Font Lucida Bright in Fettschrift",50,100);
        //The letters of the following string will be transformed (rotated) individually.
        String s = "somersault";
        Font f2 = new Font("serif",Font.PLAIN,50);
        g2d.setFont(f2);
        FontRenderContext frc = g2d.getFontRenderContext();
        //Generate a GlyphVector.
        GlyphVector gv = f2.createGlyphVector(frc, s);
        int lengthOfS = gv.getNumGlyphs();
        //Each letter is rotated a little bit mor and shifted to the right.
        AffineTransform at = new AffineTransform();
        AffineTransform shift = new AffineTransform();
        shift.setToTranslation(100,300);
        Point2D p;
        Shape glyph;
        double theta;
        g2d.setPaint(Color.red);
        for (int i=0; i<lengthOfS; i++)
            {
                //Position of the letter.
                p = gv.getGlyphPosition(i);
                //Compute the rotation angle.
                theta = (2*Math.PI*i)/(lengthOfS-1);
                //Define the rotation.
                at.setToRotation(theta,p.getX(),p.getY());
                //The (accumulated) translation.
                shift.translate(10,0);
                //The accumulated translation and rotation.
                at.preConcatenate(shift);
                //Change the glyph into a Shape.
                glyph = gv.getGlyphOutline(i);
                //Transformation of the letter (as a Shape).
                glyph = at.createTransformedShape(glyph);
                //Draw the letter (the transformed Shape).
                g2d.fill(glyph);
            }
    }

    public static void main(String[] argv)
    {
        TextExample f = new TextExample();
        f.setTitle("Use of text and letters");
        f.setSize(600,600);
        f.setVisible(true);
    }

}

