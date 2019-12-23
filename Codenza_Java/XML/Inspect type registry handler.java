Inspect type registry handler

package com.ack.webservices.soap.examples.handlers;

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.encoding.TypeMappingRegistry;
import org.apache.axis.handlers.BasicHandler;

public class InspectTypeRegistryHandler extends BasicHandler {
  public void invoke( MessageContext msgContext ) throws AxisFault {
    try {
      /**
       * get hold of the type mapping registry from the message context
       * and use the very useful axis dump method ( not
       */
      TypeMappingRegistry registry = msgContext.getTypeMappingRegistry();
      if( registry != null ) {
        System.out.println( registry.toString() );
      }
    }
    catch( Exception e ) {
      throw AxisFault.makeFault( e );
    }
  }

  public void undo( MessageContext msgContext ) {
  }
}
