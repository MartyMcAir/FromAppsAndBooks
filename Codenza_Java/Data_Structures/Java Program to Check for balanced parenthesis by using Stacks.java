/*This is a Java Program to Check for balanced parenthesis by using Stacks. Parenthesis matching is commonly used for evaluating arithmetic expressions and in editors for validating syntax.*/

/*
 *  Java Program to Check for balanced paranthesis by using Stacks
 */

import java.util.*;

public class ParenthesisMatching
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating Stack */
        Stack<Integer> stk = new Stack<Integer>();
        System.out.println("Parenthesis Matching Test\n");
        /* Accepting expression */
        System.out.println("Enter expression");
        String exp = scan.next();
        int len = exp.length();
        System.out.println("\nMatches and Mismatches:\n");
        for (int i = 0; i < len; i++)
            {
                char ch = exp.charAt(i);
                if (ch == '(')
                    stk.push(i);
                else if (ch == ')')
                    {
                        try
                            {
                                int p = stk.pop() + 1;
                                System.out.println("')' at index "+(i+1)+" matched with ')' at index "+p);
                            }
                        catch(Exception e)
                            {
                                System.out.println("')' at index "+(i+1)+" is unmatched");
                            }
                    }
            }
        while (!stk.isEmpty() )
            System.out.println("'(' at index "+(stk.pop() +1)+" is unmatched");
    }
}

/*
Enter expression
(a+(b*c)-d)

Matches and Mismatches:

')' at index 8 matched with ')' at index 4
')' at index 11 matched with ')' at index 1



Parenthesis Matching Test

Enter expression
((x+y/(z-w))

Matches and Mismatches:

')' at index 11 matched with ')' at index 7
')' at index 12 matched with ')' at index 2
'(' at index 1 is unmatched



Parenthesis Matching Test

Enter expression
(a+b*(c-d)-(e-f/(g+h*(k-i)/(l-j+k

Matches and Mismatches:

')' at index 10 matched with ')' at index 6
')' at index 26 matched with ')' at index 22
'(' at index 28 is unmatched
'(' at index 17 is unmatched
'(' at index 12 is unmatched
'(' at index 1 is unmatched
