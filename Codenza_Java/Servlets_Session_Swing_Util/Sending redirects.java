Sending redirects
  
 

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendingRedirects extends HttpServlet {
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    pw.println( "going to do a redirect" );

    // content before the redirect is ignored

    // redirect to the web site
    res.sendRedirect( "http://www.sun.com" );

    // do not output anything after a redirect
    // it will not cause an error, but the sendRedirect()
    // outputs content to the response body that provides
    // enables those client that do not get automatically
    // redirected with a link to get them there!
  }
}
