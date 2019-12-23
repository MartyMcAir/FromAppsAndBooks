Serialise object to file
  
 

package com.ack.j2se.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialiseObjectToFile {
  public static void main( String[] args ) throws IOException {
    String str = new String( "save me!" );
    FileOutputStream fos = new FileOutputStream( "thefile.obj" );
    ObjectOutputStream oos = new ObjectOutputStream( fos );
    oos.writeObject( str );
    oos.close();
  }
}
