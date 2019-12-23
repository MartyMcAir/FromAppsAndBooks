Listle leters console applet


/* Simulation of console-I/O program ListLetters,
   using ConsoleApplet as a basis.  See the file
   ConsoleApplet.java for more information.
*/

public class ListLettersConsole extends ConsoleApplet {

   protected String getTitle() {
      return "Sample program "ListLetters"";
   }

   protected void program() {

      /* This program reads a line of text entered by the user.
         It prints a list of the letters that occur in the text,
         and it reports how many different letters were found.
      */
      
      String str;  // Line of text entered by the user.
      int count;   // Number of different letters found in str.
      char letter; // A letter of the alphabet.
     
      console.putln("Please type in a line of text.");
      str = console.getln();
     
      str = str.toUpperCase();
     
      count = 0;
      console.putln("Your input contains the following letters:");
      console.putln();
      console.put("   ");
      for ( letter = 'A'; letter <= 'Z'; letter++ ) {
          int i;  // Position of a character in str.
          for ( i = 0; i < str.length(); i++ ) {
              if ( letter == str.charAt(i) ) {
                  console.put(letter);
                  console.put(' ');
                  count++;
                  break;
              }
          }
      }

      console.putln();
      console.putln();
      console.putln("There were " + count + " different letters.");


   }
}
