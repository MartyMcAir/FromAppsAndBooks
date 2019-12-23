Reading message properties
  
 

package com.ack.j2ee.jms;

import java.util.Enumeration;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ReadingMessageProperties {
  public static void main( String[] args ) throws Exception {
    QueueConnection queueCon = null;
    try {
      // get the initial context, refer to your app server docs for this
      Context ctx = new InitialContext();

      // get the connection factory, and open a connection
      QueueConnectionFactory qcf = (QueueConnectionFactory) ctx.lookup( "jms/akira/connectionfactory" );
      queueCon = qcf.createQueueConnection();

      // create queue session off the connection
      QueueSession queueSession = queueCon.
          createQueueSession( false, Session.AUTO_ACKNOWLEDGE );

      // get handle on queue, create a sender and send the message
      Queue queue = (Queue) ctx.lookup( "jms/queue/devilman" );
      QueueReceiver receiver = queueSession.createReceiver( queue );

      queueCon.start();
      System.out.println( "waiting for a message..." );
      Message m = receiver.receive();
      if( m != null && m instanceof TextMessage ) {
        System.out.println( "Message Contents:" );
        System.out.println( ( (TextMessage) m ).getText() );
        System.out.println( "Message Properties:" );

        // get a hold on all the message properties
        Enumeration theProps = m.getPropertyNames();
        while( theProps.hasMoreElements() ) {
          // get the property name
          String name = (String) theProps.nextElement();

          // and get its value as an object, so you get all property values
          Object value = m.getObjectProperty( name );
          System.out.println( "[ " + name + "," + value + " ] " );
        }
      }
    }
    finally {
      // close the queue connection
      if( queueCon != null ) {
        queueCon.close();
      }
    }
  }
}
