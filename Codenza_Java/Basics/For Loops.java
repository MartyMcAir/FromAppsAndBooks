For Loops

 

public class ForLoops {
  public static void main( String[] args ) {
    // simple for loop
    System.out.println( "loop #1" );
    for( int i = 0; i < 10; i++ ) {
      System.out.println( i );
    }

    // loop with multiple iteration constants
    System.out.println( "loop #2" );
    for( int i = 1,j = 2; i < 10 && j < 5; i += 2, j-- ) {
      System.out.println( j );
    }

    // infinite loop
    System.out.println( "infinite loop #3" );
    for( ; ; ) {
      // but we are going to break out of it
      break;
    }
  }
}
