Determining If Two Filename Paths Refer to the Same File

     public static void main(String args[]){
         try{
         File file1 = new File("gg/file.txt");
         File file2 = new File("file.txt");
        
         // Filename paths are not equal
         boolean b = file1.equals(file2); // false
        
         // Normalize the paths
             try {
             file1 = file1.getCanonicalFile(); // c:\almanac1.4\filename
             file2 = file2.getCanonicalFile(); // c:\almanac1.4\filename
             } catch (IOException e) {
         }
        
         // Filename paths are now equal
         b = file1.equals(file2); // true
     }
         catch (Exception ioe){
         ioe.printStackTrace();
     }
}
