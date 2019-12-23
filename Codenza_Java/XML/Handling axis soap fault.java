Handling axis soap fault

package com.ack.webservices.soap;

import javax.xml.namespace.QName;

import org.apache.axis.AxisFault;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class HandlingAxisSoapFault {
  public static void main( String[] args ) throws Exception {
    // the receiving soap node
    String endpoint = "http://nagoya.apache.org:5049/axis/servlet/AxisServlet";

    // set a SOAP call
    try {
      Service service = new Service();
      Call call = (Call) service.createCall();
      call.setTargetEndpointAddress( new java.net.URL( endpoint ) );
      call.setOperationName( new QName( "http://soapinterop.org/", "invalidOperationName" ) );
      call.invoke( new Object[]{"Hello!"} );
    }
    catch( AxisFault af ) {
      /**
       * The AxisFault exception maps cleanly onto the SOAPFault
       * as of SOAP version 1.1
       */
      System.out.println( "fault code: " + af.getFaultCode() );
      System.out.println( "fault string: " + af.getFaultString() );
      System.out.println( "fault details: " + af.getFaultDetails() );
      System.out.println( "fault actor: " + af.getFaultActor() );
      // or you could simple dumpt out the exception using
      // af.dump()
    }
  }
}
