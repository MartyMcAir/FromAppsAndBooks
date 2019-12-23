GetTheCurrentTime

package com.ack.j2se.date;

import java.util.Calendar;
import java.util.Date;

public class GetTheCurrentTime {
  public static void main( String[] args ) {
    // one way
    long currentTimeInMillis = System.currentTimeMillis();
    Date today = new Date( currentTimeInMillis );
    System.out.println( today );

    // another way
    Calendar cal = Calendar.getInstance();
    today = cal.getTime();
    System.out.println( today );
  }
}
