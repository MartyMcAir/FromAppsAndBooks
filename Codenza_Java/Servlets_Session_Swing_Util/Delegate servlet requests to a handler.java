Delegate servlet requests to a handler

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelegateServletRequestsToAHandler extends HttpServlet {
  /**
   * write a method to handle HTTP requests made on the servlet
   */
  public void handleRequest( HttpServletRequest req,
                             HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    // output what type of HTTP request was made on the servlet
    pw.println( "HTTP Request Method -> " + req.getMethod() );
  }

  // delegate HTTP GETs to the handler method
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    handleRequest( req, res );
  }

  // delegate HTTP POSTs to the handler method
  public void doPost( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    handleRequest( req, res );
  }
}
