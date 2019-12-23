Display all available Font families and Font Faces

public static void main(String args[])
    {
     // Get all font family names
     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
     String fontNames[] = ge.getAvailableFontFamilyNames();
     Font[] fonts = ge.getAllFonts();
    
         for (int i=0; i         //System.out.println(fontNames[i]);
     }
    
     // Display some font sizes
     String fontSizes[] = new String[64];
         for ( int i = 0; i < fontSizes.length; i++ ){
         fontSizes[i] = Integer.toString( i+7 );
         //System.out.println(fontSizes[i]);
     }
    
     // Process each font
         for (int i=0; i         // Get font's family and face
         String familyName = fonts[i].getFamily();
         String faceName = fonts[i].getName();
         System.out.println(familyName);
         System.out.println(faceName);
     }
}
