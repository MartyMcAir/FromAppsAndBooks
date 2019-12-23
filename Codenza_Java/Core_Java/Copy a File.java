Copy a File

import java.io.*;

     public class jCOPY {
         public static void main(String args[]){
             try {
             jCOPY j = new jCOPY();
             j.CopyFile(new File(args[0]),new File(args[1]));
         }
             catch (Exception e) {
             e.printStackTrace();
         }
     }
    
         public void CopyFile(File in, File out) throws Exception {
         FileInputStream fis = new FileInputStream(in);
         FileOutputStream fos = new FileOutputStream(out);
         byte[] buf = new byte[1024];
         int i = 0;
             while((i=fis.read(buf))!=-1) {
             fos.write(buf, 0, i);
         }
         fis.close();
         fos.close();
     }
}
