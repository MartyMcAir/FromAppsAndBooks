Continue Statements

 

public class ContinueStatements {
  public static void main( String[] args ) {
    // when i is 5, got back to loop, test and increment
    // in this chase the value 5 is not output
    for( int i = 0; i < 10; i++ ) {
      if( i == 5 ) {
        continue;
      }
      System.out.println( i );
    }

  }
}
