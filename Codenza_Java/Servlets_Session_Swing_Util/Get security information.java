Get security information

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetSecurityInformation extends HttpServlet {

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    /**
     * security information made available within servlets
     */
    pw.println( "<br>user principal: " + req.getUserPrincipal().getName() );
    pw.println( "<br>authentication type: " + req.getAuthType() );
    pw.println( "<br>user in footie role: " + req.isUserInRole( "footie" ) );
    pw.println( "<br>are we using HTTPS: " + req.isSecure() );
  }
}

/**
 * Here is a dump of the web.xml file containing the security
 * configuration details.
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
 <servlet>
 <servlet-name>security_info</servlet-name>
 <servlet-class>com.ack.servlet.GetSecurityInfo</servlet-class>
 </servlet>
 <servlet-mapping>
 <servlet-name>security_info</servlet-name>
 <url-pattern>/protected/footie/info</url-pattern>
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
 */
