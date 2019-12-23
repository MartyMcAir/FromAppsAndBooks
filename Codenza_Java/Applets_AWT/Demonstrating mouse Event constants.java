Demonstrating mouse Event constants

import java.applet.Applet;
import java.awt.*;

public class MouseEvents extends Applet {
   private List eventList;

   public void init()
   {
      eventList = new List( 6, false );
      add( eventList );
   }

   public boolean handleEvent( Event e )
   {
      // determine which mouse event occured
      switch ( e.id ) {
         case Event.MOUSE_UP:
            eventList.addItem( "Mouse up" );
            return true;

         case Event.MOUSE_DOWN:
            eventList.addItem( "Mouse down" );
            return true;

         case Event.MOUSE_MOVE:
            showStatus( "Mouse move" );
            return true;

         case Event.MOUSE_ENTER:
            eventList.addItem( "Mouse enter");
            return true;

         case Event.MOUSE_EXIT:
            eventList.addItem( "Mouse exit" );
            return true;

         case Event.MOUSE_DRAG:
            showStatus( "Mouse drag" );
            return true;
      }

      // not one of our mouse events
      showStatus( "Not one of the mouse events!" );
      return true;  // done processing
   }
}
