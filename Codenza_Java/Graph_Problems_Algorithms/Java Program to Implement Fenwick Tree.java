/*This is a Java Program to Implement Fenwick Tree. A Fenwick tree or binary indexed tree is a data structure providing efficient methods for calculation and manipulation of the prefix sums of a table of values.*/

/**
 *  Java Program to Implement Fenwick Tree
 **/
import java.util.Scanner;

/** Class Fenwick Tree **/
public class FenwickTree
{
    /** Function to update tree **/
    private void update(int[] arr, int pos, int val)
    {
        int len = arr.length;
        for (; pos < len; pos |= (pos + 1))
            arr[pos] += val;
    }
    /** Function to query **/
    private int query(int[] arr, int pos)
    {
        int sum = 0;
        for (; pos >= 0; pos = (pos & (pos + 1)) - 1)
            sum += arr[pos];
        return sum;
    }

    /** Main method **/
    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("Fenwick Tree Test\n");
        /** Accept number of elements **/
        System.out.println("Enter number of integer elements");
        int n = scan.nextInt();
        /** Create integer array on n elements **/
        int arr[] = new int[ n ];
        FenwickTree ft = new FenwickTree();
        /** update or find sum **/
        char ch;
        do
            {
                System.out.println("\nFenwick Tree Operations\n");
                System.out.println("1. update ");
                System.out.println("2. query");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter position and value to update");
                        ft.update(arr, scan.nextInt(), scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter position to find sum till nth element");
                        try
                            {
                                System.out.println("Sum = "+ ft.query(arr, scan.nextInt()) );
                            }
                        catch (Exception e)
                            {
                                System.out.println("\nError! Out of bounds\n");
                            }
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Fenwick Tree Test

Enter number of integer elements
5

Fenwick Tree Operations

1. update
2. query
1
Enter position and value to update
0 5

Do you want to continue (Type y or n)

y

Fenwick Tree Operations

1. update
2. query
1
Enter position and value to update
1 4

Do you want to continue (Type y or n)

y

Fenwick Tree Operations

1. update
2. query
1
Enter position and value to update
2 3

Do you want to continue (Type y or n)

y

Fenwick Tree Operations

1. update
2. query
1
Enter position and value to update
3 2

Do you want to continue (Type y or n)

y

Fenwick Tree Operations

1. update
2. query
1
Enter position and value to update
4 0

Do you want to continue (Type y or n)

y

Fenwick Tree Operations

1. update
2. query
2
Enter position to find sum till nth element
1
Sum = 9

Do you want to continue (Type y or n)

y

Fenwick Tree Operations

1. update
2. query
2
Enter position to find sum till nth element
2
Sum = 12

Do you want to continue (Type y or n)

y

Fenwick Tree Operations

1. update
2. query
2
Enter position to find sum till nth element
3
Sum = 14

Do you want to continue (Type y or n)

y

Fenwick Tree Operations

1. update
2. query
2
Enter position to find sum till nth element
4
Sum = 14

Do you want to continue (Type y or n)

n
