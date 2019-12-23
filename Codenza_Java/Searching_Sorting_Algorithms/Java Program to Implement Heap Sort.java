/*This is a Java Program to implement Heap Sort on an integer array.
Heapsort is a comparison-based sorting algorithm to create a sorted array (or list), and is part of the selection sort family.
Although somewhat slower in practice on most machines than a well-implemented quicksort, it has the advantage of a more favorable worst-case O(n log n) runtime.
Heapsort is an in-place algorithm, but it is not a stable sort.
Worst case performance : O(n log n)
Best case performance : O(n log n)
Average case performance : O(n log n)*/

/*
 * Java Program to Implement Heap Sort
 */

import java.util.Scanner;

/* Class HeapSort */
public class HeapSort
{
    private static int N;
    /* Sort Function */
    public static void sort(int arr[])
    {
        heapify(arr);
        for (int i = N; i > 0; i--)
            {
                swap(arr,0, i);
                N = N-1;
                maxheap(arr, 0);
            }
    }
    /* Function to build a heap */
    public static void heapify(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);
    }
    /* Function to swap largest element in heap */
    public static void maxheap(int arr[], int i)
    {
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])
            max = right;
        if (max != i)
            {
                swap(arr, i, max);
                maxheap(arr, max);
            }
    }
    /* Function to swap two numbers in an array */
    public static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    /* Main method */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("Heap Sort Test\n");
        int n, i;
        /* Accept number of elements */
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();
        /* Make array of n elements */
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
488 667 634 380 944 594 783 584 550 665 721 819 285 344 503 807 491 623 845 300

Elements after sorting
285 300 344 380 488 491 503 550 584 594 623 634 665 667 721 783 807 819 845 944



Heap Sort Test

Enter number of integer elements
20

Enter 20 integer elements
57 205 342 200 197 946 631 92 66 581 345 220 398 249 329 87 186 144 462 431

Elements after sorting
57 66 87 92 144 186 197 200 205 220 249 329 342 345 398 431 462 581 631 946



Heap Sort Test

Enter number of integer elements
20

Enter 20 integer elements
802 327 219 415 648 783 250 891 232 822 604 123 138 505 883 224 86 681 51 310

Elements after sorting
51 86 123 138 219 224 232 250 310 327 415 505 604 648 681 783 802 822 883 891
