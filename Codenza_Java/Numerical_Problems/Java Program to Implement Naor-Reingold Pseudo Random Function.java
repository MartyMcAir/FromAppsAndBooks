/*
This is a java program generate pseudo-random numbers using Naor-Reingold Pseudo-Random function. Let p and l be prime numbers with l |p-1. Select an element g in Fp of multiplicative order l. Then for each n-dimensional vector a = (a1, …, an). Fa(x) = g^(a1^x1 * a2^x2 …).
*/

//This is a java program to generate a random numbers using Naor-Reingold Psedurandom Function
import java.util.Random;

public class Naor_Reingold
{
    public static void main(String args[])
    {
        int p=7, l=3, g=2, n=4, x;
        int []a = {1,2,2,1};
        int []bin = new int[4];
        Random random = new Random();
        System.out.println("The Random numbers are: ");
        for(int i=0; i<10; i++)
            {
                x = random.nextInt(17);
                for(int j=3; j>=0; j--)
                    {
                        bin[j] = x%2;
                        x/=2;
                    }
                int mul = 1;
                for(int k=0; k<4; k++)
                    mul *= Math.pow(a[k], bin[k]);
                System.out.println(Math.pow(g, mul));
            }
    }
}

/*

The Random numbers are:
2.0
4.0
2.0
2.0
2.0
16.0
4.0
16.0
16.0
4.0
