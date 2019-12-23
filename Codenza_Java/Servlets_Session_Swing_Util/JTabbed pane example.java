JTabbed pane example
  
 

package com.ack.gui.swing.simple;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class JTabbedPaneExample extends JFrame {
  public static void main( String[] argv ) {
    JTabbedPaneExample myExample = new JTabbedPaneExample( "JTabbedPane Example" );
  }

  public JTabbedPaneExample( String title ) {
    super( title );
    setSize( 150, 150 );
    addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        dispose();
        System.exit( 0 );
      }
    } );
    init();
    pack();
    setVisible( true );
  }

  private void init() {
    JTabbedPane jtb = new JTabbedPane();
    for( int i = 1; i < 4; i++ ) {
      ImageIcon icon = new ImageIcon( i + ".gif" );
      JTextArea jta = new JTextArea( 20, 40 );
      jta.setText( "This is text within tab number " + i );
      JScrollPane jsp = new JScrollPane( jta );
      jtb.addTab( i + "-tab", icon, jsp );
    }
    getContentPane().add( jtb );
    jtb.setBorder( BorderFactory.createEtchedBorder() );
  }
}
