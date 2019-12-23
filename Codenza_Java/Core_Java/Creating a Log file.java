Creating a Log file

import java.io.*;
 import java.text.*;
 import java.util.*;

     public class MsgLog {
     protected static String defaultLogFile = "c:\\msglog.txt";
    
         public static void write(String s) throws IOException {
         write(defaultLogFile, s);
     }
    
         public static void write(String f, String s) throws IOException {
         TimeZone tz = TimeZone.getTimeZone("EST"); // or PST, MID, etc ...
         Date now = new Date();
         DateFormat df = new SimpleDateFormat ("yyyy.mm.dd hh:mm:ss ");
         df.setTimeZone(tz);
         String currentTime = df.format(now);
        
         FileWriter aWriter = new FileWriter(f, true);
         aWriter.write(currentTime + " " + s + "\n");
         aWriter.flush();
         aWriter.close();
     }
 }
