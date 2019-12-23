Bean util

package com.ack.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * utility class for dealing with java beans
 */
public class BeanUtil {
  /**
   * dumps the properties names and values of a bean
   * into a string
   * @param bean the JavaBean to be intropected
   * @return String a dump of the property names and values
   */
  public static String toString( Object bean ) {
    StringBuffer buf = new StringBuffer();
    if( bean != null ) {
      try {
        BeanInfo binfo = Introspector.getBeanInfo( bean.getClass() );
        PropertyDescriptor[] properties = binfo.getPropertyDescriptors();
        if( properties != null ) {
          for( int i = 0; i < properties.length; i++ ) {
            Method readMethod = properties[i].getReadMethod();
            if( readMethod != null ) {
              buf.append( properties[i].getName() );
              buf.append( " = " );
              Object obj = readMethod.invoke( bean, null );
              if( obj != null ) {
                buf.append( obj.toString() );
              }
              else {
                buf.append( "<empty>" );
              }
              buf.append( "\n" );
            }
          }
        }
      }
      catch( Exception e ) {
        // ignore exceptions thrown, this is a development aid
      }
    }
    return buf.toString();
  }
}
