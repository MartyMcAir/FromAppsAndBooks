Handling apache soap fault

package com.ack.webservices.soap;

import java.net.URL;
import java.util.Vector;

import org.apache.soap.Constants;
import org.apache.soap.Fault;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;

public class HandlingApacheSoapFault {
  public static void main( String[] args ) throws Exception {
    // soap service endpoint
    URL url = new URL( "http://services.xmethods.com:80/soap/servlet/rpcrouter" );
    Call call = new Call();
    call.setEncodingStyleURI( Constants.NS_URI_SOAP_ENC );
    call.setTargetObjectURI( "urn:xmethods-Temperatures" );

    // try calling an invalid method
    call.setMethodName( "nogetTemp" );

    Vector params = new Vector();
    params.addElement( new Parameter( "zipcode", String.class, "94041", null ) );
    call.setParams( params );
    Response resp = call.invoke( url, "" );

    // and evaluate the response
    if( resp.generatedFault() ) {
      // get the SOAP fault and dump it out
      Fault soapFault = resp.getFault();
      System.out.println( soapFault );

      // or peel out the parts of the SOAP fault one by one
      System.out.println( "fault code: " + soapFault.getFaultCode() );
      System.out.println( "fault string: " + soapFault.getFaultString() );
      System.out.println( "fault details: " + soapFault.getDetailEntries() );
      System.out.println( "fault actor: " + soapFault.getFaultActorURI() );
    }
    else {
      // do something useful with your response
    }
  }
}
