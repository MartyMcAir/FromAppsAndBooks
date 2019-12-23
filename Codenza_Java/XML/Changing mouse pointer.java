Changing mouse pointer

package com.ack.gui.awt.simple;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChangingMousePointer implements ActionListener {

  private Frame f;
  private Button b;
  private String[] cursorPointerStringArray =
      {
        "Cursor.CROSSHAIR_CURSOR",
        "Cursor.DEFAULT_CURSOR",
        "Cursor.HAND_CURSOR",
        "Cursor.MOVE_CURSOR",
        "Cursor.TEXT_CURSOR",
        "Cursor.WAIT_CURSOR",
        "Cursor.E_RESIZE_CURSOR",
        "Cursor.NE_RESIZE_CURSOR",
        "Cursor.NW_RESIZE_CURSOR",
        "Cursor.NW_RESIZE_CURSOR",
        "Cursor.N_RESIZE_CURSOR",
        "Cursor.SE_RESIZE_CURSOR",
        "Cursor.SW_RESIZE_CURSOR",
        "Cursor.SW_RESIZE_CURSOR",
        "Cursor.S_RESIZE_CURSOR",
        "Cursor.W_RESIZE_CURSOR"};

  private int[] cursorPointerArray =
      {
        Cursor.CROSSHAIR_CURSOR,
        Cursor.DEFAULT_CURSOR,
        Cursor.HAND_CURSOR,
        Cursor.MOVE_CURSOR,
        Cursor.TEXT_CURSOR,
        Cursor.WAIT_CURSOR,
        Cursor.E_RESIZE_CURSOR,
        Cursor.NE_RESIZE_CURSOR,
        Cursor.NW_RESIZE_CURSOR,
        Cursor.NW_RESIZE_CURSOR,
        Cursor.N_RESIZE_CURSOR,
        Cursor.SE_RESIZE_CURSOR,
        Cursor.SW_RESIZE_CURSOR,
        Cursor.SW_RESIZE_CURSOR,
        Cursor.S_RESIZE_CURSOR,
        Cursor.W_RESIZE_CURSOR};

  public static void main( String[] args ) {
    ChangingMousePointer changingMousePointerExample = new ChangingMousePointer();
    changingMousePointerExample.go();
  }

  public void go() {
    f = new Frame( "Various Mouse Pointers Example" );
    f.setLayout(
        new GridLayout( (int) ( cursorPointerArray.length / 3 ) + 1, 3, 20, 20 ) );

    for( int i = 0; i < cursorPointerArray.length; i++ ) {
      b = new Button( new String( cursorPointerStringArray[i] ) );
      b.addActionListener( this );
      f.add( b );
    }
    f.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        System.exit( 0 );
      }
    } );
    f.pack();
    f.setVisible( true );
  }

  public void actionPerformed( ActionEvent ae ) {
    String st = ( (Button) ae.getSource() ).getActionCommand();
    for( int i = 0; i < cursorPointerStringArray.length; i++ ) {
      if( cursorPointerStringArray[i].equals( st ) ) {
        System.out.println( st );
        f.setCursor( Cursor.getPredefinedCursor( cursorPointerArray[i] ) );
        break;
      }
    }
  }
}
