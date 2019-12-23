Reading UTF-8 Encoded Data

     public static void main(String args[]){
         try{
         BufferedReader in = new BufferedReader(
         new InputStreamReader(new FileInputStream("file.txt"), "UTF8"));
         String str = in.readLine();
         System.out.println(str);
     }
         catch (Exception ioe){
         ioe.printStackTrace();
     }
}
