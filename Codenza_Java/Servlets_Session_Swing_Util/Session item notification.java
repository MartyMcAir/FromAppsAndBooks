Session item notification
  
 

package com.ack.web.servlet;

import java.io.IOException;
import java.io.Serializable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class SessionItemNotification extends HttpServlet {
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    HttpSession session = req.getSession();

    session.setAttribute( "cone", new KnowAllItem( "snake eyes" ) );
    session.removeAttribute( "cone" );

    res.getWriter().println( "check your console..." );
  }
}

/**
 * By implementing HttpSessionBindingListener, KnowAllItem objects get
 * informed when they are added and/or removed from a servlet session
 *
 * Also, remember to make you session items serializable
 */
class KnowAllItem implements HttpSessionBindingListener, Serializable {
  private String id;

  public KnowAllItem( String theId ) {
    id = theId;
  }

  public void valueBound( HttpSessionBindingEvent evt ) {
    System.out.println( "added KnowAllItem to session -> " + dump( evt ) );
  }

  public void valueUnbound( HttpSessionBindingEvent evt ) {
    System.out.println( "removed KnowAllItem from session -> " + dump( evt ) );
  }

  private String dump( HttpSessionBindingEvent evt ) {
    return "\n attribute name: " + evt.getName() + "\n session: " +
        evt.getSession() + "\n attribute value: " + evt.getValue();
  }

  public String toString() {
    return id;
  }
}
