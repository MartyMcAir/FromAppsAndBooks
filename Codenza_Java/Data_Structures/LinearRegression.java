 

/*************************************************************************
 *  Compilation:  javac LinearRegression.java
 *  Execution:    java  LinearRegression
 *  
 *  Compute least squares solution to y = beta * x + alpha.
 *  Simple linear regression.
 *
 *  // TODO: rename beta and alpha to slope and intercept.
 *
 *************************************************************************/


/**
 *  The  LinearRegression  class performs a simple linear regression
 *  on an set of  N  data points ( y<sub>i</sub> ,  x<sub>i</sub> ).
 *  That is, it fits a straight line  y  = &alpha; + &beta;  x ,
 *  (where  y  is the response variable,  x  is the predictor variable,
 *  &alpha; is the  y-intercept , and &beta; is the  slope )
 *  that minimizes the sum of squared residuals of the linear regression model.
 *  It also computes associated statistics, including the coefficient of
 *  determination  R <sup>2</sup> and the standard deviation of the
 *  estimates for the slope and  y -intercept.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class LinearRegression {
    private final int N;
    private final double alpha, beta;
    private final double R2;
    private final double svar, svar0, svar1;

   /**
     * Performs a linear regression on the data points  (y[i], x[i]) .
     * @param x the values of the predictor variable
     * @param y the corresponding values of the response variable
     * @throws java.lang.IllegalArgumentException if the lengths of the two arrays are not equal
     */
    public LinearRegression(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("array lengths are not equal");
        }
        N = x.length;

        // first pass
        double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
        for (int i = 0; i < N; i++) sumx  += x[i];
        for (int i = 0; i < N; i++) sumx2 += x[i]*x[i];
        for (int i = 0; i < N; i++) sumy  += y[i];
        double xbar = sumx / N;
        double ybar = sumy / N;

        // second pass: compute summary statistics
        double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
        for (int i = 0; i < N; i++) {
            xxbar += (x[i] - xbar) * (x[i] - xbar);
            yybar += (y[i] - ybar) * (y[i] - ybar);
            xybar += (x[i] - xbar) * (y[i] - ybar);
        }
        beta  = xybar / xxbar;
        alpha = ybar - beta * xbar;

        // more statistical analysis
        double rss = 0.0;      // residual sum of squares
        double ssr = 0.0;      // regression sum of squares
        for (int i = 0; i < N; i++) {
            double fit = beta*x[i] + alpha;
            rss += (fit - y[i]) * (fit - y[i]);
            ssr += (fit - ybar) * (fit - ybar);
        }

        int degreesOfFreedom = N-2;
        R2    = ssr / yybar;
        svar  = rss / degreesOfFreedom;
        svar1 = svar / xxbar;
        svar0 = svar/N + xbar*xbar*svar1;
    }

   /**
     * Returns the  y -intercept &alpha; of the best of the best-fit line  y  = &alpha; + &beta;  x .
     * @return the  y -intercept &alpha; of the best-fit line  y = &alpha; + &beta; x 
     */
    public double intercept() {
        return alpha;
    }

   /**
     * Returns the slope &beta; of the best of the best-fit line  y  = &alpha; + &beta;  x .
     * @return the slope &beta; of the best-fit line  y  = &alpha; + &beta;  x 
     */
    public double slope() {
        return beta;
    }

   /**
     * Returns the coefficient of determination  R <sup>2</sup>.
     * @return the coefficient of determination  R <sup>2</sup>, which is a real number between 0 and 1
     */
    public double R2() {
        return R2;
    }

   /**
     * Returns the standard error of the estimate for the intercept.
     * @return the standard error of the estimate for the intercept
     */
    public double interceptStdErr() {
        return Math.sqrt(svar0);
    }

   /**
     * Returns the standard error of the estimate for the slope.
     * @return the standard error of the estimate for the slope
     */
    public double slopeStdErr() {
        return Math.sqrt(svar1);
    }

   /**
     * Returns the expected response  y  given the value of the predictor
     *    variable  x .
     * @param x the value of the predictor variable
     * @return the expected response  y  given the value of the predictor
     *    variable  x 
     */
    public double predict(double x) {
        return beta*x + alpha;
    }

   /**
     * Returns a string representation of the simple linear regression model.
     * @return a string representation of the simple linear regression model,
     *   including the best-fit line and the coefficient of determination  R <sup>2</sup>
     */
    public String toString() {
        String s = "";
        s += String.format("%.2f N + %.2f", slope(), intercept());
        return s + "  (R^2 = " + String.format("%.3f", R2()) + ")";
    }


}

