Informer bean

package com.ack.j2ee.ejb.session;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *  Define environment variables within the a components
 *  deployment descriptor (e.g. ejb-jar.xml )
 *
 <session>
 ...
 <env-entry>
 <description>
 determines whether date time output
 should be the long or short form
 </description>
 <env-entry-name>useLongDateFormat</env-entry-name>
 <env-entry-type>java.lang.Boolean</env-entry-type>
 <env-entry-value>true</env-entry-value>
 </env-entry>
 </session>
 */
public class InformerBean implements SessionBean {
  private SessionContext sessionContext;
  private Calendar cal;
  private DateFormat formatter;

  public void ejbCreate() throws CreateException {
    cal = Calendar.getInstance();
    try {
      setup();
    }
    catch( Exception ex ) {
      throw new CreateException( ex.getMessage() );
    }
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

  public String getTheTime() {
    return formatter.format( cal.getTime() );
  }

  // demonstrates how to read an environment variable declared within
  // the deployment descriptor of this component
  private void setup() throws NamingException {
    InitialContext ctx = new InitialContext();
    Boolean b = (Boolean) ctx.lookup( "java:comp/env/useLongDateFormat" );
    int style = ( b.booleanValue() ) ? DateFormat.LONG : DateFormat.SHORT;
    formatter = SimpleDateFormat.getDateTimeInstance( style, style );
  }
}
