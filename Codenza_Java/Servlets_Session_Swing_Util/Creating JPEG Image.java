Creating JPEG Image

import java.awt.*;
import java.io.*;
import java.awt.image.*;
import com.sun.image.codec.jpeg.*;
public class ScreenImage 
    { 
     public ScreenImage() 
         { 
         OutputStream out = null; 
         try 
             { 
             BufferedImage shot = (new Robot()).createScreenCapture(new Rectangle(0, 0, 800,600)); 
             out = new BufferedOutputStream(new FileOutputStream("shot.jpg")); 
             JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
             encoder.encode(shot); 
         } 
         catch (Exception exc) 
             { 
             exc.printStackTrace(); 
         } 
         finally 
             { 
             try 
                 { 
                 if (out != null) 
                     { 
                     out.close(); 
                 } 
                 System.exit(0); 
             } 
             catch (Throwable t) {} 
         } 
     } 
     public static void main(String[] args) 
         { 
         new ScreenImage(); 
     }
}
