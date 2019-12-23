/*
This is the java implementation of performing Discrete Fourier Transform using Fast Fourier Transform algorithm. This class finds the DFT of N (power of 2) complex elements, generated randomly, using FFT. The input to the class is a two dimensional array of sequence.
*/

//This is a sample program to perform 2D FFT inplace
import java.util.Scanner;

public class TwoD_FFT
{
    static void twoDfft(double[][] inputData, double[][] realOut,
                        double[][] imagOut, double[][] amplitudeOut)
    {
        int height = inputData.length;
        int width = inputData[0].length;
        // Two outer loops iterate on output data.
        for (int yWave = 0; yWave < height; yWave++)
            {
                for (int xWave = 0; xWave < width; xWave++)
                    {
                        // Two inner loops iterate on input data.
                        for (int ySpace = 0; ySpace < height; ySpace++)
                            {
                                for (int xSpace = 0; xSpace < width; xSpace++)
                                    {
                                        // Compute real, imag, and ampltude.
                                        realOut[yWave][xWave] += (inputData[ySpace][xSpace] * Math
                                                                  .cos(2
                                                                       * Math.PI
                                                                       * ((1.0 * xWave * xSpace / width) + (1.0
                                                                               * yWave * ySpace / height))))
                                                                 / Math.sqrt(width * height);
                                        imagOut[yWave][xWave] -= (inputData[ySpace][xSpace] * Math
                                                                  .sin(2
                                                                       * Math.PI
                                                                       * ((1.0 * xWave * xSpace / width) + (1.0
                                                                               * yWave * ySpace / height))))
                                                                 / Math.sqrt(width * height);
                                        amplitudeOut[yWave][xWave] = Math
                                                                     .sqrt(realOut[yWave][xWave]
                                                                           * realOut[yWave][xWave]
                                                                           + imagOut[yWave][xWave]
                                                                           * imagOut[yWave][xWave]);
                                    }
                                System.out.println(realOut[yWave][xWave] + " + "
                                                   + imagOut[yWave][xWave] + " i");
                            }
                    }
            }
    }

    public static void main(String args[])
    {
        System.out.println("Enter the size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] input = new double[n][n];
        double[][] real = new double[n][n];
        double[][] img = new double[n][n];
        double[][] amplitutude = new double[n][n];
        System.out.println("Enter the 2D elements ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                input[i][j] = sc.nextDouble();
        twoDfft(input, real, img, amplitutude);
        sc.close();
    }
}

/*
Enter the size:
2
Enter the 2D elements
2 3
4 2

2.5 + 0.0 i
5.5 + 0.0 i
-0.5 + -1.8369701987210297E-16 i
0.5 + -3.0616169978683826E-16 i
2.5 + 0.0 i
-0.5 + -3.6739403974420594E-16 i
-0.5 + -1.8369701987210297E-16 i
-1.5 + -1.8369701987210297E-16 i
