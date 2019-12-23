/*This is a java program to find kth smallest element form the given sequence of numbers.
 This could be solved by using Quick sort algorithm, where we partition around the pivot element,
 the entire sequence of numbers is broken down to two, we arrange the number such that numbers smaller than pivot is kept in the first sequence and
 numbers larger than the pivot is kept in the second sequence. During this comparison we find the kth smallest element.*/

//This is a java program to find kth smallest element form the randomly generated sequence using partitioning
import java.util.Random;
import java.util.Scanner;

public class Kth_Smallest_Partitioning
{
    public static int N = 20;
    public static int[] A = new int[N];

    public static void swap(int dex1, int dex2)
    {
        int temp = A[dex1];
        A[dex1] = A[dex2];
        A[dex2] = temp;
    }

    public static int partition(int start, int end)
    {
        int i = start + 1;
        int j = i;
        int pivot = start;
        for (; i < end; i++)
            {
                if (A[i] < A[pivot])
                    {
                        swap(i, j);
                        j++;
                    }
            }
        if (j <= end)
            swap(pivot, (j - 1));
        return j - 1;
    }

    public static void quick_sort(int start, int end, int K)
    {
        int part;
        if (start < end)
            {
                part = partition(start, end);
                if (part == K - 1)
                    System.out.println("kth smallest element : " + A[part]);
                if (part > K - 1)
                    quick_sort(start, part, K);
                else
                    quick_sort(part + 1, end, K);
            }
        return;
    }

    public static void main(String args[])
    {
        Random random = new Random();
        for (int i = 0; i < N; i++)
            A[i] = random.nextInt(1000);
        System.out.println("The original sequence is:  ");
        for (int i = 0; i < N; i++)
            System.out.print(A[i] + " ");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the Kth smallest you want to find: ");
        int k = sc.nextInt();
        quick_sort(0, N, k);
        sc.close();
    }
}

/*
The original sequence is:
811 30 934 118 942 89 855 917 474 194 630 887 916 997 851 550 917 841 343 202
Enter the Kth smallest you want to find:
3
kth smallest element : 118
