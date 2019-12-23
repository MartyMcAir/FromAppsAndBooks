Access an ejb from a servlet

package com.ack.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ack.j2ee.ejb.session.Lawyer;
import com.ack.j2ee.ejb.session.LawyerHome;

/**
 * web.xml configuration part of the an ejb component
 *
 *  <web-app>
 ...
 <ejb-ref>
 <ejb-ref-name>yoda</ejb-ref-name>
 <ejb-ref-type>Session</ejb-ref-type>
 <home>com.ack.j2ee.ejb.session.LawyerHome</home>
 <remote>com.ack.j2ee.ejb.session.Lawyer</remote>
 </ejb-ref>
 ...
 </web-app>
 *
 * the vendor-specific mapping of the res-ref-name into their
 * own application server space, eg weblogic does the following
 * in a weblogic.xml file
 *
 <weblogic-web-app>
 ...
 <reference-descriptor>
 ...
 <ejb-reference-description>
 <ejb-ref-name>yoda</ejb-ref-name>
 <jndi-name>ejb/lawyer</jndi-name>
 </ejb-reference-description>
 ...
 </reference-descriptor>
 ...
 </weblogic-web-app>
 */
public class AccessAnEjbFromAServlet extends HttpServlet {
  private Context ctx;

  public void init() throws ServletException {
    try {
      // lets share the context for ejb lookup for
      // this servlet's incoming requests
      ctx = new InitialContext();
    }
    catch( NamingException nex ) {
      throw new ServletException( "couldn't locate JNDI context", nex );
    }
  }


  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    res.setContentType( "text/html" );
    PrintWriter pw = res.getWriter();

    try {
      // get reference to business interface from home interface
      Lawyer lawyer = getLawyer();

      // use the business interface
      lawyer.sendHimDown( "bad guy" );

      // let application server reclaim ejb resources
      lawyer.remove();
    }
    catch( LawyerException lex ) {
      pw.println( lex.getMessage() );
    }
    catch( Exception ex ) {
      log( "problem using the lawyer", ex );
      pw.println( ex.getMessage() );
    }

    pw.println( "well, that wasn't so bad" );
  }

  private Lawyer getLawyer() throws LawyerException {
    try {
      Object ejbObject = null;

      // get hold of the object you want by name
      synchronized( this ) {
        System.out.println( "calling on yoda..." );
        ejbObject = ctx.lookup( "java:comp/env/yoda" );
      }

      // narrow retrieved object into specific expected type
      LawyerHome home = (LawyerHome) PortableRemoteObject.
          narrow( ejbObject, LawyerHome.class );

      return home.create();
    }
    catch( Exception ex ) {
      log( "problem getting hold of a lawyer", ex );
      throw new LawyerException( ex.getMessage() );
    }
  }
}

class LawyerException extends Exception {
  public LawyerException( String str ) {
    super( str );
  }
}

/**
 *
 * This is the web.xml configuration
 *
 <web-app>
 ...
 <ejb-ref>
 <description>bring forth the yoda lawyer</description>
 <ejb-ref-name>yoda</ejb-ref-name>
 <ejb-ref-type>Session</ejb-ref-type>
 <home>com.ack.j2ee.ejb.session.LawyerHome</home>
 <remote>com.ack.j2ee.ejb.session.Lawyer</remote>
 </ejb-ref>
 </web-app>
 *
 * But the vendor-specific xml file must map this
 * ejb-ref-name to the name in the JNDI space, for
 * example, in weblogic we have the weblogic.xml,
 *
 <weblogic-web-app>
 <reference-descriptor>
 <ejb-reference-description>
 <ejb-ref-name>yoda</ejb-ref-name>
 <jndi-name>ejb/lawyer</jndi-name>
 </ejb-reference-description>
 </reference-descriptor>
 </weblogic-web-app>
 */
