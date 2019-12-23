Moving a File or Directory to Another Directory

     public static void main(String args[]){
         try{
         // File (or directory) to be moved
         File file = new File("file.txt");
        
         // Destination directory
         File dir = new File("gg");
        
         // Move file to new directory
         boolean success = file.renameTo(new File(dir, file.getName()));
             if (!success) {
             System.out.println("File moved");
         }
     }
         catch (Exception ioe){
         ioe.printStackTrace();
     }
}
