import java.awt.*;
import java.awt.geom.*;

/**
* Der Buchstabe D wird mittels eines GeneralPath erzeugt und die verwendeten
* Kontrollpunkte gezeichnet.
*
* @author Frank Klawonn
* Letzte Aenderung 01.02.2005
*/
public class SimpleLetterDColour extends Frame
{

    //Konstruktor
    public SimpleLetterDColour()
    {
        //Ermoeglicht das Schliessen des Fensters
        addWindowListener(new MyFinishWindow());
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //Verwendung von Antialiasing, um die Raender weniger ausgefranst
        //erscheinen zu lassen
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //Die Linien sollen eine Dicke von 3.0 statt 1.0 haben.
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);
        //Die Kontrollpunkte, mit denen der Buchstabe definiert wird
        int xd1 =  50;
        int yd1 =  50;
        int xd2 =  50;
        int yd2 = 450;
        int xd3 = 400;
        int yd3 = 250;
        int xd4 =  50;
        int yd4 = 450;
        int xd5 =  50;
        int yd5 = 250;
        //Definition und Zeichnen der beiden Kurven, die den Buchstaben definieren
        QuadCurve2D.Double d1 = new QuadCurve2D.Double(xd1,yd1,xd3,yd3,xd2,yd2);
        g2d.draw(d1);
        QuadCurve2D.Double d2 = new QuadCurve2D.Double(xd1,yd1,xd5,yd5,xd4,yd4);
        g2d.draw(d2);
        //Zeichnen der Kontrollpunkte in unterschiedlichen Farben
        g2d.setPaint(Color.blue);
        drawSmallRect(xd1,yd1,g2d);
        g2d.setPaint(Color.green);
        drawSmallRect(xd2-3,yd2,g2d);
        g2d.setPaint(Color.magenta);
        drawSmallRect(xd3,yd3,g2d);
        g2d.setPaint(Color.red);
        drawSmallRect(xd4+3,yd4,g2d);
        g2d.setPaint(Color.yellow);
        drawSmallRect(xd5,yd5,g2d);
    }


    /**
    * Eine Methode zum Zeichnen eines kleinen Quadrats
    *
    * @param x        x-Koordinate der oberen linken Ecke des Quadrats
    * @param y        y-Koordinate der oberen linken Ecke des Quadrats
    * @param g2d      Graphics2D-Objekt, auf das gezeichnet werden soll.
    */
    public static void drawSmallRect(int x, int y, Graphics2D g2d)
    {
        Rectangle rect = new Rectangle(x-4,y-3,8,8);
        g2d.fill(rect);
    }


    public static void main(String[] argv)
    {
        SimpleLetterDColour f = new SimpleLetterDColour();
        f.setTitle("Der Buchstabe D");
        f.setSize(420,500);
        f.setVisible(true);
    }


}

