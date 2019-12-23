TimerClient
  
 

package com.ack.webservices.soap.examples.handlers;

import java.util.Calendar;
import java.util.Date;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class TimerClient {
  public static void main( String[] args ) throws Exception {
    String endpoint = "http://localhost:8080/axis/services/TimerService";

    /**
     * call the getTime to find out the time on the server
     */

    // calls are created our a service, that is typically associated,
    // but not necessarily, with a WSDL file
    Service service = new Service();
    Call call = (Call) service.createCall();

    // set in the target endpoint, operation name, and request intent
    call.setTargetEndpointAddress( new java.net.URL( endpoint ) );
    call.setOperationName( "getTime" );

    // Axis provides a nicely overloaded invoke that delivered the return value
    Date ret = (Date) call.invoke( new Object[]{} );

    // then just print it out
    System.out.println( "time on server: " + ret );

    /**
     * call the sendTime to pass the time on the client to the server
     * note: check the soap server's console for the output.
     *
     * note: Be sure to check what is returned to the client from the server
     * when an invokeOneWay() is called.  Do this be uses the TraceMessageHandler
     * in the <responseFlow> of the TimeService.
     */

    call = (Call) service.createCall();

    // set in the target endpoint, operation name, and request intent
    call.setTargetEndpointAddress( new java.net.URL( endpoint ) );
    call.setOperationName( "sendTime" );

    // send the time on the client to the server, in a one way method call
    Date clientDate = Calendar.getInstance().getTime();
    call.invokeOneWay( new Object[]{clientDate} );
  }
}
