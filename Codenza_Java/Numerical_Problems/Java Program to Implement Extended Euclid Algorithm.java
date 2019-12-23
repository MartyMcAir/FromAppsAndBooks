/*
Java Program to Implement Extended Euclid Algorithm
This is a Java Program to Implement Extended Euclid Algorithm. The extended Euclidean algorithm is an extension to the Euclidean algorithm. Besides finding the greatest common divisor of integers a and b, as the Euclidean algorithm does, it also finds integers x and y (one of which is typically negative) that satisfy Bézout’s identity
ax + by = gcd(a, b).
*/

/**
 ** Java Program to implement Extended Euclid  Algorithm
 **/

import java.util.Scanner;

/** Class ExtendedEuclid **/
public class ExtendedEuclid
{
    /** Function to solve **/
    public void solve(long a, long b)
    {
        long x = 0, y = 1, lastx = 1, lasty = 0, temp;
        while (b != 0)
            {
                long q = a / b;
                long r = a % b;
                a = b;
                b = r;
                temp = x;
                x = lastx - q * x;
                lastx = temp;
                temp = y;
                y = lasty - q * y;
                lasty = temp;
            }
        System.out.println("Roots  x : "+ lastx +" y :"+ lasty);
    }
    /** Main function **/
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Extended Euclid Algorithm Test\n");
        /** Make an object of ExtendedEuclid class **/
        ExtendedEuclid ee = new ExtendedEuclid();
        /** Accept two integers **/
        System.out.println("Enter a b of ax + by = gcd(a, b)\n");
        long a = scan.nextLong();
        long b = scan.nextLong();
        /** Call function solve of class ExtendedEuclid **/
        ee.solve(a, b);
    }
}

/*
Enter a b of ax + by = gcd(a, b)

120 23
Roots  x : -9 y :47



