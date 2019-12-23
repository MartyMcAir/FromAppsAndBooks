import java.awt.*;
import java.awt.geom.*;

/**
* Der Buchstabe D wird mittels eines GeneralPath erzeugt und die verwendeten
* Kontrollpunkte gezeichnet.
*
* @author Frank Klawonn
* Letzte Aenderung 01.02.2005
*/
public class SimpleLetterCColour extends Frame
{

    //Konstruktor
    public SimpleLetterCColour()
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
        int xc1 =  50;
        int yc1 = 250;
        int xc2 = 250;
        int yc2 =  50;
        int xc3 =  50;
        int yc3 =  50;
        int xc4 =  250;
        int yc4 =  450;
        int xc5 =  50;
        int yc5 = 450;
        //Definition und Zeichnen der beiden Kurven, die den Buchstaben definieren
        QuadCurve2D.Double d1 = new QuadCurve2D.Double(xc1,yc1,xc3,yc3,xc2,yc2);
        g2d.draw(d1);
        QuadCurve2D.Double d2 = new QuadCurve2D.Double(xc1,yc1,xc5,yc5,xc4,yc4);
        g2d.draw(d2);
        //Zeichnen der Kontrollpunkte in unterschiedlichen Farben
        g2d.setPaint(Color.blue);
        drawSmallRect(xc1,yc1,g2d);
        g2d.setPaint(Color.green);
        drawSmallRect(xc2,yc2,g2d);
        g2d.setPaint(Color.magenta);
        drawSmallRect(xc3,yc3,g2d);
        g2d.setPaint(Color.red);
        drawSmallRect(xc4,yc4,g2d);
        g2d.setPaint(Color.yellow);
        drawSmallRect(xc5,yc5,g2d);
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
        SimpleLetterCColour f = new SimpleLetterCColour();
        f.setTitle("Der Buchstabe C");
        f.setSize(420,500);
        f.setVisible(true);
    }


}

