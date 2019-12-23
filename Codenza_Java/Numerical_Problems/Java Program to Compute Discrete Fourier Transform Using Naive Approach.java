/*
This is the java implementation of Naive DFT approach over function. Formula for calculating the coefficient is X(k) = Sum(x(n)*cos(2*PI*k*n/N) – iSum(x(n)*sin(2*PI*k*n/N)) over 0 to N-1. This approach tries to many transforms using different values of k from 0 to N-1.
*/

//This is a java program to perform the DFT using naive approach
import java.util.Scanner;

public class DFT_Naive_Approach
{
    double real,  img;
    public DFT_Naive_Approach()
    {
        this.real = 0.0;
        this.img = 0.0;
    }
    public static void main(String args[])
    {
        int N = 10;
        Scanner sc = new Scanner(System.in);
        System.out.println("Disd=crete Fourier Transform using naive method");
        System.out.println("Enter the coefficient of simple linear funtion:");
        System.out.println("ax + by = c");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double []function = new double[N];
        for(int i=0; i<N; i++)
            {
                function[i] = (((a*(double)i) + (b*(double)i)) - c);
            }
        System.out.println("Enter the max K value: ");
        int k = sc.nextInt();
        DFT_Naive_Approach []dft_val = new DFT_Naive_Approach[k];
        System.out.println("The coefficients are: ");
        for(int j=0; j<k; j++)
            {
                dft_val[j] = new DFT_Naive_Approach();
                for(int i=0; i<N; i++)
                    {
                        dft_val[j].real += function[i] * Math.cos((2 * i * j * Math.PI) / N);;
                        dft_val[j].img += function[i] * Math.sin((2 * i * j * Math.PI) / N);;
                    }
                System.out.println("("+dft_val[j].real + ") - " + "("+dft_val[j].img + " i)");
            }
        sc.close();
    }
}

/*

Discrete Fourier Transform using naive method
Enter the coefficient of simple linear funtion:
ax + by = c
1 2 3
Enter the max K value:
20
The coefficients are:
(105.0) - (0.0 i)
(-15.00000000000001) - (-46.1652530576288 i)
(-15.00000000000001) - (-20.6457288070676 i)
(-15.000000000000005) - (-10.898137920080407 i)
(-15.000000000000004) - (-4.873795443493586 i)
(-15.0) - (1.4695761589768243E-14 i)
(-14.999999999999996) - (4.873795443493611 i)
(-15.000000000000103) - (10.898137920080355 i)
(-14.999999999999968) - (20.64572880706762 i)
(-14.999999999999922) - (46.16525305762871 i)
(105.0) - (-1.7634913907721884E-13 i)
(-15.00000000000012) - (-46.16525305762882 i)
(-15.000000000000053) - (-20.645728807067577 i)
(-14.999999999999911) - (-10.898137920080416 i)
(-15.000000000000037) - (-4.87379544349373 i)
(-15.0) - (1.0803613098771371E-13 i)
(-14.999999999999984) - (4.873795443493645 i)
(-14.99999999999996) - (10.89813792008029 i)
(-14.999999999999677) - (20.645728807067492 i)
(-14.999999999999769) - (46.16525305762875 i)
