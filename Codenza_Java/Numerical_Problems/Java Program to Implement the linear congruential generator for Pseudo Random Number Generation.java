/*
This is java program to generate a random numbers, using linear congruential generator. The formula for next random number in the sequence is x(n+1) = {a*x(n)+c}mod m, where x(n+1) is current number to generate, x(n) is previously generated, a is multiplier, c is additive term and m is modulus.
*/

//This is a sample program to generate random numbers based on linear congruential generator
import java.math.BigInteger;
import java.util.Random;

public class Linear_Congruential_Random_Numbers
{
    public static void main(String args[])
    {
        BigInteger n = new BigInteger(16, new Random() {});
        Random rand = new Random();
        BigInteger m = new BigInteger("65535");//2^16
        for(int i=0; i<5; i++)
            {
                System.out.print(n+", ");
                BigInteger a = new BigInteger(16, new Random() {});
                BigInteger c = new BigInteger(16, new Random() {});
                n = ((a.multiply(a)).add(c)).mod(m);
            }
        System.out.println("... ");
    }
}

/*

5107, 48257, 43654, 50875, 12815, ...
