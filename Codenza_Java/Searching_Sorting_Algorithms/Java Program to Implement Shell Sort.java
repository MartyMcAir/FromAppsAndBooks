//This is a program to sort numbers using Shell Sort
import java.util.Random;

public class Shell_Sort
{
    public static int N = 20;
    public static int[] sequence = new int[N];

    public static void shellSort()
    {
        int increment = sequence.length / 2;
        while (increment > 0)
            {
                for (int i = increment; i < sequence.length; i++)
                    {
                        int j = i;
                        int temp = sequence[i];
                        while (j >= increment && sequence[j - increment] > temp)
                            {
                                sequence[j] = sequence[j - increment];
                                j = j - increment;
                            }
                        sequence[j] = temp;
                    }
                if (increment == 2)
                    increment = 1;
                else
                    increment *= (5.0 / 11);
            }
    }

    static void printSequence(int[] sorted_sequence)
    {
        for (int i = 0; i < sorted_sequence.length; i++)
            System.out.print(sorted_sequence[i] + " ");
    }

    public static void main(String args[])
    {
        System.out
        .println("Sorting of randomly generated numbers using SHELL SORT");
        Random random = new Random();
        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        System.out.println("\nOriginal Sequence: ");
        printSequence(sequence);
        System.out.println("\nSorted Sequence: ");
        shellSort();
        printSequence(sequence);
    }
}
/*
Sorting of randomly generated numbers using BUBBLE SORT

Original Sequence:
67 57 55 13 83 80 29 89 30 46 68 71 6 12 5 3 68 8 18 6
Sorted Sequence:
3 5 6 6 8 12 13 18 29 30 46 55 57 67 68 68 71 80 83 89*/
