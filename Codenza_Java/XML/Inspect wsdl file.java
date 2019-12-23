Inspect wsdl file

package com.ack.webservices.wsdl;

import java.util.Map;
import javax.wsdl.Definition;
import javax.wsdl.Types;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

public class InspectWsdlFile {
  public static void main( String[] args ) throws Exception {
    // get hold the WSDLFactory
    WSDLFactory factory = WSDLFactory.newInstance();

    // create an object to read the WSDL file
    WSDLReader reader = factory.newWSDLReader();

    // pass the URL to the reader for parsing and get back a WSDL definiton
    Definition wsdlInstance
        = reader.readWSDL( null, "xxx" );

    // get a map of the five specific parts a WSDL file
    Types types = wsdlInstance.getTypes();
    Map messages = wsdlInstance.getMessages();
    Map portTypes = wsdlInstance.getPortTypes();
    Map bindings = wsdlInstance.getBindings();
    Map services = wsdlInstance.getServices();

    /**
     * perform lookup of types, messages, portTypes, bindings and services
     */
  }
}
