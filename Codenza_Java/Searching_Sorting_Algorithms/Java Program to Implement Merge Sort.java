/*This is a Java Program to implement Merge Sort on an integer array. Merge sort is an O(n log n) comparison-based sorting algorithm.
 Most implementations produce a stable sort, which means that the implementation preserves the input order of equal elements in the sorted output.
  Merge sort is a divide and conquer algorithm that was invented by John von Neumann in 1945.
Conceptually, a merge sort works as follows :
i) Divide the unsorted list into n sublists, each containing 1 element (a list of 1 element is considered sorted).
ii) Repeatedly merge sublists to produce new sublists until there is only 1 sublist remaining. This will be the sorted list.
Worst case performance : O(n log n)
Best case performance : O(n log n)
Average case performance : O(n log n)*/

/*
 * Java Program to Implement Merge Sort
 */

import java.util.Scanner;

/* Class MergeSort */
public class MergeSort
{
    /* Merge Sort function */
    public static void sort(int[] a, int low, int high)
    {
        int N = high - low;
        if (N <= 1)
            return;
        int mid = low + N/2;
        // recursively sort
        sort(a, low, mid);
        sort(a, mid, high);
        // merge two sorted subarrays
        int[] temp = new int[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++)
            {
                if (i == mid)
                    temp[k] = a[j++];
                else if (j == high)
                    temp[k] = a[i++];
                else if (a[j]<a[i])
                    temp[k] = a[j++];
                else
                    temp[k] = a[i++];
            }
        for (int k = 0; k < N; k++)
            a[low + k] = temp[k];
    }
    /* Main method */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("Merge Sort Test\n");
        int n, i;
        /* Accept number of elements */
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();
        /* Create array of n elements */
        int arr[] = new int[ n ];
        /* Accept elements */
        System.out.println("\nEnter "+ n +" integer elements");
        for (i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        /* Call method sort */
        sort(arr, 0, n);
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
415 440 845 535 420 555 984 509 11 561 900 413 195 963 566 305 2 169 547 607

Elements after sorting
2 11 169 195 305 413 415 420 440 509 535 547 555 561 566 607 845 900 963 984



Merge Sort Test

Enter number of integer elements
20

Enter 20 integer elements
659 277 860 56 740 480 577 932 767 56 964 103 338 342 308 984 914 314 234 91

Elements after sorting
56 56 91 103 234 277 308 314 338 342 480 577 659 740 767 860 914 932 964 984



Merge Sort Test

Enter number of integer elements
20

Enter 20 integer elements
605 514 864 711 232 664 674 357 161 695 111 508 262 879 832 849 457 357 185 974

Elements after sorting
111 161 185 232 262 357 357 457 508 514 605 664 674 695 711 832 849 864 879 974*/
