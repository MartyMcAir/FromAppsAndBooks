Sending errors
  
 

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendingErrors extends HttpServlet {

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    // response buffer is cleared before error is sent
    pw.println( "this text will be cleared and not sent to the client" );

    // send error status back to client
    res.sendError( res.SC_INTERNAL_SERVER_ERROR,
                   "application error - we're stumped!" );

    // but this line is executed; use 'return' where appropriate
    pw.println( "however, this is line is executed and sent to client" );
  }

}
