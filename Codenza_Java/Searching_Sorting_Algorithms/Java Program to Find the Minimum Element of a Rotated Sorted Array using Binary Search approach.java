/*This is a Java Program to find minimum element of a rotated sorted array.
The following program uses a binary search approach to find the minimum element of a rotated sorted array. Time complexity is O (log n)*/

/*
 * Java Program to Find the Minimum element of a rotated
 * sorted Array using Binary Search approach
 */

import java.util.Scanner;

public class MinimumElementInRotatedSortedArray
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of elements in array");
        int N = scan.nextInt();
        int[] arr = new int[ N ];
        /* Accept N elements */
        System.out.println("Enter "+ N +" elements of rotated sorted array");
        for (int i = 0; i < N; i++)
            arr[i] = scan.nextInt();
        System.out.println("Minimum element = "+ min(arr));
    }
    public static int min(int[] arr)
    {
        return min(arr, 0, arr.length - 1);
    }
    public static int min(int[] arr, int low, int high)
    {
        if (high < low)
            return arr[0];
        if (high == low)
            return arr[low];
        /* Calculate mid position */
        int mid = (high + low)/2;
        if (mid < high && arr[mid + 1] < arr[mid])
            return arr[mid + 1];
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];
        /* recursively find min */
        if (arr[high] > arr[mid])
            return min(arr, low, mid - 1);
        return min(arr, mid + 1, high);
    }
}

/*
Enter number of elements in array
10
Enter 10 elements of rotated sorted array
59 78 83 99 24 29 35 49 53 56
Minimum element = 24


Enter number of elements in array
10
Enter 10 elements of rotated sorted array
14 23 34 56 61 67 75 81 90 99
Minimum element = 14


Enter number of elements in array
10
Enter 10 elements of rotated sorted array
2 3 4 5 6 7 8 9 10 1
Minimum element = 1
