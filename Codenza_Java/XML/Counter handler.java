Counter handler

package com.ack.webservices.soap.examples.handlers;

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;

public class CounterHandler extends BasicHandler {
  public void invoke( MessageContext msgContext ) throws AxisFault {
    try {
      String thePrefix = (String) getOption( "prefix" );
      Integer accessCount = (Integer) msgContext.getProperty( "accesses" );
      if( accessCount == null ) {
        accessCount = new Integer( 1 );
      }
      else {
        accessCount = new Integer( accessCount.intValue() + 1 );
      }
      msgContext.setProperty( "accesses", accessCount );
      System.out.println( thePrefix + " " + accessCount );
    }
    catch( Exception e ) {
      throw AxisFault.makeFault( e );
    }
    System.out.println( "hash code for counter: " + hashCode() );
  }

  public void undo( MessageContext msgContext ) {
  }
}
