Histogram printing program

import javax.swing.*;

public class Histogram
     {
     public static void main( String args[] )
         {
         int n[] = { 19, 3, 15, 7, 11, 9, 13, 5, 17, 1 };
         String output = "";
        
         output += "Element\tValue\tHistogram";
        
         for ( int i = 0; i < n.length; i++ )
             {
             output += "\n" + i + "\t" + n[ i ] + "\t";
            
             for ( int j = 1; j <= n[ i ]; j++ ) // print a bar
             output += "*";
         }
        
         JTextArea outputArea = new JTextArea( 11, 30 );
         outputArea.setText( output );
        
         JOptionPane.showMessageDialog( null, outputArea,"Histogram Printing Program",JOptionPane.INFORMATION_MESSAGE );
        
         System.exit( 0 );
     }
}
