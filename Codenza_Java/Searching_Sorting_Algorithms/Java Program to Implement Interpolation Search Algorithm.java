/*This is a Java Program to Implement Interpolation Search Algorithm.
 Interpolation search (sometimes referred to as extrapolation search) is an algorithm for searching for a given key value in an indexed array that has been ordered by the values of the key.
 On average the interpolation search makes about log(log(n)) comparisons (if the elements are uniformly distributed),
 where n is the number of elements to be searched. In the worst case (for instance where the numerical values of the keys increase exponentially) it can make up to O(n) comparisons.*/

/**
 ** Java Program to Implement Interpolation Search Algorithm
 **/

import java.util.Scanner;

/** Class InterpolationSearch **/
public class InterpolationSearch
{
    /** interpolationSearch function **/
    public static int interpolationSearch(int[] sortedArray, int toFind)
    {
        int low = 0;
        int high = sortedArray.length - 1;
        int mid;
        while (sortedArray[low] <= toFind && sortedArray[high] >= toFind)
            {
                if (sortedArray[high] - sortedArray[low] == 0)
                    return (low + high)/2;
                /** out of range is possible  here **/
                mid = low + ((toFind - sortedArray[low]) * (high - low)) / (sortedArray[high] - sortedArray[low]);
                if (sortedArray[mid] < toFind)
                    low = mid + 1;
                else if (sortedArray[mid] > toFind)
                    high = mid - 1;
                else
                    return mid;
            }
        if (sortedArray[low] == toFind)
            return low;
        /** not found **/
        else
            return -1;
    }
    /** Main method **/
    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("Interpolation Search Test\n");
        int n, i;
        /** Accept number of elements **/
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();
        /** Create integer array on n elements **/
        int arr[] = new int[ n ];
        /** Accept elements **/
        System.out.println("\nEnter "+ n +" sorted integer elements");
        for (i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        System.out.println("\nEnter element to search for : ");
        int key = scan.nextInt();
        int result = interpolationSearch(arr, key);
        if (result == -1)
            System.out.println("\n"+ key +" element not found");
        else
            System.out.println("\n"+ key +" elemnt found at position "+ result);
    }
}

/*
Enter number of integer elements
10

Enter 10 sorted integer elements
12 24 36 48 60 72 84 96 108 120

Enter element to search for :
24

24 elemnt found at position 1
