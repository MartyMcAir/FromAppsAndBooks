Destroy a servlet session

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DestroyAServletSession extends HttpServlet {
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();
    pw.println( "<HTML><BODY>" );

    // get current session, and don't create one if it doesn't exist
    HttpSession theSession = req.getSession( false );

    // print out the session id
    if( theSession != null ) {
      pw.println( "<BR>Session Id: " + theSession.getId() );
      synchronized( theSession ) {
        // invalidating a session destroys it
        theSession.invalidate();
        pw.println( "<BR>Session destroyed" );
      }
    }

    pw.println( "</BODY></HTML>" );
    pw.close();
  }
}
