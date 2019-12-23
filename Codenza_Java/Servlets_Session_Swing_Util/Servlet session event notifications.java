Servlet session event notifications
  
 

package com.ack.web.servlet;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;

/**
 * Get application events for when a servlet session
 * is activated and destroyed.  Also, get events when
 * attributes are added, removed and replaced within
 * the servlet session.
 <web-app>
 <listener>
 <listener-class>com.ack.web.servlet.ServletSessionEventNotifications</listener-class>
 </listener>
 </web-app>
 */
public class ServletSessionEventNotifications
    implements HttpSessionAttributeListener, HttpSessionActivationListener {

  public void sessionDidActivate( HttpSessionEvent evt ) {
    System.out.println( "session activated: " + evt );
  }

  public void sessionWillPassivate( HttpSessionEvent evt ) {
    System.out.println( "session passivated: " + evt );
  }

  public void attributeAdded( HttpSessionBindingEvent evt ) {
    System.out.println( "attribute added to session: " + dump( evt ) );
  }

  public void attributeRemoved( HttpSessionBindingEvent evt ) {
    System.out.println( "attribute removed from session: " + dump( evt ) );
  }

  public void attributeReplaced( HttpSessionBindingEvent evt ) {
    System.out.println( "attribute replaced in session: " + dump( evt ) );
  }


  private String dump( HttpSessionBindingEvent evt ) {
    return "\n attribute name: " + evt.getName() + "\n session: " +
        evt.getSession() + "\n attribute value: " + evt.getValue();
  }
}
