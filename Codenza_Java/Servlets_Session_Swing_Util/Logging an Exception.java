Logging an Exception

public void myMethod() {
     Logger logger = Logger.getLogger("com.mycompany.MyClass");
    
     // This method should be used when an exception is encounted
         try {
         // Test with an exception
         throw new IOException();
         } catch (Throwable e){
         // Log the exception
         logger.log(Level.SEVERE, "Uncaught exception", e);
     }
    
     // When a method is throwing an exception, this method should be used
     Exception ex = new IllegalStateException();
     logger.throwing(this.getClass().getName(), "myMethod", ex);
}
