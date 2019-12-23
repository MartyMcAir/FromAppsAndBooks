Simple download
  
 

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

public class SimpleDownload extends HttpServlet {

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "application/msword" );
    res.setHeader( "Content-Disposition",
                   "Attachment; Filename=testdoc.doc" );
    ServletOutputStream os = res.getOutputStream();


    // get resource as a url
    URL resourceUrl = getServletContext().getResource( "/download/testdoc.doc" );

    // open connection to resource
    URLConnection con = null;
    try {
      con = resourceUrl.openConnection();
      con.connect();
    }
    catch( IOException ioe ) {
      res.sendError( HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                     "unable to read resource: /download/testdoc.doc" );
    }

    // set the actual content type in; must check that its non-null
    String contentType = con.getContentType();
    if( contentType != null ) {
      res.setContentType( contentType );
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
                     "unable to send resource to client: /download/testdoc.doc" );
    }
  }
}
