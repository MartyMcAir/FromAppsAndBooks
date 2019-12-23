Tokenizing Java Source Code

     public static void main(String args[]){
         try{
         // Create the tokenizer to read from a file
         FileReader rd = new FileReader("dd.java");
         StreamTokenizer st = new StreamTokenizer(rd);
        
         // Prepare the tokenizer for Java-style tokenizing rules
         st.parseNumbers();
         st.wordChars('_', '_');
         st.eolIsSignificant(true);
        
         // If whitespace is not to be discarded, make this call
         st.ordinaryChars(0, ' ');
        
         // These calls caused comments to be discarded
         st.slashSlashComments(true);
         st.slashStarComments(true);
        
         // Parse the file
         int token = st.nextToken();
             while (token != StreamTokenizer.TT_EOF) {
             token = st.nextToken();
             System.out.println("----"+st);
                 switch (token) {
                 case StreamTokenizer.TT_NUMBER:
                 // A number was found; the value is in nval
                 double num = st.nval;
                 break;
                 case StreamTokenizer.TT_WORD:
                 // A word was found; the value is in sval
                 String word = st.sval;
                 break;
                 case '"':
                 // A double-quoted string was found; sval contains the contents
                 String dquoteVal = st.sval;
                 break;
                 case '\'':
                 // A single-quoted string was found; sval contains the contents
                 String squoteVal = st.sval;
                 break;
                 case StreamTokenizer.TT_EOL:
                 // End of line character found
                 break;
                 case StreamTokenizer.TT_EOF:
                 // End of file has been reached
                 break;
                 default:
                 // A regular character was found; the value is the token itself
                 char ch = (char)st.ttype;
                 break;
             }
         }
         rd.close();
         System.out.println(st);
     }
         catch (Exception ioe){
         ioe.printStackTrace();
     }
}
