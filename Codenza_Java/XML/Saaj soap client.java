Saaj soap client
  
 

package com.ack.webservices.saaj;

import javax.xml.messaging.URLEndpoint;
import javax.xml.soap.*;


public class SaajSoapClient {
  public static void main( String[] args ) throws Exception {
    // set up the factories and create a SOAP factory
    SOAPConnection soapConnection = SOAPConnectionFactory.newInstance().createConnection();
    SOAPFactory soapFactory = SOAPFactory.newInstance();
    MessageFactory messageFactory = MessageFactory.newInstance();

    // Create a message from the message factory.
    SOAPMessage soapMessage = messageFactory.createMessage();

    // creat a SOAP part have populate the envelope
    SOAPPart soapPart = soapMessage.getSOAPPart();
    SOAPEnvelope envelope = soapPart.getEnvelope();
    envelope.setEncodingStyle( SOAPConstants.URI_NS_SOAP_ENCODING );

    // remove all header information from envelope
    envelope.getHeader().detachNode();

    // create a SOAP body
    SOAPBody body = envelope.getBody();

    // add the element <ns1:BabelFishRequest> to the body
    // in axis RC1, have to do this instead of body.addChildElement( ... )
    Name babelFishRequestName = envelope.createName( "BabelFish", "ns1", "urn:xmethodsBabelFish" );
    SOAPBodyElement soapMethod = body.addBodyElement( babelFishRequestName );

    // add elements translationmode and sourcedata to BabelFishRequest
    soapMethod.addChildElement( soapFactory.createElement( "translationmode" ).addTextNode( "en_fr" ) );
    soapMethod.addChildElement( soapFactory.createElement( "sourcedata" ).addTextNode( "hello" ) );

    // set the saves into the structure
    soapMessage.saveChanges();

    // output the message
    System.out.println( "\n============= start request msg ==========\n" );
    soapMessage.writeTo( System.out );
    System.out.println( "\n============= end request msg ==========\n" );

    URLEndpoint endpoint = new URLEndpoint( "http://services.xmethods.net:80/perl/soaplite.cgi" );
    System.out.println( "\nSending message to URL: " + endpoint.getURL() );

    // now make that call over the SOAP connection
    SOAPMessage reply = soapConnection.call( soapMessage, endpoint );

    // output the message reply
    System.out.println( "\n============= start reply ==========\n" );
    reply.writeTo( System.out );
    System.out.println( "\n============= end reply ==========\n" );

    // close down the connection
    soapConnection.close();
  }
}
