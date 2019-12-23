Create a servlet session

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateAServletSession extends HttpServlet {
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();
    pw.println( "<HTML><BODY>" );

    // get session, and create it if one doesn't already exist
    HttpSession theSession = req.getSession();

    // check if session is newly created
    if( theSession.isNew() ) {
      pw.println( "<P>Session: isNew</P>" );
    }
    else {
      pw.println( "<P>Session: Already Exists</P>" );
    }

    pw.println( "</BODY></HTML>" );
  }
}
