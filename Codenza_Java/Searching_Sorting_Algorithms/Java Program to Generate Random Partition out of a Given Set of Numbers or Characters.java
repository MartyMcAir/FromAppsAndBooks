/*This is a java program to generate a random partitioning of a set of characters or numbers in to two sets. Randomly generate an index less than the total number of elements in the set.*/

//This is a java program to perform partitioning at random index and generate two sets for given set of numbers or characters
import java.util.Random;
import java.util.Scanner;

public class Random_Partition
{
    public static void main(String args[])
    {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int noc = random.nextInt(2);
        // if noc is equal to 1 generate numbers
        if (noc == 1)
            {
                int N = 10;
                int[] sequence = new int[N];
                System.out.print("The Original set of numbers are:\n  ");
                for (int i = 0; i < N; i++)
                    {
                        sequence[i] = Math.abs(random.nextInt(100));
                        System.out.print(sequence[i] + " ");
                    }
                int partition_index = random.nextInt(11);
                System.out.println("\nThe two sequemces are: ");
                System.out.print("{ ");
                for (int i = 0; i < N; i++)
                    {
                        if (i == partition_index)
                            System.out.print(" } and { ");
                        System.out.print(sequence[i] + " ");
                    }
                System.out.print("}");
                System.out
                .println("\nPartitioning around index " + partition_index);
            }
        // else generate characters
        else
            {
                int N = 10;
                char[] sequence = new char[N];
                System.out.print("The Original set of characters are:\n  ");
                for (int i = 0; i < N; i++)
                    {
                        sequence[i] = (char) Math.abs(random.nextInt(123 - 97) + 97);
                        System.out.print(sequence[i] + " ");
                    }
                int partition_index = random.nextInt(11);
                System.out.println("\nThe two sequences are: ");
                System.out.print("{ ");
                for (int i = 0; i < N; i++)
                    {
                        if (i == partition_index)
                            System.out.print(" } and { ");
                        System.out.print(sequence[i] + " ");
                    }
                System.out.print("}");
                System.out
                .println("\nPartitioning around index " + partition_index);
            }
        sc.close();
    }
}


/*
The Original set of numbers are:
  70 13 10 36 78 98 18 64 60 84
The two sequences are:
{ 70 13 10 36 78 98 18 64  } and { 60 84 }
Partitioning around index 8

The Original set of characters are:
  n p r e m z y o x p
The two sequences are:
{ n p r e m z  } and { y o x p }
Partitioning around index 6
