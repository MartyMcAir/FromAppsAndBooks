Catching an exception

 

public class CatchingAnException {
  public static void main( String[] args ) {
    try {
      // this throws a runtime exception, that is a divide by zero
      int a = 3 / 0;
    }
    catch( ArithmeticException aex ) {
      aex.printStackTrace();
    }
  }
}
