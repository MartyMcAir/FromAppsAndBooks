Switch Statements
  
 

 

public class SwitchStatements {
  public static void main( String[] args ) {
    int amount = 10;

    // simple switch statement
    switch( amount ) {
      case 1:
        System.out.println( "amount is 1" );
        break;
      case 2:
        System.out.println( "amount is 2" );
        break;
      default:
        System.out.println( "don't care about amount" );
    }

    // more complicated switch statement
    switch( amount ) {
      case 1:
        System.out.println( "amount was 1" );
        break;

      case 10:
      case 4:
      case 3:
        if( amount == 10 ) {
          System.out.println( "amount was ten" );
        }
        else {
          System.out.println( "amount was 4 or 3, actually -> " + amount );
        }
        break;

      default:
        System.out.println( "default action" );
    }

    // switch on a char
    char c = 't';
    switch( c ) {
      case 'b':
        System.out.println( "hit the b character" );
        break;
      case 't':
        System.out.println( "hit the t character" );
        break;
      default:
        System.out.println( "unsupported character" );
    }
  }
}
