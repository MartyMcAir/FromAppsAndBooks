Handling form content

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlingFormContent extends HttpServlet {

  public void doPost( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();
    pw.println( "<h4>Form Results</h4>" );

    pw.println( "<p>query string: " + req.getQueryString() );
    pw.println( "<p>unspecified parameter: " + req.getParameter( "coldasice" ) );
    pw.println( "<p>GET parameter: " + req.getParameter( "done" ) );
    pw.println( "<p>POST parameter (textfield): " + req.getParameter( "textfield" ) );
    pw.println( "<p>POST multi-valued parameter (select): " );

    String[] values = req.getParameterValues( "select" );
    for( int i = 0; i < values.length; i++ ) {
      pw.println( values[i] );
    }
  }
}
