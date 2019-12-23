Xsl Transformer
  
 

package com.ack.xml.jaxp;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XslTransformer {
  public static void main( String[] args )
      throws TransformerException, TransformerConfigurationException,
      FileNotFoundException, IOException {
    // create a transformer factory and set properties on it
    TransformerFactory factory = TransformerFactory.newInstance();

    // once you've configured the factory create you transformer giving it the stylesheet
    Transformer transformer = factory.newTransformer( new StreamSource( "resources\\foo.xsl" ) );

    // then perform the transform on 'foo.xml' and dump it to System.out
    transformer.transform( new StreamSource( "resources\\foo.xml" ), new StreamResult( System.out ) );
  }
}
