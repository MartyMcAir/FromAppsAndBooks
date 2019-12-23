Accessing servlet jndi environment variables

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * It is better to use environment variables within a J2EE
 * context for values that can be changed a deployment time
 * instead of Context attributes within the web.xml.  This
 * way you don't have to update the web.xml to change the
 * values.
 *
 *
 <env-entry>
 <description>the guy responsible for this site</description>
 <env-entry-name>webmaster</env-entry-name>
 <env-entry-value>x@xxx</env-entry-value>
 <env-entry-type>java.lang.String</env-entry-type>
 </env-entry>
 */
public class AccessingServletJndiEnvironmentVariables extends HttpServlet {

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    String webMaster = null;
    try {
      // get a handle on the JNDI root context
      Context ctx = new InitialContext();

      // and access the environment variable for this web component
      webMaster = (String) ctx.lookup( "java:comp/env/webmaster" );
    }
    catch( NamingException ex ) {
      ex.printStackTrace();
    }

    pw.println( "the web master is -> " + webMaster );
  }
}
