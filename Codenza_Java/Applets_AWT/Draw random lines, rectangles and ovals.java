Draw random lines, rectangles and ovals

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

 public class DrawShapes extends JApplet 
 {
	 private JButton choices[];
	 private String names[] = { "Line", "Rectangle", "Oval" };
	 private JPanel buttonPanel;
	 private DrawPanel drawingArea;
	 private int width = 300, height = 200;

	 public void init()
	 {
		 drawingArea = new DrawPanel( width, height );

		 choices = new JButton[ names.length ];
		 buttonPanel = new JPanel();
		 buttonPanel.setLayout( new GridLayout( 1, choices.length ) );
		 ButtonHandler handler = new ButtonHandler();

		 for ( int i = 0; i < choices.length; i++ ) 
		 {
			 choices[ i ] = new JButton( names[ i ] );
			 buttonPanel.add( choices[ i ] );
			 choices[ i ].addActionListener( handler );
		 }
		 Container c = getContentPane();
		 c.add( buttonPanel, BorderLayout.NORTH );
		 c.add( drawingArea, BorderLayout.CENTER );
	 }

	 public void setWidth( int w )
	 { 
		 width = ( w >= 0 ? w : 300 ); 
	 }

	 public void setHeight( int h )
	 { 
		 height = ( h >= 0 ? h : 200 ); 
	 }

	 public static void main( String args[] )
	 {
		 int width, height;

		 if ( args.length != 2 ) 
		 { 
			 // no command-line arguments
			 width = 300;
			 height = 200;
		 }
		 else 
		 {
			 width = Integer.parseInt( args[ 0 ] );
			 height = Integer.parseInt( args[ 1 ] );
		 }

		 // create window in which applet will execute
		 JFrame applicationWindow = new JFrame( "An applet running as an application" );

		 applicationWindow.addWindowListener( new WindowAdapter() 
		 {
			 public void windowClosing( WindowEvent e )
			 {
				 System.exit( 0 );
			 }
		 } );

		 // create one applet instance
		 DrawShapes appletObject = new DrawShapes();
		 appletObject.setWidth( width );
		 appletObject.setHeight( height );

		 // call applet's init and start methods
		 appletObject.init();
		 appletObject.start();

		 // attach applet to center of window
		 applicationWindow.getContentPane().add( appletObject );

		 // set the window's size
		 applicationWindow.setSize( width, height );

		 // showing the window causes all GUI components
		 // attached to the window to be painted
		 applicationWindow.show();
	 }

	 private class ButtonHandler implements ActionListener 
	 {
		 public void actionPerformed( ActionEvent e )
		 {
			 for ( int i = 0; i < choices.length; i++ )
				 if ( e.getSource() == choices[ i ] ) 
				 {
					 drawingArea.setCurrentChoice( i );
					 break;
				 }
		 }
	 }
 }

 // subclass of JPanel to allow drawing in a separate area
 class DrawPanel extends JPanel 
 {
	 private int currentChoice = -1; // don't draw first time
	 private int width = 100, height = 100;
	 public DrawPanel( int w, int h )
	 {
		 width = ( w >= 0 ? w : 100 );
		 height = ( h >= 0 ? h : 100 );
	 }

	 public void paintComponent( Graphics g )
	 {
		 super.paintComponent( g );

		 switch( currentChoice ) 
		 {
			 case 0:
				 g.drawLine( randomX(), randomY(), randomX(), randomY() );
				 break;
			 case 1:
				 g.drawRect( randomX(), randomY(), randomX(), randomY() );
				 break;
			 case 2:
				 g.drawOval( randomX(), randomY(), randomX(), randomY() );
				 break;
		 }
	 }

	 public void setCurrentChoice( int c )
	 {
		 currentChoice = c;
		 repaint();
	 }
	 private int randomX()
	 { 
		 return (int) ( Math.random() * width ); 
	 }

	 private int randomY()
	 { 
		 return (int) ( Math.random() * height ); 
	 }
 }
