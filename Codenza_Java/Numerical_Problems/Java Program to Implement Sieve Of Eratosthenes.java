/*
This is a Java Program to Implement Sieve Of Eratosthenes Algorithm. This is a program to find all primes less than a number.
*/

/**
 ** Java Program to implement Sieve Of Eratosthenes
 **/

import java.util.Scanner;

/** Class SieveOfEratosthenes **/
public class SieveOfEratosthenes
{
    /** Function to calculate all primes less than n **/
    private int[] calcPrimes(int N)
    {
        int[] arr = new int[N + 1];
        for (int i = 2; i <= Math.sqrt(N); i++)
            {
                if (arr[i] == 0)
                    {
                        for (int j = i * i; j <= N; j += i)
                            {
                                arr[j] = 1;
                            }
                    }
            }
        return arr;
    }
    /** Function to get all primes **/
    public void getPrimes(int N)
    {
        int[] primes = calcPrimes(N);
        display(primes);
    }
    /** Function to display all primes **/
    public void display(int[] primes)
    {
        System.out.print("\nPrimes = ");
        for (int i = 2; i < primes.length; i++)
            if (primes[i] == 0)
                System.out.print(i +" ");
        System.out.println();
    }
    /** Main function **/
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Sieve Of Eratosthenes Prime Algorithm Test\n");
        /** Make an object of SieveOfEratosthenes class **/
        SieveOfEratosthenes soe = new SieveOfEratosthenes();
        /** Accept n **/
        System.out.println("Enter number to find all primes less than the number\n");
        int n = scan.nextInt();
        soe.getPrimes(n);
    }
}

/*

Enter number to find all primes less than the number

500

Primes = 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
101 103 107 109 113 127 131 137 139 149 151 157 163 167 173 179 181 191 193 197
199 211 223 227 229 233 239 241 251 257 263 269 271 277 281 283 293 307 311 313
317 331 337 347 349 353 359 367 373 379 383 389 397 401 409 419 421 431 433 439
443 449 457 461 463 467 479 487 491 499
