Formatting real number with Decimal

import java.text.*;
    public class NumFormat {
         public static void main (String[] args) {
         DecimalFormat science = new DecimalFormat("0.000E0");
         DecimalFormat plain = new DecimalFormat("0.0000");
        
             for(double d=100.0; d<140.0; d*=1.10) {
             System.out.println("Scientific: " + science.format(d) +
             " and Plain: " + plain.format(d));
         }
     }
}
