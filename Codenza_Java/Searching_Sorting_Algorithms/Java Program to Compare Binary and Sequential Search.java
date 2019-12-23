/*This is a java program to compare Binary Search and Linear Search algorithms. Following class provides the time required to search an element for both the algorithms*/

//This the the java program to compare the sequential and binary search
import java.util.Random;
import java.util.Scanner;

public class Sequential_Binary_Compare
{
    public static int N = 1000;
    public static int[] sequence = new int[N];

    public static boolean sequentialSearch(int[] sequence, int key)
    {
        for (int i = 0; i < sequence.length; i++)
            if (sequence[i] == key)
                return true;
        return false;
    }

    public static boolean binarySearch(int[] sequence, int key)
    {
        int low = 0, high = sequence.length - 1;
        while (low <= high)
            {
                int mid = (low + high) / 2;
                if (key < sequence[mid])
                    high = mid - 1;
                else if (key > sequence[mid])
                    low = mid + 1;
                else
                    return true;
            }
        return false;
    }

    public static void QuickSort(int left, int right)
    {
        if (right - left <= 0)
            return;
        else
            {
                int pivot = sequence[right];
                int partition = partitionIt(left, right, pivot);
                QuickSort(left, partition - 1);
                QuickSort(partition + 1, right);
            }
    }

    public static int partitionIt(int left, int right, long pivot)
    {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true)
            {
                while (sequence[++leftPtr] < pivot)
                    ;
                while (rightPtr > 0 && sequence[--rightPtr] > pivot)
                    ;
                if (leftPtr >= rightPtr)
                    break;
                else
                    swap(leftPtr, rightPtr);
            }
        swap(leftPtr, right);
        return leftPtr;
    }

    public static void swap(int dex1, int dex2)
    {
        int temp = sequence[dex1];
        sequence[dex1] = sequence[dex2];
        sequence[dex2] = temp;
    }

    public static void main(String args[])
    {
        Random random = new Random();
        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the key to be searched: ");
        int k = sc.nextInt();
        System.out
        .println("Time taken to search key using sequential search: ");
        long startTime = System.nanoTime();
        boolean result = sequentialSearch(sequence, k);
        long endTime = System.nanoTime();
        if (result == true)
            System.out.println("Key found in " + (endTime - startTime)
                               + " nanoseconds");
        else
            System.out.println("Key doesn't exist, execution time "
                               + (endTime - startTime) + " nanoseconds");
        System.out.println("Time taken to search key using binary search: ");
        QuickSort(0, N - 1);
        startTime = System.nanoTime();
        result = sequentialSearch(sequence, k);
        endTime = System.nanoTime();
        if (result == true)
            System.out.println("Key found in " + (endTime - startTime)
                               + " nanoseconds");
        else
            System.out.println("Key doesn't exist, execution time "
                               + (endTime - startTime) + " nanoseconds");
        sc.close();
    }
}

/*
Enter the key to be searched: (N=100)
85
Time taken to search key using sequential search:
Key found in 14696 nanoseconds
Time taken to search key using binary search:
Key found in 6680 nanoseconds

Enter the key to be searched: (N=1000)
562
Time taken to search key using sequential search:
Key doesn't exist, execution time 44422 nanoseconds
Time taken to search key using binary search:
Key doesn't exist, execution time 43420 nanoseconds
