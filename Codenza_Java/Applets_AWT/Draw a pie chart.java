Draw a pie chart

import java.util.*;
 import java.awt.*;
 import java.applet.Applet;

 public class Graph extends Applet {
  int    depth, radius;

 public void init() {
   float value;
   String at = getParameter("width");
   radius = (at != null) ?  Integer.valueOf(at).intValue() : 100;
   at = getParameter("depth");
   depth = (at != null) ? Integer.valueOf(at).intValue() : 20;
   at = getParameter("values");
   PieChartCanvas c = new PieChartCanvas(radius, depth);
   setLayout(new BorderLayout());

   // Create Hashtable to map color name (String) to Color type
   Hashtable colors = new Hashtable();
   colors.put("green", Color.green);
   colors.put("red", Color.red);
   colors.put("blue", Color.blue);
   colors.put("yellow", Color.yellow);
   colors.put("magenta", Color.magenta);
   colors.put("cyan", Color.cyan);
   colors.put("orange", Color.orange);
   colors.put("pink", Color.pink);
   colors.put("white", Color.white);
   colors.put("black", Color.black);

   // "value-color,value-color,..." 
   StringTokenizer t = new StringTokenizer(at, ","); 
   String s;
   int i;
   while (t.hasMoreTokens()) {
     s = t.nextToken();
     i = s.indexOf('-');
     value = Float.valueOf(s.substring(0, i)).floatValue();
     c.addSlice(value, (Color)colors.get(s.substring(i + 1)));
    }

   resize(c.getMinimumSize().width, c.getMinimumSize().height);
   add("Center", c);
   }
 }

 class PieChartCanvas extends Canvas {

   final double aspectFudge = 2.5;
   int radius, depth, called = 1, numSlices = 0;
   float total = 0, value[] = new float[10];
   Color color[] = new Color[10];
   Graphics offGraphics;
   Image gfxBuff;

   public PieChartCanvas(int radius, int depth) {
     this.value = value;
     this.color = color;
     this.radius = radius;
     this.depth = depth;
     }

   public void paint(Graphics g) {
     int startAngle;
     float angle;
     Dimension d = getSize();

     if(gfxBuff == null) {
       gfxBuff = createImage(d.width, d.height);
       offGraphics = gfxBuff.getGraphics();
       offGraphics.setColor(getBackground());
       offGraphics.fillRect(0, 0, d.width, d.height);
       }

     // do the 3d effect
     for(int x = depth; x >= 1; x--) {
       startAngle = -45;
       for(int i = 0; i < numSlices; i++) {
         offGraphics.setColor(color[i].darker());
         angle = Math.round(360 * (value[i] / total));
         offGraphics.fillArc(0, x, radius, (int)(radius / aspectFudge),
             startAngle, (int)angle);
             startAngle += angle;
         }
     }

     // draw the pie slice
     startAngle = -45;
     for(int i = 0; i < numSlices; i++) {
       offGraphics.setColor(color[i]);
       angle = Math.round(360 * (value[i] / total));
       offGraphics.fillArc(0, 0, radius, (int)(radius / aspectFudge),
          startAngle, (int)angle);
          startAngle += angle;
       }
     g.drawImage(gfxBuff, 0, 0, null);
     }

   public void addSlice(float value, Color color) {
     this.value[numSlices] = value;
     this.color[numSlices++] = color;
     total += value;
     }

   public Dimension getPreferredSize() {
     return getMinimumSize();
     }

   public Dimension getMinimumSize() {
     return new Dimension(radius, (int)((radius / aspectFudge) + depth));
     }
   }

 <APPLET CODE=Graph.class WIDTH=150 HEIGHT=150>
   <PARAM NAME="depth"  VALUE="30">
   <PARAM NAME="width"  VALUE="120">
   <PARAM NAME="values" VALUE="1-red,2-green,3-blue">
 </APPLET>
