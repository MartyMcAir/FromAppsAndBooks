Run external application in java

//This is main program

import java.io.*;

    public class MainPro{
    
     public static runExtApp runapp =new runExtApp();
     
         public static void main(String[]args){
         
         runapp.runfunc();
         
     }//end void main
    
     
}//end inheritancetest


//this class is called from main program
import java.io.*;

    public class runExtApp{
     
         public void runfunc(){
         
             try{
             Runtime.getRuntime().exec("notepad");
             }catch(IOException e){ //end try 5
             System.err.println(e);
         }//end try catch block 7
    }//end runfunc
    
}//end main class runExtApp
