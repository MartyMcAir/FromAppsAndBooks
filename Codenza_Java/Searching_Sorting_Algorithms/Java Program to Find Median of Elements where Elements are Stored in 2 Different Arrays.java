/*This is a java program to find the median from two different array. To do so we merge the two lists and then sort them, after that we find the median of the sequence.
If the total number of elements (N) is odd median is the N/2th element, if its even (N-1/2 + N/2)/2th element.*/

//This is a java program to find the median of 2 array
import java.util.Random;

public class Median_Two_Arrays
{
    static int N = 10, M = 5;
    static int[] sequence1 = new int[N];
    static int[] sequence2 = new int[M];
    static int[] sequence = new int[N+M];

    public static void sort()
    {
        int i, j, temp;
        for (i = 1; i < N+M; i++)
            {
                j = i;
                temp = sequence[i];
                while (j > 0 && temp < sequence[j - 1])
                    {
                        sequence[j] = sequence[j - 1];
                        j = j - 1;
                    }
                sequence[j] = temp;
            }
    }

    public static void main(String args[])
    {
        Random random = new Random();
        for(int i=0; i<N; i++)
            sequence1[i] = Math.abs(random.nextInt(100));
        for(int i=0; i<M; i++)
            sequence2[i] = Math.abs(random.nextInt(100));
        for(int i=0; i<N; i++)
            System.out.print(sequence1[i] + " ");
        System.out.println();
        for(int i=0; i<M; i++)
            System.out.print(sequence2[i] + " ");
        System.out.println();
        int j=0;
        for(int i=0; i<N+M; i++)
            {
                if(i >= N && j < M)
                    sequence[i] = sequence2[j++];
                else
                    sequence[i] = sequence1[i];
            }
        sort();
        if(N+M % 2 == 0)
            System.out.println("The Median is : " + (sequence[(N+M)/2-1]+sequence[(N+M)/2])/2);
        else
            System.out.println("The Median is : " + sequence[(N+M)/2]);
    }
}

/*
92 53 68 15 17 23 95 47 46 61
63 62 48 66 26
The Median is : 53
