/*This is a java program to generate and print all subsets containing exactly k element, where k is provided by user and is <= number of elements in the set. We first find the median of the sequence and then compare with each element such that the difference between the median and number is minimum, and print such k elements. We can achieve this by using Binary Counting method, where we generate first 2^k-1 numbers. The binary number itself represents a subset with 0 as absent element and 1 as present elements*/

//This is a java program to generate all subsets containing exactly K elements in it
import java.util.Random;
import java.util.Scanner;

public class K_Elements_Subsets
{
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
        System.out.println("\nEnter the number of elements in the subsets: ");
        int n = sc.nextInt();
        int[] binary = new int[(int) Math.pow(2, N)];
        for (int i = 0; i < Math.pow(2, N); i++)
            {
                int b = 1;
                binary[i] = 0;
                int num = i, count = 0;
                while (num > 0)
                    {
                        if (num % 2 == 1)
                            count++;
                        binary[i] += (num % 2) * b;
                        num /= 2;
                        b = b * 10;
                    }
                if (count == n)
                    {
                        System.out.print("{ ");
                        for (int j = 0; j < N; j++)
                            {
                                if (binary[i] % 10 == 1)
                                    System.out.print(sequence[j] + " ");
                                binary[i] /= 10;
                            }
                        System.out.println("}");
                    }
            }
        sc.close();
    }
}

/*


Enter the number of elements in the set:
6
The elements in the set :
51 36 33 97 48 22
Enter the number of elements in the subsets:
3
{ 51 36 33 }
{ 51 36 97 }
{ 51 33 97 }
{ 36 33 97 }
{ 51 36 48 }
{ 51 33 48 }
{ 36 33 48 }
{ 51 97 48 }
{ 36 97 48 }
{ 33 97 48 }
{ 51 36 22 }
{ 51 33 22 }
{ 36 33 22 }
{ 51 97 22 }
{ 36 97 22 }
{ 33 97 22 }
{ 51 48 22 }
{ 36 48 22 }
{ 33 48 22 }
{ 97 48 22 }

Enter the number of elements in the set:
5
The elements in the set :
98 74 66 16 76
Enter the number of elements in the subsets:
2
{ 98 74 }
{ 98 66 }
{ 74 66 }
{ 98 16 }
{ 74 16 }
{ 66 16 }
{ 98 76 }
{ 74 76 }
{ 66 76 }
{ 16 76 }
