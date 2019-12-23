Demonstrating the null layout manager

import java.applet.Applet;
import java.awt.*;

public class NoLayout extends Applet {
   private Choice cb;
   private Button b1, b2, b3;
    
   public void init()
   {
      // do not use a layout manager
      setLayout( null );

      cb = new Choice();
      cb.addItem( "Item 1" );
      cb.addItem( "Item 2" );
      cb.addItem( "Item 3" );

      b1 = new Button( "Button" );
      b2 = new Button( "Another Button" );
      b3 = new Button( "Last Button" );

      add( cb );
      add( b1 );
      add( b2 );
      add( b3 );   

      b1.reshape( 15, 9, 60, 26 );
      b2.reshape( 100, 40, 90, 22 );
      b3.reshape( 220, 20, 70, 55);
      cb.reshape( 50, 80, 70, 17);       
   }
}
