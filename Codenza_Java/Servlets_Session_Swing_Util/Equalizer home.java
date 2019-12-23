Equalizer home

package com.ack.j2ee.ejb.session;

import java.rmi.RemoteException;
import javax.ejb.CreateException;

import com.ack.j2ee.ejb.session.Equalizer;

public interface EqualizerHome extends javax.ejb.EJBHome {
  public Equalizer create() throws CreateException, RemoteException;
}
