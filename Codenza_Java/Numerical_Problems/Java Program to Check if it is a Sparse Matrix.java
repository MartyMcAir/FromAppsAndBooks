/*
This is the java program to find out a given matrix is sparse matrix or not. Sparse matrix contains zero elements above a certain threshold. This threshold is given by (n*m)/2, where n and m are the rows and columns in matrix. Hence, if a matrix contains more than nm/2 mumber of zeros it is sparse matrix otherwise not.
*/

//This is a sample program to check whether the matrix is sparse matrix or not
//The complexity of the code is O(n^2)
import java.util.Scanner;

public class Sparsity_Matrix
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimensions of the matrix: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        double[][] mat = new double[m][n];
        int zeros = 0;
        System.out.println("Enter the elements of the matrix: ");
        for(int i=0; i<m; i++)
            {
                for(int j=0; j<n; j++)
                    {
                        mat[i][j] = sc.nextDouble();
                        if(mat[i][j] == 0)
                            {
                                zeros++;
                            }
                    }
            }
        if(zeros > (m*n)/2)
            {
                System.out.println("The matrix is a sparse matrix");
            }
        else
            {
                System.out.println("The matrix is not a sparse matrix");
            }
        sc.close();
    }
}

/*

Enter the dimensions of the matrix:
2 3
Enter the elements of the matrix:
1 0 0
2 1 1
The matrix is not a sparse matrix

$ javac Sparsity_matrix.java
$ java Sparsity_matrix
Enter the dimensions of the matrix:
3 4
Enter the elements of the matrix:
1 0 0 0
0 1 0 0
0 0 1 1
The matrix is a sparse matrix
