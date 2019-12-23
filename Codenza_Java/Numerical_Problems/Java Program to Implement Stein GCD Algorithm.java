/*
This is a Java Program to Implement Stein GCD Algorithm. The binary GCD algorithm, also known as Stein’s algorithm, is an algorithm that computes the greatest common divisor of two nonnegative integers. Stein’s algorithm uses simpler arithmetic operations than the conventional Euclidean algorithm. It replaces division with arithmetic shifts, comparisons and subtraction.
Here is the sourc
*/

/**
 ** Java Program to Implement Stein GCD Algorithm
 **/

import java.util.Scanner;

/** Class SteinGcd **/
public class SteinGcd
{
    /** Function to calculate gcd **/
    public int gcd(int u, int v)
    {
        int shift;
        if (u == 0)
            return v;
        if (v == 0)
            return u;
        for (shift = 0; ((u | v) & 1) == 0; ++shift)
            {
                u >>= 1;
                v >>= 1;
            }
        while ((u & 1) == 0)
            u >>= 1;
        do
            {
                while ((v & 1) == 0)
                    v >>= 1;
                if (u > v)
                    {
                        int t = v;
                        v = u;
                        u = t;
                    }
                v = v - u;
            }
        while (v != 0);
        return u << shift;
    }
    /** Main function **/
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Stein GCD Algorithm Test\n");
        /** Make an object of SteingGcd class **/
        SteinGcd sg = new SteinGcd();
        /** Accept two integers **/
        System.out.println("Enter two integer numbers\n");
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        /** Call function gcd of class SteinGcd **/
        int gcd = sg.gcd(n1, n2);
        System.out.println("GCD of "+ n1 +" and "+ n2 +" = "+ gcd);
    }
}

/*
Enter two integer numbers

32984 10013
GCD of 32984 and 10013 = 589
