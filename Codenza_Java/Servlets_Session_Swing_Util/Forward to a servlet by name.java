Forward to a servlet by name

package com.ack.web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardToAServletByName extends HttpServlet {
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    // do not commit anything to the response stream before a forward

    // set in a request attribute to communicate hello to the
    // servlet we forward to
    req.setAttribute( "hello", "world" );

    // create a request dispatcher by name to forward to
    // this is more limiting that getRequestDispatcher because
    // you cannot specified a query string or extra path information
    //
    // however, you can dispatch to named web components within the
    // web.xml that do not have publicised URIs
    RequestDispatcher rd =
        getServletContext().getNamedDispatcher( "receiveforward" );

    // and then forward
    rd.forward( req, res );
  }
}
