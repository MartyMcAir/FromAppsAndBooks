Creating radio buttons using CheckboxGroup and Checkbox

import java.applet.Applet;
import java.awt.*;

public class RadioButton extends Applet {
   private TextField t;
   private Font f;
   private CheckboxGroup radio;
   private Checkbox radioBold, radioItalic,
                    radioPlain;

   public void init()
   {
      t = new TextField( "Sample Text", 40 );

      // instantiate checkbox group (i.e. radio buttons)
      radio = new CheckboxGroup(); 
      
      add( t );   // add textfield

      // instantiate radio button objects 
      add( radioPlain = new Checkbox( "Plain", radio, true ) );
      add( radioItalic = new Checkbox( "Italic", radio, false ) );  
      add( radioBold = new Checkbox( "Bold", radio, false ) );
   }

   public boolean action( Event e, Object o )
   {
      int style;

      // Check for Checkbox event
      if ( e.target instanceof Checkbox) {

         // test state of radio buttons
         if ( radioPlain.getState() == true  )  
            style = Font.PLAIN;
         else if ( radioItalic.getState() == true )
            style = Font.ITALIC;
         else
            style = Font.BOLD;  
 
         f = new Font( "TimesRoman", style, 14 );
         t.setFont( f );
      }

      return true;
   }
}
