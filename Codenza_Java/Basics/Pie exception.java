Pie exception
  
 

package com.ack.learning.exceptions;

// define your own exception by extending java.lang.Exception

public class PieException extends Exception {
  // let this exception accept a user message that can be
  // accessed through calling getMessage() that is defined
  // within its parent class
  public PieException( String msg ) {
    super( msg );
  }
}
