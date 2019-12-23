RandomFileTest

import java.io.*;
import java.util.*;

public class RandomFileTest
    { 
     public static void main(String[] args)
         {
         Employee[] staff = new Employee[3];
        
         staff[0] = new Employee("Carl Cracker", 75000,
         1987, 12, 15);
         staff[1] = new Employee("Harry Hacker", 50000,
         1989, 10, 1);
         staff[2] = new Employee("Tony Tester", 40000,
         1990, 3, 15);
        
         try
             { 
             // save all employee records to the file employee.dat
             DataOutputStream out = new DataOutputStream(new 
             FileOutputStream("employee.dat"));
             for (int i = 0; i < staff.length; i++)
             staff[i].writeData(out);
             out.close();
             
             // retrieve all records into a new array
             RandomAccessFile in 
             = new RandomAccessFile("employee.dat", "r"); 
             // compute the array size
             int n = (int)(in.length() / Employee.RECORD_SIZE);
             Employee[] newStaff = new Employee[n];
            
             // read employees in reverse order
             for (int i = n - 1; i >= 0; i--)
                 { 
                 newStaff[i] = new Employee();
                 in.seek(i * Employee.RECORD_SIZE);
                 newStaff[i].readData(in);
             }
             in.close();
             
             // print the newly read employee records
             for (int i = 0; i < newStaff.length; i++) 
             System.out.println(newStaff[i]);
         }
         catch(IOException e)
             { 
             e.printStackTrace(); 
         }
     }
}

class Employee
    {
     public Employee() {}
    
     public Employee(String n, double s, 
     int year, int month, int day)
         { 
         name = n;
         salary = s;
         GregorianCalendar calendar
         = new GregorianCalendar(year, month - 1, day);
         // GregorianCalendar uses 0 for January
         hireDay = calendar.getTime();
     }
    
     public String getName()
         {
         return name;
     }
    
     public double getSalary()
         {
         return salary;
     }
    
     public Date getHireDay()
         { 
         return hireDay;
     }
    
     public void raiseSalary(double byPercent)
         {
         double raise = salary * byPercent / 100;
         salary += raise;
     }
    
     public String toString()
         {
         return getClass().getName()
         + "[name=" + name
         + ",salary=" + salary
         + ",hireDay=" + hireDay
         + "]";
     }
    
     /**
     Writes employee data to a data output
     @param out the data output
     */
     public void raiseSalary(double byPercent)
         { 
         double raise = salary * byPercent / 100;
         salary += raise;
     }
    
     public String toString()
         { 
         return getClass().getName()
         + "[name=" + name
         + ",salary=" + salary
         + ",hireDay=" + hireDay
         + "]";
     }
    
     /**
     Writes employee data to a data output
     @param out the data output
     */
     public void writeData(DataOutput out) throws IOException
         {
         DataIO.writeFixedString(name, NAME_SIZE, out);
         out.writeDouble(salary);
        
         GregorianCalendar calendar = new GregorianCalendar();
         calendar.setTime(hireDay);
         out.writeInt(calendar.get(Calendar.YEAR));
         out.writeInt(calendar.get(Calendar.MONTH) + 1);
         out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
     }
    
     /**
     Reads employee data from a data input
     @param in the data input
     */
     public void readData(DataInput in) throws IOException
         {
         name = DataIO.readFixedString(NAME_SIZE, in);
         salary = in.readDouble();
         int y = in.readInt();
         int m = in.readInt();
         int d = in.readInt();
         GregorianCalendar calendar
         = new GregorianCalendar(y, m - 1, d);
         // GregorianCalendar uses 0 = January
         hireDay = calendar.getTime();
     }
    
     public static final int NAME_SIZE = 40;
     public static final int RECORD_SIZE
     = 2 * NAME_SIZE + 8 + 4 + 4 + 4;
    
     private String name;
     private double salary;
     private Date hireDay;
}

class DataIO
    {
     public static String readFixedString(int size,
     DataInput in) throws IOException
         { 
         StringBuffer b = new StringBuffer(size);
         int i = 0;
         boolean more = true;
         while (more && i < size)
             { 
             char ch = in.readChar();
             i++;
             if (ch == 0) more = false;
             else b.append(ch);
         }
         in.skipBytes(2 * (size - i));
         return b.toString();
     }
    
     public static void writeFixedString(String s, int size,
     DataOutput out) throws IOException
         {
         int i;
         for (i = 0; i < size; i++)
             { 
             char ch = 0;
             if (i < s.length()) ch = s.charAt(i);
             out.writeChar(ch);
         }
     }
}
