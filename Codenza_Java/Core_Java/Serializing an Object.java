Serializing an Object

     public static void main(String args[]){
         try{
         Object object = new javax.swing.JButton("push me");
        
         // Serialize to a file
         ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
         out.writeObject(object);
         out.close();
        
         // Serialize to a byte array
         ByteArrayOutputStream bos = new ByteArrayOutputStream() ;
         out = new ObjectOutputStream(bos) ;
         out.writeObject(object);
         out.close();
        
         // Get the bytes of the serialized object
         byte[] buf = bos.toByteArray();
     }
         catch (Exception ioe){
         ioe.printStackTrace();
     }
}
