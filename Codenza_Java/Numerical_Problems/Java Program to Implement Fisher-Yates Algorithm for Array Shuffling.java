/*
This is java implementation of the Fisher–Yates shuffle (named after Ronald Fisher and Frank Yates)algorithm, also known as the Knuth shuffle (after Donald Knuth), for generating a random permutation of a finite set—in plain terms, for randomly shuffling the set.
*/

//This is a sample program to shuffle the elements of an array using Fisher Yates Array Shuffling algorithm
import java.util.Random;
import java.util.Scanner;

public class Fisher_Yates_Array_Shuffling
{
    static int[] fisherYatesShuffling(int []arr, int n)
    {
        int []a = new int[n];
        int []ind = new int[n];
        for(int i=0; i<n; i++)
            ind[i] = 0;
        int index;
        Random rand = new Random();
        for(int i=0; i<n; i++)
            {
                do
                    {
                        index = rand.nextInt(n);
                    }
                while(ind[index] != 0);
                ind[index] = 1;
                a[i] = arr[index];
            }
        return a;
    }

    public static void main(String agrs[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        int n = sc.nextInt();
        System.out.println("Enter the array elements: ");
        int []a = new int[n];
        int []res = new int[n];
        for(int i=0; i<n; i++)
            {
                a[i] = sc.nextInt();
            }
        res = fisherYatesShuffling(a, n);
        for(int i=0; i<n; i++)
            {
                System.out.print(res[i]+" ");
            }
        sc.close();
    }
}


/*
Enter the array size:
12
Enter the array elements:
1 2 3 4 5 6 7 8 9 10 11 12
The shuffled elements are:
7 10 8 4 9 6 12 3 2 1 5 11
