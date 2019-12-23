    package com.c4learn;
     
    import java.util.Arrays;
    import java.util.List;
     
    public class ArrayDemo1 {
      public static void main (String args[]) {
     
       // Create an array of strings
       String arr[] = new String[]{"A","B","C","D"};
       
       List list1 = Arrays.asList(arr);
     
       // Print the list
       System.out.println("Value of Array :" + list1);
      }
    }
