import java.util.Stack;

public class StackImpl<E>
{
    private Stack<E> stack;

    /** Creates an empty Stack. **/
    public StackImpl()
    {
        stack = new Stack<E>();
    }

    /** Tests if this stack is empty. **/
    public boolean empty()
    {
        return stack.empty();
    }

    /**
     * Looks at the object at the top of this stack without removing it from the
     * stack.
     **/
    public E peek()
    {
        return stack.peek();
    }

    /**
     * Removes the object at the top of this stack and returns that object as
     * the value of this function.
     **/
    public E pop()
    {
        return stack.pop();
    }

    /** Pushes an item onto the top of this stack. **/
    public E push(E item)
    {
        return stack.push(item);
    }

    /** Returns the 1-based position where an object is on this stack. **/
    public int search(Object o)
    {
        return stack.search(o);
    }

    public static void main(String...arg)
    {
        StackImpl<Integer> stack = new StackImpl<Integer>();
        System.out.println("element pushed : " + stack.push(3));
        System.out.println("element pushed : " + stack.push(4));
        System.out.println("element pushed : " + stack.push(-19));
        System.out.println("element pushed : " + stack.push(349));
        System.out.println("element pushed : " + stack.push(35));
        System.out.println("element poped : " + stack.pop());
        System.out.println("element poped : " + stack.pop());
        System.out.println("Element peek : " + stack.peek());
        System.out.println("position of element 349 " + stack.search(3));
        while (!stack.empty())
            {
                System.out.println("element poped : " + stack.pop());
            }
    }
}

/*
element pushed : 3
element pushed : 4
element pushed : -19
element pushed : 349
element pushed : 35
element poped : 35
element poped : 349
Element peek : -19
position of element 349 3
element poped : -19
element poped : 4
element poped : 3
