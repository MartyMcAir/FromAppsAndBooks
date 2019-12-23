Trace message handler
  
 

package com.ack.webservices.soap.examples.lifestory;

import org.apache.axis.AxisFault;
import org.apache.axis.Message;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;

public class TraceMessageHandler extends BasicHandler {
  public void invoke( MessageContext msgContext ) throws AxisFault {
    try {
      System.out.println( "\n=========== trace message on " +
                          java.util.Calendar.getInstance().getTime()
                          + " =====================" );
      Message msg = msgContext.getCurrentMessage();
      msg.writeTo( System.out );
      System.out.println( "\n=================================================" );
    }
    catch( Exception e ) {
      throw AxisFault.makeFault( e );
    }
  }

  public void undo( MessageContext msgContext ) {
  }
}
