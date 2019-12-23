Validating schema
  
 

package com.ack.xml.dom;

//import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.apache.xerces.parsers.DOMParser;

/**
 * Example tested with Xerces 2.0.0
 */
public class ValidatingSchema {
  public static void main( String[] args ) throws Exception {
    // get hold of a DOM parser
    DOMParser parser = new DOMParser();

    // check your features before
    System.out.println( "parser defaults are thus:\n" );
    System.out.println( "namespaces: " + parser.getFeature( "http://xml.org/sax/features/namespaces" ) );
    System.out.println( "sax validation: " + parser.getFeature( "http://xml.org/sax/features/validation" ) );
    System.out.println( "schema validation: " + parser.getFeature( "http://apache.org/xml/features/validation/schema" ) );
    System.out.println( "full schema validation: " + parser.getFeature( "http://apache.org/xml/features/validation/schema-full-checking" ) );

    // turn on schema validation ( note need to set both sax and dom validation )
    parser.setFeature( "http://xml.org/sax/features/validation", true );
    parser.setFeature( "http://apache.org/xml/features/validation/schema", true );
    parser.setFeature( "http://apache.org/xml/features/validation/schema-full-checking", true );

    // parse the document
    InputSource is = new InputSource( "resources\\personal-schema.xml" );
    parser.parse( is );

    // get the w3c document
    Document doc = parser.getDocument();

    // notify that all is well
    System.out.println( "successfully parsed schema" );
  }
}
