Working with images
  
 

package com.ack.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkingWithImages extends HttpServlet {
  private int counter;

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    ServletOutputStream os = res.getOutputStream();
    res.setContentType( "image/bmp" );

    // where possible, tell the client how big the file is
    res.setContentLength( 3936256 );

    // get resource as a url
    URL resourceUrl = getServletContext().getResource( "/images/large.bmp" );
    if( resourceUrl == null ) {
      res.sendError( HttpServletResponse.SC_NOT_FOUND );
      return;
    }

    // open connection to resource
    URLConnection con = null;
    try {
      con = resourceUrl.openConnection();
      con.connect();
    }
    catch( IOException ioe ) {
      res.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                     "unable to read resource: /images/large.bmp" );
    }

    // send resource contents back down output stream
    try {
      InputStream is = con.getInputStream();
      byte[] buf = new byte[8096];
      int bytesRead;
      while( ( bytesRead = is.read( buf ) ) != -1 ) {
        os.write( buf, 0, bytesRead );
      }
    }
    catch( IOException ioe ) {
      res.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                     "unable to send resource to client: /image/large.bmp" );
    }
  }
}
