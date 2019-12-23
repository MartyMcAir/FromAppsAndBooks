Inner windows

package com.ack.gui.swing.simple;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class InnerWindows extends JFrame {
  public static void main( String[] argv ) {
    InnerWindows myExample = new InnerWindows( "Inner Windows Example" );
  }

  public InnerWindows( String title ) {
    super( title );
    setSize( 550, 400 );
    addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        dispose();
        System.exit( 0 );
      }
    } );
    init();
    setVisible( true );
  }

  private void init() {
    JLayeredPane layers = new JDesktopPane();
    setLayeredPane( layers );
    for( int i = 0; i < 8; i++ ) {
      JTextArea jta = new JTextArea( 20, 40 );
      jta.setText( "This is text within tab number " + i );
      JScrollPane jsp = new JScrollPane( jta );
      jsp.setPreferredSize( new Dimension( 120, 140 ) );
      //JInternalFrame(title, resizable, closable,maximizable, iconifiable)
      JInternalFrame jif = new JInternalFrame( i + " frame", true, true, true, true );
      jif.setLocation( ( i % 4 ) * 140, ( i / 4 ) * 180 );
      jif.getContentPane().add( jsp );
      jif.pack();
      layers.add( jif );
      jif.show();
    }
  }
}
