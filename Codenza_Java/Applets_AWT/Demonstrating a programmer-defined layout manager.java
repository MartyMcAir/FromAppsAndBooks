Demonstrating a programmer-defined layout manager

import java.applet.Applet;
import java.awt.*;

public class UserLayout extends Applet {
   private Choice cb1, cb2;
   private Button b1, b2, b3;

   public void init()
   {
      // use the v layout manager
      setLayout( new VLayout() );

      cb1 = new Choice();
      cb1.addItem( "Item 1" );
      cb1.addItem( "Item 2" );

      cb2 = new Choice();
      cb2.addItem( "Choice 1" );
      cb2.addItem( "Choice 2" );

      b1 = new Button( "Button 1" );
      b2 = new Button( "Button 2" );
      b3 = new Button( "Button 3" );

      // order is important
      add( cb1 );
      add( b1 );
      add( b2 );
      add( b3 );
      add( cb2 );
   }
}

// create class for user defined layout
class VLayout implements LayoutManager {

   public void layoutContainer( Container c )
   {    
      int numberOfComponents = c.countComponents();

      if ( numberOfComponents > 5 )
         numberOfComponents = 5;

      Insets i = c.insets();
      int w = c.size().width - i.left - i.right;
      int h = c.size().height - i.bottom - i.top;
      int x = 0, y = 0;

      // calculate x and y values for each component
      for ( int j = 0; j < numberOfComponents; j++ ) {
         Component comp = c.getComponent( j );
         Dimension d = comp.preferredSize();
         
         switch ( j ) {
            case 0:  // first component
               x = ( int ) ( 0.2 * w );
               y = ( int ) ( 0.25 * h );
               break;
            case 1:  // second component
               x = ( int ) ( 0.3 * w );
               y = ( int ) ( 0.5 * h );
               break;
            case 2:  // third component
               x = ( int ) ( 0.4 * w );
               y = ( int ) ( 0.75 * h );
               break;
            case 3:  // fourth component
               x = ( int ) ( 0.5 * w );
               y = ( int ) ( 0.5 * h );
               break;
            case 4:  // fifth component
               x = ( int ) ( 0.6 * w );
               y = ( int ) ( 0.25 * h );
               break;            
         }

         // size the component
         comp.reshape( x, y, d.width, d.height ); 
      }
   }

   // These last four methods must be overridden
   // However our layout manager does not use them
   public void addLayoutComponent( String s, Component c )
   { }  // empty

   public void removeLayoutComponent( Component c )
   { } // empty

   public Dimension preferredLayoutSize( Container c )
   {  return minimumLayoutSize( c );  }

   public Dimension minimumLayoutSize( Container c ) 
   {  return new Dimension( 0, 0 );   }    
}
