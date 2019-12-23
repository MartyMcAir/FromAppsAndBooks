JndiUtil
  
 

package com.ack.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JndiUtil {
  private static Context ctx;

  public static void init( Context theContext ) throws NamingException {
    if( ( JndiUtil.ctx = theContext ) == null ) {
      JndiUtil.ctx = new InitialContext();
    }
  }

  public static Object getJndiEntry( String jndiEntry )
      throws NamingException {
    return ctx.lookup( jndiEntry );
  }
}
