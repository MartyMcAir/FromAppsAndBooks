Servlet counter
  
 

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCounter extends HttpServlet {
  private int instanceCount;
  private static int classCount;

  // process the HTTP get request
  public void doGet( HttpServletRequest request, HttpServletResponse response )
      throws ServletException, IOException {
    response.setContentType( "text/html" );
    PrintWriter out = new PrintWriter( response.getOutputStream() );
    out.println( "<html>" );
    out.println( "<head><title>ServletCounter</title></head>" );
    out.println( "<body>" );
    out.println( "<h3>Hit the browser refresh button!<br>" );
    out.println( "On 10, you'll get an exception, hit refresh again</h3>" );
    out.println( "<p><hr noshade><p>" );

    // when you get to 10, throw exception to cause the
    // this servlet instance to be destroyed and reloaded
    if( instanceCount > 0 && ( instanceCount / 10 ) > 0 ) {
      instanceCount = 0;
      throw new ServletException( "Hit Refresh Again" );
    }

    // synchronize on the servlet instance before updating the counter
    synchronized( this ) {
      // number of times this servlet instance has been accessed
      out.println( "<br>Servlet Instance Count -> " + instanceCount++ );
    }

    // sychronize on the servlet class before updating the class-based counter
    synchronized( ServletCounter.class ) {
      // collective total of all accesses to all servlet instances created
      // by this class
      out.println( "<br>Servlet Total Request Count -> " + classCount++ );
    }

    out.println( "</body></html>" );
    out.close();
  }
}
