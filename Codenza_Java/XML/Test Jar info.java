Test Jar info
  
 

package com.ack.tools.jarinfo.testing;

import com.ack.tools.jarinfo.JarInfo;
import com.ack.tools.jarinfo.JarInfoException;
import com.ack.tools.jarinfo.SuffixZipEntryFilter;
import com.ack.tools.jarinfo.ZipEntryFilter;
import junit.framework.TestCase;

/**
 * Demonstrates how to use JarInfo and
 * the ZipEntryFilter interface to create views
 * on Java archive files.
 *
 */
public class TestJarInfo extends TestCase {

  public TestJarInfo( String s ) {
    super( s );
  }

  protected void setUp() {
  }

  protected void tearDown() {
  }

  public void testFilteringClassFiles() {
    // create jar file filter
    ZipEntryFilter classFilter = new SuffixZipEntryFilter( ".class" );
    String archiveName = TestJarInfoConstants.kZIP_FILE_ONE;

    JarInfo jarInfo = null;
    try {
      System.out.println( "\nreading archive file -> " + archiveName );
      jarInfo = new JarInfo( archiveName, classFilter );
      System.out.println( "\nsuccessing scanned in -> " + archiveName + "\n" );
      System.out.println( jarInfo );
    }
    catch( JarInfoException jie ) {
      jie.printStackTrace();
      System.err.println( jie );
      fail();
    }
  }
}
