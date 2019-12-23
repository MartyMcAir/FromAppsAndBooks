Lawyer bean
  
 

package com.ack.j2ee.ejb.session;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.SessionSynchronization;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;


public class LawyerBean implements SessionBean, SessionSynchronization {
  private SessionContext sessionContext;

  // called after transaction begin happens on a business method
  public void afterBegin() {
    System.out.println( "### just begun transaction" );
  }

  // called just before a transaction completes on a business method
  public void beforeCompletion() {
    System.out.println( "### about to complete transaction" );
  }

  // called after the transaction and reports whether it
  // was committed or not
  public void afterCompletion( boolean committed ) {
    System.out.println( "### after transaction: committed -> " + committed );
  }

  public void sendHimDown( String criminal ) {
    ReporterLocal reporter = null;
    try {
      InitialContext ctx = new InitialContext();

      // note that by making the Informer session bean an ejb link,
      // it can be accessed from within its naming environment,
      // that is 'java:comp/env' by using the name specified
      // within its deployment descriptor, that is 'cia/grass'
      Object ejbObject = ctx.lookup( "java:comp/env/journalist" );

      // then its business as usual once we have the ejbObject
      ReporterLocalHome home = (ReporterLocalHome) PortableRemoteObject.
          narrow( ejbObject, ReporterLocalHome.class );
      reporter = home.create();
      reporter.makeStory( criminal, true );
    }
    catch( NamingException nex ) {
      throw new EJBException( "cannot find informer", nex );
    }
    catch( CreateException cex ) {
      throw new EJBException( "problem getting informed", cex );
    }
    finally {
      if( reporter != null ) {
        try {
          reporter.remove();
        }
        catch( RemoveException rex ) {
          throw new EJBException( "problem getting rid of informer", rex );
        }
      }
    }

  }

  public void ejbCreate() throws CreateException {
  }

  public void ejbRemove() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void setSessionContext( SessionContext sessionContext ) {
    this.sessionContext = sessionContext;
  }
}
