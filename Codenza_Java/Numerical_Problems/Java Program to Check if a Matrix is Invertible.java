/*
This is the java program to check whether the matrix is invertible or not. The square matrix is invertible if and only if its determinant is non zero.
*/

//This is a simple program to check whether the matrix is invertible or not.
//The complexity of the algorithm is O(n^3)

import java.util.*;

public class Invertible_Matrix
{
    public double determinant(double A[][],int N)
    {
        double det=0;
        if(N == 1)
            {
                det = A[0][0];
            }
        else if (N == 2)
            {
                det = A[0][0]*A[1][1] - A[1][0]*A[0][1];
            }
        else
            {
                det=0;
                for(int j1=0; j1<N; j1++)
                    {
                        double[][] m = new double[N-1][];
                        for(int k=0; k<(N-1); k++)
                            {
                                m[k] = new double[N-1];
                            }
                        for(int i=1; i<N; i++)
                            {
                                int j2=0;
                                for(int j=0; j<N; j++)
                                    {
                                        if(j == j1)
                                            continue;
                                        m[i-1][j2] = A[i][j];
                                        j2++;
                                    }
                            }
                        det += Math.pow(-1.0,1.0+j1+1.0)* A[0][j1] * determinant(m,N-1);
                    }
            }
        return det;
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the order of the square matrix");
        int n = input.nextInt();
        System.out.println("Enter the elements of the square matrix");
        double[][] mat = new double[n][n];
        for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                    {
                        mat[i][j] = input.nextDouble();
                    }
            }
        Invertible_Matrix I = new Invertible_Matrix();
        if(I.determinant(mat, n) == 0)
            {
                System.out.println("Matrix is not Invertible, as the determinant is : "+I.determinant(mat, n));
            }
        else
            {
                System.out.println("Matrix is Invertible, as the determinant is : "+I.determinant(mat, n));
            }
        input.close();
    }
}

/*
Enter the order of the square matrix:
3
Enter the elements of the square matrix:
1 2 3
4 5 6
7 8 9
Matrix is not Invertible, as the determinant is : 0.0
