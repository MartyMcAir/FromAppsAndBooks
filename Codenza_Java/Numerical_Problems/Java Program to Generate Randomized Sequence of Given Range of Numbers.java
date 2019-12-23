/*
This is java program to generate the random numbers, in the range given by the user. Range could be any numbers of size integer supported by Java.
*/

//This is the sample program to generate a randomized sequence of numbers
import java.util.Random;
import java.util.Scanner;


public class Randomized_Sequence_Random_Numbers
{
    public static void main(String args[])
    {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting and ending of the sequence: ");
        int start = sc.nextInt();
        int end = sc.nextInt();
        for(int i=0; i<15; i++)
            {
                System.out.print(rand.nextInt(end-start+1)+start + ", ");
            }
        System.out.print("...");
        sc.close();
    }
}

/*

Enter the starting and ending of the sequence:
100
1000
490, 574, 179, 447, 723, 891, 589, 312, 667, 653, 375, 667, 990, 573, 399, ...
