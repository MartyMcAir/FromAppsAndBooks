import java.util.Scanner;

class Add2Matrix
{

    public static void main(String args[])
    {
        int rows, cols, c, d;
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter number of rows and columns");
        rows = in.nextInt();
        cols  = in.nextInt();
        int first[][] = new int[rows][cols];
        int second[][] = new int[rows][cols];
        int sum[][] = new int[rows][cols];
        System.out.println("Please Enter elements of first matrix");
        for (  c = 0 ; c < rows ; c++ )
            for ( d = 0 ; d < cols ; d++ )
                first[c][d] = in.nextInt();
        System.out.println("Please Enter elements of second matrix");
        for ( c = 0 ; c < rows ; c++ )
            for ( d = 0 ; d < cols ; d++ )
                second[c][d] = in.nextInt();
        for ( c = 0 ; c < rows ; c++ )
            for ( d = 0 ; d < cols ; d++ )
                sum[c][d] = first[c][d] + second[c][d];  //replace '+' with '-' to subtract matrices
        System.out.println("Sum of entered matrices:-");
        for ( c = 0 ; c < rows ; c++ )
            {
                for ( d = 0 ; d < cols ; d++ )
                    System.out.print(sum[c][d]+"\t");
                System.out.println();
            }
    }

}
