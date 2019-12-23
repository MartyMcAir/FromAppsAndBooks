JSP Http servlet response wrapper
  
 

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * JSPHttpServletResponseWrapper is used to adapt the response of a servlet.
 * The wrappers sole responsibility is to create a JSPServletOutputStream
 * off the provided HttpServletResponse.  The JSPServletOutputStream is when
 * we can customize when is streamed back to the HTTP client.  The
 * JSPHttpServletResponseWrapper provides the infrastructural scaffolding to
 * plug into our specialising output stream.
 */

public class JSPHttpServletResponseWrapper extends HttpServletResponseWrapper {
  protected ServletOutputStream stream = null;
  protected PrintWriter writer = null;
  protected HttpServletResponse origResponse = null;

  public JSPHttpServletResponseWrapper( HttpServletResponse response ) {
    super( response );
    response.setContentType("text/plain");
    origResponse = response;
  }

  public ServletOutputStream createOutputStream()
      throws IOException {
    return ( new JSPServletOutputStream( origResponse ) );
  }

  public ServletOutputStream getOutputStream()
      throws IOException {
    if( writer != null ) {
      throw new IllegalStateException( "getWriter() has already been " +
                                       "called for this response" );
    }

    if( stream == null ) {
      stream = createOutputStream();
    }

    return stream;
  }

  public PrintWriter getWriter()
      throws IOException {
    if( writer != null ) {
      return writer;
    }

    if( stream != null ) {
      throw new IllegalStateException( "getOutputStream() has already " +
                                       "been called for this response" );
    }

    stream = createOutputStream();
    writer = new PrintWriter( stream );

    return writer;
  }
}
