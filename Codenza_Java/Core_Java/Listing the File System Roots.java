Listing the File System Roots

     public static void main(String args[]){
         try{
         File[] roots = File.listRoots();
             for (int i=0; i             System.out.println((roots[i]));
         }
     }
         catch (Exception ioe){
         ioe.printStackTrace();
     }
}
