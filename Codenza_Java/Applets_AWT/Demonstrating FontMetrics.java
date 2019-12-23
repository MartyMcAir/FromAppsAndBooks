Demonstrating FontMetrics

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

 public class Metrics extends JFrame 
 {
	 public Metrics()
	 {
		 super( "Demonstrating FontMetrics" );

		 setSize( 510, 210 );
		 show();
	 }

	 public void paint( Graphics g )
	 {
		 g.setFont( new Font( "SansSerif", Font.BOLD, 12 ) );
		 FontMetrics fm = g.getFontMetrics();
		 g.drawString( "Current font: " + g.getFont(), 10, 40 );
		 g.drawString( "Ascent: " + fm.getAscent(), 10, 55 );
		 g.drawString( "Descent: " + fm.getDescent(), 10, 70 );
		 g.drawString( "Height: " + fm.getHeight(), 10, 85 );
		 g.drawString( "Leading: " + fm.getLeading(), 10, 100 );

		 Font font = new Font( "Serif", Font.ITALIC, 14 );
		 fm = g.getFontMetrics( font );
		 g.setFont( font );
		 g.drawString( "Current font: " + font, 10, 130 );
		 g.drawString( "Ascent: " + fm.getAscent(), 10, 145 );
		 g.drawString( "Descent: " + fm.getDescent(), 10, 160 );
		 g.drawString( "Height: " + fm.getHeight(), 10, 175 );
		 g.drawString( "Leading: " + fm.getLeading(), 10, 190 );
	 }

	 public static void main( String args[] )
	 {
		 Metrics app = new Metrics();

		 app.addWindowListener( new WindowAdapter() 
		 {
			 public void windowClosing( WindowEvent e )
			 {
				 System.exit( 0 );
			 }
		 });
	 }
 }
