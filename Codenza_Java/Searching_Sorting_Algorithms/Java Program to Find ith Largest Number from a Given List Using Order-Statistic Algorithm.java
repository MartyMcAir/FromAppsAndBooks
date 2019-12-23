
import java.util.Scanner;

public class KthLargestOrderStatistics
{
    public static int partition(int[] array, int first, int last)
    {
        int pivot = array[first];
        int pivotPosition = first++;
        while (first <= last)
            {
                // scan for values less than the pivot
                while ((first <= last) && (array[first] < pivot))
                    {
                        first++;
                    }
                // scan for values greater than the pivot
                while ((last >= first) && (array[last] >= pivot))
                    {
                        last--;
                    }
                if (first > last)
                    {
                        // swap the last uncoformed
                        // element with the pivot
                        swap(array, pivotPosition, last);
                    }
                else
                    {
                        // swap unconformed elements:
                        // first that was not lesser than the pivot
                        // and last that was not larger than the pivot
                        swap(array, first, last);
                    }
            }
        return last;
    }

    private static void swap(int[] array, int first, int last)
    {
        int temp;
        temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }

    public static int orderStatistic(int[] array, int k, int first, int last)
    {
        int pivotPosition = partition(array, first, last);
        if (pivotPosition == k - 1)
            {
                return array[k - 1];
            }
        if (k - 1 < pivotPosition)
            {
                return orderStatistics(array, k, first, pivotPosition - 1);
            }
        else
            {
                return orderStatistics(array, k, pivotPosition + 1, last);
            }
    }

    // iterative version
    private static int orderStatistics(int[] array, int k, int first, int last)
    {
        int pivotPosition = partition(array, first, last);
        while (pivotPosition != k - 1)
            {
                if (k - 1 < pivotPosition)
                    {
                        last = pivotPosition - 1;
                    }
                else
                    {
                        first = pivotPosition + 1;
                    }
                pivotPosition = partition(array, first, last);
            }
        return array[k - 1];
    }

    public static int kthSmallest(int[] array, int k)
    {
        return orderStatistic(array, k, 0, array.length - 1);
    }

    public static int kthLargest(int[] array, int k)
    {
        return orderStatistic(array, array.length - k + 1, 0, array.length - 1);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the sequence: ");
        int n = sc.nextInt();
        int[] sequence = new int[n];
        System.out.println("Enter the elements of the sequence: ");
        for (int i = 0; i < sequence.length; i++)
            {
                sequence[i] = sc.nextInt();
            }
        System.out
        .println("Enter the kth index to be returned as kth largest element of the sequence:");
        int k = sc.nextInt();
        System.out.println("Kth largest:" + kthLargest(sequence, k));
        sc.close();
    }
}

/*

Enter the number of elements in the sequence:
10
Enter the elements of the sequence:
2 5 6 7 4 7 9 5 8 1
Enter the kth index to be returned as kth largest element of the sequence:
4
Kth largest:7
