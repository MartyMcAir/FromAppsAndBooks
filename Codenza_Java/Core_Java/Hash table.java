Hash table

import java.util.*;


    public class SortHashtabledesc {
    
         public static void main(String[] args) {
         // Create and populate hashtable
         Hashtable ht = new Hashtable();
         ht.put("abc",new Double(3445.23));
         ht.put("xyz",new Double(2333.56));
         ht.put("pqr",new Double(3900.88));
         ht.put("mno",new Double(2449.00));
        
         // Sort hashtable.
         Vector v = new Vector(ht.keySet());
         Collections.sort(v, Collections.reverseOrder());
         
         // Display (sorted) hashtable.
             for (Enumeration e = v.elements(); e.hasMoreElements();) {
             String key = (String)e.nextElement();
             System.out.println(key+":"+ht.get(key));
             
             
             System.out.println();
         }
     }
}
