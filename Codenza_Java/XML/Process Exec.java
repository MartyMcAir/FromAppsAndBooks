Process Exec
  
 

package com.ack.j2se.lang;

import java.io.IOException;

public class ProcessExec {
  public static void main( String[] argv ) {
    String command = "c:\\winnt\\explorer.exe";

    try {
      Process process = Runtime.getRuntime().exec( command );
    }
    catch( IOException ioex ) {
      ioex.printStackTrace();
    }
  }
}
