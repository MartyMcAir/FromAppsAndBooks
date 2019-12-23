/*This is a java program to sort the numbers using the Counting Sort Technique.
In computer science, counting sort is an algorithm for sorting a collection of objects according to keys that are small integers; that is,
 it is an integer sorting algorithm. It operates by counting the number of objects that have each distinct key value,
 and using arithmetic on those counts to determine the positions of each key value in the output sequence.
Its running time is linear in the number of items and the difference between the maximum and minimum key values.*/

//This is a java program to sort numbers using counting sort
import java.util.Random;

public class Counting_Sort
{
    public static int N = 20;
    public static int[] sequence = new int[N];
    private static final int MAX_RANGE = 1000000;

    public static void sort(int[] arr)
    {
        int N = arr.length;
        if (N == 0)
            return;
        int max = arr[0], min = arr[0];
        for (int i = 1; i < N; i++)
            {
                if (arr[i] > max)
                    max = arr[i];
                if (arr[i] < min)
                    min = arr[i];
            }
        int range = max - min + 1;
        if (range > MAX_RANGE)
            {
                System.out.println("\nError : Range too large for sort");
                return;
            }
        int[] count = new int[range];
        for (int i = 0; i < N; i++)
            count[arr[i] - min]++;
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i])
                arr[j++] = i + min;
    }

    public static void main(String[] args)
    {
        System.out.println("Counting Sort Test\n");
        Random random = new Random();
        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        System.out.println("Elements before sorting");
        for (int i = 0; i < N; i++)
            System.out.print(sequence[i] + " ");
        System.out.println();
        sort(sequence);
        System.out.println("\nElements after sorting ");
        for (int i = 0; i < N; i++)
            System.out.print(sequence[i] + " ");
        System.out.println();
    }
}

/*

Counting Sort

Elements before sorting
7 7 41 56 91 65 86 84 70 44 90 38 78 58 34 87 56 16 23 86

Elements after sorting
7 7 16 23 34 38 41 44 56 56 58 65 70 78 84 86 86 87 90 91
