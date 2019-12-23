List all '.java' files present in a directory.

import java.io.*;

public class FileExt
    {
     public static void main(String args[])
         {
         try
             {
             String[] filesList;
             File dir = new File(".");
             filesList= dir.list(new FileFilter());
            
             for (int i=0;i                 {
                 System.out.println(filesList[i]);
             }
         }
         catch(Exception e){}
     }
}

class FileFilter implements FilenameFilter
    {
     public boolean accept(File dir, String name)
         {
         return (name.endsWith(".java"));
     }
}
