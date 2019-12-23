Servlet destroy callback
  
 

package com.ack.web.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;

public class ServletDestroyCallback extends HttpServlet {
  private Connection connection;

  /**
   * implement the servlet
   */
  public void destroy() {
    /**
     * in this servlet destroy callback method
     * remember to clean up resource allocated and
     * managed by this servlet
     */
    try {
      // for example, if the servlet has a
      // dedicated SQL connection
      if( connection != null ) {
        // be sure to close it when the servlet is destroy
        connection.close();
      }
    }
    catch( SQLException sqle ) {
      // and report problems to the web server/servlet engine log files
      log( sqle.toString() );
    }
  }
}
