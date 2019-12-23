Servlet error handler
  
 

package com.ack.web.servlet;

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
 <error-code>404</error-code>
 <location>/servlet/com.ack.web.servlet.ServletErrorHandler</location>
 </error-page>
 </web-app>
 */
public class ServletErrorHandler extends HttpServlet {
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    String statusCode = getRequestAttribute( req,
                                             "javax.servlet.error.status_code",
                                             "status code not supplied" );
    String errorMsg = getRequestAttribute( req,
                                           "javax.servlet.error.message",
                                           "error msg not supplied" );

    pw.println( "<h1>Error Code: " + statusCode + "</h1>" );
    pw.println( "<h2>Error Message: " + errorMsg + "</h1>" );
    pw.println( "<p>Problem accessing: " + req.getRequestURI() + "</p>" );
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
