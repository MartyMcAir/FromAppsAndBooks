/*
This is a Java Program to Implement Knapsack Algorithm. This algorithm is used to solve knapsack problem : Given a set of items, each with a mass and a value, determine the number of each item to include in a collection so that the total weight is less than or equal to a given limit and the total value is as large as possible.
*/

/**
 ** Java Program to Implement Knapsack Algorithm
 **/

import java.util.Scanner;

/** Class Knapsack **/
public class Knapsack
{
    public void solve(int[] wt, int[] val, int W, int N)
    {
        int NEGATIVE_INFINITY = Integer.MIN_VALUE;
        int[][] m = new int[N + 1][W + 1];
        int[][] sol = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++)
            {
                for (int j = 0; j <= W; j++)
                    {
                        int m1 = m[i - 1][j];
                        int m2 = NEGATIVE_INFINITY;
                        if (j >= wt[i])
                            m2 = m[i - 1][j - wt[i]] + val[i];
                        /** select max of m1, m2 **/
                        m[i][j] = Math.max(m1, m2);
                        sol[i][j] = m2 > m1 ? 1 : 0;
                    }
            }
        /** make list of what all items to finally select **/
        int[] selected = new int[N + 1];
        for (int n = N, w = W; n > 0; n--)
            {
                if (sol[n][w] != 0)
                    {
                        selected[n] = 1;
                        w = w - wt[n];
                    }
                else
                    selected[n] = 0;
            }
        /** Print finally selected items **/
        System.out.println("\nItems selected : ");
        for (int i = 1; i < N + 1; i++)
            if (selected[i] == 1)
                System.out.print(i +" ");
        System.out.println();
    }
    /** Main function **/
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Knapsack Algorithm Test\n");
        /** Make an object of Knapsack class **/
        Knapsack ks = new Knapsack();
        System.out.println("Enter number of elements ");
        int n = scan.nextInt();
        int[] wt = new int[n + 1];
        int[] val = new int[n + 1];
        System.out.println("\nEnter weight for "+ n +" elements");
        for (int i = 1; i <= n; i++)
            wt[i] = scan.nextInt();
        System.out.println("\nEnter value for "+ n +" elements");
        for (int i = 1; i <= n; i++)
            val[i] = scan.nextInt();
        System.out.println("\nEnter knapsack weight ");
        int W = scan.nextInt();
        ks.solve(wt, val, W, n);
    }
}

/*
Enter number of elements
5

Enter weight for 5 elements
50 10 20 40 30

Enter value for 5 elements
300 60 90 100 240

Enter knapsack weight
60

Items selected :
2 3 5
