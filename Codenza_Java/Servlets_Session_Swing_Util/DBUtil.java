DBUtil

package com.ack.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Provides utilities for database access
 */
public class DBUtil {
  /**
   * Produces a string representation of a complete result set
   * @param rs The ResultSet to be displayed
   * @return The string representation
   * @throws SQLException to indicate a problem with the ResultSet
   */
  public static String dumpResultSet( ResultSet rs ) throws SQLException {
    StringBuffer buf = new StringBuffer();
    if( rs != null ) {
      ResultSetMetaData rsmd = rs.getMetaData();
      int columnCount = rsmd.getColumnCount() + 1;
      for( int i = 1; i < columnCount; i++ ) {
        buf.append( rsmd.getColumnLabel( i ) );
        buf.append( "  " );
      }
      buf.append( "\n===========================================\n" );

      while( rs.next() ) {
        for( int i = 1; i < columnCount; i++ ) {
          buf.append( rs.getObject( i ) );
          buf.append( "  " );
        }
        buf.append( "\n" );
      }
    }
    return buf.toString();
  }

  /**
   * create a list of map objects.  each map object represents a row within the
   * supplied result set that is key against the column name
   *
   * @return List the list of map objects for each row in the ResultSet
   * @param rs the ResultSet to extract the data from
   * @throws SQLException report database problems extracting details from the ResultSet
   */
  public static List buildListOfMapRecords( ResultSet rs )
      throws SQLException {
    List l = new LinkedList();
    if( rs != null ) {
      ResultSetMetaData rsmd = rs.getMetaData();
      int columnCount = rsmd.getColumnCount() + 1;
      while( rs.next() ) {
        Map map = new HashMap();
        for( int i = 1; i < columnCount; i++ ) {
          map.put( rsmd.getColumnLabel( i ), rs.getObject( i ) );
        }
        l.add( map );
      }
    }
    return l;
  }
}
