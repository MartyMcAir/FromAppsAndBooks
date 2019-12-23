Accessing session items

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccessingSessionItems extends HttpServlet {
  public void goGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();
    pw.println( "<HTML><BODY>" );

    HttpSession theSession = req.getSession();

    // get a named item out of the session
    Object obj = theSession.getAttribute( "power" );
    pw.println( "<BR>" + obj );

    // get all the items out of the session
    Enumeration attributeNames = theSession.getAttributeNames();
    while( attributeNames.hasMoreElements() ) {
      String attributeName = (String) attributeNames.nextElement();
      obj = theSession.getAttribute( attributeName );
      pw.println( "<BR>" + attributeName + " = " + obj );
    }

    pw.println( "</BODY></HTML>" );
  }
}
