Handling invalid sessions

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HandlingInvalidSessions extends HttpServlet {
  public void goGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();
    pw.println( "<HTML><BODY>" );

    HttpSession theSession = req.getSession();

    try {
      Object obj = theSession.getAttribute( "counter" );

      /**
       * the above call will throw an IllegalStateException
       * if theSession has been invalidated (e.g. by the
       * container or by another servlet)
       *
       * a defensive servlet programmer should wrap all accesses
       * to a servlet session (not just getAttribute()) in a
       * try/catch block so that they can take the appropriate
       * action to handle the case where a session is destroyed
       * at anytime
       */
    }
    catch( IllegalStateException ise ) {
      // handle invalid session here
    }

    pw.println( "</BODY></HTML>" );
  }
}
