Echo document

package com.ack.xml.dom;

import com.ack.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class EchoDocument {

  private void print( Document doc ) {
    printNode( doc, "" );
  }

  public void printNode( Node n, String indent ) {
    switch( n.getNodeType() ) {
      case Node.DOCUMENT_NODE:
        NodeList children = n.getChildNodes();
        if( children != null ) {
          for( int i = 0; i < children.getLength(); i++ ) {
            printNode( children.item( i ), indent + " " );
          }
        }
        break;

      case Node.ELEMENT_NODE:
        log( indent + getElementStart( n ) );
        getElementChildren( n, indent );
        log( indent + getElementEnd( n ) );
        break;

      case Node.TEXT_NODE:
        String text = getTextNode( n );
        if( text.length() > 0 ) {
          log( indent + "  " + text );
        }
        break;

      case Node.PROCESSING_INSTRUCTION_NODE:
        log( indent + getProcessingInstructionNode( n ) );
        break;

      case Node.COMMENT_NODE:
        log( indent + getCommentNode( n ) );
        break;
    }
  }

  private void log( String msg ) {
    System.out.println( "EchoDocument: " + msg );
  }


  private String getElementStart( Node e ) {
    StringBuffer buf = new StringBuffer();
    buf.append( "<" + e.getNodeName() );
    buf.append( getElementAttributes( e ) );
    buf.append( ">" );
    return buf.toString();
  }

  private void getElementChildren( Node e, String indent ) {
    NodeList children = e.getChildNodes();
    if( children != null ) {
      for( int i = 0; i < children.getLength(); i++ )
        printNode( children.item( i ), indent + "  " );
    }
  }

  private String getElementEnd( Node e ) {
    return "</" + e.getNodeName() + ">";
  }

  private String getElementAttributes( Node e ) {
    StringBuffer buf = new StringBuffer();
    NamedNodeMap attributes = e.getAttributes();
    for( int i = 0; i < attributes.getLength(); i++ ) {
      Node n = attributes.item( i );
      buf.append( " " );
      buf.append( n.getNodeName() );
      buf.append( "=" );
      buf.append( n.getNodeValue() );
    }
    return buf.toString();
  }

  private String getTextNode( Node t ) {
    return t.getNodeValue().trim();
  }

  private String getProcessingInstructionNode( Node pi ) {
    return "<?" + pi.getNodeName() + " " + pi.getNodeValue() + "?>";
  }

  private String getCommentNode( Node c ) {
    return "comment: " + c.getNodeValue();
  }

  public static void main( String[] args )
      throws Exception {
    // create an input source for target document and parse it
    InputSource is = new InputSource( "resources\\personal.xml" );
    Document d = XmlUtil.getDocument( is );

    new EchoDocument().print( d );
  }
}
