/*
This is the java implementation of Multiply With Carry (MWC) algorithm to generate a set of random numbers. The main advantages of the MWC method are that it invokes simple computer integer arithmetic and leads to very fast generation of sequences of random numbers with immense periods. The formula it uses is, x(n) = (a*x(n-r) + c(n-1))mod n and c(n) = (a*x(n-r) + c(n-1))/n, where a is any multiplier, m is modulus, c is carry and r is initial number of seeds.
*/

//This is a sample program to generate a random numbers based on Multiply with carry method
import java.util.Random;

public class Multiply_With_Carry
{
    public static void main(String args[])
    {
        int max_Sequence_Elements = 10;
        Random random = new Random();
        int base_b = 2000;
        int multiplier_a = random.nextInt(base_b);
        int r = 1;
        int []c = new int[max_Sequence_Elements];
        int []x = new int[max_Sequence_Elements];
        c[0] = random.nextInt(multiplier_a);
        x[0] = random.nextInt(base_b);
        System.out.print("The random number sequence is: " + x[0]);
        //generating sequence
        for(int i=1; i<max_Sequence_Elements; i++)
            {
                x[i] = (multiplier_a*x[i-r] + c[i-1]) % base_b;
                c[i] = (multiplier_a*x[i-r] + c[i-1]) / base_b;
                System.out.print(" " + x[i]);
            }
    }
}

/*

The random number sequence is: 795 382 1487 260 475 1798 1347 722 1389 63
