/*This is a Java Program to subtract two large numbers using Linked List. A linked list is a data structure consisting of a group of nodes which together represent a sequence. Under the simplest form, each node is composed of a data and a reference (in other words, a link) to the next node in the sequence. This structure allows for efficient insertion or removal of elements from any position in the sequence.
Maximum value that can be stored in the primitive datatypes ‘int’ and ‘long’ is 231 and 263 respectively. Hence values larger than this cannot be represented using int or long. An alternative is to use the BigInteger class which is available in java as java.math.BigInteger . However, here we will be applying concepts of linked lists to subtract very large numbers.*/

/*
 *  Java Program to subtract two large numbers using Linked Lists
 */

import java.util.*;

public class SubtractLargeNumbersUsingLinkedLists
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Create Linked Lists */
        LinkedList<Integer> num1 = new LinkedList<Integer>();
        LinkedList<Integer> num2 = new LinkedList<Integer>();
        LinkedList<Integer> ans = new LinkedList<Integer>();
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        /* Accept numbers */
        System.out.println("Subtracting Large Numbers Using Linked Lists Test\n");
        System.out.println("Enter number 1");
        String str1 = scan.next();
        System.out.println("Enter number 2");
        String str2 = scan.next();
        /* Find larger number */
        int l1 = str1.length(), l2 = str2.length();
        String s1 = str1, s2 = str2;
        boolean sign = false;
        if (l1 < l2 || (l1 == l2 && str1.compareTo(str2) < 0))
            {
                s1 = str2;
                s2 = str1;
                sign = true;
            }
        l1 = s1.length();
        while (s2.length() != l1)
            s2 = "0" + s2;
        /* Store digits in lists */
        for (int i = l1 - 1; i >= 0; i--)
            {
                num1.add(s1.charAt(i) - '0');
                /* 9 complement of second number */
                num2.add('9' - s2.charAt(i));
            }
        /* Add the numbers */
        int carry = 0;
        for (int i = 0; i < l1; i++)
            {
                int d1 = 0, d2 = 0;
                try
                    {
                        d1 = num1.get(i);
                    }
                catch(Exception e) {}
                try
                    {
                        d2 = num2.get(i);
                    }
                catch(Exception e) {}
                int x = d1 + d2 + carry;
                tmp.add(x % 10);
                carry = x / 10;
            }
        /* Adding carry and storing in ans list*/
        for (int i = 0; i < l1; i++)
            {
                int x = tmp.get(i) + carry;
                ans.add(x % 10);
                carry = x / 10;
            }
        /* Print number */
        System.out.print("\nDifference = ");
        if (s1.equals(s2))
            System.out.print("0\n");
        else
            {
                if (sign)
                    System.out.print("-");
                /* Dont print leading zeroes */
                int i;
                for (i = ans.size() - 1; i >= 0; i--)
                    if (ans.get(i) != 0)
                        break;
                for (; i >= 0; i--)
                    System.out.print(ans.get(i));
                System.out.println();
            }
    }
}

/*

Subtracting Large Numbers Using Linked Lists Test

Enter number 1
9456738572365648932758346782759273576
Enter number 2
56736823748726353476582734827356545368752365

Difference = -56736814291987781110933802069009762609478789



Subtracting Large Numbers Using Linked Lists Test

Enter number 1
83657367648164375237587648523823975867384567263847286325673682366458782936575682
36572582365783465764756873456765826382758265784685627365826375836576572863872655

Enter number 2
23647236572638468364732576823748726573687273567283689587364723564586458287578263
86836827563287526582786235723878364738568745862358293576548237582365758781878286


Difference = 6001013107552590687285507170007524929369729369656359673830895880187
23246489974184973575480249593918197063773288746164418951992232733378927813825421
0814081994369


Subtracting Large Numbers Using Linked Lists Test

Enter number 1
83748562837562383475628737416872984236198927419812347652388735823741846283754568
27938757268728382365872562837842356872957826874236547375235627947238562794783567
53562377826357197843587645728738523657327471874678456382749836435728974816423653
2342357726378462378672357
Enter number 2
23785623874816487638672368926572358263756837435767555535238568278623758758263857
65846578384573846587657628387648523758273562386237652736486385792719281019018408
29347293758465832701801030812498357801981974384917417418924787329561727418578652
8736582735826353765198481647358365273958635759727385671

Difference = -237856238748164876386723689264886097009192750522919267978216952943
87559830844045310813395109914724030292529308205850010048340038717801736485434358
46323192144171746097701956711088455215524557447954241556171870738297731960488059
043999467039744172755237461996475450317410826022916232257297348713314
