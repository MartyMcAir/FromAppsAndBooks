import java.awt.*;


/**
* Beispiel zum Laden eines JPEG-Bildes und Darstellung im Bildschirmfenster
*
* @author Frank Klawonn
* Letzte Aenderung 27.05.2005
*/
public class ImageLoadingExample extends Frame
{

    //Das zu ladende Bild wird zunaechst hier gespeichert.
    private Image theImage;


    /**
    * Konstruktor
    */
    public ImageLoadingExample()
    {
        //Ermoeglicht das Schliessen des Fensters
        addWindowListener(new MyFinishWindow());
        //Hier wird das JPEG-Bild in das Image geladen.
        theImage = new javax.swing.ImageIcon("image1.jpg").getImage();
    }



    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //Das Bild wird auf das Fenster gezeichnet.
        g2d.drawImage(theImage,50,50,null);
    }

    public static void main(String[] argv)
    {
        ImageLoadingExample f = new ImageLoadingExample();
        f.setTitle("Laden eines Bildes");
        f.setSize(600,600);
        f.setVisible(true);
    }

}

