Drawing lines, rectangles and ovals

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

 public class LinesRectsOvals extends JFrame 
 {
	 private String s = "Using drawString!";

	 public LinesRectsOvals()
	 {
		 super( "Drawing lines, rectangles and ovals" );

		 setSize( 400, 165 );
		 show();
	 }

	 public void paint( Graphics g )
	 {
		 g.setColor( Color.red );
		 g.drawLine( 5, 30, 350, 30 );

		 g.setColor( Color.blue );
		 g.drawRect( 5, 40, 90, 55 );
		 g.fillRect( 100, 40, 90, 55 );

		 g.setColor( Color.cyan );
		 g.fillRoundRect( 195, 40, 90, 55, 50, 50 );
		 g.drawRoundRect( 290, 40, 90, 55, 20, 20 );

		 g.setColor( Color.yellow );
		 g.draw3DRect( 5, 100, 90, 55, true );
		 g.fill3DRect( 100, 100, 90, 55, false );

		 g.setColor( Color.magenta );
		 g.drawOval( 195, 100, 90, 55 );
		 g.fillOval( 290, 100, 90, 55 );
	 }

	 public static void main( String args[] )
	 {
		 LinesRectsOvals app = new LinesRectsOvals();

		 app.addWindowListener( new WindowAdapter() 
		 {
			 public void windowClosing( WindowEvent e )
			 {
				 System.exit( 0 );
			 }
		 });
	 }
 }
