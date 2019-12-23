Test reading jar resources
  
 

package com.ack.tools.jarinfo.testing;

import com.ack.tools.jarinfo.JarByteLoader;
import com.ack.tools.jarinfo.JarInfoException;
import com.ack.tools.jarinfo.SuffixZipEntryFilter;
import com.ack.tools.jarinfo.ZipEntryFilter;
import com.ack.tools.jarinfo.testing.TestJarInfoConstants;
import junit.framework.TestCase;

/**
 * demonstrates how to load resources from
 * a given jar using the JarInfo package.
 */

public class TestReadingJarResources extends TestCase {

  public TestReadingJarResources( String s ) {
    super( s );
  }

  protected void setUp() {
  }

  protected void tearDown() {
  }

  public void testAccessingJarResources() {
    String archiveName = TestJarInfoConstants.kZIP_FILE_ONE;
    ZipEntryFilter zipFilter = new SuffixZipEntryFilter( ".xsl" );

    JarByteLoader jarByteLoader = null;
    try {
      // load zip entries based upon filter
      jarByteLoader = new JarByteLoader( archiveName, zipFilter );
      System.out.println( "\nJarByteLoader successfully loaded -> " + archiveName );

      // view contents of zip entries match ".xsl"
      System.out.println( jarByteLoader.getJarInfo() );

      // load the specified resource
      String resourceName = "org/apache/tools/ant/taskdefs/optional/junit/xsl/junit-frames.xsl";
      byte[] theBytes = jarByteLoader.getResourceAsBytes( resourceName );
      System.out.println( "\nJarByteLoader loaded " + theBytes.length + " bytes for "
                          + resourceName + " from " + archiveName );

      // print out the resource
      System.out.println( new String( theBytes ) );
    }
    catch( JarInfoException jie ) {
      jie.printStackTrace();
      fail();
    }
  }
}
