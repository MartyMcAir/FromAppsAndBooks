Informer home

package com.ack.j2ee.ejb.session;

import java.rmi.RemoteException;
import javax.ejb.CreateException;

import com.ack.j2ee.ejb.session.Informer;

public interface InformerHome extends javax.ejb.EJBHome {
  public Informer create() throws CreateException, RemoteException;
}
