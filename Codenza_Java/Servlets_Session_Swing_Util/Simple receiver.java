Simple receiver
  
 

package com.ack.webservices.jaxm.servlet;

import javax.servlet.ServletException;
import javax.xml.messaging.JAXMServlet;
import javax.xml.messaging.ReqRespListener;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;


/**
 * An adapted example of the ReceiverServlet to highlight
 * the JAXM specific aspects of messaging and remove non-essential
 * API code such as servlets and log4j.
 *
 * big fanfare to the original authors:
 *
 */
public class SimpleReceiver extends JAXMServlet implements ReqRespListener {
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

      // dump out the message
      message.writeTo( System.out );

      System.out.println( "\n============ end ============\n" );

      // create a message to send back
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
