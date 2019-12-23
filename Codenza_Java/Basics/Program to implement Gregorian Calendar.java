Program to implement Gregorian Calendar

import java.util.*;
class calendar1
{
        public static void main(String arg[])
        {
              GregorianCalendar c1 = new GregorianCalendar();
              int month  = Integer.parseInt(arg[0]);
              int year = Integer.parseInt(arg[1]);
              month = month-1;
              c1.set(year,month,1);
              int day = c1.get(Calendar.DAY_OF_WEEK);
              System.out.println(day);
              int numdays = 0;

        switch(c1.get(Calendar.MONTH))
        {
           case 0:
           case 2:
           case 4:
           case 6:
           case 7:
           case 9:
           case 11:
                numdays = 31;

                break;
           case 1:
                if(c1.isLeapYear(c1.get(Calendar.YEAR)))
                   numdays = 29;
                else
                   numdays = 28;
                   break;
           case 3:
           case 5:
           case 8:
           case 10:
                 numdays = 30;
                 break;
        default:
                System.out.println("ERROR IN MONTH SPECIFICATION");
                break;
       }
       display(day,numdays);

       }
       static void display(int sday , int tday)
         {
              int k = 0;
              System.out.println(" SUN  MON  TUE  WED  THU  FRI  SAT 
");
              for(int j = 1;j <= sday-1; j++)
              {
               System.out.print("     ");
               k++;
              }
             for(int i = 1;i <= tday;i++)
             {
               if(i < 10)
                System.out.print("  "+"0"+i+" ");
               else
                System.out.print("  "+i+" ");
               k++;
               if ( k == 7)
               {
                System.out.println();
                k = 0;
               }
             }
 }
}
