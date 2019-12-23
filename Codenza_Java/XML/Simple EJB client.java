Simple EJB client
  
 

package com.ack.j2ee.ejb.simple;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import com.ack.j2ee.ejb.session.Informer;
import com.ack.j2ee.ejb.session.InformerHome;

public class SimpleEJBClient {
  public static void main( String[] args ) throws Exception {
    // get handle into the EJB naming directory
    InitialContext ctx = new InitialContext();

    // get hold of the object you want by name
    Object ejbObject = ctx.lookup( "ejb/informer" );

    // narrow retrieved object into specific expected type
    InformerHome home = (InformerHome) PortableRemoteObject.
        narrow( ejbObject, InformerHome.class );

    // get reference to business interface from home interface
    Informer informer = home.create();

    // use the business interface
    System.out.println( "What's the time: " + informer.getTheTime() );

    // let application server reclaim ejb resources
    informer.remove();
  }
}
