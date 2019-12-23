Remove last line from file

import java.io.*;

    public class DelLstLine{
         public static void main(String[] arg){
             try{
             RandomAccessFile raf = new RandomAccessFile("RandFile.txt", "rw");
             long length = raf.length();
             System.out.println("File Length="+raf.length());
             //supposing that last line is of 8 
             raf.setLength(length - 8);
             System.out.println("File Length="+raf.length());
             raf.close();
             }catch(Exception ex){
             ex.printStackTrace();
         }
     }//end of psvm
}//class ends
