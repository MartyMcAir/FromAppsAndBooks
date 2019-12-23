/*This is a java program to find the minimum element of the sequence using the technique of linear search.
 First we assign min equal to the first element of the sequence, then we go on exploring each element of the sequence and compare it with the min element, if less we update min.*/

//This is a java program to find the minimum element using the technique of Sequential Search
import java.util.Random;
import java.util.Scanner;

public class Minimum_Using_Sequential
{
    static int N = 20;
    static int []sequence = new int[N];

    public static int minSequential()
    {
        int min = sequence[0];
        for(int i=0; i<N; i++)
            if(min > sequence[i])
                min = sequence[i];
        return min;
    }
    public static void main(String args[])
    {
        Random random = new Random();
        for(int i=0; i<N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        System.out.println("The sequence is :");
        for(int i=0; i<N; i++)
            System.out.print(sequence[i] + " ");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nThe minimum element in the sequence is : " + minSequential());
        sc.close();
    }
}

/*

The sequence is :
33 43 61 93 97 31 53 62 58 87 68 61 16 52 12 29 27 63 68 22
The minimum element in the sequence is : 12
