/*This is a Java Program to evaluate an expression using stacks. Stack is an area of memory that holds all local variables and parameters used by any function and remembers the order in which functions are called so that function returns occur correctly. ‘push’ operation is used to add an element to stack and ‘pop’ operation is used to remove an element from stack. ‘peek’ operation is also implemented returning the value of the top element without removing it. The relation between the push and pop operations is such that the stack is a Last-In-First-Out (LIFO) data structure.
Here concept of stacks is applied to evaluate an arithmetic expression. This method of evaluation is commonly employed in calculators and many compilers for parsing the syntax of expressions, program blocks etc. before translating into low level code.*/

/*
 *  Java Program to Evaluate an Expression using Stacks
 */

import java.util.*;

public class EvaluateExpressionUsingStacks
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Create stacks for operators and operands */
        Stack<Integer> op  = new Stack<Integer>();
        Stack<Double> val = new Stack<Double>();
        /* Create temporary stacks for operators and operands */
        Stack<Integer> optmp  = new Stack<Integer>();
        Stack<Double> valtmp = new Stack<Double>();
        /* Accept expression */
        System.out.println("Evaluation Of Arithmetic Expression Using Stacks Test\n");
        System.out.println("Enter expression\n");
        String input = scan.next();
        input = "0" + input;
        input = input.replaceAll("-","+-");
        /* Store operands and operators in respective stacks */
        String temp = "";
        for (int i = 0; i < input.length(); i++)
            {
                char ch = input.charAt(i);
                if (ch == '-')
                    temp = "-" + temp;
                else if (ch != '+' &&  ch != '*' && ch != '/')
                    temp = temp + ch;
                else
                    {
                        val.push(Double.parseDouble(temp));
                        op.push((int)ch);
                        temp = "";
                    }
            }
        val.push(Double.parseDouble(temp));
        /* Create char array of operators as per precedence */
        /* -ve sign is already taken care of while storing */
        char operators[] = {'/','*','+'};
        /* Evaluation of expression */
        for (int i = 0; i < 3; i++)
            {
                boolean it = false;
                while (!op.isEmpty())
                    {
                        int optr = op.pop();
                        double v1 = val.pop();
                        double v2 = val.pop();
                        if (optr == operators[i])
                            {
                                /* if operator matches evaluate and store in temporary stack */
                                if (i == 0)
                                    {
                                        valtmp.push(v2 / v1);
                                        it = true;
                                        break;
                                    }
                                else if (i == 1)
                                    {
                                        valtmp.push(v2 * v1);
                                        it = true;
                                        break;
                                    }
                                else if (i == 2)
                                    {
                                        valtmp.push(v2 + v1);
                                        it = true;
                                        break;
                                    }
                            }
                        else
                            {
                                valtmp.push(v1);
                                val.push(v2);
                                optmp.push(optr);
                            }
                    }
                /* Push back all elements from temporary stacks to main stacks */
                while (!valtmp.isEmpty())
                    val.push(valtmp.pop());
                while (!optmp.isEmpty())
                    op.push(optmp.pop());
                /* Iterate again for same operator */
                if (it)
                    i--;
            }
        System.out.println("\nResult = "+val.pop());
    }
}

/*
Evaluation Of Arithmetic Expression Using Stacks Test

Enter expression

3*4+5*6-32/8+19/4*43+5-32+7-58/9+12*3-48/8-3/7+14/2+12*3+5

Result = 293.3769841269841




Evaluation Of Arithmetic Expression Using Stacks Test

Enter expression

32+45-23+45/13+28-4/32+51/17-49/3+157+2+4*45+3/4-6*5-48+13*12-42/12+24/162*94

Result = 500.17913105413106



Evaluation Of Arithmetic Expression Using Stacks Test

Enter expression

12.5*18+35.64/23.45+64.12-77.1+24/65+13.76+246.34-23*123+162.1+24*6-19+94

Result = -1973.890939806462
