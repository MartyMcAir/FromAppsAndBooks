Build document from a dom

package com.ack.xml.jdom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom.input.DOMBuilder;


public class BuildDocumentFromADom {
  public static void main( String[] args ) {
    try {
      // configure the document builder factory
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setNamespaceAware( true );

      // get a builder to create a DOM document
      DocumentBuilder domBuilder = factory.newDocumentBuilder();

      // parse the damned document
      org.w3c.dom.Document w3cDocument = domBuilder.parse( "drainpipe.xml" );

      // create a JDOM DOM Builder
      DOMBuilder jdomBuilder = new DOMBuilder();

      // create a JDOM Document from a w3c DOM
      org.jdom.Document jdomDocument = jdomBuilder.build( w3cDocument );

      System.out.println( jdomDocument );
    }
    catch( Exception e ) {
      e.printStackTrace();
    }
  }
}
