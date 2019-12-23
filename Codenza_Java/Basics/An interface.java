An interface

 

public interface AnInterface {
  // can define constants in interfaces
  public static final int MAX_VALUE = 300;

  // but really use interfaces for declaring methods
  public void aMethod();

  public int anotherMethod( String hey ) throws Exception;

  public void yetAnotherMethod() throws Exception, ArithmeticException;
}

class ImplementInterfaceClass implements AnInterface {

  public void aMethod() {

  }

  // note that methods are matched on formal parameter types and
  // method name.
  public int anotherMethod( String yep ) throws Exception {
    // note that when you implement an interface, its constants
    // are brought into the defining class's scope
    if( true ) {
      return MAX_VALUE;
    }
    else {
      // however, best to always prefix constants with the defining
      // class or interface for readability purposes
      return AnInterface.MAX_VALUE;
    }
  }

  /**
   * this causes a duplication definition of anotherMethod because
   * the method signature only differs by the return type.  In Java,
   * if two method differ only by the return type they are the same method
   * from an inheritance perspective
   *
   public String anotherMethod(String yep) throws Exception
   {
   return null;
   }
   */

  // finally, you can selectively choose which exception to declare
  // on the throws clause of the implementing method, here we choose to omit
  // Exception
  public void yetAnotherMethod() throws ArithmeticException {

  }

}
