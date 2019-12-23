/*
This is java program to find the solution to the linear equations of any number of variables.
The class provides a simple implementation of the Gauss-Seidel method.
If the matrix isn’t diagonally dominant the program tries to convert it(if possible) by rearranging the rows.
*/

//This class provides a simple implementation of the GaussSeidel method for solving systems of linear equations.
//If the matrix isn't diagonally dominant the program tries to convert it(if possible) by rearranging the rows.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gauss_Seidel
{
    public static final int MAX_ITERATIONS = 100;
    private double[][] M;
    public Gauss_Seidel(double [][] matrix)
    {
        M = matrix;
    }

    public void print()
    {
        int n = M.length;
        for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n + 1; j++)
                    System.out.print(M[i][j] + " ");
                System.out.println();
            }
    }

    public boolean transformToDominant(int r, boolean[] V, int[] R)
    {
        int n = M.length;
        if (r == M.length)
            {
                double[][] T = new double[n][n+1];
                for (int i = 0; i < R.length; i++)
                    {
                        for (int j = 0; j < n + 1; j++)
                            T[i][j] = M[R[i]][j];
                    }
                M = T;
                return true;
            }
        for (int i = 0; i < n; i++)
            {
                if (V[i]) continue;
                double sum = 0;
                for (int j = 0; j < n; j++)
                    sum += Math.abs(M[i][j]);
                if (2 * Math.abs(M[i][r]) > sum)
                    {
                        // diagonally dominant?
                        V[i] = true;
                        R[r] = i;
                        if (transformToDominant(r + 1, V, R))
                            return true;
                        V[i] = false;
                    }
            }
        return false;
    }

    public boolean makeDominant()
    {
        boolean[] visited = new boolean[M.length];
        int[] rows = new int[M.length];
        Arrays.fill(visited, false);
        return transformToDominant(0, visited, rows);
    }

    public void solve()
    {
        int iterations = 0;
        int n = M.length;
        double epsilon = 1e-15;
        double[] X = new double[n]; // Approximations
        double[] P = new double[n]; // Prev
        Arrays.fill(X, 0);
        while (true)
            {
                for (int i = 0; i < n; i++)
                    {
                        double sum = M[i][n]; // b_n
                        for (int j = 0; j < n; j++)
                            if (j != i)
                                sum -= M[i][j] * X[j];
                        // Update x_i to use in the next row calculation
                        X[i] = 1/M[i][i] * sum;
                    }
                System.out.print("X_" + iterations + " = {");
                for (int i = 0; i < n; i++)
                    System.out.print(X[i] + " ");
                System.out.println("}");
                iterations++;
                if (iterations == 1)
                    continue;
                boolean stop = true;
                for (int i = 0; i < n && stop; i++)
                    if (Math.abs(X[i] - P[i]) > epsilon)
                        stop = false;
                if (stop || iterations == MAX_ITERATIONS) break;
                P = (double[])X.clone();
            }
    }

    public static void main(String[] args) throws IOException
    {
        int n;
        double[][] M;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out, true);
        System.out.println("Enter the number of variables in the equation:");
        n = Integer.parseInt(reader.readLine());
        M = new double[n][n+1];
        System.out.println("Enter the augmented matrix:");
        for (int i = 0; i < n; i++)
            {
                StringTokenizer strtk = new StringTokenizer(reader.readLine());
                while (strtk.hasMoreTokens())
                    for (int j = 0; j < n + 1 && strtk.hasMoreTokens(); j++)
                        M[i][j] = Integer.parseInt(strtk.nextToken());
            }
        Gauss_Seidel gausSeidel = new Gauss_Seidel(M);
        if (!gausSeidel.makeDominant())
            {
                writer.println("The system isn't diagonally dominant: " +
                               "The method cannot guarantee convergence.");
            }
        writer.println();
        gausSeidel.print();
        gausSeidel.solve();
    }
}

/*

Enter the number of variables in the equation:
2
Enter the augmented matrix:
1 2 3
6 5 4

6.0 5.0 4.0
1.0 2.0 3.0
X_0 = {0.6666666666666666 1.1666666666666667 }
X_1 = {-0.30555555555555564 1.652777777777778 }
X_2 = {-0.7106481481481481 1.855324074074074 }
X_3 = {-0.8794367283950617 1.9397183641975309 }
X_4 = {-0.9497653034979425 1.9748826517489713 }
X_5 = {-0.9790688764574759 1.9895344382287379 }
X_6 = {-0.9912786985239483 1.9956393492619742 }
X_7 = {-0.9963661243849785 1.9981830621924892 }
X_8 = {-0.9984858851604077 1.9992429425802039 }
X_9 = {-0.9993691188168363 1.999684559408418 }
X_10 = {-0.9997371328403484 1.999868566420174 }
X_11 = {-0.9998904720168117 1.9999452360084058 }
X_12 = {-0.999954363340338 1.999977181670169 }
X_13 = {-0.9999809847251406 1.9999904923625702 }
X_14 = {-0.9999920769688085 1.9999960384844042 }
X_15 = {-0.9999966987370034 1.9999983493685016 }
X_16 = {-0.9999986244737512 1.9999993122368755 }
X_17 = {-0.9999994268640631 1.9999997134320315 }
X_18 = {-0.9999997611933598 1.9999998805966799 }
X_19 = {-0.9999999004972331 1.9999999502486165 }
X_20 = {-0.9999999585405137 1.9999999792702567 }
X_21 = {-0.999999982725214 1.999999991362607 }
X_22 = {-0.9999999928021724 1.9999999964010862 }
X_23 = {-0.999999997000905 1.9999999985004524 }
X_24 = {-0.999999998750377 1.9999999993751885 }
X_25 = {-0.9999999994793237 1.9999999997396618 }
X_26 = {-0.9999999997830514 1.9999999998915257 }
X_27 = {-0.9999999999096048 1.9999999999548024 }
X_28 = {-0.9999999999623352 1.9999999999811675 }
X_29 = {-0.9999999999843061 1.999999999992153 }
X_30 = {-0.9999999999934606 1.9999999999967302 }
X_31 = {-0.9999999999972751 1.9999999999986375 }
X_32 = {-0.9999999999988646 1.9999999999994322 }
X_33 = {-0.9999999999995268 1.9999999999997633 }
X_34 = {-0.9999999999998028 1.9999999999999014 }
X_35 = {-0.9999999999999176 1.9999999999999587 }
X_36 = {-0.9999999999999656 1.9999999999999827 }
X_37 = {-0.9999999999999855 1.9999999999999927 }
X_38 = {-0.9999999999999938 1.999999999999997 }
X_39 = {-0.9999999999999973 1.9999999999999987 }
X_40 = {-0.9999999999999988 1.9999999999999993 }
X_41 = {-0.9999999999999993 1.9999999999999996 }
