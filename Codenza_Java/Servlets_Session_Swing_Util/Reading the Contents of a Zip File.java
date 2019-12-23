Reading the Contents of a Zip File

import java.util.zip.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class ZipRead
    {
     public static void main(String [] args)
         {
         if(args.length!=1)
             {
             System.out.println("Usage: java ZipRead filename e.g java ZipFile test.zip");
             return;
         }
         File f = new File(args[0]);
         if(!f.exists())
             {
             System.out.println("File " + args[0] + " does not exist");
             return;
         }
         SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy hh:mm");
         try
             {
             ZipFile zf = new ZipFile(f);
             Enumeration enum = zf.entries();
             int size = 0;
             System.out.println("Zip Entries:");
             System.out.println("============");
             while(enum.hasMoreElements())
                 {
                 ZipEntry entry = (ZipEntry) enum.nextElement();
                 if(!entry.isDirectory())
                     {
                     System.out.print(df.format(new Date(entry.getTime())));
                     System.out.print("\t");
                     System.out.print(entry.getSize());
                     System.out.print("\t");
                     System.out.println(entry.toString());
                     size++;
                 }
             }
             System.out.println("============");
             System.out.println("" + size + " files found");
             zf.close();
         }
         catch(IOException e)
             {
             System.out.println("Exception: " + e.getMessage());
         }
     }
}
