FileTest

import java.io.*;
import java.util.*;

class FileTest {
    public static void main(String[] args) {
        //-- Make sure there is one parameter
        if (args.length != 1) {
            System.err.println("ERROR: must have 1 parameter");
            System.exit(1);
        }
       
        try {
            File f = new File(args[0]);
            long d;
          
            System.out.println("getName()          = " + f.getName());
            System.out.println("getAbsoluteFile().getName() = " 
                              + f.getAbsoluteFile().getName());
            boolean exists = f.exists();
            System.out.println("exists()           = " + exists);
            if (!exists) {
                System.exit(1);
            }
            System.out.println("canRead()          = " + f.canRead());
            System.out.println("canWrite()         = " + f.canWrite());
            System.out.println("getPath()          = " + f.getPath());
            System.out.println("getAbsolutePath()  = " + f.getAbsolutePath());
            System.out.println("getCanonicalPath() = " + f.getCanonicalPath());
            System.out.println("getAbsoluteFile()  = " + f.getAbsoluteFile());
            System.out.println("toURL()            = " + f.toURL());
            System.out.println("toURI()            = " + f.toURI());
            System.out.println("getParent()        = " + f.getParent());
            System.out.println("isAbsolute()       = " + f.isAbsolute());
            boolean isDirectory = f.isDirectory();
            System.out.println("isDirectory()      = " + isDirectory);
            System.out.println("isFile()           = " + f.isFile());
            System.out.println("isHidden()         = " + f.isHidden());
            System.out.println("lastModified()     = " + (d = f.lastModified())
                               + " = " + new Date(d));
            System.out.println("length()           = " + f.length());
            if (isDirectory) {
                String[] subfiles = f.list();
                for (int i=0; i<subfiles.length; i++) {
                    System.out.println("file in this dir   = " + subfiles[i]);
                }
            }
        } catch (IOException iox) {
           System.err.println(iox);
        }
    }//endmethod main
}//endclass FileTest
