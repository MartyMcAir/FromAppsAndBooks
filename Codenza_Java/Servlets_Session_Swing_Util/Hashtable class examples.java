Hashtable class examples

 // Demonstrates class Hashtable of the java.util package.
 import java.util.*;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

 public class HashtableTest extends JFrame 
 {

	 public HashtableTest()
	 {
		 super( "Hashtable Example" );

		 final JLabel status = new JLabel();
		 final Hashtable table = new Hashtable();
		 final JTextArea display = new JTextArea( 4, 20 );
		 display.setEditable( false );

		 JPanel northPanel = new JPanel();
		 northPanel.setLayout( new BorderLayout() );
		 JPanel northSubPanel = new JPanel();
		 northSubPanel.add( new JLabel( "First name" ) );
		 final JTextField fName = new JTextField( 8 );
		 northSubPanel.add( fName );

		 northSubPanel.add( new JLabel( "Last name (key)" ) );
		 final JTextField lName = new JTextField( 8 );
		 northSubPanel.add( lName );
		 northPanel.add( northSubPanel, BorderLayout.NORTH );
		 northPanel.add( status, BorderLayout.SOUTH );

		 JPanel southPanel = new JPanel();
		 southPanel.setLayout( new GridLayout( 2, 5 ) );
		 JButton put = new JButton( "Put" );
		 put.addActionListener( new ActionListener() 
		 {
			 public void actionPerformed( ActionEvent e )
			 {
				 Employee emp = new Employee( fName.getText(), lName.getText() );
				 Object val = table.put( lName.getText(), emp );

				 if ( val == null )
					 status.setText( "Put: " + emp.toString() );
				 else
					 status.setText( "Put: " + emp.toString() + "; Replaced: " + val.toString() );
			 }
		 } );
		 southPanel.add( put );

		 JButton get = new JButton( "Get" );
		 get.addActionListener(	 new ActionListener() 
		 {
			 public void actionPerformed( ActionEvent e )
			 {
				 Object val = table.get( lName.getText() );

				 if ( val != null )
					 status.setText( "Get: " + val.toString() );
				 else
					 status.setText( "Get: " + lName.getText() + " not in table" );
			 }
		 } );
		 southPanel.add( get );

		 JButton remove = new JButton( "Remove" );
		 remove.addActionListener( new ActionListener() 
		 {
			 public void actionPerformed( ActionEvent e )
			 {
				 Object val = table.remove( lName.getText() );

					 if ( val != null )
						 status.setText( "Remove: " + val.toString() );
					 else
						 status.setText( "Remove: " + lName.getText() + " not in table" );
			 }
		 } );
		 southPanel.add( remove );

		 JButton empty = new JButton( "Empty" );
		 empty.addActionListener( new ActionListener() 
		 {
			 public void actionPerformed( ActionEvent e )
			 {
				 status.setText( "Empty: " + table.isEmpty() );
			 }
		 } );
		 southPanel.add( empty );

		 JButton containsKey = new JButton( "Contains key" );
		 containsKey.addActionListener( new ActionListener() 
		 {
			 public void actionPerformed( ActionEvent e )
			 {
				 status.setText( "Contains key: " + table.containsKey( lName.getText() ) );
			 }
		  } );
		  southPanel.add( containsKey );

		 JButton clear = new JButton( "Clear table" );
		 clear.addActionListener( new ActionListener() 
		 { 
			 public void actionPerformed( ActionEvent e )
			 {
				 table.clear();
				 status.setText( "Clear: Table is now empty" );
			 }
		 } );
		 southPanel.add( clear );

		 JButton listElems = new JButton( "List objects" );
		 listElems.addActionListener( new ActionListener() 
		 {
			 public void actionPerformed( ActionEvent e )
			 {
				 StringBuffer buf = new StringBuffer();
				 for ( Enumeration enum = table.elements(); enum.hasMoreElements(); )
					 buf.append( enum.nextElement() ).append( '\n' );

					 display.setText( buf.toString() );
			 }
		 } );
		 southPanel.add( listElems );

		 JButton listKeys = new JButton( "List keys" );
		 listKeys.addActionListener( new ActionListener() 
		 {
			 public void actionPerformed( ActionEvent e )
			 {
				 StringBuffer buf = new StringBuffer();

				 for ( Enumeration enum = table.keys(); enum.hasMoreElements(); )
				 buf.append(enum.nextElement() ).append( '\n' );

				 JOptionPane.showMessageDialog( null, buf.toString(), "Display", JOptionPane.PLAIN_MESSAGE );
			 }
		 } );
		 southPanel.add( listKeys );
		 Container c = getContentPane();
		 c.add( northPanel, BorderLayout.NORTH );
		 c.add( new JScrollPane( display ), BorderLayout.CENTER );
		 c.add( southPanel, BorderLayout.SOUTH );

		 setSize( 540, 300 );
		 show();
	 }

	 public static void main( String args[] )
	 {
		 HashtableTest app = new HashtableTest();

		 app.addWindowListener( new WindowAdapter() 
		 {
			 public void windowClosing( WindowEvent e )
			 {
				 System.exit( 0 );
			 }
		 } );
	 }
 }

 class Employee 
 {
	 private String first, last;

	 public Employee( String fName, String lName )
	 {
		 first = fName;
		 last = lName;
	 }

	 public String toString() 
	 { 
		 return first + " " + last; 
	 }
 }
