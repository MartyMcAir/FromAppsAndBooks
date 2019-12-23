/*This is a Java Program to implement Insertion Sort on an integer array.
Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time.
It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.
However, advantages of Insertion Sort are that it is efficient for (quite) small data sets, adaptive for data sets that are already substantially sorted,
stable (i.e. does not change the relative order of elements with equal keys), In-place ( i.e. only requires a constant amount O(1) of additional memory space)
and online (i.e. can sort a list as it receives it).
Worst case performance : О(n2) comparisons, swaps
Best case performance : O(n) comparisons, O(1) swaps
Average case performance : О(n2) comparisons, swaps*/

/*
 * Java Program to Implement Insertion Sort
 */

import java.util.Scanner;

/* Class InsertionSort */
public class InsertionSort
{
    /* Insertion Sort function */
    public static void sort( int arr[] )
    {
        int N = arr.length;
        int i, j, temp;
        for (i = 1; i< N; i++)
            {
                j = i;
                temp = arr[i];
                while (j > 0 && temp < arr[j-1])
                    {
                        arr[j] = arr[j-1];
                        j = j-1;
                    }
                arr[j] = temp;
            }
    }
    /* Main method */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("Insertion Sort Test\n");
        int n, i;
        /* Accept number of elements */
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();
        /* Create integer array on n elements */
        int arr[] = new int[ n ];
        /* Accept elements */
        System.out.println("\nEnter "+ n +" integer elements");
        for (i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        /* Call method sort */
        sort(arr);
        /* Print sorted Array */
        System.out.println("\nElements after sorting ");
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}

/*

Enter number of integer elements
20

Enter 20 integer elements
999 921 823 816 767 712 698 657 532 412 391 323 287 256 225 162 123 64 24 6

Elements after sorting
6 24 64 123 162 225 256 287 323 391 412 532 657 698 712 767 816 823 921 999



Insertion Sort Test

Enter number of integer elements
20

Enter 20 integer elements
12 34 68 79 123 145 178 213 253 276 298 301 498 512 633 792 888 912 950 991

Elements after sorting
12 34 68 79 123 145 178 213 253 276 298 301 498 512 633 792 888 912 950 991



Insertion Sort Test

Enter number of integer elements
20

Enter 20 integer elements
54 135 23 75 1 576 234 928 13 84 631 1283 748 124 54 6 24 485 1024 0

Elements after sorting
0 1 6 13 23 24 54 54 75 84 124 135 234 485 576 631 748 928 1024 1283
