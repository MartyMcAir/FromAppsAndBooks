/*This is a java program to find permutation of N numbers using Heap’s Algorithm. Heap’s algorithm is an algorithm used for generating all possible permutations of some given length.*/


import java.util.Arrays;
import java.util.Scanner;

public class HeapsPermutation
{
    private static void swap(int[] v, int i, int j)
    {
        int t = v[i];
        v[i] = v[j];
        v[j] = t;
    }

    public void permute(int[] v, int n)
    {
        if (n == 1)
            {
                System.out.println(Arrays.toString(v));
            }
        else
            {
                for (int i = 0; i < n; i++)
                    {
                        permute(v, n - 1);
                        if (n % 2 == 1)
                            {
                                swap(v, 0, n - 1);
                            }
                        else
                            {
                                swap(v, i, n - 1);
                            }
                    }
            }
    }

    public static void main(String[] args)
    {
        System.out.println("Enter the number of elements in a sequence: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter the sequence: ");
        int sequence[] = new int[n];
        for (int i = 0; i < n; i++)
            {
                sequence[i] = sc.nextInt();
            }
        new HeapsPermutation().permute(sequence, n);
        sc.close();
    }
}

/*


Enter the number of elements in a sequence:
5
Enter the sequence:
2 4 7 3 8
[2, 4, 7, 3, 8]
[4, 2, 7, 3, 8]
[7, 2, 4, 3, 8]
[2, 7, 4, 3, 8]
[4, 7, 2, 3, 8]
[7, 4, 2, 3, 8]
[3, 4, 7, 2, 8]
[4, 3, 7, 2, 8]
[7, 3, 4, 2, 8]
[3, 7, 4, 2, 8]
[4, 7, 3, 2, 8]
[7, 4, 3, 2, 8]
[3, 2, 7, 4, 8]
[2, 3, 7, 4, 8]
[7, 3, 2, 4, 8]
[3, 7, 2, 4, 8]
[2, 7, 3, 4, 8]
[7, 2, 3, 4, 8]
[3, 2, 4, 7, 8]
[2, 3, 4, 7, 8]
[4, 3, 2, 7, 8]
[3, 4, 2, 7, 8]
[2, 4, 3, 7, 8]
[4, 2, 3, 7, 8]
[8, 2, 4, 7, 3]
[2, 8, 4, 7, 3]
[4, 8, 2, 7, 3]
[8, 4, 2, 7, 3]
[2, 4, 8, 7, 3]
[4, 2, 8, 7, 3]
[7, 2, 4, 8, 3]
[2, 7, 4, 8, 3]
[4, 7, 2, 8, 3]
[7, 4, 2, 8, 3]
[2, 4, 7, 8, 3]
[4, 2, 7, 8, 3]
[7, 8, 4, 2, 3]
[8, 7, 4, 2, 3]
[4, 7, 8, 2, 3]
[7, 4, 8, 2, 3]
[8, 4, 7, 2, 3]
[4, 8, 7, 2, 3]
[7, 8, 2, 4, 3]
[8, 7, 2, 4, 3]
[2, 7, 8, 4, 3]
[7, 2, 8, 4, 3]
[8, 2, 7, 4, 3]
[2, 8, 7, 4, 3]
[3, 8, 2, 4, 7]
[8, 3, 2, 4, 7]
[2, 3, 8, 4, 7]
[3, 2, 8, 4, 7]
[8, 2, 3, 4, 7]
[2, 8, 3, 4, 7]
[4, 8, 2, 3, 7]
[8, 4, 2, 3, 7]
[2, 4, 8, 3, 7]
[4, 2, 8, 3, 7]
[8, 2, 4, 3, 7]
[2, 8, 4, 3, 7]
[4, 3, 2, 8, 7]
[3, 4, 2, 8, 7]
[2, 4, 3, 8, 7]
[4, 2, 3, 8, 7]
[3, 2, 4, 8, 7]
[2, 3, 4, 8, 7]
[4, 3, 8, 2, 7]
[3, 4, 8, 2, 7]
[8, 4, 3, 2, 7]
[4, 8, 3, 2, 7]
[3, 8, 4, 2, 7]
[8, 3, 4, 2, 7]
[7, 3, 8, 2, 4]
[3, 7, 8, 2, 4]
[8, 7, 3, 2, 4]
[7, 8, 3, 2, 4]
[3, 8, 7, 2, 4]
[8, 3, 7, 2, 4]
[2, 3, 8, 7, 4]
[3, 2, 8, 7, 4]
[8, 2, 3, 7, 4]
[2, 8, 3, 7, 4]
[3, 8, 2, 7, 4]
[8, 3, 2, 7, 4]
[2, 7, 8, 3, 4]
[7, 2, 8, 3, 4]
[8, 2, 7, 3, 4]
[2, 8, 7, 3, 4]
[7, 8, 2, 3, 4]
[8, 7, 2, 3, 4]
[2, 7, 3, 8, 4]
[7, 2, 3, 8, 4]
[3, 2, 7, 8, 4]
[2, 3, 7, 8, 4]
[7, 3, 2, 8, 4]
[3, 7, 2, 8, 4]
[4, 7, 3, 8, 2]
[7, 4, 3, 8, 2]
[3, 4, 7, 8, 2]
[4, 3, 7, 8, 2]
[7, 3, 4, 8, 2]
[3, 7, 4, 8, 2]
[8, 7, 3, 4, 2]
[7, 8, 3, 4, 2]
[3, 8, 7, 4, 2]
[8, 3, 7, 4, 2]
[7, 3, 8, 4, 2]
[3, 7, 8, 4, 2]
[8, 4, 3, 7, 2]
[4, 8, 3, 7, 2]
[3, 8, 4, 7, 2]
[8, 3, 4, 7, 2]
[4, 3, 8, 7, 2]
[3, 4, 8, 7, 2]
[8, 4, 7, 3, 2]
[4, 8, 7, 3, 2]
[7, 8, 4, 3, 2]
[8, 7, 4, 3, 2]
[4, 7, 8, 3, 2]
[7, 4, 8, 3, 2]
