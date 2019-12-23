//This is a java program to generate all pair of subsets whose union results the original set
import java.util.Random;
import java.util.Scanner;

public class Pair_Subset_Union_Set
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
        System.out
        .println("\nThe pair of permutations whose union is original set are: ");
        for (int i = 0; i < (Math.pow(2, N) / 2); i++)
            {
                System.out.print("{ ");
                for (int j = 0; j < N; j++)
                    {
                        if (mask[i] % 10 == 1)
                            System.out.print(sequence[j] + " ");
                        mask[i] /= 10;
                    }
                System.out.print("} and ");
                System.out.print("{ ");
                for (int j = 0; j < N; j++)
                    {
                        if (mask[(int) Math.pow(2, N) - 1 - i] % 10 == 1)
                            System.out.print(sequence[j] + " ");
                        mask[(int) Math.pow(2, N) - 1 - i] /= 10;
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
3 47 97 79 8
The pair of permutations whose union is original set are:
{ } and { 3 47 97 79 8 }
{ 3 } and { 47 97 79 8 }
{ 47 } and { 3 97 79 8 }
{ 3 47 } and { 97 79 8 }
{ 97 } and { 3 47 79 8 }
{ 3 97 } and { 47 79 8 }
{ 47 97 } and { 3 79 8 }
{ 3 47 97 } and { 79 8 }
{ 79 } and { 3 47 97 8 }
{ 3 79 } and { 47 97 8 }
{ 47 79 } and { 3 97 8 }
{ 3 47 79 } and { 97 8 }
{ 97 79 } and { 3 47 8 }
{ 3 97 79 } and { 47 8 }
{ 47 97 79 } and { 3 8 }
{ 3 47 97 79 } and { 8 }

Enter the number of elements in the set:
3
The elements in the set :
37 76 87
The pair of permutations whose union is original set are:
{ } and { 37 76 87 }
{ 37 } and { 76 87 }
{ 76 } and { 37 87 }
{ 37 76 } and { 87 }
