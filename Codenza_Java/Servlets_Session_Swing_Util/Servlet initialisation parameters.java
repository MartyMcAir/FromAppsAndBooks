Servlet initialisation parameters
  
 

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * initialisation parameters inside the web.xml file
 <servlet>
 <servlet-name>initialisation</servlet-name>
 <servlet-class>com.ack.web.servlet.ServletInitialisationParameters</servlet-class>
 <init-param>
 <param-name>jdbcurl</param-name>
 <param-value>someurl</param-value>
 </init-param>
 <init-param>
 <param-name>password</param-name>
 <param-value>bah</param-value>
 </init-param>
 <init-param>
 <param-name>username</param-name>
 <param-value>foo</param-value>
 </init-param>
 </servlet>
 */
public class ServletInitialisationParameters extends HttpServlet {
  public void init() throws ServletException {
    String jdbcURL = getInitParameter( "jdbcurl" );
    String username = getInitParameter( "username" );
    String password = getInitParameter( "password" );

    try {
      if( jdbcURL == null || username == null || password == null ) {
        StringBuffer buf = new StringBuffer( "you must specify the " );
        buf.append( " 'jdbcurl', 'username', 'password' init params to -> " );
        buf.append( getClass().getName() + " within you web.xml file" );
        String msg = buf.toString();
        System.out.println( buf );
//        log( msg );
//        throw new ServletException( msg );
      }
      else {
        // possible get connection to database
      }
    }
    catch( Exception ex ) {
      log( ex.toString() );
      throw new ServletException( ex.toString() );
    }
    finally {
      // do any clean-up if you need to
    }

    log( "Completed Initialisation ->" + getClass().getName() );
  }

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    pw.println( "<h3>Servlet Initialisation Parameters</h3>" );
    pw.println( "<p><hr noshade><p>" );
    Enumeration e = getInitParameterNames();
    while( e.hasMoreElements() ) {
      String paramName = (String) e.nextElement();
      pw.println( "Initialisation Parameter: [ " );
      pw.println( paramName + " = " + getInitParameter( paramName ) );
      pw.println( " ]<br>" );
    }
  }

}
