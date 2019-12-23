Letter combinations recursion
  
 

 

public class LetterCombinationsRecursion {

  private static String sum = "";

  public static void main( String[] argv ) {
    long l = System.currentTimeMillis();
    printAlphabetCombinations( 4, "" );
    System.out.println( "Time:" + ( System.currentTimeMillis() - l ) / 1000 + " sec" );
  }

  public static void printAlphabetCombinations( int recurseCounter, String current ) {
    String temp = current;
    if( recurseCounter == 0 ) {
      System.out.println( temp );
      return;
    }
    else {
      recurseCounter--;
      for( int i = 0; i < 26; i++ ) {
        temp = current + (char) ( 65 + i );
        printAlphabetCombinations( recurseCounter, temp );
      }
    }
  }
}
