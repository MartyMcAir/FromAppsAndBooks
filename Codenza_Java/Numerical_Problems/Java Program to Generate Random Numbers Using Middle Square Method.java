/*
This is java program to generate the random numbers. In mathematics, the middle-square method is a method of generating ‘pseudorandom’ numbers.To generate a sequence of 4-digit pseudorandom numbers, a 4-digit starting value is created and squared, producing an 8-digit number (if the result is less than 8 digits, leading zeroes are added to compensate). The middle 4 digits of the result would be the next number in the sequence, and returned as the result. This process is then repeated to generate more numbers.
*/

//This is a sample program to generate random numbers using the middle square method
import java.util.Random;
import java.util.Scanner;


public class Middle_Suqare_Method
{
    static int a[] = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
    static int middleSquareNumber(int numb, int dig)
    {
        int sqn = numb*numb, next_num=0;
        int trim = (dig/2);
        sqn = sqn / a[trim];
        for(int i=0; i<dig; i++)
            {
                next_num += (sqn%(a[trim]))*(a[i]);
                sqn = sqn/10;
            }
        return next_num;
    }
    public static void main(String args[])
    {
        System.out.println("Enter the #-digit random numbers you want: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start=1, end=1;
        start = a[n-1];
        end = a[n];
        Random rand = new Random();
        int number = rand.nextInt(end-start)+start;
        System.out.print("The random numbers are:\n" +number+", ");
        int new_number=0;
        for(int i=0; i<9; i++)
            {
                number = Middle_Suqare_Method.middleSquareNumber(number, n);
                System.out.print(number+", ");
            }
        System.out.print("...");
        sc.close();
    }
}

/*
Enter the #-digit random numbers you want:
2
The random numbers are:
89, 92, 46, 11, 12, 14, 19, 36, 29, 84, ...
