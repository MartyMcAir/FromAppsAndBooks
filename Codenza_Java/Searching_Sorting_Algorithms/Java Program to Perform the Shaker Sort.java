//This is a java program to sort the numbers using Shaker Sort
import java.util.Random;

public class Shaker_Sort
{
    public static void printSequence(int[] sorted_sequence)
    {
        for (int i = 0; i < sorted_sequence.length; i++)
            System.out.print(sorted_sequence[i] + " ");
    }

    public static int[] shakerSort(int[] array)
    {
        for (int i = 0; i < array.length/2; i++)
            {
                boolean swapped = false;
                for (int j = i; j < array.length - i - 1; j++)
                    {
                        if (array[j] < array[j+1])
                            {
                                int tmp = array[j];
                                array[j] = array[j+1];
                                array[j+1] = tmp;
                            }
                    }
                for (int j = array.length - 2 - i; j > i; j--)
                    {
                        if (array[j] > array[j-1])
                            {
                                int tmp = array[j];
                                array[j] = array[j-1];
                                array[j-1] = tmp;
                                swapped = true;
                            }
                    }
                if(!swapped) break;
            }
        return array;
    }
    public static void main(String args[])
    {
        System.out
        .println("Sorting of randomly generated numbers using Shaker SORT");
        Random random = new Random();
        int N = 20;
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        System.out.println("\nOriginal Sequence: ");
        printSequence(sequence);
        System.out.println("\nSorted Sequence: ");
        printSequence(shakerSort(sequence));
    }

}

/*

Sorting of randomly generated numbers using SHAKER SORT

Original Sequence:
195 853 655 915 364 689 539 684 956 197 67 871 509 662 825 336 540 815 403 876
Sorted Sequence:
956 915 876 871 853 825 815 689 684 662 655 540 539 509 403 364 336 197 195 67
