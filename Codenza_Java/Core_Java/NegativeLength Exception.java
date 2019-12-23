NegativeLength Exception

import java.io.*;
    public class NegativeLengthException extends Exception {
    
     /** Test NegativeLengthException */
    
         public static void main(String[] args) {
             try {
             int lineLength = readLength();
                 for(int i=0; i                 System.out.print("*");
             }
             System.out.println();
             } catch (NegativeLengthException nle) {
             System.out.println("NegativeLengthException: " +
             nle.getMessage());
         }
     }
    
         public NegativeLengthException() {
         super("Negative dimensions not permitted.");
     }
    
         public NegativeLengthException(String message) {
         super(message);
     }
    
     // readLength catches IOExceptions locally but lets the
     // calling method handle NegativeLengthExceptions.
         private static int readLength() throws NegativeLengthException {
         BufferedReader in = new BufferedReader(
         new InputStreamReader(System.in));
         System.out.print("Enter length: ");
         System.out.flush();
         int len = 0;
             try {
             String line = in.readLine();
             len = Integer.parseInt(line);
                 if (len < 0) {
                 throw new NegativeLengthException();
             }
             } catch (IOException ioe) {
             System.out.println("Problem reading from keyboard");
         }
         return(len);
     }
}
