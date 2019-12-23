Writing Log Records Only After a Condition Occurs

public static void main(String args[])
    {
         try {
         // Create a memory handler with a memory of 100 records
         // and dumps the records into the file my.log when a
         // SEVERE message is logged
         FileHandler fhandler = new FileHandler("my.log");
         int numRec = 100;
         MemoryHandler mhandler = new MemoryHandler(fhandler, numRec, Level.SEVERE);
        
         // Add to the desired logger
         Logger logger = Logger.getLogger("com.mycompany");
         logger.addHandler(mhandler);
         } catch (IOException e) {
     }
    
         try {
         // Create a memory handler with a memory of 100 records
         // and dumps the records into the file my.log when a
         // some abitrary condition occurs
         FileHandler fhandler = new FileHandler("my.log");
         int numRec = 100;
             MemoryHandler mhandler = new MemoryHandler(fhandler, numRec, Level.OFF) {
                 public synchronized void publish(LogRecord record) {
                 // Log it before checking the condition
                 super.publish(record);
                
                 boolean condition = false;
                     if (condition) {
                     // Condition occurred so dump buffered records
                     push();
                 }
             }
         };
        
         // Add to the desired logger
         Logger logger = Logger.getLogger("com.mycompany");
         logger.addHandler(mhandler);
         } catch (IOException e) {
     }
    
}
