import java.awt.*;
import java.awt.geom.*;

/**
* An example for a translation applied to a rectangle. The drawing is carried out
* w.r.t. standard coordinates, not w.r.t. window coordinates.
*
* @author Frank Klawonn
* Last change 07.01.2005
*/
public class TranslationExampleColour extends Frame
{
    private int windowHeight;

    /**
    * Constructor
    *
    * @param height  The window height.
    */
    TranslationExampleColour(int height)
    {
        //Enables the closing of the window.
        addWindowListener(new MyFinishWindow());
        windowHeight = height;
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        /*yUp defines a translation allowing the specification of objects in "real"
          coordinates where the y-axis points upwards and the origin of the coordinate
          system is located in the lower left corner of the window.
        */
        AffineTransform yUp = new AffineTransform();
        yUp.setToScale(1,-1);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(40,windowHeight-50);
        yUp.preConcatenate(translate);
        //Apply the transformation to the Graphics2D object to draw everything
        //in "real" coordinates.
        g2d.transform(yUp);
        //The lines should have a thickness of 3.0 instead of 1.0.
        g2d.setStroke(new BasicStroke(3.0f));
        //Generate and draw a rectangle which will be shifted later on.
        Rectangle2D.Double rect = new Rectangle2D.Double(20,20,100,60);
        g2d.draw(rect);
        //Define a translation.
        AffineTransform translation = new AffineTransform();
        translation.setToTranslation(140,80);
        //Zeichne das skalierte Rechteck in Rot.
        g2d.setPaint(Color.red);
        g2d.draw(translation.createTransformedShape(rect));
        g2d.setPaint(Color.black);
        g2d.setStroke(new BasicStroke(1.0f));
        //Einzeichnen des Koordinatensystems
        drawSimpleCoordinateSystem(280,180,g2d);
    }


    /**
    * Zeichnet ein Koordinatensystem.
    *
    * @param xmax     x-Koordinate, bis zu der die x-Achse reichen soll
    * @param ymax     y-Koordinate, bis zu der die y-Achse reichen soll
    * @param g2d      Graphics2D-Objekt, auf das gezeichnet werden soll.
    */
    public static void drawSimpleCoordinateSystem(int xmax, int ymax,
            Graphics2D g2d)
    {
        int xOffset = 0;
        int yOffset = 0;
        int step = 20;
        String s;
        //aktuellen Font merken
        Font fo = g2d.getFont();
        //einen kleinen Font einstellen
        int fontSize = 13;
        Font fontCoordSys = new Font("serif",Font.PLAIN,fontSize);
        /*
          Leider werden die Buchstaben durch die auf das Graphics2D-Objekt
          angewendete Transformation auf dem Kopf gezeichnt. Daher: Erzeugung
          eines Fonts, bei dem die Buchstaben auf dem Kopf stehen.
        */
        //Auf den Kopf stellen durch Spiegeln.
        AffineTransform flip = new AffineTransform();
        flip.setToScale(1,-1);
        //Wieder auf die Grundlinie zurueck verschieben.
        AffineTransform lift = new AffineTransform();
        lift.setToTranslation(0,fontSize);
        flip.preConcatenate(lift);
        //Font mit auf den Kopf gestellten Buchstaben erzeugen.
        Font fontUpsideDown = fontCoordSys.deriveFont(flip);
        g2d.setFont(fontUpsideDown);
        //x-Achse
        g2d.drawLine(xOffset,yOffset,xmax,yOffset);
        //Markierungen und Beschriftung der x-Achse
        for (int i=xOffset+step; i<=xmax; i=i+step)
            {
                g2d.drawLine(i,yOffset-2,i,yOffset+2);
                g2d.drawString(String.valueOf(i),i-7,yOffset-30);
            }
        //y-Achse
        g2d.drawLine(xOffset,yOffset,xOffset,ymax);
        //Markierungen und Beschriftung der y-Achse
        s="  "; //zum Einruecken der Zahlen < 100
        for (int i=yOffset+step; i<=ymax; i=i+step)
            {
                g2d.drawLine(xOffset-2,i,xOffset+2,i);
                if (i>99)
                    {
                        s="";
                    }
                g2d.drawString(s+String.valueOf(i),xOffset-25,i-20);
            }
        //Font zurueck setzen
        g2d.setFont(fo);
    }


    public static void main(String[] argv)
    {
        int height = 280;
        TranslationExampleColour f = new TranslationExampleColour(height);
        f.setTitle("Beispiel Translation");
        f.setSize(360,height);
        f.setVisible(true);
    }


}


