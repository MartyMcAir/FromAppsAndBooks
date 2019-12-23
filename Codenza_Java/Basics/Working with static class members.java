Working with static class members
  
 

 

public class WorkingWithStaticClassMembers {
  public static void main( String[] args ) {
    Colour background = Colour.a;
  }
}

class Colour {
  // take this slowly, you are defining constant class level
  // objects for objects of this class - at compile time! boy i like Java!
  public static final Colour a = new Colour( 255, 255, 255 );
  public static final Colour b = new Colour( 255, 255, 0 );
  public static final Colour c = new Colour( 255, 0, 0 );

  private int red;
  private int green;
  private int blue;

  public Colour( int red, int green, int blue ) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }
}
