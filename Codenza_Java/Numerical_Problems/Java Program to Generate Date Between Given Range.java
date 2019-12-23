/*
This is the java program to generate all dates between the given range of dates.
*/

//This is sample program to print all the dates between range of start and end dates
import java.util.Date;

public class Generate_Date
{
    public static java.util.LinkedList searchBetweenDates(java.util.Date startDate, java.util.Date endDate)
    {
        java.util.Date begin = new Date(startDate.getTime());
        java.util.LinkedList list = new java.util.LinkedList();
        list.add(new Date(begin.getTime()));
        while(begin.compareTo(endDate)<0)
            {
                begin = new Date(begin.getTime() + 86400000);
                list.add(new Date(begin.getTime()));
            }
        return list;
    }

    public static void main(String[] args) throws Exception
    {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Enter the Start Date: dd/mm/yyyy");
        String begin = new String();
        begin = input.nextLine();
        System.out.println("Enter the End Date: dd/mm/yyyy");
        String end = new String();
        end = input.nextLine();
        java.util.LinkedList hitList = searchBetweenDates(
                                           new java.text.SimpleDateFormat("dd/MM/yyyy").parse(begin),
                                           new java.text.SimpleDateFormat("dd/MM/yyyy").parse(end));
        String[] comboDates = new String[hitList.size()];
        for(int i=0; i<hitList.size(); i++)
            comboDates[i] = new java.text.SimpleDateFormat("dd/MM/yyyy - E").format(((java.util.Date)hitList.get(i)));
        for(int i=0; i<comboDates.length; i++)
            System.out.println(comboDates[i]);
        input.close();
    }
}

/*

Enter the Start Date: dd/mm/yyyy
12/8/1992
Enter the End Date: dd/mm/yyyy
12/10/1992
12/08/1992 - Wed
13/08/1992 - Thu
14/08/1992 - Fri
15/08/1992 - Sat
16/08/1992 - Sun
17/08/1992 - Mon
18/08/1992 - Tue
19/08/1992 - Wed
20/08/1992 - Thu
21/08/1992 - Fri
22/08/1992 - Sat
23/08/1992 - Sun
24/08/1992 - Mon
25/08/1992 - Tue
26/08/1992 - Wed
27/08/1992 - Thu
28/08/1992 - Fri
29/08/1992 - Sat
30/08/1992 - Sun
31/08/1992 - Mon
01/09/1992 - Tue
02/09/1992 - Wed
03/09/1992 - Thu
04/09/1992 - Fri
05/09/1992 - Sat
06/09/1992 - Sun
07/09/1992 - Mon
08/09/1992 - Tue
09/09/1992 - Wed
10/09/1992 - Thu
11/09/1992 - Fri
12/09/1992 - Sat
13/09/1992 - Sun
14/09/1992 - Mon
15/09/1992 - Tue
16/09/1992 - Wed
17/09/1992 - Thu
18/09/1992 - Fri
19/09/1992 - Sat
20/09/1992 - Sun
21/09/1992 - Mon
22/09/1992 - Tue
23/09/1992 - Wed
24/09/1992 - Thu
25/09/1992 - Fri
26/09/1992 - Sat
27/09/1992 - Sun
28/09/1992 - Mon
29/09/1992 - Tue
30/09/1992 - Wed
01/10/1992 - Thu
02/10/1992 - Fri
03/10/1992 - Sat
04/10/1992 - Sun
05/10/1992 - Mon
06/10/1992 - Tue
07/10/1992 - Wed
08/10/1992 - Thu
09/10/1992 - Fri
10/10/1992 - Sat
11/10/1992 - Sun
12/10/1992 - Mon
