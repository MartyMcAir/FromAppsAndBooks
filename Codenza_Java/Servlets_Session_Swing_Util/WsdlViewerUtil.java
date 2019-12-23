WsdlViewerUtil
  
 

package com.ack.webservices.wsdl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.wsdl.Binding;
import javax.wsdl.Definition;
import javax.wsdl.Operation;
import javax.wsdl.Port;
import javax.wsdl.PortType;
import javax.wsdl.Service;
import javax.xml.namespace.QName;

public class WsdlViewerUtil {

  public static String viewServices( Definition wsdlDefinition ) {
    Map services = wsdlDefinition.getServices();
    Set serviceKeys = services.keySet();
    StringBuffer buf = new StringBuffer();
    for( Iterator it = serviceKeys.iterator(); it.hasNext(); ) {
      QName serviceKey = (QName) it.next();
      String serviceView = WsdlViewerUtil.viewService( (Service) services.get( serviceKey ) );
      buf.append( serviceView );
      buf.append( "\n" );
    }
    return buf.toString();
  }

  public static String viewService( Service wsdlService ) {
    StringBuffer buffer = new StringBuffer( "Service: " );
    buffer.append( wsdlService.getQName().getLocalPart() );
    buffer.append( "\n  Service Namespace: " );
    buffer.append( wsdlService.getQName().getNamespaceURI() );
    buffer.append( "\n" );

    Map ports = wsdlService.getPorts();
    Set portKeys = ports.keySet();
    for( Iterator it = portKeys.iterator(); it.hasNext(); ) {
      String portKey = (String) it.next();
      String portView = WsdlViewerUtil.viewPort( (Port) ports.get( portKey ) );
      buffer.append( portView );
      buffer.append( "\n" );
    }
    return buffer.toString();
  }

  public static String viewPort( Port wsdlPort ) {
    StringBuffer buffer = new StringBuffer( "Port: " );
    buffer.append( wsdlPort.getName() );

    Binding wsdlBinding = wsdlPort.getBinding();
    buffer.append( "\nBinding: " );
    buffer.append( wsdlBinding.getQName() );

    PortType portType = wsdlBinding.getPortType();
    buffer.append( "\nPortType: " + portType.getQName() );

    List operations = portType.getOperations();
    buffer.append( "\nOperations: " + operations.size() + " operations " );

    for( Iterator it = operations.iterator(); it.hasNext(); ) {
      Operation operation = (Operation) it.next();
      buffer.append( "\n  Operation: " + operation.getName() );
      buffer.append( " {style=" + operation.getStyle() + "}" );
      buffer.append( " {input=" + operation.getInput().getMessage().getQName().getLocalPart() + "}" );
      buffer.append( " {output=" + operation.getOutput().getMessage().getQName().getLocalPart() + "}" );
    }

    return buffer.toString();
  }

}
