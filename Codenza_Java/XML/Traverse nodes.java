Traverse nodes
  
 

package com.ack.xml.dom;

import com.ack.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * <p>Traverse all the nodes in the DOM tree</p>
 *
 */
public class TraverseNodes {
  public static void main( String[] args ) throws Exception {
    // create an input source for target document and parse it
    InputSource is = new InputSource( "resources\\personal.xml" );
    Document d = XmlUtil.getDocument( is );

    // traverse all nodes within the DOM document
    traverseNodes( d );
  }

  public static void traverseNodes( Node n ) {
    NodeList children = n.getChildNodes();
    if( children != null ) {
      for( int i = 0; i < children.getLength(); i++ ) {
        Node childNode = children.item( i );

        // here would be a good place to put your application logic
        // and do something base upon node type
        System.out.println( "node name = " + childNode.getNodeName() );
        traverseNodes( childNode );
      }
    }
  }
}
