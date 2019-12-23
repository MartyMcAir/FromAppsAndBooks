
/**
 * <p>�berschrift: GDV aufg1</p>
 * <p>Beschreibung: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Organisation: </p>
 * @author Vanessa Fischer, Nikolas Isensee (Gruppe 23)
 * @version 1.0
 */

import java.awt.*;
import java.awt.geom.*;
import javax.swing.JFrame;

public class CircleColouring
    extends JFrame
{
    public CircleColouring()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //Verwendung von Antialiasing, um die Raender weniger ausgefranst
        //erscheinen zu lassen
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        //Die Linien sollen eine Dicke von 1.5 statt 1.0 haben.
        BasicStroke bs = new BasicStroke(1.0f);
        g2d.setStroke(bs);
        //Rot {Anfangswert, Zielwert}
        int[] red =
        {
            172, 217
        };
        //Gr�n {Anfangswert, Zielwert}
        int[] green =
        {
            3, 219
        };
        //Blau {Anfangswert, Zielwert}
        int[] blue =
        {
            3, 17
        };
        //rgb-Matrix
        int steps = 1440; //Anzahl Morph-Schritte
        int[] re = new int[steps + 1];
        int[] gr = new int[steps + 1];
        int[] bl = new int[steps + 1];
        float alpha;
        float stepsDouble = steps;
        float x, y, x2, y2;
        int r = 100;
        double winkel = 0;
        x = (float) (r * Math.cos(winkel));
        x2 = x + 20;
        y = (float) (r * Math.sin(winkel));
        y2 = (y * x2) / x;
        Color color = new Color(red[0], green[0], blue[0]);
        GeneralPath gp = new GeneralPath();
        gp.moveTo(x, y);
        gp.lineTo(x2, y2);
        g2d.setColor(color);
        g2d.draw(gp);
        for (int i = 1; i <= steps; i++)
            {
                alpha = i / stepsDouble;
                winkel = winkel + 0.125;
                double winkel1 = winkel * Math.PI / 180;
                re[i] = (int) ( (1 - alpha) * red[0] + alpha * red[1]);
                gr[i] = (int) ( (1 - alpha) * green[0] + alpha * green[1]);
                bl[i] = (int) ( (1 - alpha) * blue[0] + alpha * blue[1]);
                Color c = new Color(re[i], gr[i], bl[i]);
                g2d.setColor(c);
                if (winkel <= 90)
                    {
                        x = (float) (Math.abs(r * Math.cos(winkel1))) + 150;
                        x2 = (float) (Math.abs( (r - 60) * Math.cos(winkel1))) + 150;
                        y = (float) (Math.abs(r * Math.sin(winkel1))) + 150;
                        y2 = (float) (Math.abs( (r - 60) * Math.sin(winkel1))) + 150;
                    }
                else
                    {
                        x = (float) ( -1 * (Math.abs(r * Math.cos(winkel1))) + 150);
                        x2 = (float) ( -1 * (Math.abs( (r - 60) * Math.cos(winkel1))) + 150);
                        y = (float) (Math.abs(r * Math.sin(winkel1))) + 150;
                        y2 = (float) (Math.abs( (r - 60) * Math.sin(winkel1))) + 150;
                    }
                GeneralPath gp1 = new GeneralPath();
                gp1.moveTo(x, y);
                gp1.lineTo(x2, y2);
                g2d.setColor(c);
                g2d.draw(gp1);
            }
    }

    public static void main(String[] args)
    {
        CircleColouring a3 = new CircleColouring();
        a3.setTitle("Farbkreis");
        a3.setSize(400, 400);
        a3.setVisible(true);
    }


}
