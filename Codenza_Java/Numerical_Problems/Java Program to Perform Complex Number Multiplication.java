/*
This is the java implementation of multiplication of two matrices consisting of complex numbers. Complex numbers are of the form a+bi.
*/

//This is a sample program to find the multiplication of two matrices consisting of complex numbers of any dimension
import java.util.Scanner;

public class Complex_Multiplication_Matrix
{
    private double real=0.0, img=0.0;
    public Complex_Multiplication_Matrix(double real, double img)
    {
        this.real = real;
        this.img = img;
    }
    public Complex_Multiplication_Matrix()
    {
        this.real = 0;
        this.img = 0;
    }

    public Complex_Multiplication_Matrix complex_Form(double re, double im)
    {
        Complex_Multiplication_Matrix res = new Complex_Multiplication_Matrix();
        res.real = re;
        res.img = im;
        return res;
    }
    public Complex_Multiplication_Matrix multiplication(Complex_Multiplication_Matrix C2)
    {
        Complex_Multiplication_Matrix Res = new Complex_Multiplication_Matrix();
        Res.real = (this.real * C2.real) - (this.img * C2.img);
        Res.img = (this.real * C2.img) + (this.img * C2.real);
        return Res;
    }
    public Complex_Multiplication_Matrix addtion(Complex_Multiplication_Matrix C2)
    {
        Complex_Multiplication_Matrix Res = new Complex_Multiplication_Matrix();
        this.real += C2.real;
        this.img  += C2.img;
        Res.real = this.real;
        Res.img = this.img;
        return Res;
    }
    public Complex_Multiplication_Matrix[][] matrix_multiplication(Complex_Multiplication_Matrix[][] a, Complex_Multiplication_Matrix[][] b, Complex_Multiplication_Matrix[][] res, int n)
    {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    res[i][j] = res[i][j].addtion(a[i][k].multiplication(b[k][j]));
        return res;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimension of the square matrix: ");
        int n = sc.nextInt();
        double re,im;
        Complex_Multiplication_Matrix[][] a = new Complex_Multiplication_Matrix[n][n];
        Complex_Multiplication_Matrix[][] b = new Complex_Multiplication_Matrix[n][n];
        Complex_Multiplication_Matrix[][] res = new Complex_Multiplication_Matrix[n][n];
        Complex_Multiplication_Matrix C = new Complex_Multiplication_Matrix();
        System.out.println("Enter the complex elements of 1st matrix: ");
        for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                    {
                        re = sc.nextDouble();
                        im = sc.nextDouble();
                        a[i][j] = C.complex_Form(re, im);
                    }
            }
        System.out.println("Enter the complex elements of matrix: ");
        for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                    {
                        re = sc.nextDouble();
                        im = sc.nextDouble();
                        b[i][j] = C.complex_Form(re, im);
                    }
            }
        for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                    {
                        re = 0.0;
                        im = 0.0;
                        res[i][j] = C.complex_Form(re, im);
                    }
            }
        res = C.matrix_multiplication(a, b, res, n);
        System.out.println("The Multiplication is:");
        for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                    System.out.print(res[i][j].real+"+"+res[i][j].img+"i ");
                System.out.println();
            }
        sc.close();
    }
}

/*

Enter the dimension of the square matrix:
2
Enter the complex elements of matrix:
1 2 1 2
1 2 1 2
Enter the complex elements of matrix:
1 2 1 2
1 2 1 2
The Multiplication is:
-6.0+8.0i -6.0+8.0i
-6.0+8.0i -6.0+8.0i
