/*
This is java program to implement 0/1 Knapsack problem. The knapsack problem or rucksack problem is a problem in combinatorial optimization: Given a set of items, each with a mass and a value, determine the number of each item to include in a collection so that the total weight is less than or equal to a given limit and the total value is as large as possible. It derives its name from the problem faced by someone who is constrained by a fixed-size knapsack and must fill it with the most valuable items.
*/

//This is a sample program to implement a 0/1 knapsack algorithm
import java.util.Scanner;

public class Zero_One_Knapsack
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
                        m[i][j] = Math.max(m1, m2);
                        sol[i][j] = m2 > m1 ? 1 : 0;
                    }
            }
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
        System.out.print("\nItems with weight ");
        for (int i = 1; i < N + 1; i++)
            if (selected[i] == 1)
                System.out.print(val[i] +" ");
        System.out.println("are selected by knapsack algorithm.");
    }
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Zero_One_Knapsack ks = new Zero_One_Knapsack();
        System.out.println("Enter number of elements ");
        int n = scan.nextInt();
        int[] wt = new int[n + 1];
        int[] val = new int[n + 1];
        System.out.println("Enter weight for "+ n +" elements");
        for (int i = 1; i <= n; i++)
            wt[i] = scan.nextInt();
        System.out.println("Enter value for "+ n +" elements");
        for (int i = 1; i <= n; i++)
            val[i] = scan.nextInt();
        System.out.println("Enter knapsack weight ");
        int W = scan.nextInt();
        ks.solve(wt, val, W, n);
        scan.close();
    }
}

/*
Enter number of elements
5
Enter weight for 5 elements
01 56 42 78 12
Enter value for 5 elements
50 30 20 10 50
Enter knapsack weight
150

Items with weight 50 30 20 50 are selected by knapsack algorithm.
