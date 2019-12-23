Servlet context event notifications
  
 

package com.ack.web.servlet;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Get application events for when the web application, that is
 * the servlet context, is initialised and destroyed.  Also, when
 * attributed are added, removed and replaced within the servlet
 * context.
 *
 <listener>
 <listener-class>com.ack.web.servlet.ServletContextEventNotifications</listener-class>
 </listener>
 */
public class ServletContextEventNotifications
    implements ServletContextListener, ServletContextAttributeListener {
  public void contextInitialized( ServletContextEvent evt ) {
    System.out.println( "initialised -> " + evt.getServletContext() );
  }

  public void contextDestroyed( ServletContextEvent evt ) {
    System.out.println( "destroyed -> " + evt.getServletContext() );
  }

  public void attributeAdded( ServletContextAttributeEvent evt ) {
    System.out.println( "attributed added: " + evt );
  }

  public void attributeRemoved( ServletContextAttributeEvent evt ) {
    System.out.println( "attributed removed: " + evt );
  }

  public void attributeReplaced( ServletContextAttributeEvent evt ) {
    System.out.println( "attributed replaced: " + evt );
  }
}
