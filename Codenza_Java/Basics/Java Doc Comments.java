Java Doc Comments
  
 

 

public class JavaDocComments {

  /**
   * The execute method does blah blah
   *
   * @param min the min variable is this
   * @param max the max variable is that
   * @return String the process name
   * @throws java.lang.NullPointerException reports any problems trying to execute process
   */
  public String execute( int min, String max ) throws NullPointerException {
    return null;
  }

  /**
   * outputs something like this for the execute method

   execute

   public String execute(int min, String max)

   The execute method does blah blah

   Parameters:
   min - the min variable is this
   max - the max variable is that

   Returns:
   String the process name

   Throws:
   NullPointerException - reports any problems trying to execute process
   */
}
