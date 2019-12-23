Type Casting
  
 

 

public class TypeCasting {
  public static void main( String[] args ) {
    // implicit cast

    // will allow if the right-hand side (rhs) value is small enough
    short smallValue = 45;

    // this is not allowed because rhs value is too big for a short
    //smallValue = 234251434324324;

    // assigning a short to an integer is an implicit cast and
    // one the compiler can handle because ints are bigger than shorts
    int littleValue = smallValue;

    // assigning a integer to short requires an explicit cast because
    // shorts are smaller than ints and they would a loss of precision
    smallValue = (short) littleValue;

    // specify typed literal values using L, F and D
    // ( and their lowercase equivalents )
    float pay = 42234.45f;
    long bigValue = 45243224L;
    double amount = 345.45d;

    // default literal values
    int defaultIsInt = 345;
    double defaultIsDouble = 34.5;
  }
}
