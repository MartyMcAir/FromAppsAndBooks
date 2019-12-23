Using layout managers
  
 

package com.ack.gui.swing.simple;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class UsingLayoutManagers extends JFrame {
  public UsingLayoutManagers() {
    super( "Common Layout Managers" );
    setSize( 500, 380 );

    JDesktopPane desktop = new JDesktopPane();
    getContentPane().add( desktop );

    JInternalFrame fr1 = new JInternalFrame( "FlowLayout", true, true );
    fr1.setBounds( 10, 10, 150, 150 );
    Container c = fr1.getContentPane();
    c.setLayout( new FlowLayout() );
    c.add( new JButton( "1" ) );
    c.add( new JButton( "2" ) );
    c.add( new JButton( "3" ) );
    c.add( new JButton( "4" ) );
    desktop.add( fr1, 0 );

    JInternalFrame fr2 = new JInternalFrame( "GridLayout", true, true );
    fr2.setBounds( 170, 10, 150, 150 );
    c = fr2.getContentPane();
    c.setLayout( new GridLayout( 2, 2 ) );
    c.add( new JButton( "1" ) );
    c.add( new JButton( "2" ) );
    c.add( new JButton( "3" ) );
    c.add( new JButton( "4" ) );
    desktop.add( fr2, 0 );

    JInternalFrame fr3 = new JInternalFrame( "BorderLayout", true, true );
    fr3.setBounds( 330, 10, 150, 150 );
    c = fr3.getContentPane();
    c.add( new JButton( "1" ), BorderLayout.NORTH );
    c.add( new JButton( "2" ), BorderLayout.EAST );
    c.add( new JButton( "3" ), BorderLayout.SOUTH );
    c.add( new JButton( "4" ), BorderLayout.WEST );
    desktop.add( fr3, 0 );

    JInternalFrame fr4 = new JInternalFrame( "BoxLayout - X", true, true );
    fr4.setBounds( 10, 170, 250, 120 );
    c = fr4.getContentPane();
    c.setLayout( new BoxLayout( c, BoxLayout.X_AXIS ) );
    c.add( new JButton( "1" ) );
    c.add( Box.createHorizontalStrut( 12 ) );
    c.add( new JButton( "2" ) );
    c.add( Box.createGlue() );
    c.add( new JButton( "3" ) );
    c.add( Box.createHorizontalGlue() );
    c.add( new JButton( "4" ) );
    desktop.add( fr4, 0 );

    JInternalFrame fr5 = new JInternalFrame( "BoxLayout - Y", true, true );
    fr5.setBounds( 330, 170, 150, 180 );
    c = fr5.getContentPane();
    c.setLayout( new BoxLayout( c, BoxLayout.Y_AXIS ) );
    c.add( new JButton( "1" ) );
    c.add( Box.createVerticalStrut( 10 ) );
    c.add( new JButton( "2" ) );
    c.add( Box.createGlue() );
    c.add( new JButton( "3" ) );
    c.add( Box.createVerticalGlue() );
    c.add( new JButton( "4" ) );
    desktop.add( fr5, 0 );

    try {
      fr1.setSelected( true );
    }
    catch( java.beans.PropertyVetoException ex ) {
    }

    WindowListener wndCloser = new WindowAdapter() {
      public void windowClosing( WindowEvent e ) {
        System.exit( 0 );
      }
    };
    addWindowListener( wndCloser );
    fr1.show();
    fr2.show();
    fr3.show();
    fr4.show();
    fr5.show();
    setVisible( true );
  }

  public static void main( String argv[] ) {
    new UsingLayoutManagers();
  }
}
