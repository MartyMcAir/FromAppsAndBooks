JSP file response filter
  
 

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
import javax.servlet.http.HttpServletResponse;

/*
   to configure this filter process the outgoing responses for the viewfile servlet
   that is streaming back the contents of a jsp file.

   Compile this class into the WEB-INF/classes directory
   and configure you WEB-INF/web.xml file to include the following filter.

   Note how you can map the filter onto a servlet of your choosing.

   <web-app>
     <filter>
       <filter-name>jsp_response</filter-name>
       <filter-class>com.ack.web.servlet.JSPFileResponseFilter</filter-class>
     </filter>
     <filter-mapping>
      <filter-name>jsp_response</filter-name>
      <servlet-name>viewfile</servlet-name>
     </filter-mapping>
   </web-app>
 */

public class JSPFileResponseFilter extends HttpServlet implements Filter {
  private FilterConfig filterConfig;

  public void init( FilterConfig filterConfig ) {
    this.filterConfig = filterConfig;
  }

  public void doFilter( ServletRequest request,
                        ServletResponse response,
                        FilterChain filterChain ) {
    try {
      // the extra path information contents the uri of the file to view
      String pathInfo = ( (HttpServletRequest) request ).getPathInfo();
      System.out.println( "delegate jsp view to -> " + pathInfo );

      // if its a jsp file
      if( pathInfo != null && pathInfo.endsWith( ".jsp" ) &&
          response instanceof HttpServletResponse ) {
        // create a response wrapper to handle the streaming
        // of the jsp file back to the HTTP client
        JSPHttpServletResponseWrapper wrapperResponse =
            new JSPHttpServletResponseWrapper( (HttpServletResponse) response );

        // and then do it
        filterChain.doFilter( request, wrapperResponse );
      }
      else {
        // if not a JSP file, there is no extra processing
        // to do on the response
        filterChain.doFilter( request, response );
      }
    }
    catch( ServletException sx ) {
      log( sx.getMessage() );
    }
    catch( IOException iox ) {
      log( iox.getMessage() );
    }
  }
}
