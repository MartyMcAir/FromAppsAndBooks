Test Jar info class loader
  
 

package com.ack.tools.jarinfo.testing;

import com.ack.tools.jarinfo.JarInfoClassLoader;
import com.ack.tools.jarinfo.JarInfoException;
import junit.framework.TestCase;


/**
 * Demonstrates how to use the custom
 * built JarInfoClassLoader.  This ClassLoader is
 * implemented under the covers using the JarByteLoader
 * and JarInfo classes.  It also uses JarClassByteCache
 * to cache classes loaded from the jar file
 * that JarInfoClassLoader is reading.
 */
public class TestJarInfoClassLoader extends TestCase {

  public TestJarInfoClassLoader( String s ) {
    super( s );
  }

  protected void setUp() {
  }

  protected void tearDown() {
  }

  public void testingJarInfoClassLoader() {
    // use JarInfoClassLoader for loading resources in myjarfile.jar
    JarInfoClassLoader jClassLoader = null;
    String archiveFile = TestJarInfoConstants.kJAR_FILE_ONE;
    try {
      jClassLoader = new JarInfoClassLoader( archiveFile );
      System.out.println( "\nLoading archive file: " + archiveFile );
    }
    catch( JarInfoException jie ) {
      System.err.println( jie );
      fail();
    }

    // load your class using the JarInfoClassLoader
    String aClass = "com.shattu.Java2HTML";
    Class theClass = null;
    try {
      theClass = jClassLoader.loadClass( aClass );
      System.out.println( "\nJarInfoClassLoader loaded class -> " + theClass );
    }
    catch( ClassNotFoundException cnfe ) {
      System.err.println( cnfe );
      fail();
    }

  }

}
