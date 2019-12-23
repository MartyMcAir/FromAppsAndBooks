Automatically create and delete a file

import java.util.*;
import java.io.*;
public class ab extends TimerTask
    {
     static File file;
     public static void main(String[] args ) throws IOException
         {
         file = new File ("test.dat");
         if (! file.exists() )
             {
             file.createNewFile();
         }
         System.out.println("File Created");
         ab test = new ab();
         Timer t = new Timer ();
         t.schedule(test, 30*1000L);
         try
             {
             while (file.exists())
                 {
                 System.out.print('.');
                 Thread.sleep(1000);
             }
         }
         catch (InterruptedException ie)
             {
             System.out.println("Error");
         }
         System.exit(0);
     } //end of main
     public void run()
         {
         file.delete();
     }
} //end of public class ab
