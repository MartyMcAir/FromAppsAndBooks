Arrays and collections

 

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArraysAndCollections {
  public static void main( String[] args ) {
    // create a list of integers
    List l = new LinkedList();
    for( int i = 1; i < 11; i++ ) {
      l.add( new Integer( i ) );
    }

    // convert to array
    Object[] integers = l.toArray();

    // convert back to list
    List ll = Arrays.asList( integers );

    // output lists
    System.out.println( l );
    System.out.println( ll );
  }
}
