BasicDateFormatting

package com.ack.j2se.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BasicDateFormatting {
  public static void main( String[] args ) throws Exception {
    // get today's date
    Date today = Calendar.getInstance().getTime();

    // create a short version date formatter
    DateFormat shortFormatter
        = SimpleDateFormat.getDateInstance( SimpleDateFormat.SHORT );

    // create a long version date formatter
    DateFormat longFormatter
        = SimpleDateFormat.getDateInstance( SimpleDateFormat.LONG );

    // create date time formatter, medium for day, long for time
    DateFormat mediumFormatter
        = SimpleDateFormat.getDateTimeInstance( SimpleDateFormat.MEDIUM,
                                                SimpleDateFormat.LONG );

    // use the formatters to output the dates
    System.out.println( shortFormatter.format( today ) );
    System.out.println( longFormatter.format( today ) );
    System.out.println( mediumFormatter.format( today ) );

    // convert form date -> text, and text -> date
    String dateAsText = shortFormatter.format( today );
    Date textAsDate = shortFormatter.parse( dateAsText );
    System.out.println( textAsDate );
  }
}
