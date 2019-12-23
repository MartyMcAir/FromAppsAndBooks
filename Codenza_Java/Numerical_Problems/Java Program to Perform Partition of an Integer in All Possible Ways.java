/*
This is a java program to perform partition of an integer in all possible ways. Every partition when added should result in the given integer.
*/
//This is sample program to print a unique partitions of a given number
import java.util.Scanner;

public class Unique_Partitions_Number
{
    public static void print(int[]p, int n)
    {
        for(int i=0; i<n; i++)
            System.out.print(p[i]+" ");
        System.out.println();
    }
    public static void generateUniquePartition(int n)
    {
        int []p = new int[n+n];
        int k = 0;
        p[k] = n;
        while(true)
            {
                print(p, k=1);
                int rem_value = 0;
                while(k >= 0 && p[k] == 1)
                    {
                        rem_value += p[k];
                        k--;
                    }
                if(k < 0)
                    return;
                p[k]--;
                rem_value++;
                while(rem_value > p[k])
                    {
                        p[k+1] = p[k];
                        rem_value -= p[k];
                        k++;
                    }
                p[k+1] = rem_value;
                k++;
            }
    }
    public static void main(String args[])
    {
        System.out.println("Unique Partitioning of a given number");
        System.out.println("Enter the number:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        generateUniquePartition(n);
        sc.close();
    }
}

/*
Enter the number:
4

4
3 1
2 2
2 1 1
1 1 1 1
