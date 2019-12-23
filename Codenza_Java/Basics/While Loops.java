While Loops
  
 

 

public class WhileLoops {
  public static void main( String[] args ) {
    // simple loop that goes round and around until
    // expression evaluations to false
    double index = 99999;
    while( index > 10 ) {
      System.out.println( "index has value " + index );
      index /= 2;
    }

    // this would be an infinite loop...
    while( true ) {
      break; // ...if we didn't break out here
    }

    // same as while loop, but with a subtle difference.  code is alway
    // executed before the loop iteration expression is evaluate
    // do..whiles are the least used looping structures
    do {
      index *= 2;
      System.out.println( "index has value " + index );
    } while( index < 9999 );
  }
}
