Pie Eater
  
 

package com.ack.learning.exceptions;

public class PieEater {
  private int piesEaten;

  // the throws clause tells use that this method
  // can throw a PieException
  public int howManyPies() throws PieException {
    // do some processing
    if( piesEaten > 100 ) {
      // create a PieException object and throw it
      throw new PieException( "he's eaten all the pies" );
    }

    return piesEaten;
  }
}
