Outputting Xml using Jdom
  
 

package com.ack.xml.jdom;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class OutputtingXmlUsingJdom {
  public static void main( String[] args ) {
    try {
      // use SAXBuilder to create DOM from numerous types of input
      SAXBuilder builder = new SAXBuilder();
      builder.setExpandEntities( true );
      Document doc = builder.build( "drainpipe.xml" );

      // create and configure the XMLOutputter
      XMLOutputter xmlOutputter = new XMLOutputter();
      xmlOutputter.setTextTrim( true );
      xmlOutputter.setIndent( 2 );
      xmlOutputter.setNewlines( true );

      // output the text
      xmlOutputter.output( doc, System.out );
    }
    catch( Exception ioe ) {
      ioe.printStackTrace();
    }
  }
}
