Multiple Inheritance
  
 

 

import java.io.Serializable;
import java.rmi.Remote;
import java.util.Vector;

public class MultipleInheritance
    extends Vector
    implements Remote, Serializable {
  /**
   * Java is a single inheritance tree and only allows a
   * class to inherit implementation from one class.  That
   * class is specified using extends (eg. Vector ) otherwise
   * if nothing is specified it is Object, the root class in
   * the Java inheritance hierarchy
   * <p>
   * However, Java does support the multiple interface inheritance.
   * In this example we inheritance from both the Remote and Serializable
   * interfaces.
   */
  public static void main( String[] args ) {

  }
}
