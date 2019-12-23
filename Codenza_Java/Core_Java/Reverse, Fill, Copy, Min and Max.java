Reverse, Fill, Copy, Min and Max

import java.util.*;

public class FCMM
     {
     private String letters[] = { "P", "C", "M" }, lettersCopy[];
     private List theList, copyList;
    
     public FCMM()
         {
         theList = Arrays.asList( letters ); // get List
         lettersCopy = new String[ 3 ];
         copyList = Arrays.asList( lettersCopy );
        
         System.out.println( "Printing initial statistics: " );
         printStatistics( theList );
        
         Collections.reverse( theList ); // reverse order
         System.out.println( "\nPrinting statistics after " + "calling reverse: " );
         printStatistics( theList );
        
         Collections.copy( copyList, theList ); // copy List
         System.out.println( "\nPrinting statistics after " + "copying: " );
         printStatistics( copyList );
        
         System.out.println( "\nPrinting statistics after " + "calling fill: " );
         Collections.fill( theList, "R" );
         printStatistics( theList );
     }
    
     private void printStatistics( List listRef )
         {
         System.out.print( "The list is: " );
         for ( int k = 0; k < listRef.size(); k++ )
         System.out.print( listRef.get( k ) + " " );
        
         System.out.print( "\nMax: " + Collections.max( listRef ) );
         System.out.println( " Min: " +
         Collections.min( listRef ) );
     }
    
     public static void main( String args[] )
         {
         new FCMM();
     }
}
