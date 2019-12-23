/*This is a Java Program to compute volume of tetrahedron using determinants. Call the four vertices of the tetrahedron (a, b, c), (d, e, f), (g, h, i), and (p, q, r). Now create a 4-by-4 matrix in which the coordinate triples form the columns of the matrix, with a row of 1’s appended at the bottom:
a d g p
b e h q
c f i r
1 1 1 1
The volume of the tetrahedron is 1/6 times the absolute value of the matrix determinant. For any 4-by-4 matrix that has a row of 1’s along the bottom, you can compute the determinant with a simplification formula that reduces the problem to a 3-by-3 matrix
a-p d-p g-p
b-q e-q h-q
c-r f-r i-r*/

//This is a java program to find the volume of tetrahedron using a method of determinant
import java.util.Random;

public class Volume_Tetrahedron_Determinants
{
    public static double determinant(double A[][], int N)
    {
        double det = 0;
        if (N == 1)
            {
                det = A[0][0];
            }
        else if (N == 2)
            {
                det = A[0][0] * A[1][1] - A[1][0] * A[0][1];
            }
        else
            {
                det = 0;
                for (int j1 = 0; j1 < N; j1++)
                    {
                        double[][] m = new double[N - 1][];
                        for (int k = 0; k < (N - 1); k++)
                            {
                                m[k] = new double[N - 1];
                            }
                        for (int i = 1; i < N; i++)
                            {
                                int j2 = 0;
                                for (int j = 0; j < N; j++)
                                    {
                                        if (j == j1)
                                            continue;
                                        m[i - 1][j2] = A[i][j];
                                        j2++;
                                    }
                            }
                        det += Math.pow(-1.0, 1.0 + j1 + 1.0) * A[0][j1]
                               * determinant(m, N - 1);
                    }
            }
        return det;
    }

    public static void main(String args[])
    {
        Random random = new Random();
        int x1, x2, x3, x4, y1, y2, y3, y4, z1, z2, z3, z4;
        x1 = random.nextInt(10);
        x2 = random.nextInt(10);
        x3 = random.nextInt(10);
        x4 = random.nextInt(10);
        y1 = random.nextInt(10);
        y2 = random.nextInt(10);
        y3 = random.nextInt(10);
        y4 = random.nextInt(10);
        z1 = random.nextInt(10);
        z2 = random.nextInt(10);
        z3 = random.nextInt(10);
        z4 = random.nextInt(10);
        double[][] mat = new double[4][4];
        mat[0][0] = x1;
        mat[0][1] = x2;
        mat[0][2] = x3;
        mat[0][3] = x4;
        mat[1][0] = y1;
        mat[1][1] = y2;
        mat[1][2] = y3;
        mat[1][3] = y4;
        mat[2][0] = z1;
        mat[2][1] = z2;
        mat[2][2] = z3;
        mat[2][3] = z4;
        mat[3][0] = 1;
        mat[3][1] = 1;
        mat[3][2] = 1;
        mat[3][3] = 1;
        System.out
        .println("The matrix formed by the coordinates of the tetrahedron is: ");
        for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                    System.out.print(mat[i][j] + " ");
                System.out.println();
            }
        double[][] matrix = new double[3][3];
        matrix[0][0] = x1 - x4;
        matrix[0][1] = x2 - x4;
        matrix[0][2] = x3 - x4;
        matrix[1][0] = y1 - y4;
        matrix[1][1] = y2 - y4;
        matrix[1][2] = y3 - y4;
        matrix[2][0] = z1 - z4;
        matrix[2][1] = z2 - z4;
        matrix[2][2] = z3 - z4;
        System.out.println("Matrix after simplification: ");
        for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                    System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
        double det = determinant(matrix, 3) / 6;
        if (det < 0)
            System.out.println("The Area of the tetrahedron formed by (" + x1
                               + "," + y1 + "," + z1 + "),(" + x2 + "," + y2 + "," + z2
                               + "),(" + x3 + "," + y3 + "," + z3 + "), = " + (det * -1));
        else
            System.out.println("The Area of the tetrahedron formed by (" + x1
                               + "," + y1 + "," + z1 + "),(" + x2 + "," + y2 + "," + z2
                               + "),(" + x3 + "," + y3 + "," + z3 + "), = " + (det * -1));
    }
}

/*
The matrix formed by the coordinates of the tetrahedron is:
0.0 9.0 6.0 0.0
4.0 2.0 1.0 1.0
3.0 4.0 7.0 5.0
1.0 1.0 1.0 1.0
Matrix after simplification:
0.0 9.0 6.0
3.0 1.0 0.0
-2.0 -1.0 2.0
The Area of the tetrahedron formed by (0,4,3),(9,2,4),(6,1,7), = 10.0
