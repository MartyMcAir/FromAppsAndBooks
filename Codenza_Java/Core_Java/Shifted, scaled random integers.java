Shifted, scaled random integers

import javax.swing.JOptionPane;
public class RandomInt 
     {
     public static void main( String args[] )
         {
         int value;
         String output = "";
        
         for ( int i = 1; i <= 20; i++ ) 
             {
             value = 1 + (int) ( Math.random() * 6 );
             output += value + " ";
            
             if ( i % 5 == 0 )
             output += "\n";
         }
        
         JOptionPane.showMessageDialog( null, output, "20 Random Numbers from 1 to 6", JOptionPane.INFORMATION_MESSAGE );
         
         System.exit( 0 );
     }
}
