/*This is a java program to generate and print all the subsets using the Gray Code Order. The reflected binary code, also known as Gray code after Frank Gray, is a binary numeral system where two successive values differ in only one bit (binary digit). The gray code equivalent of a binary number is (number >> 1) ^ number, i.e. right-shift the number by one and EX-ORing with the original number.*/

//This is a java program to generate all subsets of given set of numbers using gray code order
import java.util.Random;
import java.util.Scanner;

public class Gray_Code_Permutation
{
    public static int[] grayCode(int N)
    {
        int[] grayCode = new int[(int) Math.pow(2, N)];
        int[] binary = new int[(int) Math.pow(2, N)];
        for (int i = 0; i < Math.pow(2, N); i++)
            grayCode[i] = (i >> 1) ^ i;
        for (int i = 0; i < Math.pow(2, N); i++)
            {
                int b = 1;
                binary[i] = 0;
                while (grayCode[i] > 0)
                    {
                        binary[i] += (grayCode[i] % 2) * b;
                        grayCode[i] /= 2;
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
        mask = grayCode(N);
        System.out.println("\nThe permutations are: ");
        for (int i = 0; i < Math.pow(2, N); i++)
            {
                System.out.print("{ ");
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
4
The elements in the set :
36 75 15 59
The permutations are:
{ }
{ 36 }
{ 36 75 }
{ 75 }
{ 75 15 }
{ 36 75 15 }
{ 36 15 }
{ 15 }
{ 15 59 }
{ 36 15 59 }
{ 36 75 15 59 }
{ 75 15 59 }
{ 75 59 }
{ 36 75 59 }
{ 36 59 }
{ 59 }

Enter the number of elements in the set:
3
The elements in the set :
73 36 36
The permutations are:
{ }
{ 73 }
{ 73 36 }
{ 36 }
{ 36 36 }
{ 73 36 36 }
{ 73 36 }
{ 36 }
