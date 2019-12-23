Pre and post increment operators
  
 

 

public class PreAndPostIncrementOperators {
  public static void main( String[] args ) {
    int index = 0;

    // all these statements add one to index
    index = index + 1;
    index += 1;
    index++;
    ++index;

    // prints index value -> 4
    System.out.println( index );

    // prints index current value of 4, and then increments
    System.out.println( index++ );

    // prints index value which is 5
    System.out.println( index );

    // increments index, and then prints its value of 6
    System.out.println( ++index );

    // prints out current value of index which is 6
    System.out.println( index );

    // same logic holds for -- operator
  }
}
