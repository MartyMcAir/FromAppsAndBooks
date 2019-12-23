/*
This is the java implementation of performing Discrete Fourier Transform using Fast Fourier Transform algorithm. This class finds the DFT of N (power of 2) complex elements, generated randomly, using FFT. Further verification is done by taking the Inverse Discrete Fourier Transform, again using FFT.
*/

// This is a sample program to perform DFT using FFT, FFT is performed on random input sequence
public class FFT
{
    public static class Complex
    {
        private final double re; // the real part
        private final double im; // the imaginary part

        // create a new object with the given real and imaginary parts
        public Complex(double real, double imag)
        {
            re = real;
            im = imag;
        }

        // return a string representation of the invoking Complex object
        public String toString()
        {
            if (im == 0)
                return re + "";
            if (re == 0)
                return im + "i";
            if (im < 0)
                return re + " - " + (-im) + "i";
            return re + " + " + im + "i";
        }

        // return abs/modulus/magnitude and angle/phase/argument
        public double abs()
        {
            return Math.hypot(re, im);
        } // Math.sqrt(re*re + im*im)

        public double phase()
        {
            return Math.atan2(im, re);
        } // between -pi and pi

        // return a new Complex object whose value is (this + b)
        public Complex plus(Complex b)
        {
            Complex a = this; // invoking object
            double real = a.re + b.re;
            double imag = a.im + b.im;
            return new Complex(real, imag);
        }

        // return a new Complex object whose value is (this - b)
        public Complex minus(Complex b)
        {
            Complex a = this;
            double real = a.re - b.re;
            double imag = a.im - b.im;
            return new Complex(real, imag);
        }

        // return a new Complex object whose value is (this * b)
        public Complex times(Complex b)
        {
            Complex a = this;
            double real = a.re * b.re - a.im * b.im;
            double imag = a.re * b.im + a.im * b.re;
            return new Complex(real, imag);
        }

        // scalar multiplication
        // return a new object whose value is (this * alpha)
        public Complex times(double alpha)
        {
            return new Complex(alpha * re, alpha * im);
        }

        // return a new Complex object whose value is the conjugate of this
        public Complex conjugate()
        {
            return new Complex(re, -im);
        }

        // return a new Complex object whose value is the reciprocal of this
        public Complex reciprocal()
        {
            double scale = re * re + im * im;
            return new Complex(re / scale, -im / scale);
        }

        // return the real or imaginary part
        public double re()
        {
            return re;
        }

        public double im()
        {
            return im;
        }

        // return a / b
        public Complex divides(Complex b)
        {
            Complex a = this;
            return a.times(b.reciprocal());
        }

        // return a new Complex object whose value is the complex exponential of
        // this
        public Complex exp()
        {
            return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re)
                               * Math.sin(im));
        }

        // return a new Complex object whose value is the complex sine of this
        public Complex sin()
        {
            return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re)
                               * Math.sinh(im));
        }

        // return a new Complex object whose value is the complex cosine of this
        public Complex cos()
        {
            return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re)
                               * Math.sinh(im));
        }

        // return a new Complex object whose value is the complex tangent of
        // this
        public Complex tan()
        {
            return sin().divides(cos());
        }

        // a static version of plus
        public static Complex plus(Complex a, Complex b)
        {
            double real = a.re + b.re;
            double imag = a.im + b.im;
            Complex sum = new Complex(real, imag);
            return sum;
        }

        // compute the FFT of x[], assuming its length is a power of 2
        public static Complex[] fft(Complex[] x)
        {
            int N = x.length;
            // base case
            if (N == 1)
                return new Complex[] { x[0] };
            // radix 2 Cooley-Tukey FFT
            if (N % 2 != 0)
                {
                    throw new RuntimeException("N is not a power of 2");
                }
            // fft of even terms
            Complex[] even = new Complex[N / 2];
            for (int k = 0; k < N / 2; k++)
                {
                    even[k] = x[2 * k];
                }
            Complex[] q = fft(even);
            // fft of odd terms
            Complex[] odd = even; // reuse the array
            for (int k = 0; k < N / 2; k++)
                {
                    odd[k] = x[2 * k + 1];
                }
            Complex[] r = fft(odd);
            // combine
            Complex[] y = new Complex[N];
            for (int k = 0; k < N / 2; k++)
                {
                    double kth = -2 * k * Math.PI / N;
                    Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
                    y[k] = q[k].plus(wk.times(r[k]));
                    y[k + N / 2] = q[k].minus(wk.times(r[k]));
                }
            return y;
        }

        // compute the inverse FFT of x[], assuming its length is a power of 2
        public static Complex[] ifft(Complex[] x)
        {
            int N = x.length;
            Complex[] y = new Complex[N];
            // take conjugate
            for (int i = 0; i < N; i++)
                {
                    y[i] = x[i].conjugate();
                }
            // compute forward FFT
            y = fft(y);
            // take conjugate again
            for (int i = 0; i < N; i++)
                {
                    y[i] = y[i].conjugate();
                }
            // divide by N
            for (int i = 0; i < N; i++)
                {
                    y[i] = y[i].times(1.0 / N);
                }
            return y;
        }

        // display an array of Complex numbers to standard output
        public static void show(Complex[] x, String title)
        {
            System.out.println(title);
            for (int i = 0; i < x.length; i++)
                {
                    System.out.println(x[i]);
                }
            System.out.println();
        }

        public static void main(String[] args)
        {
            int N = 8;//Integer.parseInt(args[0]);
            Complex[] x = new Complex[N];
            // original data
            for (int i = 0; i < N; i++)
                {
                    x[i] = new Complex(i, 0);
                    x[i] = new Complex(-2 * Math.random() + 1, 0);
                }
            show(x, "x");
            // FFT of original data
            Complex[] y = fft(x);
            show(y, "y = fft(x)");
            // take inverse FFT
            Complex[] z = ifft(y);
            show(z, "z = ifft(y)");
        }

    }
}

/*

x
0.5568836254037923
0.8735842104393365
0.6099699812709252
0.5631502515566189
-0.518857260970139
-0.5946393148293805
0.47144753318047794
-0.3501597962417593

y = fft(x)
1.6113792298098721
1.4681239692650163 - 1.8225209872296184i
-1.0433911500177497 - 0.06595444029509645i
0.6833578034828462 - 1.545476091048724i
0.6275085279602408
0.6833578034828462 + 1.545476091048724i
-1.0433911500177497 + 0.06595444029509645i
1.4681239692650163 + 1.8225209872296184i

z = ifft(y)
0.5568836254037923
0.8735842104393365 - 5.652078740871965E-17i
0.6099699812709252 - 4.24102681660054E-18i
0.5631502515566189 - 5.4501515053796015E-17i
-0.518857260970139
-0.5946393148293805 + 5.4501515053796015E-17i
0.47144753318047794 + 4.24102681660054E-18i
-0.3501597962417593 + 5.652078740871965E-17i
