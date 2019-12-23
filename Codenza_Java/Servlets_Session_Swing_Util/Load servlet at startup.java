Load servlet at startup
  
 

package com.ack.web.servlet;

import javax.servlet.http.HttpServlet;

/**
 *
 <servlet>
 <servlet-name>earlyriser</servlet-name>
 <servlet-class>com.ack.web.servlet.LoadServletAtStartup</servlet-class>
 <load-on-startup>7</load-on-startup>
 </servlet>

 This servlet has a load-at-startup priority of 7, meaning any servlet
 with a load priority lower than 7 will be loaded before this one, and those
 greater than 7 after.  if a load-at-startup priority is not specified,
 for example <load-on-startup/>, the servlet engine chooses when
 */
public class LoadServletAtStartup extends HttpServlet {

  public void init() {
    System.out.println( getServletName() + ": initialised" );
  }

}
