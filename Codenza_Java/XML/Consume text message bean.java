Consume text message bean

package com.ack.j2ee.mdb;

import javax.ejb.CreateException;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumeTextMessageBean implements MessageDrivenBean, MessageListener {
  private MessageDrivenContext messageDrivenContext;

  public void ejbCreate() throws CreateException {
    System.out.println( "ejbCreate: " + getClass().getName() );
  }

  public void ejbRemove() {
    System.out.println( "ejbRemove: " + getClass().getName() );
  }

  public void onMessage( Message msg ) {
    if( msg instanceof TextMessage ) {
      try {
        System.out.println( ( (TextMessage) msg ).getText() );
      }
      catch( JMSException jme ) {
        System.out.println( "JMS Problem: " + jme.getMessage() );
        messageDrivenContext.setRollbackOnly();
      }
      catch( Throwable te ) {
        System.out.println( "Serious Problem: " + te.getMessage() );
        messageDrivenContext.setRollbackOnly();
      }
    }
    else {
      System.out.println( "Not a TextMessage: " );
    }
  }

  public void setMessageDrivenContext( MessageDrivenContext messageDrivenContext ) {
    this.messageDrivenContext = messageDrivenContext;
  }
}
