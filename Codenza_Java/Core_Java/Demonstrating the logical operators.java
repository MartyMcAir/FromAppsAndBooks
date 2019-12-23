Demonstrating the logical operators

import javax.swing.*;

public class LogicalOperators
     {
     public static void main( String args[] )
         {
         JTextArea outputArea = new JTextArea( 17, 20 );
         JScrollPane scroller = new JScrollPane( outputArea );
         String output = "";
        
         output += "Logical AND (&&)" +
         "\nfalse && false: " + ( false && false ) +
         "\nfalse && true: " + ( false && true ) +
         "\ntrue && false: " + ( true && false ) +
         "\ntrue && true: " + ( true && true );
        
         output += "\n\nLogical OR (||)" +
         "\nfalse || false: " + ( false || false ) +
         "\nfalse || true: " + ( false || true ) +
         "\ntrue || false: " + ( true || false ) +
         "\ntrue || true: " + ( true || true );
        
         output += "\n\nBoolean logical AND (&)" +
         "\nfalse & false: " + ( false & false ) +
         "\nfalse & true: " + ( false & true ) +
         "\ntrue & false: " + ( true & false ) +
         "\ntrue & true: " + ( true & true );
        
         output += "\n\nBoolean logical inclusive OR (|)" +
         "\nfalse | false: " + ( false | false ) +
         "\nfalse | true: " + ( false | true ) +
         "\ntrue | false: " + ( true | false ) +
         "\ntrue | true: " + ( true | true );
        
         output += "\n\nBoolean logical exclusive OR (^)" +
         "\nfalse ^ false: " + ( false ^ false ) +
         "\nfalse ^ true: " + ( false ^ true ) +
         "\ntrue ^ false: " + ( true ^ false ) +
         "\ntrue ^ true: " + ( true ^ true );
        
         output += "\n\nLogical NOT (!)" +
         "\n!false: " + ( !false ) +
         "\n!true: " + ( !true );
        
         outputArea.setText( output );
         JOptionPane.showMessageDialog( null, scroller, "Truth Tables", JOptionPane.INFORMATION_MESSAGE );
         System.exit( 0 );
     }
}
