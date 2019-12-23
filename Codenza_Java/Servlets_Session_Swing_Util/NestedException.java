NestedException
  
 

package com.ack.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Allows an exception to be nested inside it
 * <p>Note that this class will not be required with J2SE v1.4 and
 * above because java.lang.Exception has been updated to provide
 * this behaviour
 */
public class NestedException extends Exception {
  private Throwable underlyingException;

  /**
   * Constructor
   * @param msg The exception error message
   */
  public NestedException( String msg ) {
    super( msg );
  }

  /**
   * Constructor
   * @param msg The exception error message
   * @param t The nested exception
   */
  public NestedException( String msg, Throwable t ) {
    super( msg );
    underlyingException = t;
  }

  /**
   * Gets back the original triggering exception
   * @return The original exception as a throwable
   */
  public Throwable getUnderlyingException() {
    return underlyingException;
  }

  /**
   * Overrides object.toString()
   * @return The exception in string format
   */
  public String toString() {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter( sw );
    pw.println( getMessage() );

    if( underlyingException != null ) {
      pw.println( "\n==== Exception 'inside' NestedException listed below =====" );
      underlyingException.printStackTrace( pw );
      pw.println( "\n========= end of exception 'inside' NestedException ========= " );
    }
    pw.close();

    return sw.toString();
  }
}
