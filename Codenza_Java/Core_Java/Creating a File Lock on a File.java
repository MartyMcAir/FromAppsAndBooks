Creating a File Lock on a File

public static void main(String[] args)
     {
         try {
         // Get a file channel for the file
         File file = new File("Test.java");
         FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
        
         // Use the file channel to create a lock on the file.
         // This method blocks until it can retrieve the lock.
         FileLock lock = channel.lock();
        
         // Try acquiring the lock without blocking. This method returns
         // null or throws an exception if the file is already locked.
             try {
             lock = channel.tryLock();
             } catch (OverlappingFileLockException e) {
             // File is already locked in this thread or virtual machine
         }
        
         // Release the lock
         lock.release();
        
         // Close the file
         channel.close();
         } catch (Exception e) {
     }
}
