Get element attribute

package com.ack.xml.dom;

import com.ack.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GetElementAttribute {
  public static void main( String[] args ) throws Exception {
    // create an input source for target document and parse it
    InputSource is = new InputSource( "resources\\personal.xml" );
    Document d = XmlUtil.getDocument( is );

    // get all tags in the document with the name link
    NodeList links = d.getElementsByTagName( "link" );
    for( int i = 0; i < links.getLength(); i++ ) {
      // for every link tag
      Element link = (Element) links.item( i );

      // print out its manager attribute value
      System.out.println( "attribute value = " + link.getAttribute( "manager" ) );
    }
  }
}
