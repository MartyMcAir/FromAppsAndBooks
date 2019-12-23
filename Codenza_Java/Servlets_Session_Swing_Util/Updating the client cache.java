Updating the client cache
  
 

package com.ack.web.servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatingTheClientCache extends HttpServlet {
  private Date lastUpdate;

  public void init() {
    lastUpdate = new Date( System.currentTimeMillis() );
  }

  /**
   * This will see the server stuffing the Last-Modified header
   * into the response that is used by the client during
   * page reloads to check whether content on the server has
   * changed.
   *
   * Refer to how the If-Modified-Since and Last-Modified
   * headers used within the HTTP protocol
   *
   */
  public long getLastModified( HttpServletRequest req ) {
    // round time down to the last second
    return lastUpdate.getTime() / 1000 * 1000;
  }

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    boolean needToUpdate = false;

    // process some work

    if( needToUpdate ) {
      synchronized( this ) {
        lastUpdate = new Date( System.currentTimeMillis() );
      }
    }

    res.getWriter().println( "done some work" );
  }
}
