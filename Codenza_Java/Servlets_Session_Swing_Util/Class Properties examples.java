Class Properties examples

 import java.io.*;
 import java.util.*;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

 public class PropertiesTest extends JFrame
 {
	 private JLabel status;
	 private Properties table;
	 private JTextArea display;

	 public PropertiesTest()
	 {
		 super( "Properties Test" );

		 table = new Properties();
		 Container c = getContentPane();
		 JPanel northPanel = new JPanel();
		 northPanel.setLayout( new BorderLayout() );
		 JPanel northSubPanel = new JPanel();
		 JPanel southPanel = new JPanel();

		 northSubPanel.add( new JLabel( "Property value" ) );
		 final JTextField propVal = new JTextField( 10 );
		 northSubPanel.add( propVal );
		 northPanel.add( northSubPanel, BorderLayout.NORTH );

		 northSubPanel.add( new JLabel( "Property name (key)" ) );
		 final JTextField propName = new JTextField( 10 );
		 northSubPanel.add( propName );

		 display = new JTextArea( 4, 35 );

		 JButton put = new JButton( "Put" );
		 put.addActionListener( new ActionListener()
		 {
			 public void actionPerformed( ActionEvent e )
			 {
				 Object val = table.put( propName.getText(), propVal.getText() );

				 if ( val == null )
					 showStatus( "Put: " + propName.getText() + " " + propVal.getText() );
				 else
					 showStatus( "Put: " + propName.getText() + " " + propVal.getText() + "; Replaced: " + val.toString() );

				 listProperties();
			 }
		 } );
		 southPanel.setLayout( new GridLayout( 1, 5 ) );
		 southPanel.add( put );

		 JButton clear = new JButton( "Clear" );
		 clear.addActionListener( new ActionListener()
		 {
			 public void actionPerformed( ActionEvent e )
			 {
				 table.clear();
				 showStatus( "Table in memory cleared" );
				 listProperties();
			 }
		 } );
		 southPanel.add( clear );

		 JButton getProperty = new JButton( "Get property" );
		 getProperty.addActionListener( new ActionListener()
		 {
			 public void actionPerformed( ActionEvent e )
			 {
				 Object val = table.getProperty( propName.getText() );

				 if ( val != null )
					 showStatus( "Get property: " + propName.getText() + " " + val.toString() );
				 else
					 showStatus( "Get: " + propName.getText() + " not in table" );

				 listProperties();
			 }
		 } );
		 southPanel.add( getProperty );

		 JButton save = new JButton( "Save" );
		 save.addActionListener( new ActionListener()
		 {
			 public void actionPerformed( ActionEvent e )
			 {
				 try
				 {
					 FileOutputStream output;

					 output = new FileOutputStream( "props.dat" );
					 table.store( output, "Sample Properties" );
					 output.close();
					 listProperties();
				 }
				 catch( IOException ex )
				 {
					 showStatus( ex.toString() );
				 }
			 }
		 } );
		 southPanel.add( save );

		 JButton load = new JButton( "Load" );
		 load.addActionListener( new ActionListener()
		 {
			 public void actionPerformed( ActionEvent e )
			 {
				 try
				 {
					 FileInputStream input;

					 input = new FileInputStream( "props.dat" );
					 table.load( input );
					 input.close();
					 listProperties();
				 }
				 catch( IOException ex )
				 {
					 showStatus( ex.toString() );
				 }
			 }
		 });
		 southPanel.add( load );

		 status = new JLabel();
		 northPanel.add( status, BorderLayout.SOUTH );

		 c.add( northPanel, BorderLayout.NORTH );
		 c.add( new JScrollPane( display ), BorderLayout.CENTER );
		 c.add( southPanel, BorderLayout.SOUTH );

		 setSize( 550, 225 );
		 show();
	 }

	 public void listProperties()
	 {
		 StringBuffer buf = new StringBuffer();
		 String pName, pVal;

		 Enumeration enum = table.propertyNames();

		 while( enum.hasMoreElements() )
		 {
			 pName = enum.nextElement().toString();
			 pVal = table.getProperty( pName );
			 buf.append( pName ).append( '\t' );
			 buf.append( pVal ).append( '\n' );
		 }

		 display.setText( buf.toString() );
	 }

	 public void showStatus( String s )
	 {
		 status.setText( s );
	 }

	 public static void main( String args[] )
	 {
		 PropertiesTest app = new PropertiesTest();
		 app.addWindowListener( new WindowAdapter()
		 {
			 public void windowClosing( WindowEvent e )
			 {
				 System.exit( 0 );
			 }
		 } );
	 }
 }
