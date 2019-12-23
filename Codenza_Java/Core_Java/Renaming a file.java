Renaming a file

import java.io.*;

    public class Rename {
         public static void main(String[] argv) throws IOException {
        
         // Construct the file object. Does NOT create a file on disk!
         File f = new File("Rename.java'"); // backup of this source file.
        
         // Rename the backup file to "junk.dat"
         // Renaming requires a File object for the target.
         f.renameTo(new File("junk.dat"));
     }
}
