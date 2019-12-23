/*
This is a java program to generate random numbers using a probability distribution. Probability distribution is based on probability density function. a probability density function (pdf), or density of a continuous random variable, is a function that describes the relative likelihood for this random variable to take on a given value. The probability of the random variable falling within a particular range of values is given by the integral of this variable’s density over that range—that is, it is given by the area under the density function but above the horizontal axis and between the lowest and greatest values of the range.
*/

//This is a sample program to generate a random numbers based on probability desity function of spiner
//pdf(x) = 1 if x>360
//       = 0 if x<0
//       = x/360 otherwise
import java.util.Random;

public class Probability_distribution_Function_Random_Numbers
{
    static int N = 10;
    public static void main(String args[])
    {
        Random random = new Random();
        int p=0;
        for(int i=0; i<N; i++)
            {
                p = random.nextInt(400);
                if(p > 360)
                    System.out.println(1 + " ");
                else if(p < 0)
                    System.out.println(0 + " ");
                else
                    System.out.println(p*0.1/360 + " ");
            }
    }
}

/*

The random numbers are:
0.08527777777777779
0.07361111111111111
0.007222222222222223
0.08694444444444445
1
1
0.05527777777777779
0.0952777777777778
0.04888888888888889
0.016944444444444446
