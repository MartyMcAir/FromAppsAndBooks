Draw or Delete lines from JPanel

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import javax.swing.*;

public class LineUnder extends JFrame
    {
     LinePanel linePanel = new LinePanel();
     LineUnder()
         {
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         initContentPane();
         pack();
         setLocationRelativeTo(null);
         setVisible(true);
     }
     private void initContentPane()
         {
         linePanel.line.setLine(0d, 0d, 300d, 300d);
         getContentPane().add(linePanel);
     }
    
     class LinePanel extends JPanel
         {
         Point lineStart = new Point(0, 0);
         Point lineEnd = new Point(0, 0);
         Line2D line = new Line2D.Double(lineStart, lineEnd);
         //width of line
         private Stroke stroke = new BasicStroke(2.0f);
         private LineListener lis = null;
         LinePanel()
             {
             super();
             addMouseListener(lis = new LineListener(this, line));
         }
         //draw and delete line
         public void paintComponent(Graphics g)
             {
             super.paintComponent(g);
             Graphics2D g2 = (Graphics2D) g;
             g2.setStroke(stroke);
             if (lis.deleteLine)
                 {
                 g2.setColor(getBackground());
                 lis.deleteLine = false;
             }
             else
             g2.setColor(Color.RED);
             //draw shape of line
             g2.draw(line);
         }
         //define panel's size
        
         public Dimension getPreferredSize()
             {
             return new Dimension(400, 350);
         }
     }
    
     class LineListener extends MouseAdapter
         {
         private Line2D line = null;
         private JComponent parent = null;
         boolean deleteLine = false;
         LineListener(JComponent parent, Line2D line)
             {
             this.parent = parent;
             this.line = line;
         }
         public void mouseClicked(MouseEvent e)
             {
             Point p = e.getPoint();
             //this does it!
             if (line.ptSegDist(p) == 0.0)
                 {
                 System.out.println("Hit!");
                 deleteLine = true;
             }
             else
             System.out.println("Point: " + p + "\nDistance: " + line.ptSegDist(p));
             parent.repaint();
         }
     }
    
     public static void main(String[] args)
         {
         new LineUnder();
     }
}
