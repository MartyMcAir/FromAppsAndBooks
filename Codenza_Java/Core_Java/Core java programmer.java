Core java programmer

import java.io.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
class History
    {
     
     public static void main(String args[])
         {
         
         
         String dd="asbdjs";
         while(dd.length()>0)
             {
             
                 try{
                 System.out.println("welcome to personal account information");
                 System.out.println("\n"+"enter q to quit");
                 System.out.println("\n");
                 System.out.println("enter account number :");
                 BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
                 String sx=read.readLine();
                 if(sx.equals("q"))
                     {
                     System.exit(0);
                 }
                 else
                     {
                     try
                         {
                         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                     }
                     catch(ClassNotFoundException k)
                         {
                         System.out.println(k);
                     }
                     try
                         {
                         String url="jdbc:odbc:test";
                         int account=Integer.parseInt(sx);
                         String command="select * from Account where account like "+account;
                         Connection con=DriverManager.getConnection(url);
                         Statement s=con.createStatement();
                         ResultSet rs=s.executeQuery(command);
                         
                         
                         
                         while(rs.next())
                             { 
                        
                             String s1=rs.getString(1);
                             String s2=rs.getString(2);
                             int d1=rs.getInt(3);
                             int d2=rs.getInt(4);
                             int s3=rs.getInt(5);
                             
                             String data="account "+s1+"\n"+"date "+s2+" withdrawl "+d1+" deposit "+d2+"\n"+"balance "+s3+"\n";
                            
                             System.out.println(data);
                             System.out.println("\n");
                             
                         }
                         
                     } 
                     catch(SQLException k)
                         {
                         System.out.println(k);
                     }
                 }
                 
             }
                          
             catch(Exception w)
                 {
                 System.out.println(w);
             }
         }
    }
}
