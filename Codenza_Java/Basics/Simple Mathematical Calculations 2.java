Simple Mathematical Calculations 2

import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class Points extends JApplet implements ActionListener {
   JTextField x1Input, x2Input, y1Input, y2Input;
   JLabel labelX1, labelY1, labelX2, labelY2;

   // set up GUI components
   public void init()
   {
      labelX1 = new JLabel( "Enter X1: " );
      labelY1 = new JLabel( "Enter Y1: " );
      labelX2 = new JLabel( "Enter X2: " );
      labelY2 = new JLabel( "Enter Y2: " );
      x1Input = new JTextField( 4 );
      x2Input = new JTextField( 4 );
      y1Input = new JTextField( 4 );
      y2Input = new JTextField( 4 );
      y2Input.addActionListener( this );

      Container container = getContentPane();
      container.setLayout( new FlowLayout() );
      container.add( labelX1 );
      container.add( x1Input );
      container.add( labelY1 );
      container.add( y1Input );
      container.add( labelX2 );
      container.add( x2Input );
      container.add( labelY2 );
      container.add( y2Input );
   }

   // display distance between user input points
   public void actionPerformed( ActionEvent e )
   {
      double x1, y1, x2, y2;

	  // read in two points
      x1 = Double.parseDouble( x1Input.getText() );
      y1 = Double.parseDouble( y1Input.getText() );
      x2 = Double.parseDouble( x2Input.getText() );
      y2 = Double.parseDouble( y2Input.getText() );

      double theDistance = distance( x1, y1, x2, y2 );
      showStatus( "Distance is " + theDistance );
   }

   // calculate distance between two points
   public double distance( double x1, double y1,
      double x2, double y2 )
   {
      return Math.sqrt( Math.pow( ( x1 - x2 ), 2 ) +
         Math.pow( ( y1 - y2 ), 2 ) );
   }

} // end class Points
