Simple Strings
  
 

 

/**
 * messing about with Java Strings
 */
public class SimpleStrings {
  public static void main( String[] args ) {
    // a string is a array of characters
    char[] helloChars = {'h', 'e', 'l', 'l', 'o'};
    String helloString = new String( helloChars );
    System.out.println( helloString );

    // best way to assign a string literal
    helloString = "hello";

    // no need to do this
    helloString = new String( "hello" );

    // an example
    String barryWhite = "i love you all!";
    System.out.println( barryWhite.length() );              // 15
    System.out.println( barryWhite.charAt( 0 ) );             // i
    System.out.println( barryWhite.startsWith( "i love" ) );  // true
    System.out.println( barryWhite.endsWith( "all" ) );       // false
    System.out.println( barryWhite.indexOf( 'l' ) );          // 2
    System.out.println( barryWhite.indexOf( "you" ) );        // 7
    System.out.println( barryWhite.substring( 7 ) );          // you all!
    System.out.println( barryWhite.substring( 3, 8 ) );        // ove y

    // String equality
    String a = "hello";
    String b = "world";
    String c = new String( "hello" );
    String d = a;

    // == between Java objects is on reference equality
    // equals() method is used to value equality
    System.out.println( a == b );          // false
    System.out.println( a == c );         // false
    System.out.println( a.equals( c ) );    // true
    System.out.println( a == d );         // true

    // String are immutable
    String noChange = "have i changed, not likely";

    noChange.substring( 3 );
    noChange.toLowerCase();
    noChange.toUpperCase();
    noChange.trim();
    System.out.println( noChange );       // have i changed, not likely

    // StringBuffer usage
    StringBuffer buffer = new StringBuffer();
    for( int i = 0; i < 10; i++ ) {
      buffer.append( "say hello: " );
      buffer.append( i );
      buffer.append( "\n" );
    }

    System.out.println( buffer );
    /**
     *   this outputs
     *   say hello: 0
     *   say hello: 1
     *   say hello: 2
     *   say hello: 3
     *   say hello: 4
     *   say hello: 5
     *   say hello: 6
     *   say hello: 7
     *   say hello: 8
     *   say hello: 9
     */
  }
}
