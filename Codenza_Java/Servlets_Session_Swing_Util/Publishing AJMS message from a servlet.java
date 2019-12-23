Publishing AJMS message from a servlet
  
 

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
 <description>outgoing jms publish</description>
 <res-ref-name>jms/topic/connection</res-ref-name>
 <res-type>javax.jms.TopicConnectionFactory</res-type>
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
 <res-ref-name>jms/topic/connection</res-ref-name>
 <jndi-name>jms/akira/connectionfactory</jndi-name>
 </resource-description>
 ...
 </reference-descriptor>
 ...
 </weblogic-web-app>
 */

public class PublishingAJMSMessageFromAServlet extends HttpServlet {

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    TopicConnection topicCon = null;
    try {
      // get the topic connection factory
      Context ctx = new InitialContext();
      TopicConnectionFactory tcf
          = (TopicConnectionFactory) ctx.lookup( "java:comp/env/jms/topic/connection" );

      topicCon = tcf.createTopicConnection();

      // create topic session off the connection
      TopicSession topicSession = topicCon.
          createTopicSession( false, Session.AUTO_ACKNOWLEDGE );

      // get handle on topic, create a publisher and publish the message
      Topic topic = (Topic) ctx.lookup( "jms/topic/devilman" );
      TopicPublisher publisher = topicSession.createPublisher( topic );
      Message msg = topicSession.createTextMessage( "hello..." );
      publisher.publish( msg );

      pw.println( "published the message" );
    }
    catch( Exception ex ) {
      log( "couldn't publish the message", ex );
      res.sendError( res.SC_INTERNAL_SERVER_ERROR, ex.getMessage() );
    }

    finally {
      // close the topic connection
      if( topicCon != null ) {
        try {
          topicCon.close();
        }
        catch( JMSException jme ) {
          log( "problem closing topic con" );
        }
      }
    }
  }
}
