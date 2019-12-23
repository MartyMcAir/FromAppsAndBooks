Server information
  
 

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServerInformation extends HttpServlet {

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    pw.println( "<h3>Server Information</h3>" );
    pw.println( "<p><hr noshade><p>" );

    pw.println( "<br>Server Information: " + getServletContext().getServerInfo() );
    pw.println( "<br>Servlet API Version: " +
                getServletContext().getMajorVersion() + "." +
                getServletContext().getMinorVersion() );
    pw.println( "<br>Server Name: " + req.getServerName() );
    pw.println( "<br>Server Port: " + req.getServerPort() );
  }
}
