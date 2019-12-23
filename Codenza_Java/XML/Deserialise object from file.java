Deserialise object from file

package com.ack.j2se.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserialiseObjectFromFile {
  public static void main( String[] args )
      throws IOException, ClassNotFoundException {
    FileInputStream fin = new FileInputStream( "thefile.obj" );
    ObjectInputStream ois = new ObjectInputStream( fin );
    String str = (String) ois.readObject();
    ois.close();
    System.out.println( str );
  }
}
