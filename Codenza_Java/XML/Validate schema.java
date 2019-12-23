Validate schema
  
 

package com.ack.xml.jdom;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ValidateSchema {
  public static void main( String[] args ) {
    SAXBuilder builder = new SAXBuilder( "org.apache.xerces.parsers.SAXParser" );
    //DOMBuilder builder = new DOMBuilder( "org.apache.xerces.parsers.DOMParser" );
    builder.setValidation( true );
    builder.setFeature( "http://apache.org/xml/features/validation/schema", true );

    // command line should offer URIs or file names
    try {
      Document doc = builder.build( "E:\\projects\\smsgateway\\vertis_sms\\config\\vertismsg.xml" );
    }
    catch( JDOMException e ) {
      System.out.println( e.getMessage() );
    }
  }
}
