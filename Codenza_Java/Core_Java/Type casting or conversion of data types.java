Type casting or conversion of data types

import java.text.*;

public class CastingsORConversions
    {
     public static void main(String a[])
         {
         String str = "java";
         int i = 10;
         //byte byteInt;
        
         //String to Bytes
         byte[] str_bytes = str.getBytes();
        
         //Bytes to String
         String bytes_str = new String(str_bytes);
        
         //int to Bytes
         byte int_bytes = (byte)i;
        
         //Bytes to int
         int bytes_int1 = int_bytes;
        
         //int to String
         String int_str = String.valueOf(i);
        
         //String to int
         int str_int1 = Integer.parseInt(str);
        
         //String to Float
         String str_flt1 = "3.14159";
         Float str_flt2 = Float.valueOf(str_flt1);
        
         //int to float
         int int1_float1 = 10;
         Integer int_one = new Integer(int1_float1);
         float int2_float2 = int_one.floatValue();
        
         //int to double
         int int_dble = 10;
         double int1_dble = (double)int_dble;
        
         //int to double for wrapper classes
         Integer int2_dble = new Integer(10);
         Double int3_dble = new Double(int2_dble.doubleValue());
        
         //int to char
         char int1_char = (char)65;
        
         //double to string
         double dble_str1 = 10.10;
         String dble_str2 = Double.toString(dble_str1);
        
         //double to string with only 2 decimals after the dot
         double dble_str3 = 10.0;
         DecimalFormat fmt = new DecimalFormat( "0.00;-0.00" );
         String stringVal = fmt.format( dble_str3 );
        
         //double to int 1st method
         double dble_int1 = 10.309414484580145;
         int dble_int2 = (int)dble_int1;
        
         //Double to int 2st method
         //if dble_int3 is an instance of Double, use intValue();
         Double dble_int3 = new Double(10.309414484580145);
         int dble_int4 = (int)(dble_int3).intValue();
        
         //Double to Integer
         Double dble_Int1 = new Double(2.0);
         Integer dble_Int2 = new Integer(dble_Int1.intValue());
        
         //double to float
         float dble_flt = (float)2.70;
        
         //Float to float
         Float flt_flt1 = new Float(2.31);
         float flt_flt2 = flt_flt1.floatValue();
        
         //Float to String
         Float flt_str1 = new Float(123456789f);
         System.out.println(new DecimalFormat("0").format(flt_str1));
        
         //flotat to int
         float flt_int1 = 30.0F;
         int flt_int2 = (int)flt_int1;
        
         //float to Float
         float flt_Flt1 = 3.456789012f;
         Float flt_Flt2 = new Float(flt_Flt1);
         float flt_Flt3 = flt_Flt2.floatValue();// convert back to float and check value
        
         //float to double
         float f = 3.12f;
         double d = (float)f;
     }
}
