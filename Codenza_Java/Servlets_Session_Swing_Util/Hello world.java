Hello world

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HelloWorld servlet
 */
public class HelloWorld extends HttpServlet {
  /**
   * HTTP GET requests result in this doGet() method getting called and
   * the incoming request and outgoing response objects passed in
   */
  public void doGet( HttpServletRequest request, HttpServletResponse response )
      throws ServletException, IOException {
    response.setContentType( "text/html" );

    // get a handle on the output stream
    // used to send stuff back to the calling client
    PrintWriter out = response.getWriter();

    // and then output what you want to send
    out.println( "hello world" );
  }
}
