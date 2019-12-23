Computing Fibonacci numbers

import java.io.*;
import java.math.BigInteger;

/**
* BigFib is a simple class for computing Fibonacci
* numbers, using the Java multi-precision integer
* class java.math.BigInteger.
*/
    public class BigFib {
    BigInteger last;
    BigInteger next;
    int n;
    
    /**
    * Create a new BigFib object, initialized to 0 on
    * the Fibonnacci sequence.
    */
        public BigFib () {
        n = 0;
        last = new BigInteger("0");
        next = new BigInteger("1");
    }
    
    /**
    * Compute c more Fibonnacci numbers, returning the
    * last one. Ideally, c should be even and >0.
    * If you want to print the numbers too, pass printTo
    * as non-null.
    */
        public BigInteger getFib(int c, PrintStream printTo) {
        BigInteger tmp;
            for( ; c > 0; c -= 2) {
            last = last.add(next); n++;
            if (printTo != null) printTo.println(" " + n + "\t" + last);
            next = next.add(last); n++;
            if (printTo != null) printTo.println(" " + n + "\t" + next);
        }
        if (c == 0) return next;
        else return last;
    }
    
    /**
    * Default limit for self-test.
    */
    public static final int defaultLimit = 100;
    
    /**
    * Self-test code, accepts an integer from the
    * command line, or uses the default limit.
    */
        public static void main(String args[]) {
        BigInteger answer;
        
        BigFib fib = new BigFib();
        
        System.out.println("\t\t Fibonacci sequence!");
        System.out.println("");
        
        System.out.println();
        int limit = 100;
            if (args.length > 0) {
            try { limit = Integer.parseInt(args[0]); }
                catch (NumberFormatException nfe) {
                System.err.println("Bad number, using default " + limit);
            }
                if (limit < 1) {
                limit = defaultLimit;
                System.err.println("Limit too low, using default " + limit);
            }
        }
        
        answer = fib.getFib(limit, System.out);
    }
}
