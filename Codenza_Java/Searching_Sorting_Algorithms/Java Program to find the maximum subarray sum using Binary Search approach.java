/*This is a Java Program to find maximum subarray sum of an array.
A subarray is a continuous portion of an array. The following program uses binary search approach to find the maximum subarray sum.
The time complexity of the following program is O (n log n).*/


/*
 * Java Program to Find the maximum subarray sum using Binary Search approach
 */
import java.util.Scanner;

public class MaxSubarraySum2
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of elements in array");
        int N = scan.nextInt();
        int[] arr = new int[ N ];
        /* Accept N elements */
        System.out.println("Enter "+ N +" elements");
        for (int i = 0; i < N; i++)
            arr[i] = scan.nextInt();
        System.out.println("Max sub array sum  = "+ max_sum(arr));
    }
    public static int max_sum(int[] arr)
    {
        return max_sum(arr, 0, arr.length - 1);
    }
    public static int max_sum(int[] arr, int low, int mid, int high)
    {
        int l = Integer.MIN_VALUE, r = Integer.MIN_VALUE;
        for (int i = mid, sum = 0; i >= low; i--)
            if ((sum += arr[i]) > l)
                l = sum;
        for (int i = mid +1, sum = 0; i <= high; i++)
            if ((sum += arr[i]) > r)
                r = sum;
        return l + r;
    }
    public static int max_sum(int[] arr, int low, int high)
    {
        if (low == high)
            return arr[low];
        int mid = (low + high)/2;
        int max1 = max_sum(arr, low, mid);
        int max2 = max_sum(arr, mid + 1, high);
        int max3 = max_sum(arr, low, mid, high);
        return Math.max(Math.max(max1, max2), max3);
    }
}

/*
Enter number of elements in array
8
Enter 8 elements
20 5 3 -2 -1 -5 43 24
Max sub array sum  = 87
