Converting Between Strings (Unicode) and Other Character Set Encodings

public static void main(String args[])
    {
     // Create the encoder and decoder for ISO-8859-1
     Charset charset = Charset.forName("ISO-8859-1");
     CharsetDecoder decoder = charset.newDecoder();
     CharsetEncoder encoder = charset.newEncoder();
    
         try {
         // Convert a string to ISO-LATIN-1 bytes in a ByteBuffer
         // The new ByteBuffer is ready to be read.
         ByteBuffer bbuf = encoder.encode(CharBuffer.wrap("a string"));
        
         // Convert ISO-LATIN-1 bytes in a ByteBuffer to a character ByteBuffer and then to a string.
         // The new ByteBuffer is ready to be read.
         CharBuffer cbuf = decoder.decode(bbuf);
         String s = cbuf.toString();
         System.out.println(s);
         } catch (CharacterCodingException e) {
     }
}
