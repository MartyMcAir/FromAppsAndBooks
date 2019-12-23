Demonstrating method mouseDrag

import java.applet.Applet;
import java.awt.*;

public class Drag extends Applet {
   private int xValue, yValue;
   private boolean firstTime;

   public void init()
   {
      // first running of program
      firstTime = true;
   }

   public void paint( Graphics g )
   {
      // do not draw the first time
      if ( !firstTime )
         g.fillOval( xValue, yValue, 4, 4 );
   }

   // override Component class update
   public void update( Graphics g )
   {
      // do not clear background
      // only call paint
      paint( g );  
   }                
       
   public boolean mouseDrag( Event e, int x, int y )
   {
      xValue = x; 
      yValue = y;

      // enable drawing
      firstTime = false;

      repaint();     // call repaint
      showStatus( "Event: mouseDrag" );

      return true;   // event handled
   }
}
