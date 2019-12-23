Listing the Files or Subdirectories in a Directory

     public static void main(String args[]){
         try{
         File dir = new File("d:\\temp");
        
         String[] children = dir.list();
             if (children == null) {
             System.out.println("Directory does not exist or is not a Directory");
             } else {
                 for (int i=0; i                 // Get filename of file or directory
                 String filename = children[i];
                 System.out.println(filename);
             }
         }
        
         // It is also possible to filter the list of returned files.
         // This example does not return any files that start with `.'.
             FilenameFilter filter = new FilenameFilter() {
                 public boolean accept(File dir, String name) {
                 return !name.startsWith(".");
             }
         };
         children = dir.list(filter);
        
        
         // The list of files can also be retrieved as File objects
         File[] files = dir.listFiles();
        
         // This filter only returns directories
             FileFilter fileFilter = new FileFilter() {
                 public boolean accept(File file) {
                 return file.isDirectory();
             }
         };
         files = dir.listFiles(fileFilter);
     }
         catch (Exception ioe){
         ioe.printStackTrace();
     }
}
