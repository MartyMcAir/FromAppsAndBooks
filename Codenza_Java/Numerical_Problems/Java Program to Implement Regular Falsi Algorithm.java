/*
This is a Java Program to Implement Regular Falsi Algorithm. Regular Falsi method is used for finding roots of functions.
*/

/**
 * Java Program to Implement Regular Falsi Algorithm
 **/

public class RegularFalsi
{
    /** function to find root for **/
    public double f(double x)
    {
        /** make your own function here but accordingly change (s, t) **/
        return Math.cos(x) - x * x * x;
        // return x * x * x - 3 * x + 4;
        // return Math.cos(x) - 3 * x + 1;
        // return 2 * x - Math.log(x)/Math.log(10) - 7;
        // return x * x - Math.log(x) - 12;
    }
    /** function to find root **/
    public double findRoot(double s, double t, double e, int m)
    {
        double r = 0.0,fr;
        int n, side = 0;
        /** starting values at endpoints of interval **/
        double fs = f(s);
        double ft = f(t);
        for (n = 0; n < m; n++)
            {
                r = (fs * t - ft * s) / (fs - ft);
                if (Math.abs(t - s) < e * Math.abs(t + s))
                    break;
                fr = f(r);
                if (fr * ft > 0)
                    {
                        /** fr and ft have same sign, copy r to t **/
                        t = r;
                        ft = fr;
                        if (side == -1)
                            fs /= 2;
                        side = -1;
                    }
                else if (fs * fr > 0)
                    {
                        /** fr and fs have same sign, copy r to s **/
                        s = r;
                        fs = fr;
                        if (side == +1)
                            ft /= 2;
                        side = +1;
                    }
                else
                    {
                        /** fr * f_ very small (looks like zero) **/
                        break;
                    }
            }
        return r;
    }
    /** Main function **/
    public static void main(String[] args)
    {
        System.out.println("Regular Falsi Test ");
        RegularFalsi rf = new RegularFalsi();
        /** lower limit **/
        double s = 0;
        /** upper limit **/
        double t = 1;
        /** half of upper bound for relative error **/
        double e = 5E-15;
        /** number of iterations **/
        int iterations = 100;
        System.out.println("\nRoot : "+ rf.findRoot(s, t, e, iterations));
    }
}

/*
Root : 0.8654740331016145
