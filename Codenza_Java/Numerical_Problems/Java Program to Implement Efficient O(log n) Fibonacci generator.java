/*
This is a Java Program to Implement Efficient O(log n) Fibonacci generator . This is a program to generate nth fibonacci number with O(log n) complexity.
*/

/**
 ** Java Program to Implement Efficient O(log n) Fibonacci generator
 **/

import java.util.Scanner;
import java.math.BigInteger;

/** Class FibonacciGenerator **/
public class FibonacciGenerator
{
    /** function to generate nth fibonacci number **/
    public void genFib(long n)
    {
        BigInteger arr1[][] = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        if (n == 0)
            System.out.println("\nFirst Fibonacci number = 0");
        else
            {
                power(arr1, n - 1);
                System.out.println("\n"+ n +" th Fibonacci number = "+ arr1[0][0]);
            }
    }
    /** function raise matrix to power n recursively **/
    private void power(BigInteger arr1[][], long n)
    {
        if (n == 0 || n == 1)
            return;
        BigInteger arr2[][] = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        power(arr1, n / 2);
        multiply(arr1, arr1);
        if (n % 2 != 0)
            multiply(arr1, arr2);
    }
    /** function to multiply two 2 d matrices **/
    private void multiply(BigInteger arr1[][], BigInteger arr2[][])
    {
        BigInteger x = (arr1[0][0].multiply(arr2[0][0])).add(arr1[0][1].multiply(arr2[1][0]));
        BigInteger y = (arr1[0][0].multiply(arr2[0][1])).add(arr1[0][1].multiply(arr2[1][1]));
        BigInteger z = (arr1[1][0].multiply(arr2[0][0])).add(arr1[1][1].multiply(arr2[1][0]));
        BigInteger w = (arr1[1][0].multiply(arr2[0][1])).add(arr1[1][1].multiply(arr2[1][1]));
        arr1[0][0] = x;
        arr1[0][1] = y;
        arr1[1][0] = z;
        arr1[1][1] = w;
    }
    /** Main function **/
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Efficient Fibonacci Generator\n");
        System.out.println("Enter number n to find nth fibonacci number\n");
        long n = scan.nextLong();
        FibonacciGenerator fg = new FibonacciGenerator();
        fg.genFib(n);
    }
}

/*
Enter number n to find nth fibonacci number

1000

1000 th Fibonacci number = 43466557686937456435688527675040625802564660517371780
40248172908953655541794905189040387984007925516929592259308032263477520968962323
9873322471161642996440906533187938298969649928516003704476137795166849228875
