Reporter bean
  
 

package com.ack.j2ee.ejb.session;

import java.sql.Connection;
import java.sql.Statement;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;

public class ReporterBean implements SessionBean {

  private SessionContext sessionContext;

  public void makeStory( String criminal, boolean isGuilty ) {
    UserTransaction tx = null;
    Connection con = null;
    try {
      // create a user transaction
      tx = sessionContext.getUserTransaction();
      tx.begin();

      // get hold of a database connection
      Context ctx = new InitialContext();
      DataSource ds = (DataSource) ctx.lookup( "jdbc/gangland" );
      con = ds.getConnection();
      con.setAutoCommit( false );

      // perform the insert
      Statement stmt = con.createStatement();
      stmt.executeUpdate( "insert into enemies values ( '" + criminal + "')" );
      tx.commit();
    }
    catch( Exception ex ) {
      if( tx != null ) {
        try {
          tx.rollback();
        }
        catch( Exception nex ) {
          ex.printStackTrace();
        }
      }
    }
    finally {
      if( con != null ) {
        try {
          con.close();
        }
        catch( Exception ex ) {
          ex.printStackTrace();
        }
      }
    }
  }

  public void ejbCreate() throws CreateException {
  }

  public void ejbRemove() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void setSessionContext( SessionContext sessionContext ) {
    this.sessionContext = sessionContext;
  }

}
