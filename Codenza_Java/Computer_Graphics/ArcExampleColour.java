import java.awt.*;
import java.awt.geom.*;

/**
* Hier werden die verschiedenen Varianten von Ellipsenboegen demonstriert.
*
* @author Frank Klawonn
* Letzte Aenderung 07.01.2005
*/
public class ArcExampleColour extends Frame
{
    //Konstruktor
    ArcExampleColour()
    {
        //Ermoeglicht das Schliessen des Fensters
        addWindowListener(new MyFinishWindow());
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //Verwendung von Antialiasing, um die Kurven weniger ausgefranst
        //erscheinen zu lassen
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //Die Ellipsenboegen sollen etwas dicker gezeichnet werden,
        //die umschliessenden Hilfsrechtecke etwas duenner.
        BasicStroke bsThin = new BasicStroke(2.0f);
        BasicStroke bsThick = new BasicStroke(3.0f);
        //Das umschliessende Rechteck fuer die erste Ellipse
        Rectangle2D.Double rect1 = new Rectangle2D.Double(50,50,200,100);
        g2d.setPaint(Color.black);
        g2d.setStroke(bsThin);
        g2d.draw(rect1);
        //Ein Ellipsenbogen
        Arc2D.Double arcOpen = new Arc2D.Double(rect1,45,90,Arc2D.OPEN);
        g2d.setPaint(Color.red);
        g2d.setStroke(bsThick);
        g2d.draw(arcOpen);
        //Das umschliessende Rechteck fuer die zweite Ellipse
        Rectangle2D.Double rect2 = new Rectangle2D.Double(300,50,200,100);
        g2d.setPaint(Color.black);
        g2d.setStroke(bsThin);
        g2d.draw(rect2);
        //Ein Ellipsenausschnitt
        Arc2D.Double arcPie = new Arc2D.Double(rect2,45,90,Arc2D.PIE);
        g2d.setPaint(Color.green);
        g2d.setStroke(bsThick);
        g2d.draw(arcPie);
        //Das umschliessende Rechteck fuer die dritte Ellipse
        Rectangle2D.Double rect3 = new Rectangle2D.Double(550,50,200,100);
        g2d.setPaint(Color.black);
        g2d.setStroke(bsThin);
        g2d.draw(rect3);
        //Ein Ellipsenabschnitt
        Arc2D.Double arcChord = new Arc2D.Double(rect3,45,90,Arc2D.CHORD);
        g2d.setPaint(Color.blue);
        g2d.setStroke(bsThick);
        g2d.draw(arcChord);
    }



    public static void main(String[] argv)
    {
        ArcExampleColour f = new ArcExampleColour();
        f.setTitle("Ellipsenbogen, -aus- und -abschnitt");
        f.setSize(800,200);
        f.setVisible(true);
    }
}

