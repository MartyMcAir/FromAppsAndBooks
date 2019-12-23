Sorting

import java.io.*;
class A
    {
     public static void main(String args[])throws Exception
         {
         DataInputStream dis=new DataInputStream(System.in);
         System.out.println("Enter How many numbers to sort ");
         String s=dis.readLine();
         int l=Integer.valueOf(s).intValue();
         System.out.println("Please Enter "+l+" integers to sort");
         int a[]=new int[l];
         for (int i=0;i             {
             s=dis.readLine();
             int m=Integer.valueOf(s).intValue();
             a[i]=m;
         }
         System.out.println("Here is the sorted numbers ");
         for(int j=0;j         for(int k=j+1;k             {
             if(a[j]                 {
                 int t;
                 t=a[j];
                 a[j]=a[k];
                 a[k]=t;
             }
         }
         for(int x=0;x         System.out.println(a[x]);
        
     }
}
