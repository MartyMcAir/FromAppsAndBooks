Repeat a char for the specified number of times

public class Test1
    {
     public static void main(String args[])
         {
         String ht = repeat('X',7);
         System.out.println(ht);
     }
    
     public static String repeat(char c,int i)
         {
         String tst = "";
         for(int j = 0; j < i; j++)
             {
             tst = tst+c;
         }
         return tst;
     }
}
