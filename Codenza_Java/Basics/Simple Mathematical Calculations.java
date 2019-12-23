Simple Mathematical Calculations

// Exercise 3.12 Solution: Multiples.java
// Given two doubles as input, the program determines if the first// is a multiple of the second.

// Java core packages
import java.awt.Graphics;   // import class Graphics

// Java extension packages
import javax.swing.*;       // import package javax.swing

public class Multiples extends JApplet {
   String result;   // output display String

   // initialize applet by obtaining values from user
   public void init()
   {
      String firstNumber;    // first String entered by user
      String secondNumber;   // second String entered by user
      double number1;        // first number to compare
      double number2;        // second number to compare

      // read first number from user as a String
      firstNumber =
         JOptionPane.showInputDialog( "Enter first floating-point number:" );

      // read second number from user as a String
      secondNumber =
         JOptionPane.showInputDialog( "Enter second floating-point number:" );

      // convert numbers from type String to type double
      number1 = Double.parseDouble( firstNumber );
      number2 = Double.parseDouble( secondNumber );

      if ( number1 % number2 == 0 )
      	result  = number1 + " is a multiple of " + number2;

      if ( number1 % number2 != 0 )
      	result  = number1 + " is not a multiple of " + number2;

   }  // end method init

   // draw results on applet's background
   public void paint( Graphics g )
   {
      // draw result as a String at (25, 25)
      g.drawString( result, 25, 25 );

   }  // end method paint

}  // end class OddEven
