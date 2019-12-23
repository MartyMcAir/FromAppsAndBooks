Replace a line or word in a file

import java.io.*;

public class BTest
    {
     public static void main(String args[])
         {
         try
             {
             File file = new File("file.txt");
             BufferedReader reader = new BufferedReader(new FileReader(file));
             String line = "", oldtext = "";
             while((line = reader.readLine()) != null)
                 {
                 oldtext += line + "\r\n";
             }
             reader.close();
             // replace a word in a file
             //String newtext = oldtext.replaceAll("drink", "Love");
            
             //To replace a line in a file
             String newtext = oldtext.replaceAll("This is test string 20000", "blah blah blah");
            
             FileWriter writer = new FileWriter("file.txt");
             writer.write(newtext);writer.close();
         }
         catch (IOException ioe)
             {
             ioe.printStackTrace();
         }
     }
}

file.txt
I drink Java
I sleep Java
This is test string 1
This is test string 20000
