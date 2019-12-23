/*
This is java program to implement Knapsack problem using Dynamic programming.Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Consider all subsets of items and calculate the total weight and value of all subsets. Consider the only subsets whose total weight is smaller than W. From all such subsets, pick the maximum value subset.
*/

//This is the java program to implement the knapsack problem using Dynamic Programming
import java.util.Scanner;

public class Knapsack_DP
{
    static int max(int a, int b)
    {
        return (a > b)? a : b;
    }
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int [][]K = new int[n+1][W+1];
        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
            {
                for (w = 0; w <= W; w++)
                    {
                        if (i==0 || w==0)
                            K[i][w] = 0;
                        else if (wt[i-1] <= w)
                            K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                        else
                            K[i][w] = K[i-1][w];
                    }
            }
        return K[n][W];
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        System.out.println("Enter the items weights: ");
        int []wt = new int[n];
        for(int i=0; i<n; i++)
            wt[i] = sc.nextInt();
        System.out.println("Enter the items values: ");
        int []val = new int[n];
        for(int i=0; i<n; i++)
            val[i] = sc.nextInt();
        System.out.println("Enter the maximum capacity: ");
        int W = sc.nextInt();
        System.out.println("The maximum value that can be put in a knapsack of capacity W is: " + knapSack(W, wt, val, n));
        sc.close();
    }
}

/*

Enter the number of items:
5
Enter the items weights:
01 56 42 78 12
Enter the items values:
50 30 20 10 50
Enter the maximum capacity:
150
The maximum value that can be put in a knapsack of capacity W is: 150
