/*This is a java program to implement Alexander Bogomolny’s permutation algorithm. This version of program computes all possible permutations of numbers from 1 to N using Alexander Bogomolyn’s algorithm.*/


import java.util.Scanner;

public class AlexanderBogomolnyPermutation
{
    static int level = -1;

    public static void print(int[] value, int n)
    {
        if (value.length != 0)
            {
                for (int i = 0; i < value.length; i++)
                    {
                        System.out.print(value[i] + " ");
                    }
                System.out.println();
            }
    }

    public static void visit(int[] Value, int N, int k)
    {
        level = level + 1;
        Value[k] = level;
        if (level == N)
            print(Value, N);
        else
            for (int i = 0; i < N; i++)
                if (Value[i] == 0)
                    visit(Value, N, i);
        level = level - 1;
        Value[k] = 0;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the sequence:");
        int n = sc.nextInt();
        int sequence[] = new int[n];
        for (int i = 0; i < n; i++)
            {
                sequence[i] = 0;
            }
        System.out.println("The permutations are: ");
        visit(sequence, n, 0);
        sc.close();
    }
}
/*

Enter the size of the sequence:
4
The permutations are:
1 2 3 4
1 2 4 3
1 3 2 4
1 4 2 3
1 3 4 2
1 4 3 2
2 1 3 4
2 1 4 3
3 1 2 4
4 1 2 3
3 1 4 2
4 1 3 2
2 3 1 4
2 4 1 3
3 2 1 4
4 2 1 3
3 4 1 2
4 3 1 2
2 3 4 1
2 4 3 1
3 2 4 1
4 2 3 1
3 4 2 1
4 3 2 1*/
