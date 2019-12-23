Forward to a servlet by request

package com.ack.web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardToAServletByRequest extends HttpServlet {
  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    // do not commit anything to the response stream before a forward

    // set in a request attribute to communicate hello to the
    // servlet we forward to
    req.setAttribute( "hello", "world" );

    // create a request dispatcher to forward
    RequestDispatcher rd =
        getServletContext().
        getRequestDispatcher( "/acceptforward/barry/white?rules=ok" );

    // and then forward
    rd.forward( req, res );
  }
}
