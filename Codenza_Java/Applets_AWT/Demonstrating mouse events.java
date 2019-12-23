Demonstrating mouse events

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

 public class MouseTracker extends JFrame implements MouseListener, MouseMotionListener
 {
	 private JLabel statusBar;

	 public MouseTracker()
	 {
		 super( "Demonstrating Mouse Events" );

		 statusBar = new JLabel();
		 getContentPane().add( statusBar, BorderLayout.SOUTH );

		 // application listens to its own mouse events
		 addMouseListener( this );
		 addMouseMotionListener( this );

		 setSize( 275, 100 );
		 show();
	 }

	 // MouseListener event handlers
	 public void mouseClicked( MouseEvent e )
	 {
		 statusBar.setText( "Clicked at [" + e.getX() + ", " + e.getY() + "]" );
	 }

	 public void mousePressed( MouseEvent e )
	 {
		 statusBar.setText( "Pressed at [" + e.getX() + ", " + e.getY() + "]" );
	 }

	 public void mouseReleased( MouseEvent e )
	 {
		 statusBar.setText( "Released at [" + e.getX() + ", " + e.getY() + "]" );
	 }

	 public void mouseEntered( MouseEvent e )
	 {
		 statusBar.setText( "Mouse in window" );
	 }

	 public void mouseExited( MouseEvent e )
	 {
		 statusBar.setText( "Mouse outside window" );
	 }

	 // MouseMotionListener event handlers
	 public void mouseDragged( MouseEvent e )
	 {
		 statusBar.setText( "Dragged at [" + e.getX() + ", " + e.getY() + "]" );
	 }

	 public void mouseMoved( MouseEvent e )
	 {
		 statusBar.setText( "Moved at [" + e.getX() + ", " + e.getY() + "]" );
	 }

	 public static void main( String args[] )
	 {
		 MouseTracker app = new MouseTracker();

		 app.addWindowListener( new WindowAdapter()
		 {
			 public void windowClosing( WindowEvent e )
			 {
				 System.exit( 0 );
			 }
		 } );
	 }
 }
