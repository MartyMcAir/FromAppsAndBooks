Deserializing an Object

     public static void main(String args[]){
         try{
         // Deserialize from a file
         File file = new File("filename.ser");
         ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
         // Deserialize the object
         javax.swing.JButton button = (javax.swing.JButton) in.readObject();
         in.close();
        
         // Get some byte array data
         byte[] bytes = getBytesFromFile(file);
         // see e36 Reading a File into a Byte Array for the implementation of this method
        
         // Deserialize from a byte array
         in = new ObjectInputStream(new ByteArrayInputStream(bytes));
         button = (javax.swing.JButton) in.readObject();
         in.close();
     }
         catch (Exception ioe){
         ioe.printStackTrace();
     }
}
