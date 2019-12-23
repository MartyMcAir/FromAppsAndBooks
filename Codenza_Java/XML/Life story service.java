Life story service
  
 

package com.ack.webservices.soap.examples.lifestory;

/**
 * tell me you details and i'll let me know if you're drinking
 * the right amount to get you to your target age
 */

public class LifeStoryService {

  public String tellStory( Person person ) {
    StringBuffer buf = new StringBuffer();
    buf.append( "hey there, " + person.getName() );
    buf.append( ", aged " + person.getAge() );
    buf.append( ", from " + person.getOrigin() );
    buf.append( ".\n  If you really want to reach " );
    buf.append( person.getTargetAge() );
    buf.append( " you're gonna have to " );

    int maxUnits = 0;
    int maxUnitsDay = 0;
    int[] unitsPerDayOfWeek = person.getUnitsConsumedLastWeek();
    if( unitsPerDayOfWeek != null ) {
      int totalUnits = 0;
      for( int dayOfWeek = 0; dayOfWeek < 6; dayOfWeek++ ) {
        totalUnits += unitsPerDayOfWeek[dayOfWeek];
        if( maxUnits < unitsPerDayOfWeek[dayOfWeek] ) {
          maxUnits = unitsPerDayOfWeek[dayOfWeek];
          maxUnitsDay = dayOfWeek;
        }
      }

      if( totalUnits < 10 ) {
        buf.append( "start drinking some more.  damn!" );
      }
      else if( totalUnits > 100 ) {
        buf.append( "rest the elbox and slow down my friend!" );
      }
      else {
        buf.append( "carry on as you are solder!" );
      }

      if( maxUnits > 50 ) {
        buf.append( "\nHell, that was some night - " );
        buf.append( maxUnits + " units - easy tiger!" );
      }
    }
    else {
      buf.append( "start drinking some more.  damn!" );
    }
    return buf.toString();
  }
}
