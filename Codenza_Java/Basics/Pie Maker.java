Pie Maker
  
 

package com.ack.learning.exceptions;

import com.ack.learning.exceptions.PieEater;
import com.ack.learning.exceptions.PieException;

public class PieMaker {
  public static void main( String[] args ) {
    try {
      PieEater pie = new PieEater();
      // some processing
      System.out.println( pie.howManyPies() );
    }
    catch( PieException pex ) {
      // catch the PieException and printout its stack trace
      pex.printStackTrace();
    }
    finally {
      // and always print out 'no more pies', regardless of what
      // happens within the try block
      System.out.println( "no more pies" );
    }
  }
}
