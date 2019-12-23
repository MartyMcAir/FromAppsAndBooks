Mail message util
  
 

package com.ack.j2ee.javamail;

import java.io.PrintStream;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;

/**
 * provides useful feedback on JavaMail MessagingExceptions
 */
public class MailMessageUtil implements java.io.Serializable {
  /**
   * Writes the messaging exception in readable format to the supplied print stream.
   * @param me The MessagingException object
   * @param out The PrintStream to display the exception on
   */
  public static void reportOnException( MessagingException me, PrintStream out ) {
    do {
      if( me instanceof SendFailedException ) {
        SendFailedException sfex = (SendFailedException) me;
        Address[] invalid = sfex.getInvalidAddresses();

        if( invalid != null ) {
          out.println( "    ** Invalid Addresses" );
          if( invalid != null ) {
            for( int i = 0; i < invalid.length; i++ )
              out.println( "         " + invalid[i] );
          }
        }

        Address[] validUnsent = sfex.getValidUnsentAddresses();
        if( validUnsent != null ) {
          out.println( "    ** ValidUnsent Addresses" );
          if( validUnsent != null ) {
            for( int i = 0; i < validUnsent.length; i++ )
              out.println( "         " + validUnsent[i] );
          }
        }

        Address[] validSent = sfex.getValidSentAddresses();
        if( validSent != null ) {
          out.println( "    ** ValidSent Addresses" );
          if( validSent != null ) {
            for( int i = 0; i < validSent.length; i++ )
              out.println( "         " + validSent[i] );
          }
        }
      }

      out.println();
      if( me instanceof MessagingException ) {
        me = (MessagingException) me.getNextException();
      }
      else {
        me = null;
      }
    } while( me != null );
  }
}
