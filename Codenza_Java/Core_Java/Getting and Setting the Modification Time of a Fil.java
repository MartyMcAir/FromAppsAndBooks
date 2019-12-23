Getting and Setting the Modification Time of a File or Directory

     public static void main(String args[]){
         try{
         File file = new File("file.txt");
        
         // Get the last modified time
         long modifiedTime = file.lastModified();
         // 0L is returned if the file does not exist
        
         // Set the last modified time
         long newModifiedTime = System.currentTimeMillis();
         boolean success = file.setLastModified(newModifiedTime);
             if (!success) {
             System.out.println("Operation failed");
         }
     }
         catch (Exception ioe){
         ioe.printStackTrace();
     }
}
