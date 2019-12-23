Basic authentication web resource

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Securing a web application with basic HTTP authentication
 * has been reduced to a configuration within web.xml
 *
 * to test: http://localhost/ack/servlet/protected/footie/get_time
 *
 <web-app>
 <servlet>
 <servlet-name>footie_time</servlet-name>
 <servlet-class>com.ack.web.servlet.BasicAuthenticationWebResource</servlet-class>
 </servlet>
 <servlet-mapping>
 <servlet-name>footie_time</servlet-name>
 <url-pattern>/protected/footie/get_time</url-pattern>
 </servlet-mapping>
 <security-constraint>
 <web-resource-collection>
 <web-resource-name>protected_zone</web-resource-name>
 <url-pattern>/protected/footie/*</url-pattern>
 <http-method>GET</http-method>
 <http-method>POST</http-method>
 <http-method>PUT</http-method>
 <http-method>DELETE</http-method>
 <http-method>HEAD</http-method>
 <http-method>OPTIONS</http-method>
 <http-method>TRACE</http-method>
 </web-resource-collection>
 <auth-constraint>
 <role-name>footie</role-name>
 </auth-constraint>
 <user-data-constraint>
 <transport-guarantee>NONE</transport-guarantee>
 </user-data-constraint>
 </security-constraint>
 <login-config>
 <auth-method>BASIC</auth-method>
 <realm-name>pure genius football club</realm-name>
 </login-config>
 <security-role>
 <description>the footie guys</description>
 <role-name>footie</role-name>
 </security-role>
 </web-app>
 *
 * finally we need to map from the 'footie' role name to the
 * security principal with the application server, in weblogic
 * we do the following within the supporting weblogic.xml file:
 *
 *
 <weblogic-web-app>
 <security-role-assignment>
 <role-name>footie</role-name>
 <principal-name>cleve</principal-name>
 </security-role-assignment>
 </weblogic-web-app>
 */
public class BasicAuthenticationWebResource extends HttpServlet {
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    pw.println( "<strong>21:00 @ The Wandle Centre, Wandsworth</strong>" );
    pw.println( "<br>don't be late!" );

  }
}
