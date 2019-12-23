Scribble into a canvas
  
 

package com.ack.gui.awt.simple;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScribbleIntoACanvas extends Canvas implements MouseListener, MouseMotionListener {
  int old_mouse_x = 0;
  int old_mouse_y = 0;

  public void mousePressed( MouseEvent e ) {
    old_mouse_x = e.getX();
    old_mouse_y = e.getY();
  }

  public void mouseDragged( MouseEvent e ) {
    Graphics g = getGraphics();
    int x = e.getX(), y = e.getY();
    g.drawLine( old_mouse_x, old_mouse_y, x, y );
    old_mouse_x = x;
    old_mouse_y = y;
  }

  public void mouseReleased( MouseEvent e ) {
    ;
  }

  public void mouseClicked( MouseEvent e ) {
    ;
  }

  public void mouseEntered( MouseEvent e ) {
    ;
  }

  public void mouseExited( MouseEvent e ) {
    ;
  }

  public void mouseMoved( MouseEvent e ) {
    ;
  }

  public static void main( String[] args ) {
    Frame myFrame = new Frame( "Scribble Into A Canvas Example" );
    ScribbleIntoACanvas myCanvas = new ScribbleIntoACanvas();
    myCanvas.addMouseListener( myCanvas );
    myCanvas.addMouseMotionListener( myCanvas );
    myFrame.add( myCanvas );
    myFrame.setSize( 600, 600 );
    myFrame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        System.exit( 0 );
      }
    } );
    myFrame.show();
  }
}
