Timer
  
 

package com.ack.webservices.soap.examples.handlers;

import java.util.Calendar;
import java.util.Date;

public class Timer {
  public void sendTime( Date theTime ) {
    System.out.println( "time on client: " + theTime );
  }

  public Date getTime() {
    // return time on server
    return Calendar.getInstance().getInstance().getTime();
  }
}
