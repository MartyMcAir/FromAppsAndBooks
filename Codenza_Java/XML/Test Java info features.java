Test Java info features
  
 

package com.ack.tools.jarinfo.testing;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.ack.tools.jarinfo.ByteLoader;
import com.ack.tools.jarinfo.JarInfo;
import com.ack.tools.jarinfo.JarInfoException;
import com.ack.tools.jarinfo.ZipEntryFilter;
import junit.framework.TestCase;



public class TestJavaInfoFeatures extends TestCase {

  public TestJavaInfoFeatures( String s ) {
    super( s );
  }

  protected void setUp() {
  }

  protected void tearDown() {
  }

  public void testJarInfoFeatures() {
    String archiveName = "resources\\doctree.zip";
    try {
      // create the HtmlZipEntryFilter and passed is the maximum size in bytes
      ZipEntryFilter htmlFilter = new HtmlZipEntryFilter( 500 );

      // create JarInfo from the archiveName and HtmlZipEntryFilter
      System.out.println( "\nreading archive file -> " + archiveName );
      JarInfo htmlJarInfo = new JarInfo( archiveName, htmlFilter );
      System.out.println( "\nsuccessing scanned in -> " + archiveName + "\n" );

      // dump out the filter entries
      System.out.println( "\nthese are the filtered html entries: \n\n" + htmlJarInfo );

      // load bytes from the filtered ZipEntrys
      ZipInputStream zis = null;
      try {
        // we know archiveFile exists, because htmlJarInfo was created
        FileInputStream fis = new FileInputStream( archiveName );
        BufferedInputStream bis = new BufferedInputStream( fis );
        zis = new ZipInputStream( bis );

        // jarInfoZipEntries are ZipEntrys keyed against they ZipEntry name
        Hashtable jarInfoZipEntries = htmlJarInfo.zipEntryTable();

        // use ByteLoader to load bytes for ZipEntrys in jarInfoZipEntries
        ByteLoader byteLoader = new ByteLoader();
        Hashtable ht = byteLoader.loadBytesFromZipEntries( zis, jarInfoZipEntries );

        if( ht.size() == jarInfoZipEntries.size() ) {
          System.out.println( "\nsuccessfully loaded bytes for all entries in the htmlJarInfo" );
        }
        else {
          System.out.println( "\n" + ( jarInfoZipEntries.size() - ht.size() ) +
                              " entries couldn't be loaded" );
        }
      }
          // tidy up, and let the outer IOException report the I/O problems
      finally {
        if( zis != null )
          zis.close();
      }
    }
    catch( JarInfoException jie ) {
      jie.printStackTrace();
    }
    catch( IOException ioe ) {
      ioe.printStackTrace();
    }
  }
}

/**
 * ZipEntryFilter for HTML files that are less
 * than <b>fSize</b> bytes in size
 */
class HtmlZipEntryFilter implements ZipEntryFilter {
  private static final String kHTMLSUFFIX = ".html";
  private long fSize;

  public HtmlZipEntryFilter( long size ) {
    fSize = size;
  }

  public boolean accept( ZipEntry ze ) {
    boolean outcome = false;
    if( ze != null ) {
      if( ze.getName().endsWith( kHTMLSUFFIX ) && ze.getSize() < fSize )
        outcome = true;
    }
    return outcome;
  }
}
