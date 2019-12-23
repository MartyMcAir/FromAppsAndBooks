Using a HashSet to remove duplicates

 import java.util.*;

 public class HashSetTest
 {
	 private String colors[] = { "red", "white", "blue",
	 "green", "gray", "orange",
	 "tan", "white", "cyan",
	 "peach", "gray", "orange" };

	 public HashSetTest()
	 {
		 ArrayList aList;

		 aList = new ArrayList( Arrays.asList( colors ) );
		 System.out.println( "ArrayList: " + aList );
		 printNonDuplicates( aList );
	 }

	 public void printNonDuplicates( Collection c )
	 {
		 HashSet ref = new HashSet( c ); // create a HashSet
		 Iterator i = ref.iterator(); // get iterator

		 System.out.println( "\nNonduplicates are: " );
		 while ( i.hasNext() )
			 System.out.print( i.next() + " " );

		 System.out.println();
	 }

	 public static void main( String args[] )
	 {
		 new HashSetTest();
	 }
 }
