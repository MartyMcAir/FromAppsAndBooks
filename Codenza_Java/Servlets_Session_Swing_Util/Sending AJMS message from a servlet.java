Sending AJMS message from a servlet
  
 

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web.xml servlet configuration file
 *
 <web-app>
 ...
 <resource-ref>
 <description>outgoing jms send</description>
 <res-ref-name>jms/queue/connection</res-ref-name>
 <res-type>javax.jms.QueueConnectionFactory</res-type>
 <res-auth>CONTAINER</res-auth>
 </resource-ref>
 ...
 </web-app>
 *
 * the vendor-specific web.xml file that maps the res-ref-name
 * onto the one found in the jndi name space
 *
 <weblogic-web-app>
 ...
 <reference-descriptor>
 <resource-description>
 <res-ref-name>jms/queue/connection</res-ref-name>
 <jndi-name>jms/akira/connectionfactory</jndi-name>
 </resource-description>
 ...
 </reference-descriptor>
 ...
 </weblogic-web-app>
 */
public class SendingAJMSMessageFromAServlet extends HttpServlet {

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    QueueConnection queueCon = null;
    try {
      // get the queue connection factory
      Context ctx = new InitialContext();
      QueueConnectionFactory qcf
          = (QueueConnectionFactory) ctx.lookup( "java:comp/env/jms/queue/connection" );

      queueCon = qcf.createQueueConnection();

      // create queue session off the connection
      QueueSession queueSession = queueCon.
          createQueueSession( false, Session.AUTO_ACKNOWLEDGE );

      // get handle on queue, create a sender and send the message
      Queue queue = (Queue) ctx.lookup( "jms/queue/devilman" );
      QueueSender sender = queueSession.createSender( queue );
      Message msg = queueSession.createTextMessage( "hello..." );
      sender.send( msg );

      pw.println( "sent the message" );
    }
    catch( Exception ex ) {
      log( "couldn't send the message", ex );
      res.sendError( res.SC_INTERNAL_SERVER_ERROR, ex.getMessage() );
    }

    finally {
      // close the queue connection
      if( queueCon != null ) {
        try {
          queueCon.close();
        }
        catch( JMSException jme ) {
          log( "problem closing queue con" );
        }
      }
    }
  }
}
