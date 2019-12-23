Byte to Binary Conversion

import java.io.*;

/**
* BinCat is a simple class for reading bytes and 
* writting them back out in binary representation.
*/
    public class BinCat {
     BufferedInputStream brIn;
     PrintStream psOut;
    
     public static int BYTES_PER_LINE = 4;
    
         public BinCat() {
         this(System.in,System.out);
     }
    
         public BinCat(InputStream in, OutputStream out) {
         brIn = new BufferedInputStream(in);
         if (out instanceof PrintStream)
         psOut = (PrintStream)out;
         else
         psOut = new PrintStream(out);
     }
    
     
    
         public void doit() {
         int ch, cv, bit, cnt;
             try {
                 for(cnt = 0, ch = brIn.read(); ch >= 0; ch = brIn.read()) {
                 cv = ((int)ch & 0x00ff);
                     for(bit = 7; bit >= 0; bit--) {
                     if ((cv & (2 << bit)) > 0)
                     psOut.print("1");
                     else
                     psOut.print("0");
                 }
                 cnt++;
                 if ((cnt % BYTES_PER_LINE) == 0) 
                 psOut.println("");
             }
         } catch (IOException e) { }
         return;
     }
    
     /**
     * Test main for BinCat 
     */
         public static void main(String args[]) {
         BinCat kitty;
         kitty = new BinCat();
         kitty.doit();
         System.exit(0);
     }
}
