Serialize an Object to a File

import java.util.Vector;
import java.io.*;

     public class Queue extends Vector {
     /*
     ** FIFO, first in first out
     */
         Queue() {
         super();
     }
     
         void put(Object o) {
         addElement(o);
     }
    
         Object get() {
         if (isEmpty()) return null;
         Object o = firstElement();
         removeElement(o);
         return o;
     }
    
         Object peek() {
         if (isEmpty()) return null;
         return firstElement();
     }
 }

//To serialize (save the Queue state to a file) :

     public static void main(String args[]) {
     Queue theQueue;
      
     theQueue = new Queue();
     theQueue.put("element 1");
     theQueue.put("element 2");
     theQueue.put("element 3");
     theQueue.put("element 4");
     System.out.println(theQueue.toString());
      
     // serialize the Queue
     System.out.println("serializing theQueue");
         try {
         FileOutputStream fout = new FileOutputStream("thequeue.dat");
         ObjectOutputStream oos = new ObjectOutputStream(fout);
         oos.writeObject(theQueue);
         oos.close();
     }
     catch (Exception e) { e.printStackTrace(); }
}

//To unserialize (to load a previously saved Queue) :

     public static void main(String args[]) {
     Queue theQueue;
        
     theQueue = new Queue();
        
     // unserialize the Queue
     System.out.println("unserializing theQueue");
         try {
         FileInputStream fin = new FileInputStream("thequeue.dat");
         ObjectInputStream ois = new ObjectInputStream(fin);
         theQueue = (Queue) ois.readObject();
         ois.close();
     }
     catch (Exception e) { e.printStackTrace(); }
         
     System.out.println(theQueue.toString());    
}
