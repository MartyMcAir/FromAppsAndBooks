Generic filter

package com.ack.web.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * provides a base implementation for servlet filters.  just
 * extend to implement your own custom filters
 */
public class GenericFilter implements Filter {
  private FilterConfig config;

  public void doFilter( final ServletRequest req,
                        final ServletResponse res,
                        FilterChain chain )
      throws ServletException, IOException {
    chain.doFilter( req, res );
  }

  public void init( FilterConfig config ) {
    setFilterConfig( config );
  }

  public void setFilterConfig( FilterConfig config ) {
    this.config = config;
  }

  public ServletContext getServletContext() {
    return getFilterConfig().getServletContext();
  }

  public FilterConfig getFilterConfig() {
    return config;
  }

  public void log( String str ) {
    getServletContext().log( str );
  }

  public void log( String str, Exception e ) {
    getServletContext().log( str, e );
  }

  public void destroy() {
  }
}
