Simple Arithmetic
  
 

 

public class SimpleArithmetic {
  public static void main( String[] args ) {
    int withdraw = 300;
    int deposit = 400;

    // declare and define using initialised variables
    int balance = deposit - withdraw;

    // different way of adding 100 to balance
    balance = balance + 100;
    balance += 100;

    // use boolean
    boolean isGood = false;
    isGood = !isGood; // isGood is now true

    // remainder is one
    int remainder = 100 % 3;

    // all operators have the <operator>= semantics
    // so we have examles of /= and *= below
    int value = 100 * 10;
    value /= 5;
    value *= 2;

    // and of course we can have compound arithmetic
    int yourValue = ( ( value + balance ) / ( withdraw * deposit ) );
  }
}
