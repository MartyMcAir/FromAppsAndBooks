Change look and feel

package com.ack.gui.swing.simple;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class ChangeLookAndFeel extends JFrame implements ActionListener {
  static String metalClassName = "javax.swing.plaf.metal.MetalLookAndFeel";
  static String motifClassName = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
  static String windowsClassName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

  public static void main( String[] argv ) {
    ChangeLookAndFeel myExample = new ChangeLookAndFeel( "Change Look And Feel" );
  }

  public ChangeLookAndFeel( String title ) {
    super( title );
    setSize( 150, 150 );
    addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        dispose();
        System.exit( 0 );
      }
    } );
    JPanel my_panel = new JPanel();
    my_panel.setLayout( new GridLayout( 1, 3 ) );
    JButton jb = new JButton( "Metal" );
    my_panel.add( jb );
    jb.addActionListener( this );
    jb = new JButton( "Motif" );
    my_panel.add( jb );
    jb.addActionListener( this );
    jb = new JButton( "Windows" );
    my_panel.add( jb );
    jb.addActionListener( this );
    getContentPane().add( my_panel );
    my_panel.setBorder( BorderFactory.createEtchedBorder() );
    pack();
    setVisible( true );
  }

  public void changeLookTo( String cName ) {
    try {
      UIManager.setLookAndFeel( cName );
    }
    catch( Exception e ) {
      System.out.println( "Could not change l&f" );
    }
    SwingUtilities.updateComponentTreeUI( this );
    this.pack();
  }

  public void actionPerformed( ActionEvent ae ) {
    String title = ae.getActionCommand();
    if( title.equals( "Metal" ) )
      changeLookTo( metalClassName );
    else if( title.equals( "Motif" ) )
      changeLookTo( motifClassName );
    else if( title.equals( "Windows" ) ) changeLookTo( windowsClassName );

  }
}
