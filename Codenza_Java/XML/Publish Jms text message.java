Publish Jms text message
  
 

package com.ack.j2ee.jms;

import javax.jms.Message;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;

public class PublishJmsTextMessage {
  public static void main( String[] args ) throws Exception {
    TopicConnection topicCon = null;
    try {
      // get the initial context, refer to your app server docs for this
      Context ctx = new InitialContext();

      // get the connection factory, and open a connection
      TopicConnectionFactory tcf = (TopicConnectionFactory) ctx.lookup( "jms/akira/connectionfactory" );
      topicCon = tcf.createTopicConnection();

      // create queue session off the connection
      TopicSession topicSession = topicCon.
          createTopicSession( false, Session.AUTO_ACKNOWLEDGE );

      // get handle on queue, create a sender and send the message
      Topic topic = (Topic) ctx.lookup( "jms/topic/devilman" );
      TopicPublisher publisher = topicSession.createPublisher( topic );
      Message msg = topicSession.createTextMessage( "hello..." );
      publisher.publish( msg );

      System.out.println( "published message" );
    }
    finally {
      // close the queue connection
      if( topicCon != null ) {
        topicCon.close();
      }
    }
  }
}
