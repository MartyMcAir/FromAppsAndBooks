Read contents of URL
  
 

package com.ack.j2se.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadContentsOfURL {
  public static void main( String[] args ) throws Exception {
    // create a URL object and open a stream to it
    //URL ftpUrl            = new URL("ftp://ftp.sun.com/welcome.msg");
    URL httpUrl = new URL( "http://www.sun.com/index.html" );
    InputStream istream = httpUrl.openStream();

    // convert stream to a BufferedReader
    InputStreamReader ir = new InputStreamReader( istream );
    BufferedReader reader = new BufferedReader( ir );

    // then read the contents of the URL through a BufferedReader
    StringBuffer buf = new StringBuffer();
    int nextChar;
    while( ( nextChar = reader.read() ) != -1 ) {
      buf.append( (char) nextChar );
    }

    // close the reader
    reader.close();

    System.out.println( buf );
  }
}
