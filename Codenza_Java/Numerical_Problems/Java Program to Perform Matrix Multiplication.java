/*
This is a java program to perform a simple matrix multiplication. For matrix multiplication to happen the column of the first matrix should be equal to the row of the second matrix.
*/
// This is sample program for matrix multiplication
// The complexity of the algorithm is O(n^3)


import java.util.Scanner;

public class MatixMultiplication
{
    public static void main(String args[])
    {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the base of squared matrices");
        n = input.nextInt();
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        int[][] c = new int[n][n];
        System.out.println("Enter the elements of 1st martix row wise \n");
        for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                    {
                        a[i][j] = input.nextInt();
                    }
            }
        System.out.println("Enter the elements of 2nd martix row wise \n");
        for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                    {
                        b[i][j] = input.nextInt();
                    }
            }
        System.out.println("Multiplying the matrices...");
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
        System.out.println("The product is:");
        for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                    {
                        System.out.print(c[i][j] + " ");
                    }
                System.out.println();
            }
        input.close();
    }
}

/*
Enter the base of squared matrices:
3
Enter the elements of 1st martix row wise:
1 2 3
4 5 6
7 8 9
Enter the elements of 2nd martix row wise:
2 3 4
5 6 7
8 9 1
Multiplying the matrices...
The product is:
36 42 21
81 96 57
126 150 93
