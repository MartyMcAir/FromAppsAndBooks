/*This is a java program to generate and print all the partitions of a number such that when those partition elements are added results in the number itself, plus the partition should be unique. We start with the number, number minus one is the next partition and so on, till all one’s are the last partition where we stop.*/

//This is a java program to perform integer partition such that every partition is unique
import java.util.Scanner;

public class Integer_Partition
{
    public static void print(int[]p, int n)
    {
        for(int i=0; i<n; i++)
            System.out.print(p[i]+" ");
        System.out.println();
    }
    public static void generateUniquePartition(int n)
    {
        int []p = new int[n];
        int k = 0;
        p[k] = n;
        while(true)
            {
                print(p, k+1);
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
        System.out.println("Partitioning of a given Integer such that every partition is unique");
        System.out.println("Enter the number:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        generateUniquePartition(n);
        sc.close();
    }

}

/*

Partitioning of a given Integer such that every partition is unique
Enter the number:
6
6
5 1
4 2
4 1 1
3 3
3 2 1
3 1 1 1
2 2 2
2 2 1 1
2 1 1 1 1
1 1 1 1 1 1
