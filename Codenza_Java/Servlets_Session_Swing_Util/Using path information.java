Using path information
  
 

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * For the web application, named 'ack' this servlet
 * outputted the following when run on our machines
 * with the URL:
 *
 * http://localhost:8080/ack/servlet/
 *          com.ack.web.servlet.UsingPathInformation/images/hey.gif
 *
 * URL Path: /images/hey.gif
 * Physical Path: E:\servlets\ack\images\hey.gif
 * Resource Path: E:\servlets\ack\index.jsp
 * Web Application Path: /ack
 *
 */
public class UsingPathInformation extends HttpServlet {

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    // work with extra path information
    if( req.getPathInfo() != null ) {
      pw.println( "<br>URL Path: " + req.getPathInfo() );
      pw.println( "<br>Physical Path: " + req.getPathTranslated() );
    }
    else {
      pw.println( "<br>No extra path information" );
    }

    // get physical path of something without extra path information
    pw.println( "<br>Resource Path: " +
                getServletContext().getRealPath( "/index.jsp" ) );

    // get the URL path of the current web application
    pw.println( "<br>Web Application Path: " + req.getContextPath() );

  }
}
