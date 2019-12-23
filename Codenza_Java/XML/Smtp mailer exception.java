Smtp mailer exception
  
 

package com.ack.j2ee.javamail;

/**
 * Exception class for SMTP mailer exceptions
 */
public class SmtpMailerException extends Exception {
  /**
   * Constructor
   * @param str The exception error message
   */
  public SmtpMailerException( String str ) {
    super( str );
  }
}
