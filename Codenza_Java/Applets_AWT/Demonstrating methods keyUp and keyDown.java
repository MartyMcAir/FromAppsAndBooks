Demonstrating methods keyUp and keyDown

import java.applet.Applet;
import java.awt.*;

public class Key extends Applet {
   private Font f;
   private String letter;
   private boolean first;

   public void init()
   {
      f = new Font( "Courier", Font.BOLD, 72 );
      first = true;
   }

   public void paint( Graphics g )
   {
      g.setFont( f );

      if ( !first )
         g.drawString( letter, 75, 70 );
   }

   public boolean keyDown( Event e, int key )
   {
      showStatus( "keyDown: the " + ( char ) key +
                  " was pressed." );

      letter = String.valueOf( ( char ) key );
      first = false;
      repaint();

      return true;   // event has been handled
   }

   public boolean keyUp( Event e, int key )
   {
      showStatus( "keyUp: the " + ( char ) key +
                  " was released." );

      return true;   // event has been handled
   }
}
