Demonstrating methods controlDown, metaDown and shiftDown

import java.applet.Applet;
import java.awt.*;

public class MetaShiftCtrl extends Applet {
   private TextField meta, shift, ctrl;

   public void init()
   {
      meta = new TextField( 10 );
      shift = new TextField( 10 );
      ctrl = new TextField( 10 );

      meta.setEditable( false );
      ctrl.setEditable( false );
      shift.setEditable( false );

      add( meta );
      add( shift );
      add( ctrl );
   }

   public boolean handleEvent( Event e )
   {
      if ( e.metaDown() )
         meta.setText( " META" );

      if ( e.controlDown() )
         ctrl.setText( " CTRL" );

      if ( e.shiftDown() )
         shift.setText( "SHIFT" );             

      return true;   // event has been handled
   }
}
