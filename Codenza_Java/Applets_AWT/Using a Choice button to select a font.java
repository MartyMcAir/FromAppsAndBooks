Using a Choice button to select a font

import java.applet.Applet;
import java.awt.*;

public class MyChoice extends Applet {
   private Choice choiceButton;
   private TextField t;
   private Font f;

   public void init()
   {
      choiceButton = new Choice();
      t = new TextField( "Sample Text", 16 );
      t.setEditable( false );

      // add items to choiceButton
      choiceButton.addItem( "TimesRoman" );
      choiceButton.addItem( "Courier" );
      choiceButton.addItem( "Helvetica" );

      f = new Font( choiceButton.getItem( 0 ),
                    Font.PLAIN, 14 );
      t.setFont( f ); 
      add( choiceButton );
      add( t );
   }

   public boolean action( Event e, Object o )
   {
      String s;

      // Check for Choice button event
      if ( e.target instanceof Choice ) {
         f = new Font( choiceButton.getSelectedItem(),
                       Font.PLAIN, 14 );

         t.setFont( f );

         s = "Number of items: " +
             choiceButton.countItems();

         s += "      Current index: " +
              choiceButton.getSelectedIndex();

         showStatus( s );
      }

      return true;
   }
}
