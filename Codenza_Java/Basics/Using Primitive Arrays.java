Using Primitive Arrays
  
 

 

public class UsingPrimitiveArrays {
  public static void main( String[] args ) {
    // declare an array
    int[] bags;

    // create and assign array with 10 elements
    bags = new int[5];

    // declare, create and assign array in one step
    float[] balances = new float[4];

    /**
     * Note that both the 'bags' and 'balances' arrays
     * are initialised with the default values which for
     * ints and float are zero
     */

    // assign bags new values
    bags = new int[]{5, 10, 15, 20, 25};

    // here is a shorthand for declaring an array,
    // and assigning values.  note that the omission
    // of the new statement can only be done if declaration
    // and assignment take place within one statement
    int[] sacks = {1, 2, 3, 4, 5};

    // and to get the length of the array
    // java provides a special property on arrays
    // NOTE: length is not a method, hence no parenthesis
    System.out.println( "The number of sacks is: " + sacks.length );

    // accessing arrays
    for( int i = 0; i < bags.length; i++ ) {
      System.out.println( bags[i] );
    }
  }
}
