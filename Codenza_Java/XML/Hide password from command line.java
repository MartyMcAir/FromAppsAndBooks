Hide password from command line

package com.ack.j2se.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HidePasswordFromCommandLine extends Thread {
  boolean stopThread = false;
  boolean hideInput = false;
  boolean shortMomentGone = false;

  public void run() {
    try {
      sleep( 500 );
    }
    catch( InterruptedException e ) {
    }
    shortMomentGone = true;
    while( !stopThread ) {
      if( hideInput ) {
        System.out.print( "\b*" );
      }
      try {
        sleep( 1 );
      }
      catch( InterruptedException e ) {
      }
    }
  }

  public static void main( String[] arguments ) {
    String name = "";
    String password = "";
    HidePasswordFromCommandLine hideThread = new HidePasswordFromCommandLine();
    hideThread.start();
    BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
    try {
      System.out.println( "Name: " );
      // Wait for the username and clear the keyboard buffer (if neccessarry)
      do {
        name = in.readLine();
      } while( hideThread.shortMomentGone == false );

      // Now the hide thread should begin to overwrite any input with "*"
      hideThread.hideInput = true;

      // Read the password
      System.out.println( "\nPassword:" );
      System.out.print( " " );
      password = in.readLine();
      hideThread.stopThread = true;
    }
    catch( Exception e ) {
    }
    System.out.print( "\b \b" );
    // JUST FOR TESTING - PLEASE DELETE!
    System.out.println( "\n\nLogin= " + name );
    System.out.println( "Password= " + password );
  }
}
