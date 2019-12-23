Creating dynamic graphics (Stars)

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class Cells1 extends JFrame
    {
     private DPanel pan = new DPanel();
     private Network net = new Network(pan);
    
     public Cells1()
         {
         addWindowListener(new WindowAdapter()
             {
             public void windowClosing(WindowEvent ev)
                 {
                 dispose();
                 System.exit(0);
             }
         });
         setBounds(10,10,400,350);
         setContentPane(pan);
         setVisible(true);
     }
    
     public class DPanel extends JPanel
         {
         private Graphics2D g2f;
         private Color colors[] = new Color[]
             {
             Color.red,Color.black,Color.yellow,Color.blue,Color.green,Color.gray,Color.cyan,Color.cyan,Color.orange,Color.magenta
         };
         public DPanel()
             {
             setBackground(Color.white);
         }
         public void paintComponent(Graphics g)
             {
             super.paintComponent(g);
             g2f = (Graphics2D)g;
             Vector cells = net.getCells();
             for (int j=0; j < cells.size(); j++)
             draw((Cell_Info)cells.get(j));
            
             g2f = null;
         }
         public void draw(Cell_Info ci)
             {
             if (g2f == null)
             g2f = (Graphics2D)getGraphics();
            
             Point p = ci.getPoint();
             g2f.setColor(colors[ci.getAction()]);
             g2f.fillOval(p.x,p.y,8,8);
         }
     }
     public class Network extends Object
         {
         private Vector cells = new Vector();
         public Network(final DPanel pan)
             {
             cells.add(new Cell_Info(20,20));
             cells.add(new Cell_Info(50,120));
             cells.add(new Cell_Info(45,20));
             cells.add(new Cell_Info(90,55));
             cells.add(new Cell_Info(40,110));
             cells.add(new Cell_Info(35,80));
             cells.add(new Cell_Info(95,70));
             cells.add(new Cell_Info(24,40));
             cells.add(new Cell_Info(35,60));
             cells.add(new Cell_Info(80,100));
             cells.add(new Cell_Info(90,90));
             javax.swing.Timer ta = new javax.swing.Timer(200, new ActionListener()
                 {
                 public void actionPerformed(ActionEvent e)
                     {
                     int v = (int)(Math.random()*cells.size());
                     int c = (int)(Math.random()*10);
                     Cell_Info ci = (Cell_Info)cells.get(v);
                     ci.setAction(c);
                     pan.draw(ci);
                 }
             });
             ta.start();
         }
         public Vector getCells()
             {
             return(cells);
         }
     }
     public class Cell_Info extends Object
         {
         Point point;
         int activ = 0;
         public Cell_Info(int x, int y)
             {
             point = new Point(x,y);
         }
         public Point getPoint()
             {
             return(point);
         }
         public int getAction()
             {
             return(activ);
         }
         public void setAction(int a)
             {
             activ = a;
         }
     }
     public static void main (String[] args)
         {
         new Cells1();
     }
}
