/*This is a Java Program to find peak element of an array. A peak element of an array is that element which is not smaller than its neighbors. Consider only one neighbour for corner elements. The time complexity of the following program is O (n).
Brute Force Algorithm is as follows :

for i in range (n) :
    if A[i - 1] <= A[i] >= A[i + 1] :
        print A[i]
    end if
end for*/

/*
 *    Java Program to Find the peak element of an array O(n) time (Naive Method)
 */

import java.util.Scanner;

public class PeakElement1
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of array");
        int N = scan.nextInt();
        int[] arr = new int[N + 2];
        /* set corner values to -infinity */
        arr[0] = Integer.MIN_VALUE;
        arr[N + 1] = Integer.MIN_VALUE;
        /* Accept N elements */
        System.out.println("Enter "+ N +" elements");
        for (int i = 1; i <= N; i++)
            arr[i] = scan.nextInt();
        /* Find All Peak Elements */
        System.out.println("\nAll Peak Elements : ");
        for (int i = 1; i <= N; i++)
            if (arr[i - 1] <= arr[i] && arr[i] >= arr[i + 1])
                System.out.println(arr[i] +" at position "+ i);
        System.out.println();
    }
}

/*
Enter size of array
6
Enter 6 elements
1 2 5 5 4 1

All Peak Elements :
5 at position 3
5 at position 4



Enter size of array
7
Enter 7 elements
6 24 15 2 23 99 67

All Peak Elements :
24 at position 2
99 at position 6



Enter size of array
10
Enter 10 elements
10 9 8 24 8 7 97 28 17 63

All Peak Elements :
10 at position 1
24 at position 4
97 at position 7
63 at position 10
