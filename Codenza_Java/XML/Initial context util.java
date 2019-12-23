Initial context util

package com.ack.util;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class InitialContextUtil {
  public static Context getInitialContext( String factoryClass, String providerUrl,
                                           String principal, String password )
      throws NamingException {
    try {
      Properties properties = new Properties();
      if( factoryClass != null ) {
        properties.put( Context.INITIAL_CONTEXT_FACTORY, factoryClass );
      }

      if( providerUrl != null ) {
        properties.put( Context.PROVIDER_URL, providerUrl );
      }

      if( principal != null ) {
        properties.put( Context.SECURITY_PRINCIPAL, principal );
        properties.put( Context.SECURITY_CREDENTIALS, password == null ? "" : password );
      }
      return new InitialContext( properties );
    }
    catch( NamingException e ) {
      System.out.println( "Unable to connect to JNDI server at " + providerUrl );
      throw e;
    }
  }

  public static Context getAnonymousInitialContext( String factoryClass, String providerUrl )
      throws NamingException {
    return getInitialContext( factoryClass, providerUrl, null, null );
  }
}
