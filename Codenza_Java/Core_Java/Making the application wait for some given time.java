Making the application wait for some given time

import java.util.*;

public class WaitForSomeTime
    {
     public static void main(String args[])
         {
         WaitForSomeTime waitForSomeTime = new WaitForSomeTime();
         waitForSomeTime.myMethod();
     }
    
     public void myMethod()
         {
         System.out.println("Starting......");
        
         // pause for a while
         Thread thisThread = Thread.currentThread();
         try
             {
             thisThread.sleep(10000);
         }
         catch (Throwable t)
             {
             throw new OutOfMemoryError("An Error has occured");
         }
         System.out.println("Ending......");
        
     }
}
