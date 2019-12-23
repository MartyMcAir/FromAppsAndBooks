Block read ascii file

package com.ack.j2se.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BlockReadAsciiFile {
  public static void main( String[] args ) throws IOException {
    String myFile = "readme.txt";
    FileReader fr = null;
    char[] thechars = null;

    try {
      File thefile = new File( myFile );
      fr = new FileReader( thefile );
      int size = (int) thefile.length();
      thechars = new char[size];

      int count, index = 0;

      // read in the bytes from the input stream
      while( ( count = fr.read( thechars, index, size ) ) > 0 ) {
        size -= count;
        index += count;
      }
    }
    finally {
      if( fr != null )
        fr.close();
    }
    System.out.println( new String( thechars ) );
  }
}
