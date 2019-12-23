Using a BitSet to demonstrate the Sieve of Eratosthenes

 import java.awt.*;
 import java.awt.event.*;
 import java.util.*;
 import javax.swing.*;

 public class BitSetTest extends JFrame 
 {

	public BitSetTest()
	 {
		 super( "BitSets" );

		 final BitSet sieve = new BitSet( 1024 );
		 Container c = getContentPane();
		 final JLabel status = new JLabel();
		 c.add( status, BorderLayout.SOUTH );
		 JPanel inputPanel = new JPanel();

		 inputPanel.add( new JLabel( "Enter a value from " + "1 to 1023" ) );
		 final JTextField input = new JTextField( 10 );
		 input.addActionListener( new ActionListener() 
		 {
			 public void actionPerformed( ActionEvent e )
			 {
				 int val = Integer.parseInt( input.getText() );

				 if ( sieve.get( val ) )
					 status.setText( val + " is a prime number" );
				 else
					 status.setText( val + " is not a prime number" );
			 }
		 } );
		 inputPanel.add( input );
		 c.add(inputPanel, BorderLayout.NORTH );

		 JTextArea primes = new JTextArea();
		 ScrollPane p = new ScrollPane();
		 p.add( primes );

		 c.add( p, BorderLayout.CENTER );

		 // set all bits from 1 to 1023
		 int size = sieve.size();

		 for ( int i = 1; i < size; i++ )
			 sieve.set( i );

		 // perform Sieve of Eratosthenes
		 int finalBit = ( int ) Math.sqrt( sieve.size() );

		 for ( int i = 2; i < finalBit; i++ )
			 if ( sieve.get( i ) )
				 for ( int j = 2 * i; j < size; j += i )
					 sieve.clear( j );

		 int counter = 0;

		 for ( int i = 1; i < size; i++ )
			 if ( sieve.get( i ) ) 
			 {
				 primes.append( String.valueOf( i ) );
				 primes.append( ++counter % 7 == 0 ? "\n" : "\t" );
			 }

			 setSize( 300, 250 );
			 show();
	 }

	 public static void main( String args[] )
	 {
		 BitSetTest app = new BitSetTest();
		 app.addWindowListener( new WindowAdapter() 
		 {
			 public void windowClosing( WindowEvent e )
			 {
				 System.exit( 0 );
			 }
		 } );
	 }
 }
