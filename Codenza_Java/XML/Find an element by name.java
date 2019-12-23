Find an element by name

package com.ack.xml.dom;

import com.ack.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class FindAnElementByName {
  public static void main( String[] args ) throws Exception {
    // create an input source for target document and parse it
    InputSource is = new InputSource( "resources\\personal.xml" );
    Document d = XmlUtil.getDocument( is );

    // get all tags in the document with the name email
    NodeList emails = d.getElementsByTagName( "email" );
    for( int i = 0; i < emails.getLength(); i++ ) {
      // for every email tag
      Element person = (Element) emails.item( i );

      // print out the text value.  note that we have to get the value of
      // first child of the email element which is a text node
      System.out.println( person.getFirstChild().getNodeValue() );
    }
  }
}
