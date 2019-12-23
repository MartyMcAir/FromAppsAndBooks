Interface List and class LinkedList example

 import java.util.*;

 public class ListTest1 
 {
	 private String colors[] = { "black", "yellow", "green",
	 "blue", "violet", "silver" };
	 private String colors2[] = { "gold", "white", "brown",
	 "blue", "gray", "silver" };

	 public ListTest1()
	 {
		 LinkedList link = new LinkedList();
		 LinkedList link2 = new LinkedList();
		 for ( int k = 0; k < colors.length; k++ ) 
		 {
			 link.add( colors[ k ] );
			 link2.add( colors2[ k ] ); // same length as colors
		 }

		 link.addAll( link2 ); // concatenate lists
		 link2 = null; // release resources

		 printList( link );
		 uppercaseStrings( link );
		 printList( link );
		 System.out.print( "\nDeleting elements 4 to 6..." );
		 removeItems( link, 4, 7 );
		 printList( link );
	 }

	 public void printList( List listRef )
	 {
		 System.out.println( "\nlist: " );
		 for ( int k = 0; k < listRef.size(); k++ )
		 System.out.print( listRef.get( k ) + " " );

		 System.out.println();
	 }

	 public void uppercaseStrings( List listRef2 )
	 {
		 ListIterator listIt = listRef2.listIterator();

		 while ( listIt.hasNext() ) 
		 {
			 Object o = listIt.next(); // get item

			 if ( o instanceof String ) // check for String
			 listIt.set( ( ( String ) o ).toUpperCase() );
		 }
	 }

	 public void removeItems( List listRef3, int start, int end )
	 {
		 listRef3.subList( start, end ).clear(); // remove items
	 }

	 public static void main( String args[] )
	 {
		 new ListTest1();
	 }
 }
