Read an Xml file
  
 

package com.ack.xml.jdom;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ReadAnXmlFile {
  public static void main( String[] args ) {
    try {
      // use SAXBuilder to create DOM from numerous types of input
      SAXBuilder builder = new SAXBuilder();

      // expand entities within the SAXBuilder
      builder.setExpandEntities( true );

      // SAXBuilder is more does create the entire DOM at once
      Document doc = builder.build( "drainpipe.xml" );

      System.out.println( doc );
    }
    catch( JDOMException e ) {
      e.printStackTrace();
    }
  }
}
