Shut down hooks
  
 
package com.ack.j2se.lang;

public class ShutdownHooks {
  public static void main( String[] args ) {
    Thread myShutdownThread = new Thread( new ShutdownProcess() );
    Runtime.getRuntime().addShutdownHook( myShutdownThread );
  }
}

class ShutdownProcess implements Runnable {
  public void run() {
    System.out.println( "System shutdown at: " +
                        new java.util.Date( System.currentTimeMillis() ) );
  }
}
