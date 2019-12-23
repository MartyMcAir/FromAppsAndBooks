Sax reader
  
 

package com.ack.xml.jaxp;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SaxReader {
  public static void main( String[] args ) {
    // create factory
    SAXParserFactory factory = SAXParserFactory.newInstance();

    // set it so that it is validating and namespace aware
    factory.setValidating( true );
    factory.setNamespaceAware( true );

    try {
      SAXParser parser = factory.newSAXParser();
      parser.parse( "resources\\personal.xml", new SimpleSaxHandler() );
    }
    catch( IOException ioe ) {
      ioe.printStackTrace();
    }
    catch( SAXException saxe ) {
      saxe.printStackTrace();
    }
    catch( ParserConfigurationException pce ) {
      pce.printStackTrace();
    }
  }

}
