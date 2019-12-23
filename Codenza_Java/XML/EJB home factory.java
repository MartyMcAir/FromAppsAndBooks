EJB home factory

package com.ack.j2ee.ejb.simple;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJBHome;
import javax.ejb.EJBLocalHome;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class EJBHomeFactory {
  private Map ejbHomes;
  private Context initialCtx;
  private static EJBHomeFactory instance;

  public synchronized static void init() throws NamingException {
    instance = new EJBHomeFactory( null );
  }

  public synchronized static void init( Context ctx ) throws NamingException {
    instance = new EJBHomeFactory( ctx );
  }

  public static EJBHomeFactory getFactory() {
    if( instance == null ) {
      throw new IllegalStateException( "EJBHomeFactory singleton has not been initialised" );
    }

    // this can happen if client forgets to call EJBHomeFactory.init()
    if( instance.getInitialContext() == null ) {
      throw new
          IllegalArgumentException( "initial context is null in EJBHomeFactory" );
    }

    return instance;
  }

  public static EJBHome lookUpHome( String jndiName, Class homeClass ) throws NamingException {
    return EJBHomeFactory.getFactory().lookUp( jndiName, homeClass );
  }

  public static EJBLocalHome lookUpLocalHome( String jndiName, Class localHomeClass ) throws NamingException {
    return EJBHomeFactory.getFactory().lookUpLocal( jndiName, localHomeClass );
  }

  /**
   * object responsibilities
   */

  /**
   * @param jndiName
   * @param homeClass
   * @return NamingException
   * @throws javax.naming.NamingException
   */
  public EJBHome lookUp( String jndiName, Class homeClass ) throws NamingException {
    /**
     * input validate arguments
     */
    if( jndiName == null ) {
      throw new IllegalArgumentException( "supplied jndiName to lookup was null" );
    }

    if( homeClass == null ) {
      throw new IllegalArgumentException( "supplied home class to lookup was null" );
    }

    // lookup ejb home in cache
    EJBHome ejbHome = (EJBHome) ejbHomes.get( homeClass );

    // if not there, create and add to cache
    if( ejbHome == null ) {
      ejbHome =
          (EJBHome) PortableRemoteObject.
          narrow( initialCtx.lookup( jndiName ), homeClass );
      ejbHomes.put( homeClass, ejbHome );
    }

    // send back the specified home interface
    return ejbHome;
  }

  public EJBLocalHome lookUpLocal( String jndiName, Class homeClass ) throws NamingException {
    /**
     * input validate arguments
     */
    if( jndiName == null ) {
      throw new IllegalArgumentException( "supplied jndiName to lookup was null" );
    }

    if( homeClass == null ) {
      throw new IllegalArgumentException( "supplied home class to lookup was null" );
    }

    // lookup ejb home in cache
    EJBLocalHome ejbLocalHome = (EJBLocalHome) ejbHomes.get( homeClass );

    // if not there, create and add to cache
    if( ejbLocalHome == null ) {
      ejbLocalHome =
          (EJBLocalHome) PortableRemoteObject.
          narrow( initialCtx.lookup( jndiName ), homeClass );
      ejbHomes.put( homeClass, ejbLocalHome );
    }

    // send back the specified home interface
    return ejbLocalHome;
  }


  /**
   * Constructor
   * @param ctx the JNDI initial context
   * @throws javax.naming.NamingException
   */
  private EJBHomeFactory( Context ctx ) throws NamingException {
    if( ( initialCtx = ctx ) == null ) {
      initialCtx = new InitialContext();
    }
    ejbHomes = Collections.synchronizedMap( new HashMap() );
  }

  /**
   * get the initial context
   * @return Context the JNDI initial context
   */
  private Context getInitialContext() {
    return initialCtx;
  }
}
