/**
 * Java Program to Implement K Way Merge Algorithm
 **/

import java.util.Scanner;

/** Class KWayMerge **/
public class KWayMerge
{
    /** Function to merge arrays **/
    private int[] merge(int[][] arr)
    {
        int K = arr.length;
        int N = arr[0].length;
        /** array to keep track of non considered positions in subarrays **/
        int[] curPos = new int[K];
        /** final merged array **/
        int[] mergedArray = new int[K * N];
        int p = 0;
        while (p < K * N)
            {
                int min = Integer.MAX_VALUE;
                int minPos = -1;
                /** search for least element **/
                for (int i = 0; i < K; i++)
                    {
                        if (curPos[i] < N)
                            {
                                if (arr[i][curPos[i]] < min)
                                    {
                                        min = arr[i][curPos[i]];
                                        minPos = i;
                                    }
                            }
                    }
                curPos[minPos]++;
                mergedArray[p++] = min;
            }
        return mergedArray;
    }

    /** Main method **/
    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("K Way Merge Test\n");
        /** Accept k and n **/
        System.out.println("Enter K and N");
        int K = scan.nextInt();
        int N = scan.nextInt();
        int[][] arr = new int[K][N];
        /** Accept all elements **/
        System.out.println("Enter "+ K +" sorted arrays of length "+ N);
        for (int i = 0; i < K; i++)
            for (int j = 0; j < N; j++)
                arr[i][j] = scan.nextInt();
        KWayMerge kwm = new KWayMerge();
        int[] mergedArray = kwm.merge(arr);
        /** Print merged array **/
        System.out.println("\nMerged Array : ");
        for (int i = 0; i < mergedArray.length; i++)
            System.out.print(mergedArray[i] +" ");
        System.out.println();
    }
}

/*
Enter K and N
5 4
Enter 5 sorted arrays of length 4
2 4 6 19
1 20 35 67
3 5 7 11
45 46 47 48
3 9 100 200

Merged Array :
1 2 3 3 4 5 6 7 9 11 19 20 35 45 46 47 48 67 100 200



K Way Merge Test

Enter K and N
4 5
Enter 4 sorted arrays of length 5
2 4 6 19 94
2 8 5 19 63
3 5 7 11 13
1 10 25 50 100

Merged Array :
1 2 2 3 4 5 6 7 8 5 10 11 13 19 19 25 50 63 94 100



K Way Merge Test

Enter K and N
3 10
Enter 3 sorted arrays of length 10
3 6 9 12 15 18 21 24 27 30
2 5 8 11 14 17 20 23 26 29
1 4 7 10 13 16 19 22 25 28

Merged Array :
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
