StringBuffer class

public class StringBufferAppend
     {
     public static void main( String args[] )
         {
         Object o = "hello";
         String s = "good bye";
         char charArray[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
         boolean b = true;
         char c = 'Z';
         int i = 7;
         long l = 10000000;
         float f = 2.5f;
         double d = 33.333;
         StringBuffer buf = new StringBuffer();
        
         buf.append( o );
         buf.append( " " );
         buf.append( s );
         buf.append( " " );
         buf.append( charArray );
         buf.append( " " );
         buf.append( charArray, 0, 3 );
         buf.append( " " );
         buf.append( b );
         buf.append( " " );
         buf.append( c );
         buf.append( " " );
         buf.append( i );
         buf.append( " " );
         buf.append( l );
         buf.append( " " );
         buf.append( f );
         buf.append( " " );
         buf.append( d );
        
         //capacity
         buf.ensureCapacity( 75 );
         buf.capacity();
        
         //length
         buf.setLength( 10 );
         buf.length();
        
         //char methods
         char charArr[] = new char[ buf.length() ];
         buf.getChars( 0, buf.length(), charArr, 0 );
         buf.setCharAt( 0, 'H' );
         buf.setCharAt( 6, 'T' );
        
         //reverse
         buf.reverse();
        
         //constructors
         StringBuffer buf1, buf2, buf3;
        
         buf1 = new StringBuffer();
         buf2 = new StringBuffer( 10 );
         buf3 = new StringBuffer( "hello" );
        
         //insert and delete
         buf.insert( 0, o );
         buf.insert( 0, " " );
         buf.deleteCharAt( 10 ); // delete 5 in 2.5
         buf.delete( 2, 6 ); // delete .333 in 33.333
     }
}
