Password Encryption class

/**
Usage: PasswordEncryption pe = new PasswordEncryption();
String pwd = pe.getEncriptedData(string_to_encrypt);
*/
    public class PasswordEncryption{
     public PasswordEncryption(){}
    
     /**
     This Method returns encripted String data
     */
         public String getEncriptedData(String str){
         str=str.substring(4)+str.substring(2,3)+str.substring(1,4)+str.substring(0,1);
         str=""+str.hashCode();
         String retString = "";
         int a=0;
             for(int i=0;i             retString = retString + str.valueOf(str.charAt(i));
                 if(i == 0){
                 retString=retString+(a+i);
                 a=a+25;
             }
                 else if(i == 1){
                 retString=retString+(a-i+7);
             }
                 else if(i == 3){
                 retString=retString+a+(i*10);
             }
         }
         return retString.trim();
     }
}
