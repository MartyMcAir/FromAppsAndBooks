Menu example
  
 

package com.ack.gui.awt.simple;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuExample extends Frame implements ActionListener {

  public static void main( String[] args ) {
    MenuExample myFrame = new MenuExample();
    myFrame.setSize( 400, 400 );
    MenuBar myMenuBar = new MenuBar();
    myFrame.setMenuBar( myMenuBar );
    Menu myFileMenu = new Menu( "File" );
    Menu myEditMenu = new Menu( "Edit" );
    Menu myHelpMenu = new Menu( "Help" );
    myMenuBar.add( myFileMenu );
    myMenuBar.add( myEditMenu );
    myMenuBar.add( myHelpMenu );
    MenuItem myFileOpenMenuItem = new MenuItem( "Open..." );
    MenuItem myFileExitMenuItem = new MenuItem( "Exit", new MenuShortcut( KeyEvent.VK_X ) );
    MenuItem myEditUndoMenuItem = new MenuItem( "Undo", new MenuShortcut( KeyEvent.VK_Z ) );
    MenuItem myHelpAboutMenuItem = new MenuItem( "About" );
    myFileOpenMenuItem.addActionListener( myFrame );
    myFileExitMenuItem.addActionListener( myFrame );
    myEditUndoMenuItem.addActionListener( myFrame );
    myHelpAboutMenuItem.addActionListener( myFrame );
    myFileOpenMenuItem.setActionCommand( "open" );
    myFileExitMenuItem.setActionCommand( "exit" );
    myEditUndoMenuItem.setActionCommand( "undo" );
    myHelpAboutMenuItem.setActionCommand( "about" );
    myFileMenu.add( myFileOpenMenuItem );
    myFileMenu.addSeparator();
    myFileMenu.add( myFileExitMenuItem );
    myEditMenu.add( myEditUndoMenuItem );
    myHelpMenu.add( myHelpAboutMenuItem );
    myFrame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        System.exit( 0 );
      }
    } );
    myFrame.setVisible( true );
  }

  public void actionPerformed( ActionEvent e ) {
    String cmd = e.getActionCommand();
    if( cmd.equals( "open" ) ) {
      System.out.println( "open" );
    }
    else if( cmd.equals( "exit" ) ) {
      System.exit( 0 );
    }
    else if( cmd.equals( "undo" ) ) {
      System.out.println( "undo" );
    }
    else if( cmd.equals( "about" ) ) {
      System.out.println( "about" );
    }
  }
}
