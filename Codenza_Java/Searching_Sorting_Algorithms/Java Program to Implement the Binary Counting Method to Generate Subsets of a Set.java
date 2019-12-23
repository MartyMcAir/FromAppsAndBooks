/*This is a java program to generate and print all possible subsets using the method of Binary Counting method. The generations of subsets are done using binary numbers. Let there be 3 elements in the set, we generate binary equivalent of 2^3 = 8 numbers(0-7), where each bit in a number represents the presence/absence of element in the subset. The element is present if bit is 1, absent otherwise. 010 – only second element is present in the subset.*/

//This is a java program to generate all subsets of given set of numbers using binary counting method
import java.util.Random;
import java.util.Scanner;

public class Binary_Counting_Subsets
{
    public static int[] binary(int N)
    {
        int[] binary = new int[(int) Math.pow(2, N)];
        for (int i = 0; i < Math.pow(2, N); i++)
            {
                int b = 1;
                binary[i] = 0;
                int num = i;
                while (num > 0)
                    {
                        binary[i] += (num % 2) * b;
                        num /= 2;
                        b = b * 10;
                    }
            }
        return binary;
    }

    public static void main(String args[])
    {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the set: ");
        int N = sc.nextInt();
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(100));
        System.out.println("The elements in the set : ");
        for (int i = 0; i < N; i++)
            System.out.print(sequence[i] + " ");
        int[] mask = new int[(int) Math.pow(2, N)];
        mask = binary(N);
        System.out.println("\nThe permutations are: ");
        for (int i = 0; i < Math.pow(2, N); i++)
            {
                System.out.print("{");
                for (int j = 0; j < N; j++)
                    {
                        if (mask[i] % 10 == 1)
                            System.out.print(sequence[j] + " ");
                        mask[i] /= 10;
                    }
                System.out.println("}");
            }
        sc.close();
    }
}

/*
Enter the number of elements in the set:
5
The elements in the set :
78 35 5 10 15
The permutations are:
{ }
{ 78 }
{ 35 }
{ 78 35 }
{ 5 }
{ 78 5 }
{ 35 5 }
{ 78 35 5 }
{ 10 }
{ 78 10 }
{ 35 10 }
{ 78 35 10 }
{ 5 10 }
{ 78 5 10 }
{ 35 5 10 }
{ 78 35 5 10 }
{ 15 }
{ 78 15 }
{ 35 15 }
{ 78 35 15 }
{ 5 15 }
{ 78 5 15 }
{ 35 5 15 }
{ 78 35 5 15 }
{ 10 15 }
{ 78 10 15 }
{ 35 10 15 }
{ 78 35 10 15 }
{ 5 10 15 }
{ 78 5 10 15 }
{ 35 5 10 15 }
{ 78 35 5 10 15 }
