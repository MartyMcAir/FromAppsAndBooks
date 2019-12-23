Currency Formatter

import java.text.*;
import java.io.*;

    class CurrencyFormatter{
    public static void main(String[] args)
    throws java.io.IOException, java.text.ParseException
        {
        
        BufferedReader inStream=
         new BufferedReader(new InputStreamReader(System.in));
        
        double currency;
        
        NumberFormat currencyFormatter=
         NumberFormat.getCurrencyInstance();
        
        NumberFormat numberFormatter=
         NumberFormat.getInstance();
        
        String currencyOut;
        
        System.out.println("Please enter a number to be formatted as currency:\n");
        
        currency=numberFormatter.parse(inStream.readLine()).doubleValue();
        
        currencyOut=currencyFormatter.format(currency);
        
        System.out.println("\n\nThe number formatted as currency is:\n");
        System.out.println(currencyOut);
        
    }//close main
    
}//close class
