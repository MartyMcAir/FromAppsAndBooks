/*
This is a java program to encrypt a matrix using a key. The key is hidden and kept secret and
inverse copy of the key is provided to the receiver, with which he/she can decrypt the matrix.
The operation performed is matrix multiplication.
*/

//This is sample program to encode any 2-dimensional matrix using matrix of elememts (i+j)
// for 2x2 encoding is done by multiplying given matrix with 0 1
//                                                           1 2
import java.util.Scanner;

public class Encoding_Matrix
{
    public static void main(String args[])
    {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the base of squared matrices");
        n = input.nextInt();
        int [][] a = new int[n][n];
        int [][] b = new int[n][n];
        int [][] c = new int[n][n];
        System.out.println("Enter the elements of matrix to be encoded: ");
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                a[i][j] = input.nextInt();
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                b[i][j] = i+j;
        for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                    {
                        for (int k = 0; k < n; k++)
                            {
                                c[i][j] = c[i][j] + a[i][k] * b[k][j];
                            }
                    }
            }
        System.out.println("The Encoded matrix is:");
        for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                    {
                        System.out.print(c[i][j] + " ");
                    }
                System.out.println();
            }
        input.close();
    }
}

/*

Enter the base of squared matrices
2
Enter the elements of matrix to be encoded:
1 5
3 9
The Encoded matrix is:
5 11
9 21

Enter the base of squared matrices
3
Enter the elements of matrix to be encoded:
1 2 3
4 5 6
7 8 9
The Encoded matrix is:
8 14 20
17 32 47
26 50 74
