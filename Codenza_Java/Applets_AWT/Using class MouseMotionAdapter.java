Using class MouseMotionAdapter

 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;

 public class Painter extends JFrame 
 {
	 private int xValue = -10, yValue = -10;

	 public Painter()
	 {
		 super( "A simple paint program" );

		 getContentPane().add( new Label( "Drag the mouse to draw" ), BorderLayout.SOUTH );

		 addMouseMotionListener( new MouseMotionAdapter() 
		 {
			 public void mouseDragged( MouseEvent e )
			 {
				 xValue = e.getX();
				 yValue = e.getY();
				 repaint();
			 }
		 } );

		 setSize( 300, 150 );
		 show();
	 }

	 public void paint( Graphics g )
	 {
		 g.fillOval( xValue, yValue, 4, 4 );
	 }

	 public static void main( String args[] )
	 {
		 Painter app = new Painter();

		 app.addWindowListener( new WindowAdapter() 
		 {
			 public void windowClosing( WindowEvent e )
			 {
				 System.exit( 0 );
			 }
		 } );
	 }
 }
