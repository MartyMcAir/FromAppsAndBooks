/*This is a java program to find the maximum element using binary search technique.
Binary search requires sequence to be sorted. We return the last element of the sequence, which is maximum.*/

//This is a java program to find maximum element using Binary Search
import java.util.Random;

public class Maximum_Using_Binary
{
    static int N = 20;
    static int []sequence = new int[N];

    public static void sort()
    {
        int i, j, temp;
        for (i = 1; i< N; i++)
            {
                j = i;
                temp = sequence[i];
                while (j > 0 && temp < sequence[j-1])
                    {
                        sequence[j] = sequence[j-1];
                        j = j-1;
                    }
                sequence[j] = temp;
            }
    }

    public static void main(String args[])
    {
        Random random = new Random();
        for(int i=0; i<N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        System.out.println("The sequence is :");
        for(int i=0; i<N; i++)
            System.out.print(sequence[i] + " ");
        sort();
        System.out.println("\nThe maximum element in the sequence is : " + sequence[N-1]);
    }
}

/*
The sequence is :
40 60 99 69 71 90 33 83 7 79 49 67 24 23 36 46 55 13 98 8
The miaximum element in the sequence is : 99
