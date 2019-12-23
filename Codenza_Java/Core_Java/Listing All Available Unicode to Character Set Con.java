Listing All Available Unicode to Character Set Converters

public static void main(String args[])
    {
     Map map = Charset.availableCharsets();
     Iterator it = map.keySet().iterator();
         while (it.hasNext()) {
         // Get charset name
         String charsetName = (String)it.next();
         System.out.println("Charset Name "+charsetName);
        
         // Get charset
         Charset charset = Charset.forName(charsetName);
         System.out.println("Charset "+charset);
     }
}
