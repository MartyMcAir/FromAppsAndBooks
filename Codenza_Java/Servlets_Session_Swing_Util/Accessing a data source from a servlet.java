Accessing a data source from a servlet

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * web.xml configuration part of the a data source
 *
 *  <web-app>
 ...
 <resource-ref>
 <description>the database for this app</description>
 <res-ref-name>jdbc/thedatabase</res-ref-name>
 <res-type>javax.sql.DataSource</res-type>
 <res-auth>CONTAINER</res-auth>
 </resource-ref>
 ...
 </web-app>
 *
 * the vendor-specific mapping of the res-ref-name into their
 * own application server space, eg weblogic does the following
 * in a weblogic.xml file
 *
 <weblogic-web-app>
 ...
 <reference-descriptor>
 ...
 <resource-description>
 <res-ref-name>jdbc/thedatabase</res-ref-name>
 <jndi-name>jdbc/gangland</jndi-name>
 </resource-description>
 ...
 </reference-descriptor>
 ...
 </weblogic-web-app>
 */

public class AccessingADataSourceFromAServlet extends HttpServlet {

  public void init() {
    System.out.println( "### loading -> " + getServletName() + " at " +
                        new Date( System.currentTimeMillis() ).toString() );

  }

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    Connection con = null;
    try {
      Context ctx = new InitialContext();
      DataSource ds = (DataSource) ctx.lookup( "java:comp/env/jdbc/thedatabase" );
      con = ds.getConnection();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery( "select * from enemies" );
      while( rs.next() ) {
        pw.println( rs.getString( "name" ) + "<br>" );
      }
    }
    catch( Exception ex ) {
      log( "problem accessing database", ex );
      res.sendError( res.SC_INTERNAL_SERVER_ERROR, ex.getMessage() );
    }
    finally {
      if( con != null ) {
        try {
          con.close();
        }
        catch( SQLException ex ) {
          log( "problem closing connection", ex );
        }
      }
    }
  }
}
