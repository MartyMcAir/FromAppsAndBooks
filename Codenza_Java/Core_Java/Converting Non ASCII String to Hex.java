Converting Non ASCII String to Hex

public static String toHexString(char c)
    {
     String rep;
     String temp;
     int low = c & 0x00FF;
     int high = c & 0xFF00;
     temp = Integer.toHexString(low);
     if( temp.length() == 1 )
     temp = "0" + temp;
    
     rep = temp;
    
     temp = Integer.toHexString(high);
     if( temp.length() == 1 )
     temp = "0" + temp;
    
     rep += temp;
     // If you want a space between bytes
     // rep += " " + temp;
    
     return rep;
}

public static void main(String a[])
    {
     String str = toHexString('b');
     System.out.println(str);
}
