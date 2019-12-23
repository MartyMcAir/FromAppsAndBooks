/*
This is a Java Program to Implement Pollard Rho Algorithm. Pollard Rho algorithm is a general purpose factorization algorithm. It is particularly effective at splitting composite numbers with small factors.
*/

/**
 ** Java Program to implement Pollard Rho Algorithm
 **/

import java.util.Scanner;

/** Class PollardRho **/
public class PollardRho
{
    private static final long C = 1;
    /** function X * X + C, change value of C as required **/
    private long f(long X)
    {
        return X * X + C;
    }
    /** get divisor **/
    private long rho(long N)
    {
        long x1 = 2, x2 = 2, divisor;
        if (N % 2 == 0)
            return 2;
        do
            {
                x1 = f(x1) % N;
                x2 = f(f(x2)) % N;
                divisor = gcd(Math.abs(x1 - x2), N);
            }
        while (divisor == 1);
        /** return divisor **/
        return divisor;
    }
    /** GCD of two numbers **/
    public  long gcd(long p, long q)
    {
        if (p % q == 0)
            return q;
        return gcd(q, p % q);
    }
    /** Check if num is prime **/
    public boolean isPrime(long N)
    {
        for (int i = 2; i <= Math.sqrt(N); i++)
            if (N % i == 0)
                return false;
        return true;
    }
    /** get all factors **/
    public void factor(long N)
    {
        if (N == 1)
            return;
        if (isPrime(N))
            {
                System.out.println(N);
                return;
            }
        long divisor = rho(N);
        factor(divisor);
        factor(N / divisor);
    }
    /** Main function **/
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pollard Rho Algorithm\n");
        System.out.println("Enter a number");
        long N = scan.nextLong();
        System.out.println("\nFactors are : ");
        PollardRho pr = new PollardRho();
        pr.factor (N);
    }
}

/*
Enter a number
2406

Factors are :
2
3
401
