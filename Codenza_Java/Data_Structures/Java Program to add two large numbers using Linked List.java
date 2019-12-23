/*This is a Java Program to add two large numbers using Linked List. A linked list is a data structure consisting of a group of nodes which together represent a sequence. Under the simplest form, each node is composed of a data and a reference (in other words, a link) to the next node in the sequence. This structure allows for efficient insertion or removal of elements from any position in the sequence.
Maximum value that can be stored in the primitive datatypes ‘int’ and ‘long’ is 231 and 263 respectively. Hence values larger than this cannot be represented using int or long. An alternative is to use the BigInteger class which is available in java as java.math.BigInteger . However, here we will be applying concepts of linked lists to add very large numbers.*/

/*
 *  Java Program to add two large numbers using Linked List
 */

import java.util.*;

public class AddLargeNumbersUsingLinkedLists
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Create Linked Lists */
        LinkedList<Integer> num1 = new LinkedList<Integer>();
        LinkedList<Integer> num2 = new LinkedList<Integer>();
        LinkedList<Integer> ans = new LinkedList<Integer>();
        /* Accept numbers */
        System.out.println("Adding Large Numbers Using Linked Lists Test\n");
        System.out.println("Enter number 1");
        String s1 = scan.next();
        System.out.println("Enter number 2");
        String s2 = scan.next();
        /* Store digits in lists */
        int l1 = s1.length(), l2 = s2.length();
        for (int i = l1 - 1; i >= 0; i--)
            num1.add(s1.charAt(i) - '0');
        for (int i = l2 - 1; i >= 0; i--)
            num2.add(s2.charAt(i) - '0');
        /* Adding digits and storing in ans list */
        int len = l1 > l2 ? l1 : l2;
        int carry = 0;
        for (int i = 0; i < len; i++)
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
                ans.add(x % 10);
                carry = x / 10;
            }
        /* Adding carry */
        while (carry != 0)
            {
                ans.add(carry % 10);
                carry /= 10;
            }
        /* Printing ans list */
        System.out.print("\nSum = ");
        for (int i = ans.size() - 1; i >= 0; i--)
            System.out.print(ans.get(i));
        System.out.println();
    }
}

/*

Adding Large Numbers Using Linked Lists Test

Enter number 1
47573267684781773734658371972483657818736465
Enter number 2
1287486758723589773489812734285684586837498748865872358

Sum = 1287486758771163041174594508020342958809982406684608823



Adding Large Numbers Using Linked Lists Test

Enter number 1
54723648627465378475862384728763573645862736573563826875476567826384627357235724
87246375782638746723578634757823647236757658726345273864725762378623572365657236
573467236762365726846574658736453476582368991237
Enter number 2
23472356764817284635723642478356785728497172547386528348732572836483657582375823
65726481943756235876458237483764572836562387567823657823476417832685638756723658
491819284782843637856284719784

Sum = 54723648627465378499334741493580858281586379051920612603973740373771155705
96829770894741540876329089305116701579883113215896210109846701288149946447230189
133654406152875519089385338393943519297114438653711021



Adding Large Numbers Using Linked Lists Test

Enter number 1
85676347892358776738492384576783294876574923843567754398557493284767549328457543
92847567893284375382918356348293847564892347654839846589238457839382374653489283
75648392384756738298475674839234856743892984567849329123847548329138475489238465
Enter number 2
34637829234856543728928346578434576754894857657849876754838375674839387476574839
38756578438756783938756574839387657584932837567483928435743534567657267367346572
36576572687365347658235826357298347918239102391084345435648274982981029310849376

Sum = 12031417712721532046742073115521787163146978150141763115339586895960693680
50323833160414633204115932167493118768150514982518522232377502498199240703964202
08358561222496507212208595671150119653320466213208695893367455949582331211950480
0087841
