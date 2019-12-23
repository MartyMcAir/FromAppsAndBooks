/*This is a Java Program to implement Direct Addressing Tables. Direct Addressing Tables are used when each element has a key drawn from a universe U = {0, 1, . . . ,m − 1} where m isn’t too large and each key is unique. Here Direct Addressing Tables is implemented using an array of strings where array index is the key.*/

/*
 *    Java Program to Implement Direct Addressing Tables
 */

import java.util.Scanner;

class DirectAddressingTable
{
    private String[] arr ;
    private final int DEFAULT_CAPACITY = 10001;

    /* Constructor */
    public DirectAddressingTable()
    {
        arr = new String[DEFAULT_CAPACITY];
    }
    /* Constructor */
    public DirectAddressingTable(int capacity)
    {
        arr = new String[capacity + 1];
    }
    /* function to insert */
    public void insert(int k, String d)
    {
        arr[k] = d;
    }
    /* function to delete */
    public void delete(int k)
    {
        arr[k] = null;
    }
    /* function to get value */
    public String get(int k)
    {
        return arr[k];
    }
    /* function to clear */
    public void clear()
    {
        int l = arr.length;
        arr = new String[l];
    }
    /* function to print */
    public void printTable()
    {
        System.out.println("\nDirect Addressing Table : ");
        int l = arr.length;
        for (int i = 0; i < l; i++)
            if (arr[i] != null)
                System.out.println(i +" "+ arr[i]);
        System.out.println();
    }
}

public class DirectAddressingTableTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Direct Addressing Table Test\n\n");
        /* Make object of DirectAddressingTable */
        DirectAddressingTable dat = new DirectAddressingTable();
        char ch;
        /*  Perform DirectAddressingTable operations  */
        do
            {
                System.out.println("\nDirect Addressing Table Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. remove");
                System.out.println("3. get");
                System.out.println("4. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter int key and string value");
                        dat.insert( scan.nextInt(), scan.next() );
                        break;
                    case 2 :
                        System.out.println("Enter int key");
                        dat.delete( scan.nextInt() );
                        break;
                    case 3 :
                        System.out.println("Enter int key");
                        System.out.println("Value = "+ dat.get( scan.nextInt() ));
                        break;
                    case 4 :
                        dat.clear();
                        System.out.println("Direct Addressing Table Cleared\n");
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /* Display hash table */
                dat.printTable();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Direct Addressing Table Operations

1. insert
2. remove
3. get
4. clear
1
Enter int key and string value
6 mango

Direct Addressing Table :
6 mango


Do you want to continue (Type y or n)

y

Direct Addressing Table Operations

1. insert
2. remove
3. get
4. clear
1
Enter int key and string value
24 pineapple

Direct Addressing Table :
6 mango
24 pineapple


Do you want to continue (Type y or n)

y

Direct Addressing Table Operations

1. insert
2. remove
3. get
4. clear
1
Enter int key and string value
17 orange

Direct Addressing Table :
6 mango
17 orange
24 pineapple


Do you want to continue (Type y or n)

y

Direct Addressing Table Operations

1. insert
2. remove
3. get
4. clear
1
Enter int key and string value
1 apple

Direct Addressing Table :
1 apple
6 mango
17 orange
24 pineapple


Do you want to continue (Type y or n)

y

Direct Addressing Table Operations

1. insert
2. remove
3. get
4. clear
3
Enter int key
24
Value = pineapple

Direct Addressing Table :
1 apple
6 mango
17 orange
24 pineapple


Do you want to continue (Type y or n)

y

Direct Addressing Table Operations

1. insert
2. remove
3. get
4. clear
2
Enter int key
17

Direct Addressing Table :
1 apple
6 mango
24 pineapple


Do you want to continue (Type y or n)

y

Direct Addressing Table Operations

1. insert
2. remove
3. get
4. clear
4
Direct Addressing Table Cleared


Direct Addressing Table :


Do you want to continue (Type y or n)

n
