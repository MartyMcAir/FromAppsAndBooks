/*
This is a java program to generate and print all the permutation of the Numbers.
User first enters the element in the set and then actual elements. The notion of permutation relates to the act of permuting, or
rearranging, members of a set into a particular sequence or order (unlike combinations, which are selections that disregard order). For example,
there are six permutations of the set {1,2,3}, namely (1,2,3), (1,3,2), (2,1,3), (2,3,1), (3,1,2), and (3,2,1).
*/

//This is a java program to perform all permutation of given list of numbers of a specific length
import java.util.Random;
import java.util.Scanner;

public class Permute_All_List_Numbers
{
    static void permute(int[] a, int k)
    {
        if (k == a.length)
            {
                for (int i = 0; i < a.length; i++)
                    {
                        System.out.print(" [" + a[i] + "] ");
                    }
                System.out.println();
            }
        else
            {
                for (int i = k; i < a.length; i++)
                    {
                        int temp = a[k];
                        a[k] = a[i];
                        a[i] = temp;
                        permute(a, k + 1);
                        temp = a[k];
                        a[k] = a[i];
                        a[i] = temp;
                    }
            }
    }

    public static void main(String args[])
    {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of list: ");
        int N = sc.nextInt();
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        System.out.println("The original sequence is: ");
        for (int i = 0; i < N; i++)
            System.out.print(sequence[i] + " ");
        System.out.println("\nThe permuted sequences are: ");
        permute(sequence, 0);
        sc.close();
    }
}

/*

Enter the length of list:
3
The original sequence is:
15 61 16
The permuted sequences are:
 [15]  [61]  [16]
 [15]  [16]  [61]
 [61]  [15]  [16]
 [61]  [16]  [15]
 [16]  [61]  [15]
 [16]  [15]  [61]


Enter the length of list:
4
The original sequence is:
50 98 4 61
The permuted sequences are:
 [50]  [98]  [4]  [61]
 [50]  [98]  [61]  [4]
 [50]  [4]  [98]  [61]
 [50]  [4]  [61]  [98]
 [50]  [61]  [4]  [98]
 [50]  [61]  [98]  [4]
 [98]  [50]  [4]  [61]
 [98]  [50]  [61]  [4]
 [98]  [4]  [50]  [61]
 [98]  [4]  [61]  [50]
 [98]  [61]  [4]  [50]
 [98]  [61]  [50]  [4]
 [4]  [98]  [50]  [61]
 [4]  [98]  [61]  [50]
 [4]  [50]  [98]  [61]
 [4]  [50]  [61]  [98]
 [4]  [61]  [50]  [98]
 [4]  [61]  [98]  [50]
 [61]  [98]  [4]  [50]
 [61]  [98]  [50]  [4]
 [61]  [4]  [98]  [50]
 [61]  [4]  [50]  [98]
 [61]  [50]  [4]  [98]
 [61]  [50]  [98]  [4]
