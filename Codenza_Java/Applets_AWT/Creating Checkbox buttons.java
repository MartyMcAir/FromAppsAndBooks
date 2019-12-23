Creating Checkbox buttons

import java.applet.Applet;
import java.awt.*;

public class MyCheckbox extends Applet {
   private Font f;
   private TextField t;
   private Checkbox checkBold, checkItalic;

   public void init()
   {
      t = new TextField( "Sample Text", 30 );

      // instantiate checkbox objects
      checkBold = new Checkbox( "Bold" );
      checkItalic = new Checkbox();  
      checkItalic.setLabel( "Italic" );  // set checkbox label

      f = new Font( "TimesRoman", Font.PLAIN, 14 );
      t.setFont( f ); 

      add( t );
      add( checkBold );     // unchecked (false) by default
      add( checkItalic );   // unchecked (false) by default
   }

   public boolean action( Event e, Object o )
   {
      int b, i;

      // Check for Checkbox event
      if ( e.target instanceof Checkbox ) {

         // test state of bold checkbox
         if ( checkBold.getState() == true  )  
            b = Font.BOLD;
         else
            b = Font.PLAIN;   // value of 0

         // test state of italic checkbox
         if ( checkItalic.getState() == true )
            i = Font.ITALIC;
         else
            i = Font.PLAIN;   // value of 0
         
         f = new Font( "TimesRoman", b + i, 14 );
         t.setFont( f );
      }

      return true;
   }
}
