Get servlet session time info

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetServletSessionTimeInfo extends HttpServlet {
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();
    pw.println( "<HTML><BODY>" );

    // get session, and create it if one doesn't already exist
    HttpSession theSession = req.getSession();

    // get session id and it's max lifetime in seconds
    pw.println( "<BR>Session Id: " + theSession.getId() );
    pw.println( "<BR>Session Max Inactive Time (seconds): "
                + theSession.getMaxInactiveInterval() );

    // get creation time
    long dateTimes = theSession.getCreationTime();
    pw.println( "<BR>Session Creation Time: " + new Date( dateTimes ) );

    // get last access time, negative if never been accessed
    dateTimes = theSession.getLastAccessedTime();
    if( dateTimes < 0 ) {
      pw.println( "<BR>Session Last Access Time: Never Been Access Befored" );
    }
    else {
      pw.println( "<BR>Session Last Access Time: " + new Date( dateTimes ) );
    }

    pw.println( "</BODY></HTML>" );
  }
}
