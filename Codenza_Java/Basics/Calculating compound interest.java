Calculating compound interest

 import java.text.DecimalFormat;
 import javax.swing.JOptionPane;
 import javax.swing.JTextArea;

 public class Interest 
 {
	 public static void main( String args[] )
	 {
		 double amount, principal = 1000.0, rate = .05;

		 DecimalFormat precisionTwo = new DecimalFormat( "0.00" );
		 JTextArea outputTextArea = new JTextArea( 11, 20 );

		 outputTextArea.append( "Year\tAmount on deposit\n" );

		 for ( int year = 1; year <= 10; year++ ) 
		 {
			 amount = principal * Math.pow( 1.0 + rate, year );
			 outputTextArea.append( year + "\t" +
			 precisionTwo.format( amount ) + "\n" );
		 }

		 JOptionPane.showMessageDialog( null, outputTextArea, "Compound Interest", JOptionPane.INFORMATION_MESSAGE );

		 System.exit( 0 ); // terminate the application
	}
 }
