An included servlet

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnIncludedServlet extends HttpServlet {

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    PrintWriter pw = res.getWriter();

    /**
     * note that a servlet that has been included within another
     * servlet has access to both the original request uri, servlet
     * path, path info, context path and query string through the
     * HttpServletRequest object.
     *
     * However it also has access to these values that can be different
     * depending on how the servlet include was dispatched.  The servlet
     * engine gives you access to these though request attributes as
     * demonstrated before.
     */

    pw.println( "<h1>The Included Servlet</h1>" );
    pw.println( "<br>request uri: " +
                req.getAttribute( "javax.servlet.include.request_uri" ) );
    pw.println( "<br>context path: " +
                req.getAttribute( "javax.servlet.include.context_path" ) );
    pw.println( "<br>servlet path: " +
                req.getAttribute( "javax.servlet.include.servlet_path" ) );
    pw.println( "<br>path info: " +
                req.getAttribute( "javax.servlet.include.path_info" ) );
    pw.println( "<br>query string: " +
                req.getAttribute( "javax.servlet.include.query_string" ) );
  }
}
