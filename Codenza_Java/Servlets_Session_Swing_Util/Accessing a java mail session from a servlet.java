Accessing a java mail session from a servlet

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * configure a resource reference within the web.xml file
 * that is a container managed javamail session object
 *
 <web-app>
 ...
 <resource-ref>
 <description>smtp mail out</description>
 <res-ref-name>mail/smtp</res-ref-name>
 <res-type>javax.mail.Session</res-type>
 <res-auth>CONTAINER</res-auth>
 </resource-ref>
 </web-app>
 *
 * and use your vendor specific xml file to map the
 * resource name to the jndi name, eg for weblogic
 *
 <weblogic-web-app>
 ...
 <reference-descriptor>
 <resource-description>
 <res-ref-name>mail/smtp</res-ref-name>
 <jndi-name>mail/dailyplanet</jndi-name>
 </resource-description>
 ...
 </reference-descriptor>
 </weblogic-web-app>
 *
 *
 */

public class AccessingAJavaMailSessionFromAServlet extends HttpServlet {
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    try {
      // get hold of the JavaMail session
      Context ctx = new InitialContext();
      Session mailSession = (Session) ctx.lookup( "java:comp/env/mail/smtp" );

      // create a message
      Message msg = new MimeMessage( mailSession );
      msg.setSubject( "a servlet test email" );
      msg.setSentDate( new java.util.Date( System.currentTimeMillis() ) );
      msg.setText( "<h1>Hello You</h1>" );
      msg.addHeader( "Content-Type", "text/html" );
      msg.setFrom( new InternetAddress( "x@xxx" ) );
      msg.setRecipient( Message.RecipientType.TO,
                        new InternetAddress( "cleve" ) );

      // send it
      Transport.send( msg );

      // and provide feedback to the use
      pw.println( "message sent!" );
    }
    catch( Exception ex ) {
      // if we get a problem, log it
      log( "problem sending message", ex );

      // and send an error back to the client
      res.sendError( res.SC_INTERNAL_SERVER_ERROR, ex.getMessage() );
    }
  }
}
