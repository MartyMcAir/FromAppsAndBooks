/*This is a Java Program to implement Selection Sort on an integer array.
Selection sort is a sorting algorithm, specifically an in-place comparison sort.
 It has O(n2) time complexity, making it inefficient on large lists, and generally performs worse than the similar insertion sort.
 Selection sort is noted for its simplicity, and it has performance advantages over more complicated algorithms in certain situations,
 particularly where auxiliary memory is limited.
Worst case performance : О(n2)
Best case performance : O(n2)
Average case performance : О(n2)*/

/*
 * Java Program to Implement Selection Sort
 */

import java.util.Scanner;

/* Class SelectionSort */
public class SelectionSort
{
    /* Selection Sort function */
    public static void sort( int arr[] )
    {
        int N = arr.length;
        int i, j, pos, temp;
        for (i = 0; i < N-1; i++)
            {
                pos = i;
                for (j = i+1; j < N; j++)
                    {
                        if (arr[j] < arr[pos])
                            {
                                pos = j;
                            }
                    }
                /* Swap arr[i] and arr[pos] */
                temp = arr[i];
                arr[i] = arr[pos];
                arr[pos]= temp;
            }
    }
    /* Main method */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("Selection Sort Test\n");
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



Selection Sort Test

Enter number of integer elements
20

Enter 20 integer elements
12 34 68 79 123 145 178 213 253 276 298 301 498 512 633 792 888 912 950 991

Elements after sorting
12 34 68 79 123 145 178 213 253 276 298 301 498 512 633 792 888 912 950 991



Selection Sort Test

Enter number of integer elements
20

Enter 20 integer elements
54 135 23 75 1 576 234 928 13 84 631 1283 748 124 54 6 24 485 1024 0

Elements after sorting
0 1 6 13 23 24 54 54 75 84 124 135 234 485 576 631 748 928 1024 1283*/
