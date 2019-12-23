No catch read ascii file
  
 

package com.ack.j2se.io;

import java.io.FileReader;

public class NoCatchReadAsciiFile {

  public static void main( String[] args ) throws Exception {
    String myFile = "readme.txt";
    StringBuffer buf = null;
    FileReader fr = null;

    try {
      fr = new FileReader( myFile );

      int theChar;
      buf = new StringBuffer();

      while( ( ( theChar = fr.read() ) != -1 ) ) {
        buf.append( (char) theChar );
      }
    }
    finally {
      if( fr != null )
        fr.close();
    }

    if( buf != null )
      System.out.println( buf );
  }
}
