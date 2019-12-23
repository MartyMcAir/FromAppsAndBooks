Null Reference
  
 

 

import com.ack.learning.examples.account.Account;

public class NullReference {
  public static void main( String[] args ) {
    // unitialised variables
    String x;
    Account y;

    /**
     * this is an error because x is unitialised
     if( x == null )
     {

     }
     */

    // initialised variables
    String hsbc = null;
    Account account = null;

    // object arrays are initialised to null
    String[] names = new String[5];
    for( int i = 0; i < names.length; i++ ) {
      System.out.println( names[i] );
    }
  }
}
