Equalizer

package com.ack.j2ee.ejb.session;

import java.rmi.RemoteException;

public interface Equalizer extends javax.ejb.EJBObject {
  public String getTimeOfHit() throws RemoteException;
}
