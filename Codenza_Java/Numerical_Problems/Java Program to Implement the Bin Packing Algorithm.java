/*
This is the java implementation of classic Bin-Packing algorithm. In the bin packing problem, objects of different volumes must be packed into a finite number of bins or containers each of volume V in a way that minimizes the number of bins used. In computational complexity theory, it is a combinatorial NP-hard problem.
*/

//This is a sample program to illustrate the Bin-Packing algorithm using next fit heuristics
import java.util.Scanner;

public class Bin_Packing_Algorithm
{
    public static void binPacking(int []a, int size, int n)
    {
        int binCount=1;
        int s = size;
        for(int i=0; i<n; i++)
            {
                if(s - a[i] > 0)
                    {
                        s -= a[i];
                        continue;
                    }
                else
                    {
                        binCount++;
                        s = size;
                        i--;
                    }
            }
        System.out.println("Number of bins required: "+binCount);
    }

    public static void main(String args[])
    {
        System.out.println("BIN - PACKING Algorithm");
        System.out.println("Enter the number of items in Set: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter "+n+" items:");
        int []a = new int[n];
        for(int i=0; i<n; i++)
            a[i] = sc.nextInt();
        System.out.println("Enter the bin size: ");
        int size = sc.nextInt();
        binPacking(a, size, n);
        sc.close();
    }
}

/*
BIN - PACKING Algorithm
Enter the number of items in Set:
8
Enter 8 items:
4 5 8 3 4 5 1 6
Enter the bin size:
10

Number of bins required: 5
