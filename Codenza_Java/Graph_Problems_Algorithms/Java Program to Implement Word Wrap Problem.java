/*This Java program Implements Word Wrap Problem.A Given a sequence of words, and a limit on the number of characters that can be put in one line (line width). Put line breaks in the given sequence such that the lines are printed neatly. Assume that the length of each word is smaller than the line width.*/

public class WordWrapProblem
{
    private static final int INFINITY = Integer.MAX_VALUE;

    void solveWordWrap(int l[], int n, int M)
    {
        int extras[][] = new int[n + 1][n + 1];
        int lineCost[][] = new int[n + 1][n + 1];
        int cost[] = new int[n + 1];
        int printSol[] = new int[n + 1];
        int i, j;
        for (i = 1; i <= n; i++)
            {
                extras[i][i] = M - l[i - 1];
                for (j = i + 1; j <= n; j++)
                    {
                        extras[i][j] = extras[i][j - 1] - l[j - 1] - 1;
                    }
            }
        for (i = 1; i <= n; i++)
            {
                for (j = i; j <= n; j++)
                    {
                        if (extras[i][j] < 0)
                            {
                                lineCost[i][j] = INFINITY;
                            }
                        else if (j == n && extras[i][j] >= 0)
                            {
                                lineCost[i][j] = 0;
                            }
                        else
                            lineCost[i][j] = extras[i][j] * extras[i][j];
                    }
            }
        cost[0] = 0;
        for (j = 1; j <= n; j++)
            {
                cost[j] = INFINITY;
                for (i = 1; i <= j; i++)
                    {
                        if (cost[i - 1] != INFINITY && lineCost[i][j] != INFINITY
                                && (cost[i - 1] + lineCost[i][j] < cost[j]))
                            {
                                cost[j] = cost[i - 1] + lineCost[i][j];
                                printSol[j] = i;
                            }
                    }
            }
        printSolution(printSol, n);
    }

    private int printSolution(int p[], int n)
    {
        int k;
        if (p[n] == 1)
            {
                k = 1;
            }
        else
            {
                k = printSolution(p, p[n] - 1) + 1;
            }
        System.out.println("Line number " + k + " From word no " + p[n] + " to " + n);
        return k;
    }

    public static void main(String...arg)
    {
        int l[]  = {3,2,2,5};
        int n = 4;
        int M = 6;
        WordWrapProblem wordWrapProblem = new WordWrapProblem();
        wordWrapProblem.solveWordWrap(l, n, M);
    }
}

/*
Line number 1 From word no 1 to 1
Line number 2 From word no 2 to 3
Line number 3 From word no 4 to 4
