Request timer filter
  
 

package com.ack.web.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/*
   to configure this filter display every request uri and the time taken
   to complete it.  Compile this class into the WEB-INF/classes directory
   and configure you WEB-INF/web.xml file to include the following filter.

   Note how you can map the filter onto any url-pattern of your choosing.

   <web-app>
    <filter>
      <filter-name>requesttimerfilter</filter-name>
      <filter-class>com.ack.web.servlet.RequestTimerFilter</filter-class>
    </filter>
    <filter-mapping>
      <filter-name>requesttimerfilter</filter-name>
      <url-pattern>/*</url-pattern>
    </filter-mapping>
   </web-app>
 */

public class RequestTimerFilter extends HttpServlet implements Filter {
  private FilterConfig filterConfig;

  public void init( FilterConfig filterConfig ) {
    this.filterConfig = filterConfig;
  }

  public void doFilter( ServletRequest request,
                        ServletResponse response,
                        FilterChain filterChain ) {
    try {
      long startTime = System.currentTimeMillis();
      filterChain.doFilter( request, response );
      long endTime = System.currentTimeMillis();
      String requestURI = ( (HttpServletRequest) request ).getRequestURI();
      System.out.println( requestURI + " took -> " + ( endTime - startTime ) + " ms " );
    }
    catch( ServletException sx ) {
      log( sx.getMessage() );
    }
    catch( IOException iox ) {
      log( iox.getMessage() );
    }
  }
}
