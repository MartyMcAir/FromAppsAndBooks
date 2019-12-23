Writing UTF-8 Encoded Data

     public static void main(String args[]){
         try{
         Writer out = new BufferedWriter(new OutputStreamWriter(
         new FileOutputStream("outfilename"), "UTF8"));
         out.write(aString);
         out.close();
     }
         catch (Exception ioe){
         ioe.printStackTrace();
     }
}
