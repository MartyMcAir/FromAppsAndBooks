/*
This is the java program to perform addition of two numbers without using any arithmetic operators. The summation of two numbers can be obtained using XOR operation and carry can be obtained using AND performed at bit level.
*/

//This is sample program to perform addition operation using bitwise operators.
import java.util.Scanner;

public class Bitwise_Addition
{
    static int add(int x, int y)
    {
        int carry;
        while(y!=0)
            {
                carry = x & y;
                x = x ^ y;
                y = carry << 1;
            }
        return x;
    }
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers to be added:");
        int x = input.nextInt();
        int y = input.nextInt();
        System.out.println("The Summation is: "+add(x, y));
        input.close();
    }
}

/*

Enter the numbers to be added:
15
16
The Summation is: 31
