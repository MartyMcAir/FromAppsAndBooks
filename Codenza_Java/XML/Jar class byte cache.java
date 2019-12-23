Jar class byte cache
  
 

package com.ack.tools.jarinfo;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.zip.ZipEntry;

import com.ack.tools.jarinfo.SuffixZipEntryFilter;
import com.ack.tools.jarinfo.JarInfo;
import com.ack.tools.jarinfo.JarInfoException;

/**
 * This class provides an abstraction for classes within
 * a jar/zip file.  It simply returns the bytes for named
 * classes that live within the supplied jar/zip file.
 * Once retrieved from the jar/zip file, the bytes for
 * a class are cached within the JarClassByteCache.
 *
 * <p>JarClassByteCache demonstrates of how easy it is
 *  to create your own cache of resources using JarInfo
 *  and JarByteLoader classes.
 *
 * @see com.ack.tools.jarinfo.JarInfo
 * @see com.ack.tools.jarinfo.JarByteLoader
 */
public class JarClassByteCache {
  private static final String kCLASS_SUFFIX = ".class";

  private Hashtable fClassTable;
  private Hashtable fZipTable;
  private JarByteLoader fLoader;

  /**
   * Create a JarClassByteCache for classes in the zip file
   *
   * @exception reports problems reading the zip file
   * @param the jar/zip file holding the classes
   */
  public JarClassByteCache( String zipFile ) throws JarInfoException {
    // creates a JarInfo object that contains zip entries for Java Classes only
    fLoader = new JarByteLoader( zipFile, new SuffixZipEntryFilter( kCLASS_SUFFIX ) );
    init();
  }

  /**
   * accessor method to the byte cache's class names
   * @return list of class names that will/have been cached
   */
  public Enumeration getClassNames() {
    return fZipTable.keys();
  }

  /**
   * accessor method to get the JarInfo
   * @return the jar info
   */
  public JarInfo getJarInfo() {
    return fLoader.getJarInfo();
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
   */
  public byte[] getClassBytes( String className ) throws JarInfoException {
    if( className == null )
      throw new JarInfoException( "supplied className to getClassBytes() was null" );

    // first check to see if bytes for this class are cached
    byte[] b = (byte[]) fClassTable.get( className );

    // if not
    if( b == null ) {
      // get classes bytes from archive and cache them
      if( ( b = loadBytes( className ) ) != null )
        fClassTable.put( className, b );
      else
        throw new JarInfoException( "Unable to load class bytes for -> " + className );
    }
    return b;
  }

  /**
   * Called from the constructor to create a cache of
   * named classes against the actual ZipEntry in the
   * jar/zip file.
   */
  private void init() {
    fClassTable = new Hashtable();    // maps class names to class bytes
    fZipTable = new Hashtable();    // maps class names to ZipEntry

    // cycle through all zip entries within fInfo
    // which are all zip entries for java classes
    Enumeration e = fLoader.getJarInfo().zipEntries();
    while( e.hasMoreElements() ) {
      ZipEntry ze = (ZipEntry) e.nextElement();
      String className = ze.getName();
      int index = className.lastIndexOf( '.' );
      className = className.substring( 0, index ).replace( '/', '.' );
      fZipTable.put( className, ze );
    }
  }

  /**
   * Extract the bytes for a class from the jar/zip file
   * based on the supplied class name
   *
   * @exception reports any problem trying to get the
   * the class bytes from the ZipEntry
   * @param the full pathname of the class
   * @return the bytes for the named class
   */
  private byte[] loadBytes( String className ) throws JarInfoException {
    return fLoader.getResourceAsBytes( (ZipEntry) fZipTable.get( className ) );
  }
}
