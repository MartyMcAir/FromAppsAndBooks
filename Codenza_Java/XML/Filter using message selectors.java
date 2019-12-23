Filter using message selectors

package com.ack.j2ee.jms;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

public class FilterUsingMessageSelectors {
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
      QueueReceiver receiver = queueSession.createReceiver( queue, "ACK_DEBUG = FALSE" );

      queueCon.start();
      while( true ) {
        Message m = receiver.receive();
        if( m != null && m instanceof TextMessage ) {
          TextMessage message = (TextMessage) m;
          System.out.println( "Reading message: " + message.getText() );
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
