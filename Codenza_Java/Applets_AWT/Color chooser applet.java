Color chooser applet.html

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class ColorChooserApplet extends Applet implements AdjustmentListener {

   private float[] hsb = new float[3];   // For holding HSB color components.
   
   private int r = 0, g = 0, b = 0;      // The RGB color components.
   
   private Scrollbar hueScroll, brightnessScroll, saturationScroll,  // Scroll bars.
                     redScroll, greenScroll, blueScroll;
   
   private Label hueLabel, brightnessLabel, saturationLabel,  // Display component values.
                 redLabel, greenLabel, blueLabel;
                 
   private Canvas colorCanvas;  // Color patch for displaying the color.
                 
   public void init() {
   
       Color.RGBtoHSB(0,0,0,hsb);  // Get HSB equivalent of RGB = (0,0,0);
       
       /* Create Scrollbars with possible values from 0 to 255. */
       
       hueScroll = new Scrollbar(Scrollbar.HORIZONTAL, (int)(255*hsb[0]), 10, 0, 265);
       saturationScroll = new Scrollbar(Scrollbar.HORIZONTAL, (int)(255*hsb[1]), 10, 0, 265);
       brightnessScroll = new Scrollbar(Scrollbar.HORIZONTAL, (int)(255*hsb[2]), 10, 0, 265);
       redScroll = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
       greenScroll = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
       blueScroll = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 265);
       
       /* Create Labels showing current RGB and HSB values. */
       
       hueLabel = new Label(" H = " + hsb[0]);
       saturationLabel = new Label(" S = " + hsb[1]);
       brightnessLabel = new Label(" B = " + hsb[2]);
       redLabel = new Label(" R = 0");
       greenLabel = new Label(" G = 0");
       blueLabel = new Label(" B = 0");
       
       /* Set background colors for Scrollbars and Labels, so they don't
          inherit the gray background of the applet. */
       
       hueScroll.setBackground(Color.lightGray);
       saturationScroll.setBackground(Color.lightGray);
       brightnessScroll.setBackground(Color.lightGray);
       redScroll.setBackground(Color.lightGray);
       greenScroll.setBackground(Color.lightGray);
       blueScroll.setBackground(Color.lightGray);
       
       hueLabel.setBackground(Color.white);
       saturationLabel.setBackground(Color.white);
       brightnessLabel.setBackground(Color.white);
       redLabel.setBackground(Color.white);
       greenLabel.setBackground(Color.white);
       blueLabel.setBackground(Color.white);
       
       /* Set the applet to listen for changes to the Scrollbars' values */
       
       hueScroll.addAdjustmentListener(this);
       saturationScroll.addAdjustmentListener(this);
       brightnessScroll.addAdjustmentListener(this);
       redScroll.addAdjustmentListener(this);
       greenScroll.addAdjustmentListener(this);
       blueScroll.addAdjustmentListener(this);
       
       /* Create a canvas whose background color will always be set to the
          currently selected color. */
       
       colorCanvas = new Canvas();
       colorCanvas.setBackground(Color.black);
       
       /* Create the applet format, which consists of a row of
          three equal-sized regions holding the Scrollbars,
          the Labels, and the color patch.  The background color
          of the applet is gray, which will show around the edges
          and between components. */
       
       setLayout(new GridLayout(1,3,3,3));
       setBackground(Color.gray);
       Panel scrolls = new Panel();
       Panel labels = new Panel();
       add(scrolls);
       add(labels);
       add(colorCanvas);
       
       /* Add the Scrollbars and the Labels to their respective panels. */
       
       scrolls.setLayout(new GridLayout(6,1,2,2));
       scrolls.add(redScroll);
       scrolls.add(greenScroll);
       scrolls.add(blueScroll);
       scrolls.add(hueScroll);
       scrolls.add(saturationScroll);
       scrolls.add(brightnessScroll);
       
       labels.setLayout(new GridLayout(6,1,2,2));
       labels.add(redLabel);
       labels.add(greenLabel);
       labels.add(blueLabel);
       labels.add(hueLabel);
       labels.add(saturationLabel);
       labels.add(brightnessLabel);
       
   } // end init();
   

   public void adjustmentValueChanged(AdjustmentEvent evt) {
           // This is called when the user has changed the values on
           // one of the scrollbars.  All the scrollbars and labels
           // and the color patch are reset to correspond to the new color.
       int r1, g1, b1;
       r1 = redScroll.getValue();
       g1 = greenScroll.getValue();
       b1 = blueScroll.getValue();
       if (r != r1 || g != g1 || b != b1) {  // One of the RGB components has changed.
          r = r1;
          g = g1;
          b = b1;
          Color.RGBtoHSB(r,g,b,hsb);
       }
       else {  // One of the HSB components has changed.
           hsb[0] = hueScroll.getValue()/255.0F;
           hsb[1] = saturationScroll.getValue()/255.0F;
           hsb[2] = brightnessScroll.getValue()/255.0F;
           int rgb = Color.HSBtoRGB(hsb[0],hsb[1],hsb[2]);
           r = (rgb >> 16) & 0xFF;
           g = (rgb >> 8) & 0xFF;
           b = rgb & 0xFF;
       }
       redLabel.setText(" R = " + r);
       greenLabel.setText(" G = " + g);
       blueLabel.setText(" B = " + b);
       hueLabel.setText(" H = " + hsb[0]);
       saturationLabel.setText(" S = " + hsb[1]);
       brightnessLabel.setText(" B = " + hsb[2]);
       redScroll.setValue(r);
       greenScroll.setValue(g);
       blueScroll.setValue(b);
       hueScroll.setValue((int)(255*hsb[0]));
       saturationScroll.setValue((int)(255*hsb[1]));
       brightnessScroll.setValue((int)(255*hsb[2]));
       colorCanvas.setBackground(new Color(r,g,b));
       colorCanvas.repaint();  // Tell the system to redraw the canvas in its new color.
   } // end adjustmentValueChanged

   
   public Insets getInsets() {
          // The system calls this method to find out how much space to
          // leave between the edges of the applet and the components that
          // it contains.  I want a 3-pixel border at each edge.
      return new Insets(3,3,3,3);
   }
}  // end class ColorChooserApplet
