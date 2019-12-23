Attachment receiver

package com.ack.webservices.jaxm.servlet;

import java.util.Iterator;
import javax.servlet.ServletException;
import javax.xml.messaging.JAXMServlet;
import javax.xml.messaging.ReqRespListener;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

/**
 * Servlet that accepts a SOAP message and looks through
 * its attachments before sending the SOAP part of the message
 * to the console and sending back a response
 *
 */
public class AttachmentReceiver extends JAXMServlet implements ReqRespListener {
  private MessageFactory fac;

  public void init() throws ServletException {
    try {
      fac = MessageFactory.newInstance();
    }
    catch( Exception ex ) {
      ex.printStackTrace();
      throw new ServletException( ex );
    }
  }

  // This is the application code for handling the message.. Once the
  // message is received the application can retrieve the soap part, the
  // attachment part if there are any, or any other information from the
  // message.

  public SOAPMessage onMessage( SOAPMessage message ) {
    System.out.println( "On message called in receiving servlet" );
    try {
      System.out.println( "\nMessage Received: " );
      System.out.println( "\n============ start ============\n" );

      // dump out attachments
      System.out.println( "Number of Attachments: " + message.countAttachments() );
      int i = 1;
      for( Iterator it = message.getAttachments(); it.hasNext(); i++ ) {
        AttachmentPart ap = (AttachmentPart) it.next();
        System.out.println( "Attachment #" + i + " content type : " +
                            ap.getContentType() );
      }

      // dump out the SOAP part of the message
      SOAPPart soapPart = message.getSOAPPart();
      System.out.println( "SOAP Part of Message:\n\n" + soapPart );
      System.out.println( "\n============ end ===========\n" );

      SOAPMessage msg = fac.createMessage();
      SOAPEnvelope env = msg.getSOAPPart().getEnvelope();

      env.getBody()
          .addChildElement( env.createName( "MessageResponse" ) )
          .addTextNode( "Right back at you" );
      return msg;
    }
    catch( Exception e ) {
      e.printStackTrace();
      return null;
    }
  }
}
