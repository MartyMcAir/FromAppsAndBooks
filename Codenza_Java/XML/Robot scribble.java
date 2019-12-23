Robot scribble
  
 

package com.ack.gui.awt.simple;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RobotScribble
    extends Canvas
    implements MouseListener, MouseMotionListener {
  int maxX, maxY, minMaxXY, xCenter, yCenter;
  private Dimension size = new Dimension( 600, 600 );
  private static final int ROBOT_DELAY = 20;
  int old_mouse_x = 0;
  int old_mouse_y = 0;
  private Robot robot;

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

  public void takeControl() {
    initgr();
    try {
      robot = new Robot();
    }
    catch( AWTException ex ) {
      ex.printStackTrace();
      System.exit( 1 );
    }
  
    float side = 0.95F * minMaxXY,
        sideHalf = 0.5F * side,
        h = sideHalf * (float) Math.sqrt( 3 ),
        xA,
        yA,
        xB,
        yB,
        xC,
        yC,
        xA1,
        yA1,
        xB1,
        yB1,
        xC1,
        yC1,
        p,
        q;
    q = 0.05F;
    p = 1 - q;
    xA = xCenter - sideHalf;
    yA = yCenter - 0.5F * h;
    xB = xCenter + sideHalf;
    yB = yA;
    xC = xCenter;
    yC = yCenter + 0.5F * h;
    for( int i = 0; i < 50; i++ ) {
      moveRobot( iX( xA ), iY( yA ), iX( xB ), iY( yB ) );
      moveRobot( iX( xB ), iY( yB ), iX( xC ), iY( yC ) );
      moveRobot( iX( xC ), iY( yC ), iX( xA ), iY( yA ) );
      xA1 = p * xA + q * xB;
      yA1 = p * yA + q * yB;
      xB1 = p * xB + q * xC;
      yB1 = p * yB + q * yC;
      xC1 = p * xC + q * xA;
      yC1 = p * yC + q * yA;
      xA = xA1;
      xB = xB1;
      xC = xC1;
      yA = yA1;
      yB = yB1;
      yC = yC1;
    }
  }

  public void moveRobot( int x1, int y1, int x2, int y2 ) {
    robot.delay( ROBOT_DELAY );
    robot.mouseMove( x1, y1 );
    robot.mousePress( InputEvent.BUTTON1_MASK );
    robot.delay( ROBOT_DELAY );
    robot.mouseMove( x2, y2 );
    robot.mouseRelease( InputEvent.BUTTON1_MASK );
  }

  void initgr() {
    maxX = size.width - 1;
    maxY = size.height - 1;
    minMaxXY = Math.min( maxX, maxY );
    xCenter = maxX / 2;
    yCenter = maxY / 2;
  }

  int iX( float x ) {
    return Math.round( x );
  }

  int iY( float y ) {
    return maxY - Math.round( y );
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
    RobotScribble robotScribble = new RobotScribble();
    robotScribble.addMouseListener( robotScribble );
    robotScribble.addMouseMotionListener( robotScribble );
    myFrame.add( robotScribble );
    myFrame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent we ) {
        System.exit( 0 );
      }
    } );
    myFrame.pack();
    myFrame.setVisible( true );
    robotScribble.takeControl();
  }

  public Dimension getPreferredSize() {
    return size;
  }
}
