Simple sax handler
  
 

package com.ack.xml.jaxp;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleSaxHandler extends DefaultHandler {

  public void endDocument() throws org.xml.sax.SAXException {
    log( "finished parsing document" );
  }

  public void startDocument() throws org.xml.sax.SAXException {
    log( "starting to parse document" );
  }

  public void warning( SAXParseException exception ) throws SAXException {
    log( "Warning SAX Exception:" +
         "\nProblem at line " + exception.getLineNumber() +
         ", column " + exception.getColumnNumber() +
         "\nReason: " + exception.getMessage() );
  }

  public void error( SAXParseException exception ) throws SAXException {
    log( "Error SAX Exception:" +
         "\nProblem at line " + exception.getLineNumber() +
         ", column " + exception.getColumnNumber() +
         "\nReason: " + exception.getMessage() );
  }

  public void fatalError( SAXParseException exception ) throws SAXException {
    log( "Fatal Error SAX Exception:" +
         "\nProblem at line " + exception.getLineNumber() +
         ", column " + exception.getColumnNumber() +
         "\nReason: " + exception.getMessage() );
  }

  private void log( String msg ) {
    System.out.println( "\n======================" );
    System.out.println( msg );
    System.out.println( "======================" );
  }

}
