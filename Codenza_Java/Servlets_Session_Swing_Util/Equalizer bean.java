Equalizer bean

package com.ack.j2ee.ejb.session;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

/**
 *
 <session>
 <display-name>Equalizer</display-name>
 ...
 <ejb-ref>
 <description>one the top CIA informers</description>
 <ejb-ref-name>cia/grass</ejb-ref-name>
 <ejb-ref-type>Session</ejb-ref-type>
 <home>com.ack.j2ee.ejb.session.EqualizerHome</home>
 <remote>com.ack.j2ee.ejb.session.Equalizer</remote>
 <ejb-link>Equalizer</ejb-link>
 </ejb-ref>
 </session>
 */

public class EqualizerBean implements SessionBean {
  private SessionContext sessionContext;

  public String getTimeOfHit() throws RemoteException {
    Informer informer = null;
    try {
      InitialContext ctx = new InitialContext();

      // note that by making the Informer session bean an ejb link,
      // it can be accessed from within its naming environment,
      // that is 'java:comp/env' by using the name specified
      // within its deployment descriptor, that is 'cia/grass'
      Object ejbObject = ctx.lookup( "java:comp/env/cia/grass" );

      // then its business as usual once we have the ejbObject
      InformerHome home = (InformerHome) PortableRemoteObject.
          narrow( ejbObject, InformerHome.class );
      informer = home.create();
      return "Assassination Time: " + informer.getTheTime();
    }
    catch( NamingException nex ) {
      throw new EJBException( "cannot find informer", nex );
    }
    catch( CreateException cex ) {
      throw new EJBException( "problem getting informed", cex );
    }
    finally {
      if( informer != null ) {
        try {
          informer.remove();
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
