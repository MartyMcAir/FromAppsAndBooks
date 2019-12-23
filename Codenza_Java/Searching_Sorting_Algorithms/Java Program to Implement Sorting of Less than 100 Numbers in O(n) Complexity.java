/*This is a java program to sort an elements in order n time. Bucket sort can be used to achieve this goal. Bucket sort is O(n) algorithm in time but takes more space, than the normal algorithms.*/


//This is a java program to sort numbers less than 100 in O(n) time
//Bucket sort is O(n) algorithm
import java.util.Random;

public class Order_n_Sorting_Algorithm
{
    static int[] sort(int[] sequence, int maxValue)
    {
        // Bucket Sort
        int[] Bucket = new int[maxValue + 1];
        int[] sorted_sequence = new int[sequence.length];
        for (int i = 0; i < sequence.length; i++)
            Bucket[sequence[i]]++;
        int outPos = 0;
        for (int i = 0; i < Bucket.length; i++)
            for (int j = 0; j < Bucket[i]; j++)
                sorted_sequence[outPos++] = i;
        return sorted_sequence;
    }

    static void printSequence(int[] sorted_sequence)
    {
        for (int i = 0; i < sorted_sequence.length; i++)
            System.out.print(sorted_sequence[i] + " ");
    }

    static int maxValue(int[] sequence)
    {
        int maxValue = 0;
        for (int i = 0; i < sequence.length; i++)
            if (sequence[i] > maxValue)
                maxValue = sequence[i];
        return maxValue;
    }

    public static void main(String args[])
    {
        System.out
        .println("Sorting of randomly generated numbers using O(n) BUCKET SORT algorithm");
        Random random = new Random();
        int N = 25;
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        int maxValue = maxValue(sequence);
        System.out.println("\nOriginal Sequence: ");
        printSequence(sequence);
        System.out.println("\nSorted Sequence: ");
        printSequence(sort(sequence, maxValue));
    }

}


/*
Sorting of randomly generated numbers using O(n) BUCKET SORT algorithm

Original Sequence:
43 50 28 1 80 8 77 92 55 44 15 42 47 98 44 12 78 36 73 57 86 36 11 35 51
Sorted Sequence:
1 8 11 12 15 28 35 36 36 42 43 44 44 47 50 51 55 57 73 77 78 80 86 92 98
