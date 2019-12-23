If Else Statement

 

public class IfElseStatement {
  public static void main( String[] args ) {
    boolean single = false;
    boolean tall = true;

    // one way
    if( single )
      System.out.println( "i am single" );

    // recommended
    if( single ) {
      System.out.println( "i am single" );
    }

    // one way
    if( single )
      System.out.println( "i am single" );
    else
      System.out.println( "i am not single" );

    // recommended
    if( single ) {
      System.out.println( "i am single" );
    }
    else {
      System.out.println( "i am not single" );
      System.out.println( "...but sometimes..." );
    }

    // note that there can be any number of
    // if...else if statements
    if( single == true ) {
      System.out.println( "i am single" );
    }
    else if( single == false && tall ) {
      System.out.println( "tall, non-single man" );
    }
    else {
      System.out.println( "and all the rest..." );
    }
  }
}
