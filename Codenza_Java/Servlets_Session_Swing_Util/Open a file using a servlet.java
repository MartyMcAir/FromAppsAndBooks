Open a file using a servlet
  
 

package com.ack.web.servlet;

import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenAFileUsingAServlet extends HttpServlet {
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    String webAppPath = getServletContext().getRealPath( "" );
    String webXMLFile = getServletContext().getRealPath( "/WEB-INF/web.xml" );
    FileReader fr = new FileReader( webXMLFile );
    for( int c = fr.read(); c != -1; c = fr.read() ) {
      System.out.print( (char) c );
    }

    res.getWriter().println( "check the console!" );
  }
}
