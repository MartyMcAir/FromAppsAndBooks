Reading from an abstract resource
  
 

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

/**
 *
 * This class demonstrates how to view static resources
 * within a web application.  It is a URL based scheme
 * for reading resources within the web application.  This
 * makes it a more portable solution than the usual
 * getPathTranslated() technique that deals exclusively
 * with files.
 *
 * This class caters for web applications deployed as WAR
 * files and those that are distributed across machines.
 *
 * Note that this is not a production level implementation
 * and really opens up your web application to anyone.  It
 * is only meant as a demonstration of how to use
 * getServletContext().getResource() for reading resources
 * within a web application.
 *
 * Use As Follows:
 * http://<server>:<port>/<web-app>/servlet/<servlet path>/file_to_view
 *
 * For example to view my index.jsp page in my web apps root directory
 *
 * http://localhost:8080/ack/vf/index.jsp
 *
 * where /vf/* is mapped to the com.ack.web.servlet.ReadingFromAnAbstractResource
 */
public class ReadingFromAnAbstractResource extends HttpServlet {

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    ServletOutputStream os = res.getOutputStream();
    res.setContentType( "text/plain" );


    // get the resource
    String resourcePath = req.getPathInfo();
    if( resourcePath == null ) {
      res.sendError( HttpServletResponse.SC_NOT_FOUND );
      return;
    }

    System.out.println( "about to read resource -> " + resourcePath );

    // get resource as a url
    URL resourceUrl = getServletContext().getResource( resourcePath );
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
                     "unable to read resource: " + resourcePath );
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
                     "unable to send resource to client: " + resourcePath );
    }
  }
}
