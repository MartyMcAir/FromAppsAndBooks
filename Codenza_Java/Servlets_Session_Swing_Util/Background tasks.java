Background tasks

package com.ack.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BackgroundTasks extends HttpServlet {
  private Ticker ticker;

  public void init() {
    ticker = new Ticker();
    Thread t = new Thread( ticker );
    t.start();
  }

  public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
    // this servlet processes requests and has a background
    // thread running to handle the execute of ticker objects

    // do not pass HttpServletRequest and HttpServletResponse to
    // background threads

    res.setContentType( "text/html" );
    res.getWriter().println( "check your console, i'm ticking<br>" );
  }

  public void destroy() {
    ticker.stop();
  }

}

// background task

class Ticker implements Runnable {
  private volatile boolean keepAlive = true;
  private int count;

  public synchronized void stop() {
    keepAlive = false;
  }

  public void run() {
    while( keepAlive ) {
      System.out.println( "still alive [" + ( count++ ) + "]" );
      try {
        Thread.currentThread().sleep( 5000 );
      }
      catch( InterruptedException ie ) {
        ie.printStackTrace();
      }
    }
  }
}
