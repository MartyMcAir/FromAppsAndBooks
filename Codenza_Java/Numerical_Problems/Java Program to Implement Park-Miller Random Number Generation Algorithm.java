/*
Java Program to Implement Park-Miller Random Number Generation Algorithm
This is java program to generate the random numbers, using the Park-Miller algorithm.Park–Miller random number generator (after Stephen K. Park and Keith W. Miller), is a variant of linear congruential generator (LCG) that operates in multiplicative group of integers modulo n. A general formula of a random number generator (RNG) of this type is, x(n+1) = g*x(n) mod n.
*/

//This is a sample program to random numbers using Park Miller Random Numbers algorithm
public class Park_Miller_Random_Numbers
{
    static final long m = 2147483647L;
    static final long a = 48271L;
    static final long q = 44488L;
    static final long r = 3399L;

    static long r_seed = 12345678L;

    public static double uniform ()
    {
        long hi = r_seed / q;
        long lo = r_seed - q * hi;
        long t = a * lo - r * hi;
        if (t > 0)
            r_seed = t;
        else
            r_seed = t + m;
        return r_seed;
    }

    public static void main (String[] argv)
    {
        double[] A = new double [10];
        for (int i=0; i<5; i++)
            A[i] = uniform();
        for (int i=0; i<5; i++)
            System.out.print ("  " + A[i]);
    }
}

//1.085252519E9  5.08259731E8  1.352291773E9  1.563240271E9  8.90733155E8 ...
