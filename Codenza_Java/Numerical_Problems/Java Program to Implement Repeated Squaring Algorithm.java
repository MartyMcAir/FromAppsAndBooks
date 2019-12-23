/*
This is a Java Program to Implement Repeated Squaring Algorithm. Repeated squaring algorithm is used to compute xn efficiently.
*/

/**
 ** Java Program to Implement Repeated Squaring Algorithm
 **/

import java.util.Scanner;

/** Class RepeatedSquaring **/
public class RepeatedSquaring
{
    /** Function for repeated squaring **/
    public double expBySquaring(double x, int n)
    {
        if (n < 0)
            return expBySquaring(1 / x, -n);
        else if (n == 0)
            return 1;
        else if (n == 1)
            return x;
        else if (n % 2 == 0)
            return expBySquaring(x * x, n / 2);
        else
            return x * expBySquaring(x * x, (n - 1)/2);
    }
    /** Main function **/
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Repeated Squaring Algorithm Test\n");
        /** Make an object of RepeatedSquaring class **/
        RepeatedSquaring rs = new RepeatedSquaring();
        /** Accept n , k **/
        System.out.println("\nEnter n and k of (N ^ K)");
        double n = scan.nextDouble();
        int k = scan.nextInt();
        double result = rs.expBySquaring(n, k);
        System.out.println("\nResult : "+ result);
    }
}

/*

Enter n and k of (N ^ K)
3 19

Result : 1.162261467E9


Repeated Squaring Algorithm Test


Enter n and k of (N ^ K)
7 -4

Result : 4.1649312786339016E-4
