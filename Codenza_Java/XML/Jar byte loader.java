Jar byte loader
  
 

package com.ack.tools.jarinfo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.ack.tools.jarinfo.JarInfo;
import com.ack.tools.jarinfo.JarInfoException;
import com.ack.tools.jarinfo.ByteLoader;
import com.ack.tools.jarinfo.ZipEntryFilter;

/**
 * This class provides an abstraction for resources within
 * a jar/zip file.  It takes either a com.ack.tools.jarinfo.JarInfo object,
 * or a jar/zip file and a ZipEntry filter.
 *
 * JarByteLoader provides clients with a means to load
 * resources from the jar/zip file into a byte array.
 *
 *
 */
public class JarByteLoader {
  private JarInfo fInfo;
  private ByteLoader fByteLoader;

  /**
   * Create a JarClassTable that is a cache for bytes
   * for classes within the supplied zip file
   *
   * @exception com.ack.tools.jarinfo.JarInfoException reports problems reading the zip file
   * @param the jar/zip file to search for classes
   * @param filter to be applied to the zip file
   */
  public JarByteLoader( String zipFile, ZipEntryFilter filter )
      throws JarInfoException {
    // creates a JarInfo object that contains zip entries according to the filter
    fInfo = new JarInfo( zipFile, filter );
    fByteLoader = new ByteLoader();
  }

  /**
   * Creates a JarByteLoader from JarInfo
   *
   * @param a view on a jar file
   * @return reports problems with the JarInfo object
   * @exception com.ack.tools.jarinfo.JarInfoException reports problems with JarInfo
   */
  public JarByteLoader( JarInfo info ) throws JarInfoException {
    if( ( fInfo = info ) == null )
      throw new JarInfoException( "supplied JarInfo object was null" );
    fByteLoader = new ByteLoader();
  }

  /**
   * get the class bytes for the named class.  this will first
   * look in its internal cache for the bytes for the named class
   * and if it is not found in there load it from the underlying
   * jar/zip file.
   *
   * @param the class name
   * @return bytes for the named class.  if it can't be found
   * this method returns null
   * @exception com.ack.tools.jarinfo.JarInfoException reports problems getting resources from jar
   */
  public byte[] getResourceAsBytes( String resourceName ) throws JarInfoException {
    if( resourceName == null )
      throw new JarInfoException( "supplied resourceName to getResourceAsBytes() was null" );

    ZipEntry ze = fInfo.getZipEntry( resourceName );
    if( ze == null )
      throw new JarInfoException( "no such resource '" +
                                  resourceName + "' in archive -> " + fInfo.zipFileName() );
    return loadBytes( ze );
  }

  /**
   * Load the supplied ZipEntry resource from JarByteLoader's java
   * archive into a byte array
   *
   * @param the ZipEntry to be loaded
   * @return the byte array holding the contains of the ZipEntry
   * @exception com.ack.tools.jarinfo.JarInfoException reports problems trying to load supplied resource
   */
  public byte[] getResourceAsBytes( ZipEntry resource ) throws JarInfoException {
    return loadBytes( resource );
  }

  /**
   * accessor method for the JarInfo object
   *
   * @return the JarInfo object
   */
  public JarInfo getJarInfo() {
    return fInfo;
  }

  /**
   * Extract the bytes for a resource from the jar/zip file
   * based on the supplied resource name
   *
   * @exception com.ack.tools.jarinfo.JarInfoException reports any problem trying to get the
   * the resource bytes from the ZipEntry
   * @param the full pathname of the resource
   * @return the bytes for the named resource
   */
  private byte[] loadBytes( ZipEntry zentry ) throws JarInfoException {
    // get the zip entry for the named class from JarInfo
    if( zentry == null )
      throw new JarInfoException( "supplied zip entry to Java archive '" +
                                  fInfo.zipFileName() + "' was null" );
    byte[] b = null;
    ZipInputStream zis = null;
    try {
      // if there is such a ZipEntry, open up the jar/zip file
      FileInputStream fis = new FileInputStream( fInfo.zipFileName() );
      BufferedInputStream bis = new BufferedInputStream( fis );
      zis = new ZipInputStream( bis );
      b = fByteLoader.loadBytesFromZipEntry( zis, zentry );
    }
    catch( IOException ioe ) {
      ioe.printStackTrace();
      throw new JarInfoException( ioe.getMessage() );
    }
    catch( ClassFormatError cfe ) {
      cfe.printStackTrace();
      throw new JarInfoException( cfe.getMessage() );
    }
    finally {
      if( zis != null )
        try {
          zis.close();
        }
        catch( IOException ioe ) {
        }
    }

    if( b == null )
      throw new JarInfoException( "no such resource '" + zentry.getName() +
                                  "' inside Java archive -> " + fInfo.zipFileName() );

    return b;
  }
}
