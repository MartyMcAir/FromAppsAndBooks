Servlet information
  
 

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletInformation extends HttpServlet {
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    pw.println( "<h3>Servlet Information</h3>" );
    pw.println( "<p><hr noshade><p>" );

    pw.println( "<br>Servlet Path: " + req.getServletPath() );
    pw.println( "<br>Servlet Info: " + getServletInfo() );
  }

  // implement this method to inform others
  // what you're all about - very important and often overlooked
  public String getServletInfo() {
    return "I am a nice servlet, and this is my story...";
  }
}
