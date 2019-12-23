/*
This is the java program to check the multiplication of the two matrices. Two matrices are multiplicable if and only if the number of rows of the left hand side matrix is equal to the number of columns of the right hand side matrix.
*/

//This is sample program to find out whether the two matrices are multiplicable or not
//The complexity of the code is O(n)(linear)
import java.util.Scanner;

public class Multiplicability_Matrix
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimension of the matrix:\n ");
        int rowA = sc.nextInt();
        int colA = sc.nextInt();
        System.out.println("Enter the dimension of the other matrix:\n ");
        int rowB = sc.nextInt();
        int colB = sc.nextInt();
        if(colA == rowB)
            {
                System.out.println("Matrices are multipilcable");
            }
        else
            {
                System.out.println("Matrices are not multipilcable");
            }
        sc.close();
    }
}

/*
Enter the dimension of the matrix:
1 2
Enter the dimension of the other matrix:
2 3
Matrices are multipilcable
