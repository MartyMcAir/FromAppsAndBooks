Using HashMap to store number of words

 import java.util.*;

 public class HashMapTest 
 {
	 private static String names[] = { "one", "two", "three",
	 "four", "five", "six",
	 "seven", "two", "ten", "four" };

	 public HashMapTest()
	 {
		 HashMap m = new HashMap();
		 Integer i;

		 for ( int k = 0; k < names.length; k++ ) 
		 {
			 i = ( Integer ) m.get( new Character( names[ k ].charAt( 0 ) ) );

			 // if key is not in map then give it value one
			 // otherwise increment its value by 1
			 if ( i == null )
				 m.put( new Character( names[ k ].charAt( 0 ) ), new Integer( 1 ) );
			 else
				 m.put( new Character( names[ k ].charAt( 0 ) ), new Integer( i.intValue() + 1 ) );
		 }

		 System.out.println( "\nnumber of words beginning with " + "each letter: " );
		 printMap( m );
	 }
	 public void printMap( Map mapRef )
	 {
		 System.out.println( mapRef.toString() );
		 System.out.println( "size: " + mapRef.size() );
		 System.out.println( "isEmpty: " + mapRef.isEmpty() );
	 }

	 public static void main( String args[] )
	 {
		 new HashMapTest();
	 }
 }
