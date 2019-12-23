Break statements

 

public class BreakStatements {
  public static void main( String[] args ) {

    /**
     * break out of a loop here
     */
    for( int i = 0; i < 10; i++ ) {
      System.out.println( i );
      if( i == 5 ) {
        break;
      }
    }

    /**
     * note, break only breaks you out of the current loop
     */
    for( int i = 0; i < 10; i++ ) {
      for( int j = 0; j < 10; j++ ) {
        if( i == j ) {
          System.out.println( "breaking out with i = " + i );
          break;
        }
      }
    }

    boolean doneGetOut = false;
  }
}
