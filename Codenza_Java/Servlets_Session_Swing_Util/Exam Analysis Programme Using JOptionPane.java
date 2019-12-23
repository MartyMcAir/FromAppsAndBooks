Exam Analysis Programme Using JOptionPane

import javax.swing.JOptionPane;
public class ExamAnalysis
     {
     public static void main( String args[] )
         {
         // initializing variables in declarations
         int passes = 0, // number of passes
         failures = 0, // number of failures
         student = 1, // student counter
         result; // one exam result
         String input, // user-entered value
         output; // output string
        
         // process 10 students; counter-controlled loop
         while ( student <= 10 )
             {
             input = JOptionPane.showInputDialog( "Enter result (1=pass,2=fail)" );
             result = Integer.parseInt( input );
            
             if ( result == 1 )
             passes = passes + 1;
             else
             failures = failures + 1;
            
             student = student + 1;
         }
        
         // termination phase
         output = "Passed: " + passes + "\nFailed: " + failures;
         if( passes > 8 )
         output = output + "\nRaise Tuition";
        
         JOptionPane.showMessageDialog( null, output, "Analysis of Examination Results", JOptionPane.INFORMATION_MESSAGE );
        
         System.exit( 0 );
     }
}
