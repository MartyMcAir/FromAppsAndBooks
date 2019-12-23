/*

This is a Java Program to Implement Fermat Factorization Algorithm. Fermat’s factorization method, named after Pierre de Fermat, is based on the representation of an odd integer as the difference of two squares: N = a2 – b2. That difference is algebraically factorable as (a + b)(a – b); if neither factor equals one, it is a proper factorization of N.
*/

/**
 ** Java Program to implement Fermat Factorization Algorithm
 **/

import java.util.Scanner;

public class FermatFactorization
{
    /** Fermat factor **/
    public void FermatFactor(long N)
    {
        long a = (long) Math.ceil(Math.sqrt(N));
        long b2 = a * a - N;
        while (!isSquare(b2))
            {
                a++;
                b2 = a * a - N;
            }
        long r1 = a - (long)Math.sqrt(b2);
        long r2 = N / r1;
        display(r1, r2);
    }
    /** function to display roots **/
    public void display(long r1, long r2)
    {
        System.out.println("\nRoots = "+ r1 +" , "+ r2);
    }
    /** function to check if N is a perfect square or not **/
    public boolean isSquare(long N)
    {
        long sqr = (long) Math.sqrt(N);
        if (sqr * sqr == N || (sqr + 1) * (sqr + 1) == N)
            return true;
        return false;
    }
    /** main method **/
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Fermat Factorization Test\n");
        System.out.println("Enter odd number");
        long N = scan.nextLong();
        FermatFactorization ff = new FermatFactorization();
        ff.FermatFactor(N);
    }
}

/*

Enter odd number
5959

Roots = 59 , 101


Fermat Factorization Test

Enter odd number
432633

Roots = 499 , 867
