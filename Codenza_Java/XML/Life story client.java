Life story client
  
 

package com.ack.webservices.soap.examples.lifestory;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class LifeStoryClient {
  public static void main( String[] args ) throws Exception {
    String endpoint = "http://localhost:8080/axis/services/LifeStoryService";

    // calls are created our a service, that is typically associated,
    // but not necessarily, with a WSDL file
    Service service = new Service();
    Call call = (Call) service.createCall();

    // set in the target endpoint, operation name, and request intent
    call.setTargetEndpointAddress( new java.net.URL( endpoint ) );
    call.setOperationName( "tellStory" );

    /**
     * important to get the QName right as this should match up
     * with the 'namespace' and 'qname' with the deployment descriptor.
     * This is because the fully qualified name 'urn:LifeStoryService:Person'
     * has a deserializer keyed against it that is looked up at the soap
     * server to inflate a Person object from its XML representation on the
     * wire.
     */
    QName qn = new QName( "urn:LifeStoryService", "Person" );
//    call.addSerializer(Person.class, qn, new BeanSerializer(Person.class));

    // if you want to specify the name of the element for this parameter
    // call.addParameter( "person", new XMLType(qn), Call.PARAM_MODE_IN );

    // Axis provides a nicely overloaded invoke that delivered the return value
    String ret = (String) call.invoke( new Object[]{createPerson()} );

    // then just print it out
    System.out.println( ret );
  }

  private static Person createPerson() {
    Person person = new Person();
    person.setName( "tom" );
    person.setAge( 35 );
    person.setTargetAge( 70 );
    person.setOrigin( "england" );
    person.setUnitsConsumedLastWeek(
        new int[]{0, 20, 45, 70, 34, 30, 22} );
    return person;
  }
}
