DbInfo

package com.ack.j2ee.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * A simple utility class that dumps out useful information
 * about a database that is access through JDBC
 *
 */
public class DbInfo {
  private DatabaseMetaData dbMetaData;

  /**
   * construct a DbInfo object from a Connection object
   *
   * @param con a JDBC Connection
   * @exception SQLException reports errors that occurred getting the
   * database metadata information off the supplied Connection
   */
  public DbInfo( Connection con ) throws SQLException {
    dbMetaData = con.getMetaData();
  }

  /**
   * get a dump of information about the database from a JDBC Connection
   *
   * @return a string holding information on the database
   * @exception SQLException reports problems extract database information from the
   * JDBC DatabaseMetaData object
   */
  public String getInfo() throws SQLException {
    StringBuffer buf = new StringBuffer();
    buf.append( "Database Name: " + dbMetaData.getDatabaseProductName() + "\n" );
    buf.append( "Database Version: " + dbMetaData.getDatabaseProductVersion() + "\n" );
    buf.append( "Driver Name: " + dbMetaData.getDriverName() + "\n" );
    buf.append( "Database Name: " + dbMetaData.getDriverVersion() + "\n" );
    buf.append( "Maximum number of active connections: " + dbMetaData.getMaxConnections() + "\n" );
    buf.append( "Get database URL: " + dbMetaData.getURL() + "\n" );
    return buf.toString();
  }
}
