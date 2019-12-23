Threaded visual counters
  
 

package com.ack.gui.awt.examples.threadrace;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ThreadedVisualCounters extends Frame {

  // private ThreadedVisualCounters tvc;
  private Dimension size = new Dimension( 400, 400 );

  public ThreadedVisualCounters( String title ) {
    super( title );
    setLayout( new GridLayout( 3, 3, 2, 2 ) );
    setBackground( Color.black );
    Counter[] counterArray = new Counter[10];
    for( int i = 1; i < counterArray.length; i++ ) {
      counterArray[i] = new Counter( "Counter " + i, i );
      add( counterArray[i] );

      addWindowListener( new WindowAdapter() {
        public void windowClosing( WindowEvent we ) {
          System.exit( 0 );
        }
      } );

      pack();
      setVisible( true );
    }
  }

  public Dimension getPreferredSize() {
    return ( new Dimension( size.width, size.height ) );
  }

  public static void main( String[] args ) {
    ThreadedVisualCounters threadedVisualCounters1 =
        new ThreadedVisualCounters( "Threaded Visual Counters" );
  }
}

class Counter extends Panel implements Runnable {
  int c = 1;
  int priority;
  Thread t1 = null;
  String cname;

  public Counter( String cname, int priority ) {
    this.priority = priority;
    this.cname = cname;
    t1 = new Thread( this );
    t1.setPriority( priority );
    t1.setName( cname );
    t1.start();
  }

  public void run() {
    while( true ) {
      if( c > 254 )
        c = 1;
      c++;
      try {
        t1.sleep( this.priority * 150 );
      }
      catch( InterruptedException ie ) {
        System.out.println( ie.getMessage() );
      }
      repaint();
    }
  }

  public void paint( Graphics g ) {
    g.setColor( new Color( 255, 255 - c, 0 ) );
    g.fillRect( 5, 5, c / 2, 30 );
    g.setColor( Color.white );
    g.drawString( cname + "  :  " + c, 25, 25 );
  }
}
