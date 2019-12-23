Writing a Thread-Safe Singleton

public class JGKSingleton 
    {
     /* Here is the instance of the Singleton */
     private static JGKSingleton instance_;
     /* Need the following object to synchronize */
     /* a block */
     private static Object syncObject_;
     /* Prevent direct access to the constructor*/
     private JGKSingleton() 
         {
         super();
     }
     public static JGKSingleton getInstance() 
         {
         /* in a non-thread-safe version of a Singleton the following line could be executed, and the */ 
         /* thread could be immediately swapped out */
         if (instance_ == null) 
             {
             synchronized(syncObject_) 
                 {
                 if (instance_ == null) 
                     {
                     instance_ = new JGKSingleton();
                 }
             }
         }
         return instance_;
     }
}
