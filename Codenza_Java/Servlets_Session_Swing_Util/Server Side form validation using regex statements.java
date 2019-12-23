Server Side form validation using regex statements

package name;
import java.util.regex.*;

    public class regexFunctions {
    private static int SUCCESS = 0;
    private static int FAILURE = 1;
    private static int MISSING_INFO = -1;
    public static String ALL_STRING_REGEX = "[\w]+";
    public static String ALL_NUMBER_REGEX = "[0-9]+";
     
     
     /**
     * Description: Validate the field input value against the regexString which was inputted.
     * If it is null, then a missing info return code is returned (-1).

     * //java.sun.com/j2se/1.4.2/docs/api/java/util/regex/Pattern.html>Link to Javadoc

     * Return Type: int

     * @param regexString

     * @param strFieldInput

     * @return SUCESS = 0 or FAILURE = 1 or MISSING_INFO = -1
     */
     public static int testFieldValue (String regexString, String strFieldInput)
         {
         int retCode = FAILURE;
         if ((regexString != null) && (regexString.length() > 0) &&
         (strFieldInput != null) && (strFieldInput.length() > 0))
             {
             Pattern pattern = Pattern.compile(regexString);
             Matcher matcher = pattern.matcher(strFieldInput);
             if (matcher.find()) 
                 {
                 retCode = SUCCESS;
             } 
         }
         else
             {
             retCode = MISSING_INFO;
         }
         return retCode;
     } 
    
     /**
     * Description: This method takes in an inputted String value and tries to match it 
     * against the regex pattern for Strings. If successful, then the method returns a 0, if the inputted
     * value is empty or null - then it returns a -1. Finally, if the pattern does not match at all it returns a 1.

     * File: regexFunctions.java

     * Return Type: int RetCode - 0=SUCCESS; -1=Missing Information; 1=Does not Match

     */
     public static int checkForString(String inputtedValue)
         {
         int retCode = FAILURE;
         if ((inputtedValue != null) && (inputtedValue.length() > 0))
             {
             Pattern pattern = Pattern.compile(ALL_STRING_REGEX);
             Matcher matcher = pattern.matcher(inputtedValue);
             if (matcher.find()) 
                 {
                 retCode = SUCCESS;
             }
         }
         return retCode;
     }
     /**
     * Description: This method takes in an inputted String value and tries to match it 
     * against the regex pattern for all numbers. If successful, then the method returns a 0, if the inputted
     * value is empty or null - then it returns a -1. Finally, if the pattern does not match at all it returns a 1.

     * File: regexFunctions.java

     * Return Type: int RetCode - 0=SUCCESS; -1=Missing Information; 1=Does not Match

     */
     public static int checkForNumber(String inputtedValue)
         {
         int retCode = FAILURE;
         if ((inputtedValue != null) && (inputtedValue.length() > 0))
             {
             Pattern pattern = Pattern.compile(ALL_NUMBER_REGEX);
             Matcher matcher = pattern.matcher(inputtedValue);
             if (matcher.find()) 
                 {
                 retCode = SUCCESS;
             }
         }
         return retCode;
     }
