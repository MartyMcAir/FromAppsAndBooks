Raise Exceptions
  
 

 

/**
 * This example demonstrates how to catch
 * multiple exceptions that are raised in
 * a try block
 */
public class RaiseExceptions {
  public static void main( String[] args ) {
    try {
      Integer.parseInt( "a" );
      double[] amounts = new double[-10];
      "hello".charAt( -1 );
      String str = args[6];
      ( (String) null ).length();
      int a = 3 / 0;
    }
    catch( NumberFormatException nfex ) {
      System.out.println( nfex );
    }
    catch( NegativeArraySizeException nasex ) {
      System.out.println( nasex );
    }
    catch( StringIndexOutOfBoundsException siex ) {
      System.out.println( siex );
    }
    catch( ArrayIndexOutOfBoundsException arex ) {
      System.out.println( arex );
    }
    catch( NullPointerException npex ) {
      System.out.println( npex );
    }
    catch( ArithmeticException aex ) {
      System.out.println( aex );
    }

  }
}
