Include a servlet

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IncludeAServlet extends HttpServlet {

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    pw.println( "<h1>The Including Servlet</h1>" );
    pw.println( "<br>request uri: " + req.getRequestURI() );
    pw.println( "<br>servlet path: " + req.getServletPath() );
    pw.println( "<br>path info: " + req.getPathInfo() );
    pw.println( "<br>query string: " + req.getQueryString() );
    pw.println( "<p><hr><p>" );

    RequestDispatcher rd
        = getServletContext().
        getRequestDispatcher( "/includeme/marvin/gaye?billy=idol" );

    rd.include( req, res );
  }
}
