Updating session items
  
 

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdatingSessionItems extends HttpServlet {
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();
    pw.println( "<HTML><BODY>" );

    HttpSession theSession = req.getSession();

    // updated a named item in the session
    synchronized( theSession ) {
      /**
       * when updating items within a session object, you must
       * ensure that you have exclusive access to session object
       * by first synchronizing on the session
       */
      Integer counter = (Integer) theSession.getAttribute( "counter" );

      if( counter == null ) {
        theSession.setAttribute( "counter", new Integer( 1 ) );
      }
      else {
        theSession.setAttribute( "counter", new Integer( counter.intValue() + 1 ) );
      }

      pw.println( "<BR>" + counter );
      /**
       * also note that items inside your session object should really
       * be serializable to ensure that your session can scale within
       * a clustered environment
       */
    }

    pw.println( "</BODY></HTML>" );
  }
}
