import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import com.sun.image.codec.jpeg.*;
import java.io.*;


/**
* Beispiel zum Speichern eines Bildes
*
* @author Frank Klawonn
* Letzte Aenderung 27.05.2005
*/

public class ImageSavingExample extends Frame
{

    //Hierauf wird das zu speichernde Bild gezeichnet
    private BufferedImage theImage;

    /**
    * Konstruktor
    */
    public ImageSavingExample()
    {
        //Ermoeglicht das Schliessen des Fensters
        addWindowListener(new MyFinishWindow());
        //Initialisiere das BufferedImage
        theImage = new BufferedImage(200,300,BufferedImage.TYPE_INT_RGB);
        //Erzeuge das zugehoerige Graphics2D-Objekt.
        Graphics2D g2dImage = theImage.createGraphics();
        //Das gewuenschte Bild wird gezeichnet.
        clearWindow(g2dImage);
        g2dImage.setPaint(Color.blue);
        g2dImage.draw(new Rectangle2D.Double(10,10,150,250));
        g2dImage.setPaint(Color.red);
        g2dImage.drawString("Ein Test",30,230);
        try
            {
                //Erzeugung eines file output streams.
                FileOutputStream fos = new FileOutputStream("test.jpg");
                //Erzeugung eines JPEGImageEncoder, der den file output stream verwendet.
                JPEGImageEncoder jie = JPEGCodec.createJPEGEncoder(fos);
                //Der JPEGImageEncoder schreibt das Bild auf den file output stream.
                jie.encode(theImage);
            }
        catch (Exception e)
            {
                System.out.println(e);
            }
    }



    //Hier wird das Bild noch einmal im Fenster zu Demonstrationszwecken
    //angezeigt. Zum Speichern des Bildes ist dies nicht erforderlich.
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(theImage,50,50,null);
    }



    public static void clearWindow(Graphics2D g)
    {
        g.setPaint(Color.white);
        g.fill(new Rectangle(0,0,600,600));
        g.setPaint(Color.black);
    }

    public static void main(String[] argv)
    {
        ImageSavingExample f = new ImageSavingExample();
        f.setTitle("Speichern eines Bildes");
        f.setSize(600,600);
        f.setVisible(true);
    }

}

