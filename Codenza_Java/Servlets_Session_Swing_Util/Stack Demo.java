Stack Demo

import java.util.Stack;

public class StackDemo
    {
    public static void main(String args[])
        {
        Stack lifo=new Stack();
        
        for(int i=1; i<=20; i++)
            {
            lifo.push (new Integer(i) );
        }
        while(!lifo.empty())
            {
            System.out.print(lifo.pop());
            System.out.print(',');
        }
        System.out.println("LIFT-OFF");
    }
}
