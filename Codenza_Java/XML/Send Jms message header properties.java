Send Jms message header properties
  
 

package com.ack.j2ee.jms;

import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

public class SendJmsMessageHeaderProperties {
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
      QueueSender sender = queueSession.createSender( queue );

      Message msg = queueSession.createTextMessage( "hello..." );

      msg.setBooleanProperty( "ACK_DEBUG", true );
      msg.setFloatProperty( "ACK_BALANCE", 24234.44f );
      sender.send( msg );

      System.out.println( "sent the message" );
    }
    finally {
      // close the queue connection
      if( queueCon != null ) {
        queueCon.close();
      }
    }
  }
}
