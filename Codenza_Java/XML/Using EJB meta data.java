Using EJB meta data
  
 

package com.ack.j2ee.ejb.simple;

import javax.ejb.EJBHome;
import javax.ejb.EJBMetaData;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import com.ack.j2ee.ejb.session.InformerHome;

public class UsingEJBMetaData {
  public static void main( String[] args ) throws Exception {
    // get handle into the EJB naming directory
    InitialContext ctx = new InitialContext();

    // get hold of the object you want by name
    Object ejbObject = ctx.lookup( "ejb/informer" );

    // narrow retrieved object into specific expected type
    InformerHome home = (InformerHome) PortableRemoteObject.
        narrow( ejbObject, InformerHome.class );

    // get meta data regarding the ejb off its home interface
    EJBMetaData md = home.getEJBMetaData();

    // get the ejb home
    EJBHome homeInterface = md.getEJBHome();
    System.out.println( "is stateless session: " + md.isStatelessSession() );
    System.out.println( "is session bean: " + md.isSession() );
    System.out.println( md.getRemoteInterfaceClass().getName() );
    System.out.println( md.getHomeInterfaceClass().getName() );
    if( md.isSession() == false ) {
      // must be an entity bean, because message-driven beans
      // don't have home interfaces, hence no meta-data
      System.out.println( md.getPrimaryKeyClass().getName() );
    }
  }
}
