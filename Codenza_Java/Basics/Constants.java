Constants

 

public class Constants {
  // define two class-level constants with static final
  private static final int MAX_VALUE = 100;
  private static final String LOCAL_URL = "http://localhost:8080/";

  public static void main( String[] args ) {
    // define MY_PIE as a local constant
    final double MY_PIE = 3.14;

    System.out.println( Constants.MAX_VALUE );
    System.out.println( Constants.LOCAL_URL );
    System.out.println( MY_PIE );

    // MY_PIE = 3.15 result in an error, because MY_PIE is a constant
  }

  public static void execute( final int min, final int max ) {
    // min and max cannot be altered within this method
  }
}
