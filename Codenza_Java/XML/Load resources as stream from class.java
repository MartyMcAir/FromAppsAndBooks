Load resources as stream from class
  
 

package com.ack.j2se.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadResourcesAsStreamFromClass {
  public static void main( String[] args ) throws IOException {
    // select a class on the classpath that will used to load a resource
    Class resourceClass = LoadResourcesAsStreamFromClass.class;

    // here the hello.properties resource is in the same directory as
    // com.ack.j2se.io.LoadResourcesAsStreamFromClass.class
    InputStream propStream = resourceClass.getResourceAsStream( "hello.properties" );

    // here fox.txt is in the 'resources' directory, which is the immediate
    // subdirectory of the directory that holds LoadResourcesAsStreamFromClass.class
    InputStream fileStream = resourceClass.getResourceAsStream( "resources/fox.txt" );

    // once you have a handle on the input stream, use to populate properties
    Properties props = new Properties();
    props.load( propStream );
    System.out.println( props );

    // or use to do whatever you want
    for( int c = fileStream.read(); c != -1; c = fileStream.read() ) {
      System.out.print( (char) c );
    }

    // this is a very good way of storing and accessing java resources
    // that are stored within a jar file
  }
}
