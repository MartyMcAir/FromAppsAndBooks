/*
This is a Java Program to Implement Shoelace Algorithm. The shoelace formula, or shoelace algorithm, is a mathematical algorithm to determine the area of a simple polygon whose vertices are described by ordered pairs in the plane
*/

/**
 ** Java Program to Implement Shoelace Algorithm
 **/

import java.util.Scanner;

/** Class Shoelace **/
public class Shoelace
{
    /** Function to calculate area **/
    public double area(int[][] arr)
    {
        int n = arr.length;
        /** copy initial point to last row **/
        arr[n - 1][0] = arr[0][0];
        arr[n - 1][1] = arr[0][1];
        double det = 0.0;
        /** add product of x coordinate of ith point with y coordinate of (i + 1)th point **/
        for (int i = 0; i < n - 1; i++)
            det += (double)(arr[i][0] * arr[i + 1][1]);
        /** subtract product of y coordinate of ith point with x coordinate of (i + 1)th point **/
        for (int i = 0; i < n - 1; i++)
            det -= (double)(arr[i][1] * arr[i + 1][0]);
        /** find absolute value and divide by 2 **/
        det = Math.abs(det);
        det /= 2;
        return det;
    }
    /** Main function **/
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Shoelace Algorithm Test\n");
        /** Make an object of Shoelace class **/
        Shoelace s = new Shoelace();
        /** Accept number of points **/
        System.out.println("\nEnter number of points");
        int n = scan.nextInt();
        int[][] arr = new int[n + 1][2];
        System.out.println("Enter "+ n +" x, y coordinates");
        for (int i = 0; i < n; i++)
            {
                arr[i][0] = scan.nextInt();
                arr[i][1] = scan.nextInt();
            }
        double area = s.area(arr);
        System.out.println("\nArea = "+ area);
    }
}

/*
Enter number of points
5
Enter 5 x, y coordinates
3 4
5 11
12 8
9 5
5 6

Area = 30.0
