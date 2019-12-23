Servlet exception handler
  
 

package com.ack.web.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Map the location of the servlet to handle at error
 * with the supplied status code
 *
 <web-app>
 ...
 <error-page>
 <exception-type>javax.servlet.ServletException</exception-type>
 <location>/servlet/com.ack.web.servlet.ServletExceptionHandler</location>
 </error-page>
 </web-app>
 */
public class ServletExceptionHandler extends HttpServlet {
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    String exceptionType = getRequestAttribute( req,
                                                "javax.servlet.error.exception_type",
                                                "status code not supplied" );
    String errorMsg = getRequestAttribute( req,
                                           "javax.servlet.error.message",
                                           "error msg not supplied" );

    // exception attribute available as of servlet 2.3 API
    Object exception = req.getAttribute( "javax.servlet.error.exception" );

    pw.println( "<h1>Custom Exception Handler</h1>" );
    pw.println( "<h2>Exception type: " + exceptionType + "</h1>" );
    pw.println( "<h2>Exception Message: " + errorMsg + "</h1>" );
    pw.println( "<p>Problem accessing: " + req.getRequestURI() + "</p>" );

    // if we have the exception dump it out to the page
    if( exception != null ) {
      ByteArrayOutputStream bos = null;
      try {
        pw.println( "<p><hr noshade><p><pre>" );
        bos = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter( bos, true );
        ( (Exception) exception ).printStackTrace( writer );
        pw.println( bos.toString() );
      }
      finally {
        pw.println( "</pre>" );
        if( bos != null ) bos.close();
      }
    }

    // output date and time of error
    pw.println( "<p><hr><p>" );
    pw.println( new java.util.Date( System.currentTimeMillis() ) );
  }

  private String getRequestAttribute( HttpServletRequest req,
                                      String name,
                                      String defaultValue ) {
    Object value = req.getAttribute( name );
    return ( value != null ) ? value.toString() : defaultValue;
  }
}
