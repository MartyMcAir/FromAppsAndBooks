Try Pie Finally
  
 

package com.ack.learning.exceptions;

import com.ack.learning.exceptions.PieEater;
import com.ack.learning.exceptions.PieException;

public class TryPieFinally {
  public static void main( String[] args ) throws PieException {

    // in this example, you have decided not to handle
    // PieExceptions raised in the try block.

    // When a PieException occurs, the finally block code
    // is executed and the exception propagates up the
    // method stack to main(), which we see can throw PieException

    // The JVM seeing that main() is the program entry point, catches
    // the exception, dumps out its stack trace and ends the program

    // note: better to always handle application specific errors
    try {
      PieEater pe = new PieEater();
      // eat over a 100 pies
      System.out.println( pe.howManyPies() );
    }
    finally {
      System.out.println( "no more pies" );
    }
  }
}
