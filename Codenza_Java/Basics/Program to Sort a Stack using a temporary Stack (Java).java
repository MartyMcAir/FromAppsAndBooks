/*
You have a stack with full of integers. Sort it in the ascending order using another temporary array by using all stack functionality.
*/

import java.util.Stack;

public class StackSort
{

    public static Stack<Integer> sortStack(Stack<Integer> input)
    {
        Stack<Integer> tmpStack = new Stack<Integer>();
        System.out.println("=============== debug logs ================");
        while(!input.isEmpty())
            {
                int tmp = input.pop();
                System.out.println("Element taken out: "+tmp);
                while(!tmpStack.isEmpty() && tmpStack.peek() > tmp)
                    {
                        input.push(tmpStack.pop());
                    }
                tmpStack.push(tmp);
                System.out.println("input: "+input);
                System.out.println("tmpStack: "+tmpStack);
            }
        System.out.println("=============== debug logs ended ================");
        return tmpStack;
    }

    public static void main(String a[])
    {
        Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);
        System.out.println("input: "+input);
        System.out.println("final sorted list: "+sortStack(input));
    }
}
