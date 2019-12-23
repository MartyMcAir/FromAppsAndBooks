String class

public final class StringEx
    {
     public static void main(String[] args)
         {
         String s1 = "java";
         String s2 = "JAVA";
         char charArray[] = { 'b', 'i', 'r', 't', 'h', ' ', 'd', 'a', 'y' };
         byte byteArray[] = { (byte) 'n', (byte) 'e', (byte) 'w', (byte) ' ', (byte) 'y', (byte) 'e', (byte) 'a', (byte) 'r' };
         StringBuffer buffer;
         String s11, s22, s3, s4, s5, s6;
        
         //comparings
         System.out.println(s1.equals(s2));
         System.out.println(s1.equalsIgnoreCase(s2));
        
         //concating
         System.out.println(s1.concat(s2));
        
         //Constructors
         s11 = new String();
         s22 = new String( s1 );
         s3 = new String( charArray );
         s4 = new String( charArray, 6, 3 );
         s5 = new String( byteArray, 4, 4 );
         s6 = new String( byteArray );
        
         //print hash code for string
         System.out.println(s1.hashCode());
         System.out.println(s2.hashCode());
        
         //indexOf methods
         System.out.println(s1.indexOf('g'));
         System.out.println(s1.indexOf('a',1));
         System.out.println(s1.indexOf('$'));
         System.out.println(s1.lastIndexOf('a'));
         System.out.println(s1.indexOf("ja"));
         System.out.println(s1.lastIndexOf("ja"));
        
         //using intern()
         System.out.println(s1.intern());
         System.out.println(s2.intern());
        
         //length of a string
         System.out.println(s1.length());
        
         //chatAt of a string
         System.out.println(s1.charAt(1));
        
         //getChars() method
         char charArrays[] = new char[5];
         s1.getChars(0,5,charArrays,0);
         System.out.println(charArrays);
        
         //using replace method
         System.out.println(s1.replace('j','J'));
         System.out.println(s1.replaceAll("a","A"));
        
         //toLower and toUpper case conversion
         System.out.println(s2.toLowerCase());
         System.out.println(s1.toUpperCase());
        
         //trim() method
         System.out.println(s1.trim());
        
         //toString()
         System.out.println(s2.toString());
        
         //toCharArray()
         char charArrays1[] = s1.toCharArray();
         System.out.println(charArrays1);
        
         //String starts with and ends with
         System.out.println(s1.startsWith("j"));
         System.out.println(s1.endsWith("a"));
        
         //valueOf() method
         char charAr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
         boolean b = true;
         char c = 'Z';
         int i = 7;
         long l = 10000000;
         float f = 2.5f;
         double d = 33.333;
         Object o = "hello"; // Assign to an Object reference
         String output;
        
         output = "char array = " + String.valueOf( charAr ) + "\npart of char array = " +
         String.valueOf( charAr, 3, 3 ) +
         "\nboolean = " + String.valueOf( b ) +
         "\nchar = " + String.valueOf( c ) +
         "\nint = " + String.valueOf( i ) +
         "\nlong = " + String.valueOf( l ) +
         "\nfloat = " + String.valueOf( f ) +
         "\ndouble = " + String.valueOf( d ) +
         "\nObject = " + String.valueOf( o );
        
         //String substring() method
         System.out.println(s1.substring(2));
         System.out.println(s1.substring(2,5));
     }
}
