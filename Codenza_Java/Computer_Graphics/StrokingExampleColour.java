import java.awt.*;


/**
* Beispiel fuer unterschiedliche Strichelungsmuster
*
* @author Frank Klawonn
* Letzte Aenderung 01.05.2005
*/
public class StrokingExampleColour extends Frame
{
    private int windowHeight;

    /**
    * Konstruktor
    */
    StrokingExampleColour()
    {
        //Ermoeglicht das Schliessen des Fensters
        addWindowListener(new MyFinishWindow());
    }


    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //Zeichnen einer Linie der Dicke 3 (Pixel)
        BasicStroke bsThickLine = new BasicStroke(3.0f);
        g2d.setStroke(bsThickLine);
        g2d.drawLine(30,50,30,250);
        //Array zur Beschreibung der unterschiedlichen Strichelungsmuster
        float[] dashPattern;
        //Offset, bei dem das Strichelungsmuster beginnt
        float dashPhase = 0.0f;
        //Ein Strichelungsmuster mit Luecken konstanter Laenge (6 Pixel)
        //zwischen den Einzelstrichen und Strichen, die sich, beginnend bei der
        //Laenge 4, jeweils um 2 verlaengern bis zu einer Maximallaenge von 12
        dashPattern = new float[10];
        dashPattern[0] = 4.0f;
        dashPattern[1] = 5.0f;
        dashPattern[2] = 8.0f;
        dashPattern[3] = 5.0f;
        dashPattern[4] = 12.0f;
        dashPattern[5] = 5.0f;
        dashPattern[6] = 16.0f;
        dashPattern[7] = 5.0f;
        dashPattern[8] = 20.0f;
        dashPattern[9] = 5.0f;
        //Definition des entsprechenden BasicStroke
        BasicStroke bsIncreasing = new BasicStroke(3.0f,BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_BEVEL,2.0f,
                dashPattern,dashPhase);
        g2d.setStroke(bsIncreasing);
        //Zeichnen einer entsprechenden Linie in Blau
        g2d.setPaint(Color.blue);
        g2d.drawLine(60,50,60,250);
        //Ein einfaches Strichelungsmuster mit Strichen der Laenge 20 und
        //Luecken der Laenge 10
        dashPattern = new float[2];
        dashPattern[0] = 20;
        dashPattern[1] = 10;
        //Definition des entsprechenden BasicStroke
        BasicStroke bsDashed = new BasicStroke(3.0f,BasicStroke.CAP_BUTT,
                                               BasicStroke.JOIN_BEVEL,2.0f,
                                               dashPattern,dashPhase);
        g2d.setStroke(bsDashed);
        //Zeichnen einer entsprechenden (vertikalen) Linie in Rot
        g2d.setPaint(Color.red);
        g2d.drawLine(120,50,120,250);
        //Zeichnen einer entsprechenden (diagonalen) Linie in Gruen
        g2d.setPaint(Color.green);
        g2d.drawLine(150,50,350,250);
        //Verwendung des gleichen, einfachen Strichelungsmuster mit einem
        //Offset von 10
        dashPhase = 10.0f;
        //Definition des entsprechenden BasicStroke
        BasicStroke bsDashedShifted = new BasicStroke(3.0f,BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_BEVEL,2.0f,
                dashPattern,dashPhase);
        //Zeichnen einer entsprechenden Linie in Gelb
        g2d.setStroke(bsDashedShifted);
        g2d.setPaint(Color.yellow);
        g2d.drawLine(90,50,90,250);
    }





    public static void main(String[] argv)
    {
        StrokingExampleColour f = new StrokingExampleColour();
        f.setTitle("Gestrichelte Linien");
        f.setSize(400,300);
        f.setVisible(true);
    }
}

