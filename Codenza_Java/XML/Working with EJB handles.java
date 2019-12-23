Working with EJB handles
  
 

package com.ack.j2ee.ejb.simple;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.ejb.EJBHome;
import javax.ejb.HomeHandle;

public class WorkingWithEJBHandles {
  public static void main( String[] args ) throws Exception {
    EJBHome aHome = null;

    // get hold of a home interface
    HomeHandle handle = aHome.getHomeHandle();
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream( bos );
    oos.writeObject( handle );
    byte[] handleAsBytes = bos.toByteArray();

    // store in the database, on file. howwever you want

    FileInputStream fis = new FileInputStream( "fileobj" );
    ObjectInputStream ois = new ObjectInputStream( fis );
    HomeHandle theHandle = (HomeHandle) ois.readObject();

    // get back the EJBHome from the HomeHandle
    aHome = theHandle.getEJBHome();

    // the same kind of logic also holds for EJBHandles, as well as
    // HomeHandles
  }
}
