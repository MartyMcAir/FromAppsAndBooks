Saaj receiving attachments servlet
  
 

package com.ack.webservices.saaj;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class SaajReceivingAttachmentsServlet extends HttpServlet {
  private MessageFactory messageFactory;

  public void init() throws ServletException {
    try {
      // Initialize it to the default.
      messageFactory = MessageFactory.newInstance();
    }
    catch( SOAPException ex ) {
      throw new ServletException( "Unable to create message factory"
                                  + ex.getMessage() );
    }
  }

  public void doPost( HttpServletRequest req, HttpServletResponse resp )
      throws ServletException, IOException {

    try {
      // Get all the headers from the HTTP request.
      MimeHeaders headers = SaajUtils.getHeaders( req );

      // Get the body of the HTTP request.
      InputStream is = req.getInputStream();

      // Now internalize the contents of a HTTP request and
      // create a SOAPMessage
      SOAPMessage msg = messageFactory.createMessage( headers, is );
      SOAPMessage reply = null;

      // There are no replies in case of an OnewayListener.
      reply = onMessage( msg );

      if( reply != null ) {

        // Need to saveChanges 'cos we're going to use the
        // MimeHeaders to set HTTP response information. These
        // MimeHeaders are generated as part of the save.

        if( reply.saveRequired() ) {
          reply.saveChanges();
        }

        resp.setStatus( HttpServletResponse.SC_OK );

        SaajUtils.putHeaders( reply.getMimeHeaders(), resp );

        // Write out the message on the response stream.
        OutputStream os = resp.getOutputStream();
        reply.writeTo( os );

        os.flush();

      }
      else {
        resp.setStatus( HttpServletResponse.SC_NO_CONTENT );
      }
    }
    catch( Exception ex ) {
      throw new ServletException( "Saaj POST failed " + ex.getMessage() );
    }
  }

  // This is the application code for handling the message.. Once the
  // message is received the application can retrieve the soap part, the
  // attachment part if there are any, or any other information from the
  // message.

  public SOAPMessage onMessage( SOAPMessage message ) {
    System.out.println( "On message called in receiving servlet" );
    try {
      System.out.println( "Here's the message: " );
      message.writeTo( System.out );
      System.out.println( SaajUtils.getAttachmentReport( message ) );

      SOAPMessage msg = messageFactory.createMessage();
      SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
      env.getBody()
          .addChildElement( env.createName( "Response" ) )
          .addTextNode( "This is a response" );
      return msg;

    }
    catch( Exception e ) {
      e.printStackTrace();
      return null;
    }
  }


  public void doGet( HttpServletRequest req, HttpServletResponse resp )
      throws ServletException, IOException {
    System.out.println( "### got the servlet..." );
    resp.getWriter().println( "hello you!" );
  }
}
