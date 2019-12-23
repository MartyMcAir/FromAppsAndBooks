/*
This is java program to solve the system of linear equations. This can be done by first representing equations(vectors)
to matrix form, then finding the inverse of the matrix formed by the coefficients of variable and multiplying it with constants.
*/

//This is a sample program to solve the linear equations.
import java.util.Scanner;

public class Solve_Linear_Equation
{
    public static void main(String args[])
    {
        char []var = {'x', 'y', 'z', 'w'};
        System.out.println("Enter the number of variables in the equations: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("Enter the coefficients of each variable for each equations");
        System.out.println("ax + by + cz + ... = d");
        double [][]mat = new double[n][n];
        double [][]constants = new double[n][1];
        //input
        for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                    {
                        mat[i][j] = input.nextDouble();
                    }
                constants[i][0] = input.nextDouble();
            }
        //Matrix representation
        for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                    {
                        System.out.print(" "+mat[i][j]);
                    }
                System.out.print("  "+ var[i]);
                System.out.print("  =  "+ constants[i][0]);
                System.out.println();
            }
        //inverse of matrix mat[][]
        double inverted_mat[][] = invert(mat);
        System.out.println("The inverse is: ");
        for (int i=0; i<n; ++i)
            {
                for (int j=0; j<n; ++j)
                    {
                        System.out.print(inverted_mat[i][j]+"  ");
                    }
                System.out.println();
            }
        //Multiplication of mat inverse and constants
        double result[][] = new double[n][1];
        for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < 1; j++)
                    {
                        for (int k = 0; k < n; k++)
                            {
                                result[i][j] = result[i][j] + inverted_mat[i][k] * constants[k][j];
                            }
                    }
            }
        System.out.println("The product is:");
        for(int i=0; i<n; i++)
            {
                System.out.println(result[i][0] + " ");
            }
        input.close();
    }

    public static double[][] invert(double a[][])
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;
// Transform the matrix into an upper triangle
        gaussian(a, index);
// Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                    -= a[index[j]][i]*b[index[i]][k];
// Perform backward substitutions
        for (int i=0; i<n; ++i)
            {
                x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
                for (int j=n-2; j>=0; --j)
                    {
                        x[j][i] = b[index[j]][i];
                        for (int k=j+1; k<n; ++k)
                            {
                                x[j][i] -= a[index[j]][k]*x[k][i];
                            }
                        x[j][i] /= a[index[j]][j];
                    }
            }
        return x;
    }

// Method to carry out the partial-pivoting Gaussian
// elimination.  Here index[] stores pivoting order.

    public static void gaussian(double a[][], int index[])
    {
        int n = index.length;
        double c[] = new double[n];
// Initialize the index
        for (int i=0; i<n; ++i)
            index[i] = i;
// Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i)
            {
                double c1 = 0;
                for (int j=0; j<n; ++j)
                    {
                        double c0 = Math.abs(a[i][j]);
                        if (c0 > c1) c1 = c0;
                    }
                c[i] = c1;
            }
// Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j)
            {
                double pi1 = 0;
                for (int i=j; i<n; ++i)
                    {
                        double pi0 = Math.abs(a[index[i]][j]);
                        pi0 /= c[index[i]];
                        if (pi0 > pi1)
                            {
                                pi1 = pi0;
                                k = i;
                            }
                    }
                // Interchange rows according to the pivoting order
                int itmp = index[j];
                index[j] = index[k];
                index[k] = itmp;
                for (int i=j+1; i<n; ++i)
                    {
                        double pj = a[index[i]][j]/a[index[j]][j];
// Record pivoting ratios below the diagonal
                        a[index[i]][j] = pj;
// Modify other elements accordingly
                        for (int l=j+1; l<n; ++l)
                            a[index[i]][l] -= pj*a[index[j]][l];
                    }
            }
    }
}

/*

Enter the number of variables in the equations:
2
Enter the coefficients of each variable for each equations
ax + by + cz + ... = d
1 2 3
3 2 1

 1.0 2.0  x  =  3.0
 3.0 2.0  y  =  1.0

 The inverse is:
-0.49999999999999994  0.5
 0.7499999999999999  -0.24999999999999997

 The product is:
-0.9999999999999998
 1.9999999999999996
