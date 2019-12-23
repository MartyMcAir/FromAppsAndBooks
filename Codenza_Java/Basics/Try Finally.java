Try Finally
  
 

 

public class TryFinally {
  public static void main( String[] args ) throws Exception {
    // important to note that try, does not always need
    // to be accompanied by a catch block
    try {
      // if an exception is raised the finally block is
      // executed and the exception propogates out, hence
      // note the Exception on the main method's throw clause
      throw new Exception( "oopsy" );
    }
    finally {
      System.out.println( "no worries, i'm always called" );
    }
  }
}
