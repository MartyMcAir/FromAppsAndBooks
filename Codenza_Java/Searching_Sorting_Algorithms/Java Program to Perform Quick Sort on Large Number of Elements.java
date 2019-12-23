/*This is a java program to sort the large number of elements using Quick Sort Technique. Quick sort uses a pivot element,
where all the elements less that pivot are kept in one list and all the elements greater than pivot are kept in another list, and so on.*/

//This is a java program to sort large number of element using Quick Sort
import java.util.Random;

public class Quick_Sort
{
    public static int N = 25;
    public static int[] sequence = new int[N];

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

    static void printSequence(int[] sorted_sequence)
    {
        for (int i = 0; i < sorted_sequence.length; i++)
            System.out.print(sorted_sequence[i] + " ");
    }

    public static void main(String args[])
    {
        System.out
        .println("Sorting of randomly generated numbers using QUICK SORT");
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
Sorting of randomly generated numbers using QUICK SORT

Original Sequence:
54 22 88 52 43 84 61 75 54 72 7 42 47 15 40 16 46 28 9 48 78 10 89 95 8
Sorted Sequence:
7 8 9 10 15 16 22 28 40 42 43 46 47 48 52 54 54 61 72 75 78 84 88 89 95
