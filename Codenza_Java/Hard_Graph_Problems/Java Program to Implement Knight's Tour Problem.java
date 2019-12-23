/*This Java Program is to Implement Knight’s Tour Problem.A knight’s tour is a sequence of moves of a knight on a chessboard such that the knight visits every square exactly once. If the knight ends on a square that is one knight’s move from the beginning square (so that it could tour the board again immediately, following the same path), the tour is closed, otherwise it is open. The exact number of open tours on an 8×8 chessboard is still unknown.*/

public class KnightTour
{
    private static final int N = 8;
    private int soln[][];

    public KnightTour()
    {
        soln = new int[N][N];
    }

    private boolean isSafe(int x, int y)
    {
        if (x >= 0 && x < N && y >= 0 && y < N && soln[x][y] == -1)
            return true;
        return false;
    }

    private void printSolution()
    {
        for (int x = 0; x < N; x++)
            {
                for (int y = 0; y < N; y++)
                    {
                        System.out.print("  " + soln[x][y]);
                    }
                System.out.println();
            }
    }

    private boolean solveKTUtil(int x, int y, int movei, int xMove[],int yMove[])
    {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;
        for (k = 0; k < N; k++)
            {
                next_x = x + xMove[k];
                next_y = y + yMove[k];
                if (isSafe(next_x, next_y))
                    {
                        soln[next_x][next_y] = movei;
                        if (solveKTUtil(next_x, next_y, movei + 1, xMove, yMove))
                            return true;
                        else
                            soln[next_x][next_y] = -1;
                    }
            }
        return false;
    }

    public boolean solveKnightTour()
    {
        for (int x = 0; x < N; x++)
            {
                for (int y = 0; y < N; y++)
                    {
                        soln[x][y] = -1;
                    }
            }
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        soln[0][0] = 0;
        if (!solveKTUtil(0, 0, 1, xMove, yMove))
            {
                System.out.println("the solution does not exist");
                return false;
            }
        else
            {
                printSolution();
            }
        return true;
    }

    public static void main(String... arg)
    {
        KnightTour knightTour = new KnightTour();
        System.out.println("the solution is");
        knightTour.solveKnightTour();
    }
}

/*
the solution is

 0  59  38  33  30  17  8  63
 37  34  31  60  9  62  29  16
 58  1  36  39  32  27  18  7
 35  48  41  26  61  10  15  28
 42  57  2  49  40  23  6  19
 47  50  45  54  25  20  11  14
 56  43  52  3  22  13  24  5
 51  46  55  44  53  4  21  12
