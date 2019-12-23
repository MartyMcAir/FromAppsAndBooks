Receive servlet forward
  
 

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * The receiving servlet of a forward, can have a different
 * uri path, servlet path, path info and query string to the
 * servlet that did the forward in the first place.
 */
public class ReceiveServletForward extends HttpServlet {

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    pw.println( "<br>request attr: " + req.getAttribute( "hello" ) );
    pw.println( "<br>request uri: " + req.getRequestURI() );
    pw.println( "<br>servlet path: " + req.getServletPath() );
    pw.println( "<br>path info: " + req.getPathInfo() );
    pw.println( "<br>query string: " + req.getQueryString() );

  }
}
