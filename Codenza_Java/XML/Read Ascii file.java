Read Ascii file
  
 

package com.ack.j2se.io;

import java.io.FileReader;
import java.io.IOException;

public class ReadAsciiFile {

  public static void main( String[] args ) {
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
    catch( IOException ioe ) {
      ioe.printStackTrace();
    }
    finally {
      if( fr != null ) {
        try {
          fr.close();
        }
        catch( IOException ioe ) {
        }
      }
    }

    if( buf != null )
      System.out.println( "file contents: " + buf );
  }
}
