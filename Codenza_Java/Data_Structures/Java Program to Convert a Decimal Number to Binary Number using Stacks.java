/*This is a Java Program to find the binary equivalent of a decimal number using stacks. Stack is an area of memory that holds all local variables and parameters used by any function and remembers the order in which functions are called so that function returns occur correctly. ‘push’ operation is used to add an element to stack and ‘pop’ operation is used to remove an element from stack. ‘peek’ operation is also implemented returning the value of the top element without removing it. The relation between the push and pop operations is such that the stack is a Last-In-First-Out (LIFO) data structure.
For converting decimal number to binary, initially we push all the binary digits formed into the stack. After the entire number has been converted into the binary form, we pop one digit at a time from the stack and print it. Therefore we get the decimal number converted into its proper binary form.*/

/*
 *  Java Program to Convert a Decimal Number
 *  to Binary Number using Stacks
 */

import java.util.*;

/*  DecimalToBinaryUsingStacks  */
public class DecimalToBinaryUsingStacks
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating Stack object  */
        Stack<Integer> stk = new Stack<Integer>();
        /* Accepting number */
        System.out.println("Enter decimal number");
        int num = scan.nextInt();
        while (num != 0)
            {
                int d = num % 2;
                stk.push(d);
                num /= 2;
            }
        /* Print Binary equivalent */
        System.out.print("\nBinary equivalent = ");
        while (!(stk.isEmpty() ))
            {
                System.out.print(stk.pop());
            }
        System.out.println();
    }
}

/*
Enter decimal number
12345

Binary equivalent = 11000000111001


Enter decimal number
99

Binary equivalent = 1100011


Enter decimal number
24162

Binary equivalent = 101111001100010


Enter decimal number
347562318

Binary equivalent = 10100101101110110000101001110
