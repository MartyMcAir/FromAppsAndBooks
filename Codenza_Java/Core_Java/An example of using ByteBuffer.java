An example of using ByteBuffer

public static void main(String[] args)
    {
     // Create a ByteBuffer using a byte array
     byte[] bytes = new byte[10];
     ByteBuffer buf = ByteBuffer.wrap(bytes);
    
     // Create a non-direct ByteBuffer with a 10 byte capacity
     // The underlying storage is a byte array.
     buf = ByteBuffer.allocate(10);
    
     // Create a direct (memory-mapped) ByteBuffer with a 10 byte capacity.
     buf = ByteBuffer.allocateDirect(10);
    
     // Get the ByteBuffer's capacity
     int capacity = bbuf.capacity(); // 10
    
     // Use the absolute get(). This method does not affect the position.
     byte b = bbuf.get(5); // position=0
    
     // Set the position
     bbuf.position(5);
    
     // Use the relative get()
     b = bbuf.get();
    
     // Get the new position
     int pos = bbuf.position(); // 6
    
     // Get remaining byte count
     int rem = bbuf.remaining(); // 4
    
     // Set the limit
     bbuf.limit(7); // remaining=1
    
     // This convenience method sets the position to 0
     bbuf.rewind(); // remaining=7
    
     // Use the absolute put(). This method does not affect the position.
     bbuf.put((byte)0xFF); // position=0
    
     // Use the relative put()
     bbuf.put((byte)0xFF);
    
     // This convenience method sets the position to 0
     bbuf.rewind(); // remaining=7
    
    
     /*
     Use ByteBuffer to store Strings
     */
     // Create a character ByteBuffer
     CharBuffer cbuf = buf.asCharBuffer();
    
     // Write a string
     cbuf.put("str");
    
     // Convert character ByteBuffer to a string.
     // Uses characters between current position and limit so flip it first
     cbuf.flip();
     String s = cbuf.toString(); // str Does not affect position
    
     // Get a substring
     int start = 2; // start is relative to cbuf's current position
     int end = 5;
     CharSequence sub = cbuf.subSequence(start, end); // str
    
     /*
     Set Byte Ordering for a ByteBuffer
     */
     // Get default byte ordering
     ByteOrder order = buf.order(); // ByteOrder.BIG_ENDIAN
    
     // Put a multibyte value
     buf.putShort(0, (short)123);
     buf.get(0); // 0
     buf.get(1); // 123
    
     // Set to little endian
     buf.order(ByteOrder.LITTLE_ENDIAN);
    
     // Put a multibyte value
     buf.putShort(0, (short)123);
     buf.get(0); // 123
     buf.get(1); // 0
}
