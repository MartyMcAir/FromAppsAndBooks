StringUtil
  
 

package com.ack.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Utilities for handling strings
 */
public class StringUtil {

  /**
   * Strips a string of white space
   * @return String with trailing white spaces removed, or null
   * if they are no remaining characters
   * @param value String to be trimmed
   */
  public static String trim( String value ) {
    if( value != null ) {
      value = value.trim();
      if( value.length() == 0 ) {
        value = null;
      }
    }
    return value;
  }


  /**
   * Replacement utility - substitutes <b>all</b> occurrences of 'src' with 'dest' in the string 'name'
   * @param name the string that the substitution is going to take place on
   * @param src the string that is going to be replaced
   * @param dest the string that is going to be substituted in
   * @return String with the substituted strings
   */
  public static String substitute( String name, String src, String dest ) {
    if( name == null || src == null || name.length() == 0 ) {
      return name;
    }

    if( dest == null ) {
      dest = "";
    }

    int index = name.indexOf( src );
    if( index == -1 ) {
      return name;
    }

    StringBuffer buf = new StringBuffer();
    int lastIndex = 0;
    while( index != -1 ) {
      buf.append( name.substring( lastIndex, index ) );
      buf.append( dest );
      lastIndex = index + src.length();
      index = name.indexOf( src, lastIndex );
    }
    buf.append( name.substring( lastIndex ) );
    return buf.toString();
  }

  /**
   * Converts an exception into a string
   * @param t the exception to be converted
   * @return String a string representation of the exception
   */
  public static String exceptionToString( Throwable t ) {
    if( t != null ) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter( sw );
      pw.println( t.getMessage() );
      pw.println( "\n=====================\n" );
      t.printStackTrace( pw );
      pw.println( "\n=====================\n" );
      pw.close();
      return sw.toString();
    }
    else {
      return "";
    }
  }
}
