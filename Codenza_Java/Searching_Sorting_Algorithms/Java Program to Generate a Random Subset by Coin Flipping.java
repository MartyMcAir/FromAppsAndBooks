//This is a java program to generate a random subset using coin flipping
import java.util.Random;
import java.util.Scanner;

public class Random_Subset_Coin_Flipping
{
    static int coinFlip()
    {
        Random random = new Random();
        return random.nextInt(2);
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
        System.out.print("\nThe random subset is: \n{ ");
        for (int i = 0; i < N; i++)
            if (coinFlip() == 1)
                System.out.print(sequence[i] + " ");
        System.out.println("}");
        sc.close();
    }
}

/*
Enter the number of elements in the set:
10
The elements in the set :
1 44 88 58 8 62 94 59 38 33
The random subset is:
{ 1 44 8 33 }

Enter the number of elements in the set:
3
The elements in the set :
0 42 91
The random subset is:
{ 42 91 }
