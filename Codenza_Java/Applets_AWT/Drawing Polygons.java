Drawing Polygons

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

 public class DrawPolygons extends JFrame 
 {
	 public DrawPolygons()
	 {
		 super( "Drawing Polygons" );
		 setSize( 275, 230 );
		 show();
	 }

	 public void paint( Graphics g )
	 {
		 int xValues[] = { 20, 40, 50, 30, 20, 15 };
		 int yValues[] = { 50, 50, 60, 80, 80, 60 };
		 Polygon poly1 = new Polygon( xValues, yValues, 6 );

		 g.drawPolygon( poly1 );

		 int xValues2[] = { 70, 90, 100, 80, 70, 65, 60 };
		 int yValues2[] = { 100, 100, 110, 110, 130, 110, 90 };

		 g.drawPolyline( xValues2, yValues2, 7 );

		 int xValues3[] = { 120, 140, 150, 190 };
		 int yValues3[] = { 40, 70, 80, 60 };

		 g.fillPolygon( xValues3, yValues3, 4 );

		 Polygon poly2 = new Polygon();
		 poly2.addPoint( 165, 135 );
		 poly2.addPoint( 175, 150 );
		 poly2.addPoint( 270, 200 );
		 poly2.addPoint( 200, 220 );
		 poly2.addPoint( 130, 180 );

		 g.fillPolygon( poly2 );
	 }

	 public static void main( String args[] )
	 {
		 DrawPolygons app = new DrawPolygons();

		 app.addWindowListener( new WindowAdapter() 
		 {
			 public void windowClosing( WindowEvent e )
			 {
				 System.exit( 0 );
			 }
		 } );
	 }
}
