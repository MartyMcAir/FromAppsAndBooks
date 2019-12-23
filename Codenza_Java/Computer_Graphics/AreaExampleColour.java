import java.awt.*;
import java.awt.geom.*;

/**
* Diese Klasse veranschaulicht Vereinigung, Durchschnitt, Differenz und
* symmetrische Differenz von Shapes.
* Die Operationen werden auf einen und ein Rechteck angewendet.
*
* @author Frank Klawonn
* Letzte Aenderung 07.01.2005
*/
public class AreaExampleColour extends Frame
{
    //Konstruktor
    AreaExampleColour()
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
        //Radius des Kreises
        int radius = 50;
        //Positionierung des ersten Kreises
        int startx = 100;
        int starty = 100;
        //Groesse des Rechtecks
        int width = 70;
        int height = 100;
        //Positionierung des ersten Rechtecks relativ zum Kreis
        int rectshiftx = -10;
        int rectshifty = 10;
        //Verschiebung des Rechtecks und des Kreises nach rechts,
        //wenn eine der vier Kombinationsoperationen ausgefuehrt wird.
        int xshift = 140;
        //Vereinigungen: add
        //Erzeuge Kreis und Rechteck.
        Ellipse2D.Double circle1 = circleDouble(startx,starty,radius);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(startx+rectshiftx,
                starty+rectshifty,
                width,
                height);
        //Wandle Kreis und Rechteck in Area-Objekte um.
        Area c1 = new Area(circle1);
        Area r1 = new Area(rect1);
        //Berechnung der Vereinigung
        c1.add(r1);
        //Zeichnen der Vereinigung
        g2d.setPaint(Color.green);
        g2d.fill(c1);
        //Durchschnitt: intersect
        //Erzeuge Kreis und Rechteck (nach rechts verschoben)
        Ellipse2D.Double circle2 = circleDouble(startx+xshift,starty,radius);
        Rectangle2D.Double rect2 = new Rectangle2D.Double(startx+rectshiftx+xshift,
                starty+rectshifty,
                width,
                height);
        //Wandle Kreis und Rechteck in Area-Objekte um.
        Area c2 = new Area(circle2);
        Area r2 = new Area(rect2);
        //Berechnung des Durchschnitts
        c2.intersect(r2);
        //Zeichnen des Durchschnitts
        g2d.setPaint(Color.red);
        g2d.fill(c2);
        //Differenz: subtract
        //Erzeuge Kreis und Rechteck (nach rechts verschoben)
        Ellipse2D.Double circle3 = circleDouble(startx+2*xshift,starty,radius);
        Rectangle2D.Double rect3 = new Rectangle2D.Double(startx+rectshiftx+2*xshift,
                starty+rectshifty,
                width,
                height);
        //Wandle Kreis und Rechteck in Area-Objekte um.
        Area c3 = new Area(circle3);
        Area r3 = new Area(rect3);
        //Berechnung der Differenz
        c3.subtract(r3);
        //Zeichnen der Differenz
        g2d.setPaint(Color.blue);
        g2d.fill(c3);
        //symmetrische Differenz: XOR
        //Erzeuge Kreis und Rechteck (nach rechts verschoben)
        Ellipse2D.Double circle4 = circleDouble(startx+3*xshift,starty,radius);
        Rectangle2D.Double rect4 = new Rectangle2D.Double(startx+rectshiftx+3*xshift,
                starty+rectshifty,
                width,
                height);
        //Wandle Kreis und Rechteck in Area-Objekte um.
        Area c4 = new Area(circle4);
        Area r4 = new Area(rect4);
        //Berechnung der symmetrischen Differenz
        c4.exclusiveOr(r4);
        //Zeichnen der Differenz
        g2d.setPaint(Color.yellow);
        g2d.fill(c4);
    }



    /**
    * Erzeugt einen Kreis mit Radius radius und Mittelpunkt (x,y).
    *
    * @param x        x-Koordinate des Kreismittelpunktes
    * @param y        y-Koordinate des Kreismittelpunktes
    * @param radius   Der Radius des Kreises
    *
    * @return         Kreis mit Radius radius und Mittelpunkt (x,y)
    */
    public Ellipse2D.Double circleDouble(double x, double y, double radius)
    {
        return(new Ellipse2D.Double(x-radius,y-radius,2*radius,2*radius));
    }




    public static void main(String[] argv)
    {
        AreaExampleColour f = new AreaExampleColour();
        f.setTitle("Kombination von Flaechen");
        f.setSize(600,250);
        f.setVisible(true);
    }

}

