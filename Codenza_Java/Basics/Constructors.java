Constructors

 

public class Constructors {
  private static final String DEFAULT_MSG = "hey";
  private static final int DEFAULT_AMOUNT = 25;

  private String msg;
  private int amount;

  public Constructors( String msg, int amount ) {
    // use the 'this' keyword to reference to this object instance
    // variables, with out, msg and amount refer to the formal parameters
    this.msg = msg;
    this.amount = amount;
  }

  public Constructors( String msg ) {
    // must be first line in a constructor and calls the constructor
    // within this class with those formal parameters
    this( msg, DEFAULT_AMOUNT );
  }

  public Constructors() {
    // must be first line in a constructor and calls the constructor
    // within this class with those formal parameters
    this( DEFAULT_MSG );
  }

  public static void main( String[] args ) {
    // here, we demonstrate how all three constructors
    // can be called to construct an object
    new Constructors();
  }
}
