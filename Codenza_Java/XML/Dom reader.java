Dom reader

package com.ack.xml.jaxp;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DomReader {
  public static void main( String[] args ) {
    // configure the document builder factory
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setValidating( true );
    factory.setNamespaceAware( true );

    try {
      // get a builder to create a DOM document
      DocumentBuilder builder = factory.newDocumentBuilder();

      // parse the damned document
      Document d = builder.parse( "resources\\personal.xml" );
      System.out.println( "the document: " + d );
    }
    catch( ParserConfigurationException pce ) {
      pce.printStackTrace();
    }
    catch( SAXException se ) {
      se.printStackTrace();
    }
    catch( IOException ioe ) {
      ioe.printStackTrace();
    }
  }
}
