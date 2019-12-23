/*
This is a java program to LU Decomposition of a given matrix. LU decomposition is the process of
reducing single matrix into 2 matrices such that, upon multiplication we get the original matrix,
having property that one of them is lower trinagular matrix and other one is upper trinagular matrix.
*/

//This is a sample program to calulate the LU decomposition of the given matrix
import java.util.Scanner;

public class LUDecomposition
{
    public static void main(String args[])
    {
        System.out.println("Enter the dimension of the matrix:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double [][]mat = new double[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                mat[i][j] = sc.nextDouble();
        if(n==2)
            {
                double [][]l = new double[n][n];
                l[0][0] = l[1][1] = 1;
                l[0][1] = 0;
                double [][]u = new double[n][n];
                u[1][0] = 0;
                u[0][0] = mat[0][0];
                u[0][1] = mat[0][1];
                l[1][0] = mat[1][0]/mat[0][0];
                u[1][1] = mat[1][1] - (l[1][0]*u[0][1]);   //mat[2][2]-(mat[2][1]*mat[1][2]/mat[1][1]);
                System.out.println("The L Component is:");
                for(int i=0; i<n; i++)
                    {
                        for(int j=0; j<n; j++)
                            System.out.print(" "+l[i][j]);
                        System.out.println();
                    }
                System.out.println("The U Component is:");
                for(int i=0; i<n; i++)
                    {
                        for(int j=0; j<n; j++)
                            System.out.print(" "+u[i][j]);
                        System.out.println();
                    }
            }
        if(n==3)
            {
                double [][]l = new double[n][n];
                l[0][0] = l[1][1] = l[2][2] = 1;
                l[0][1] = l[0][2] = l[1][2] = 0;
                double [][]u = new double[n][n];
                u[1][0] = u[2][0] = u[2][1] = 0;
                u[0][0] = mat[0][0];
                u[0][1] = mat[0][1];
                u[0][2] = mat[0][2];
                l[1][0] = mat[1][0]/mat[0][0];
                u[1][1] = mat[1][1] - (l[1][0]*u[0][1]);   //mat[2][2]-(mat[2][1]*mat[1][2]/mat[1][1]);
                u[1][2] = mat[1][2] - (l[1][0]*u[0][2]);
                l[2][0] = mat[2][0]/u[0][0];
                l[2][1] = (mat[2][1] - l[2][1]*u[0][1])/u[1][1];
                u[2][2] = mat[2][2] - (l[2][0]*u[0][2]) - (l[2][1]*u[1][2]);
                System.out.println("The L Component is:");
                for(int i=0; i<n; i++)
                    {
                        for(int j=0; j<n; j++)
                            System.out.print(" "+l[i][j]);
                        System.out.println();
                    }
                System.out.println("The U Component is:");
                for(int i=0; i<n; i++)
                    {
                        for(int j=0; j<n; j++)
                            System.out.print(" "+u[i][j]);
                        System.out.println();
                    }
            }
        sc.close();
    }
}

/*
Enter the dimension of the matrix:
3
2 3 1
4 5 1
1 1 1
The L Component is:
 1.0 0.0 0.0
 2.0 1.0 0.0
 0.5 -1.0 1.0
The U Component is:
 2.0 3.0 1.0
 0.0 -1.0 -1.0
 0.0 0.0 -0.5
