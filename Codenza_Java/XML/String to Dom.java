String to Dom
  
 

package com.ack.xml.dom;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class StringToDom {
  private static final String ADOC =
      "<hello><name>john</name></hello>";

  public static void main( String[] args ) {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      InputSource is = new InputSource( new StringReader( ADOC ) );
      Document d = builder.parse( is );
    }
    catch( Exception ex ) {
      ex.printStackTrace();
    }
  }
}
