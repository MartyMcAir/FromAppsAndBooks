/*This is a Java Program to find number of occurences of a given number using binary search approach. The time complexity of the following program is O (log n).*/

/*
 *    Java Program to Find the Number of occurrences of a given Number using Binary Search approach
 */

import java.util.Scanner;

public class NumberOfOccurences
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of elements in sorted array");
        int N = scan.nextInt();
        int[] arr = new int[ N ];
        /* Accept N elements */
        System.out.println("Enter "+ N +" sorted elements");
        for (int i = 0; i < N; i++)
            arr[i] = scan.nextInt();
        System.out.println("Enter number to find occurences");
        int num = scan.nextInt();
        int f = occur(arr, num);
        if (f == -1)
            System.out.println("No occurence");
        else
            System.out.println("Occurences = "+ f);
    }
    public static int occur(int[] arr, int num)
    {
        /* find first index */
        int l1 = first(arr, num);
        /* find last index */
        int l2 = last(arr, num);
        if (l1 == -1 || l2 == -1)
            return -1;
        return l2 - l1 + 1;
    }
    public static int first(int[] arr, int num)
    {
        if (arr[0] == num)
            return 0;
        int start = 0, end = arr.length - 1;
        int mid = (start + end) / 2;
        int flag = 0;
        while (!(arr[mid] == num && arr[mid - 1] < arr[mid]))
            {
                if (start == end)
                    {
                        flag = 1;
                        break;
                    }
                if (arr[mid] >= num)
                    end = mid - 1;
                if (arr[mid] < num)
                    start = mid + 1;
                mid = (start + end) / 2;
            }
        if (flag == 0)
            return mid;
        return -1;
    }
    public static int last(int[] arr, int num)
    {
        if (arr[arr.length - 1] == num)
            return arr.length - 1;
        int start = 0, end = arr.length - 1;
        int mid = (start + end) / 2;
        int flag = 0;
        while (!(arr[mid] == num && arr[mid + 1] > arr[mid]))
            {
                if (start == end)
                    {
                        flag = 1;
                        break;
                    }
                if (arr[mid] > num)
                    end = mid - 1;
                if (arr[mid] <= num)
                    start = mid + 1;
                mid = (start + end) / 2;
            }
        if (flag == 0)
            return mid;
        return -1;
    }
}

/*
Enter number of elements in sorted array
10
Enter 10 sorted elements
1 1 3 3 3 3 4 4 4 5
Enter number to find occurences
3
Occurences = 4


Enter number of elements in sorted array
10
Enter 10 sorted elements
1 1 3 3 3 3 4 4 4 5
Enter number to find occurences
5
Occurences = 1
