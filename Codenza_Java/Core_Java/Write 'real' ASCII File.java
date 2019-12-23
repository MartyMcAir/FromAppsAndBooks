Write 'real' ASCII File

import java.io.*;
 import java.awt.*;

     public class j {
     myFrame f;
         public static void main(String args[]){
         j aj = new j();
         aj.doit();
     }
    
         public void doit(){  
         f = new myFrame();
     }
}

     class myFrame extends Frame {
     TextField tf;
     Button b;
    
         myFrame(){
         setLayout(new FlowLayout());
         tf = new TextField(20);
         b = new Button("Write");
         add(tf);
         add(b);
         setSize(200,200);
         setVisible(true);
     }
    
         public boolean action(Event e, Object o) {
             if (e.target == b) {  
             // TextField content
             String s = tf.getText();
             // JAVA string
             String t = "� \u0082";
                 try {
                 /*
                 ** Deals with TextField content
                 ** we use CodePage850 because this the
                 ** multilingual character set used on the PC.
                 */
                 // output is ASCII (codepage 850)
                 FileOutputStream f = new FileOutputStream("out.dat");
                 f.write(s.getBytes("Cp850"));
                 f.write("\n\r".getBytes());
                 // output is Windows ANSI (if under Win)
                 f.write(s.getBytes());
                 f.write("\n\r".getBytes());
                 /*
                 ** Deals with a JAVA String
                 */
                 // first character stays the same
                 // Unicode escape sequence is translated to ascii
                 f.write(t.getBytes());
                 f.write("\n\r".getBytes());
                 // first char translated
                 // Unicode escape code garbage!
                 f.write(t.getBytes("Cp850"));
                 f.write("\n".getBytes());
                 f.close(); 
                 /*
                 ** the conclusion for String is that you
                 ** can't use both Unicode and converter.
                 */
             }
                 catch (Exception e) {
                 e.printStackTrace();
             }
             return true;
         }
         return false;
     }
 }
