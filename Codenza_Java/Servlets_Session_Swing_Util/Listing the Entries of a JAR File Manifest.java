Listing the Entries of a JAR File Manifest

public static void main(String args[])
    {
         try {
         // Open the JAR file
         JarFile jarfile = new JarFile("abc.jar");
        
         // Get the manifest
         Manifest manifest = jarfile.getManifest();
        
         // Get the manifest entries
         Map map = manifest.getEntries();
        
         // Enumerate each entry
             for (Iterator it=map.keySet().iterator(); it.hasNext(); ) {
             // Get entry name
             String entryName = (String)it.next();
            
             // Get all attributes for the entry
             Attributes attrs = (Attributes)map.get(entryName);
            
             // Enumerate each attribute
                 for (Iterator it2=attrs.keySet().iterator(); it2.hasNext(); ) {
                 // Get attribute name
                 Attributes.Name attrName = (Attributes.Name)it2.next();
                
                 // Get attribute value
                 String attrValue = attrs.getValue(attrName);
             }
         }
         } catch (IOException e) {
     }
}
