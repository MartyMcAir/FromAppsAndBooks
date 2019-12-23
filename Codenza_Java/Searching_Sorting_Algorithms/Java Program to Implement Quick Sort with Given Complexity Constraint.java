
import java.util.Random;

public class QuickSortComplexityConstraint
{
    public static int N = 20;
    public static int[] sequence = new int[N];

    public static void QuickSort(int left, int right)
    {
        if (right - left <= 0)
            return;
        else
            {
                Random rand = new Random();
                int pivotIndex = left + rand.nextInt(right - left + 1);
                swap(pivotIndex, right);
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

    static void printSequence(int[] sorted_sequence)
    {
        for (int i = 0; i < sorted_sequence.length; i++)
            System.out.print(sorted_sequence[i] + " ");
    }

    public static void main(String args[])
    {
        System.out
        .println("Sorting of randomly generated numbers using QUICK SORT with complexity less than n^2");
        Random random = new Random();
        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        System.out.println("\nOriginal Sequence: ");
        printSequence(sequence);
        System.out.println("\nSorted Sequence: ");
        QuickSort(0, N - 1);
        printSequence(sequence);
    }
}

/*
Sorting of randomly generated numbers using QUICK SORT with complexity less than n^2

Original Sequence:
29 19 67 48 23 99 72 40 23 93 0 79 70 87 43 24 56 67 51 71
Sorted Sequence:
0 19 23 23 24 29 40 43 48 51 56 67 67 70 71 72 79 87 93 99
