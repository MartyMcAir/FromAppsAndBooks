Using Exceptions

public class UsingExceptions 
     {
     public static void main( String args[] )
         {
         try 
             {
             throwException();
         }
         catch ( Exception e )
             {
             System.err.println( "Exception handled in main" );
         }
        
         doesNotThrowException();
     }
    
     public static void throwException() throws Exception
         {
         // Throw an exception and immediately catch it.
         try 
             {
             System.out.println( "Method throwException" );
             throw new Exception(); // generate exception
         }
         catch( Exception e )
             {
             System.err.println( "Exception handled in method throwException" );
             throw e; // rethrow e for further processing
             
             // any code here would not be reached
         }
         finally 
             {
             System.err.println( "Finally executed in throwException" );
         }
        
         // any code here would not be reached
     }
    
     public static void doesNotThrowException()
         {
         try 
             {
             System.out.println( "Method doesNotThrowException" );
         }
         catch( Exception e )
             {
             System.err.println( e.toString() );
         }
         finally 
             {
             System.err.println( "Finally executed in doesNotThrowException" );
         }
        
         System.out.println( "End of method doesNotThrowException" );
     }
}
