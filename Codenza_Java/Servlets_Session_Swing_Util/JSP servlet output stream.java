JSP servlet output stream
  
 

package com.ack.web.servlet;

import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * In the ServletOutputStream all methods converge on the write(int)
 * output method.  So it is this method that we override to customise
 * what is sent back to an HTTP client that uses the JSPServletOutputStream.
 *
 * In this case we simply replace '<' with '[' and '>' with ']', each
 * with ascii values 60, 91, 62, 93 respectively.
 *
 */
public class JSPServletOutputStream extends ServletOutputStream {
  private HttpServletResponse delegate;

  public JSPServletOutputStream( HttpServletResponse hss ) {
    delegate = hss;
  }

  public void write( int c ) throws IOException {
    if( c == 60 ) {
      delegate.getOutputStream().write( 91 );
    }
    else if( c == 62 ) {
      delegate.getOutputStream().write( 93 );
    }
    else {
      delegate.getOutputStream().write( c );
    }
  }
}
