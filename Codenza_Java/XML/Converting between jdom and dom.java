Converting between jdom and dom

package com.ack.xml.jdom;

import org.jdom.input.DOMBuilder;
import org.jdom.input.SAXBuilder;
import org.jdom.output.DOMOutputter;

public class ConvertingBetweenJdomAndDom {
  public static void main( String[] args ) throws Exception {
    SAXBuilder builder = new SAXBuilder();
    org.jdom.Document doc = builder.build( "drainpipe.xml" );

    // converts JDOM to W3C DOM
    DOMOutputter domOutputter = new DOMOutputter();
    // converts W3C DOM to JDOM
    DOMBuilder domBuilder = new DOMBuilder();

    // convert between documents
    org.w3c.dom.Document w3cDoc = domOutputter.output( doc );
    doc = domBuilder.build( w3cDoc );

    // convert between elements
    org.jdom.Element jdomRoot = doc.getRootElement();
    org.w3c.dom.Element domRoot = domOutputter.output( jdomRoot );
    jdomRoot = domBuilder.build( domRoot );

    System.out.println( jdomRoot );
    System.out.println( domRoot );

    // convert between JDOM and DOM Attributes
    org.jdom.Attribute jdomAttr = jdomRoot.getAttribute( "type" );
    org.w3c.dom.Attr domAttr = domOutputter.output( jdomAttr );

    System.out.println( jdomAttr.getValue() );
    System.out.println( domAttr.getValue() );
  }
}
