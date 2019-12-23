/*This is a Java Program to find median of two sorted arrays using binary search approach. In probability theory and statistics, a median is described as the number separating the higher half of a sample, a population, or a probability distribution, from the lower half. The median of a finite list of numbers can be found by arranging all the numbers from lowest value to highest value and picking the middle one. However size of both arrays must be equal. The time complexity of the following program is O (log n).*/

/*
 * Java Program to Find the Median of two Sorted arrays using
 * Binary Search Approach
 */

import java.util.Scanner;

public class MedianOfTwoSortedArrays
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of elements in arrays");
        int N = scan.nextInt();
        int[] arr1 = new int[ N ];
        int[] arr2 = new int[ N ];
        System.out.println("Enter "+ N +" elements of array 1");
        for (int i = 0; i < N; i++)
            arr1[i] = scan.nextInt();
        System.out.println("Enter "+ N +" elements of array 2");
        for (int i = 0; i < N; i++)
            arr2[i] = scan.nextInt();
        int med = median(arr1, arr2);
        System.out.println("Median = "+ med);
    }
    public static int median(int[] arr1, int[] arr2)
    {
        int N = arr1.length;
        return median(arr1, 0, N -1, arr2, 0, N - 1);
    }
    public static int median(int[] arr1, int l1, int h1, int[] arr2, int l2, int h2)
    {
        int mid1 = (h1 + l1 ) / 2;
        int mid2 = (h2 + l2 ) / 2;
        if (h1 - l1 == 1)
            return (Math.max(arr1[l1], arr2[l2]) + Math.min(arr1[h1], arr2[h2]))/2;
        else if (arr1[mid1] > arr2[mid2])
            return median(arr1, l1, mid1, arr2, mid2, h2);
        else
            return median(arr1, mid1, h1, arr2, l2, mid2 );
    }
}

/*


Enter number of elements in arrays
5
Enter 5 elements of array 1
1 12 15 26 38
Enter 5 elements of array 2
2 13 17 30 45
Median = 16
