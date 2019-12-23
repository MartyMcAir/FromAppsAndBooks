Thread race
  
 

package com.ack.gui.awt.examples.threadrace;

import java.awt.*;

public class ThreadRace extends Frame {
  public static void main( String[] args ) {
    ThreadRace myThreadRace = new ThreadRace( "ThreadRace Example" );
  }

  public ThreadRace( String s ) {
    super( s );
    setBackground( Color.red );
    setLayout( new GridLayout( 10, 1, 3, 3 ) );
    MyWindowListener mwl = new MyWindowListener();
    addWindowListener( mwl );
    for( int i = 1; i < 11; i++ ) {
      MyPanel mp = new MyPanel( i );
      add( mp );
    }
    pack();
    setVisible( true );
  }
}

class MyPanel extends Panel implements Runnable {
  int x = 10;
  Thread t1 = null;
  int priority;

  public MyPanel( int prior ) {
    t1 = new Thread( this );
    t1.setPriority( prior );
    priority = prior;
    t1.start();
  }

  public void run() {
    while( true ) {
      if( x > 490 ) x = 10;
      x++;
      try {
        t1.sleep( 40 );
      }
      catch( InterruptedException ie ) {
      }
      repaint();
    }
  }

  public void paint( Graphics g ) {
    g.setColor( Color.white );
    g.fillRect( 0, 0, 500, 50 );
    g.setColor( Color.black );
    g.drawLine( 10, 25, 490, 25 );
    g.setColor( Color.blue );
    g.fillOval( x, 20, 10, 10 );
    g.setColor( Color.red );
    g.drawString( String.valueOf( priority ), x + 2, 22 );
  }

  public Dimension getPreferredSize() {
    return ( new Dimension( 500, 50 ) );
  }
}

class MyWindowListener extends java.awt.event.WindowAdapter {
  public void windowClosing( java.awt.event.WindowEvent event ) {
    System.exit( 0 );
  }
}
