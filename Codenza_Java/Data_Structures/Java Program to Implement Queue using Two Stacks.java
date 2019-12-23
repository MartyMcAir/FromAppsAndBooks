/*Queue is a particular kind of abstract data type or collection in which the entities in the collection are kept in order and the principal (or only) operations on the collection are the addition of entities to the rear terminal position, known as enqueue, and removal of entities from the front terminal position, known as dequeue. This makes the queue a First-In-First-Out (FIFO) data structure.

Stack is a particular kind of abstract data type or collection in which the principal (or only) operations on the collection are the addition of an entity to the collection, known as push and removal of an entity, known as pop. The relation between the push and pop operations is such that the stack is a Last-In-First-Out (LIFO) data structure.

However a queue can be implemented using two stacks. Algorithm is as follows :

Create two stacks : 's' and 'tmp' as in the program given below
For insert operation :
    if size of s = 0 then
        push value into s
    else
        push all popped elements from s to tmp
        push value into s
        push all popped elements from tmp to s

For remove operation :
    if size of s = 0 then
        throw 'underflow' exception
    else
        return pop element from s*/

/*
*  Java Program to Implement Queue using Two Stacks
*/

import java.util.*;

/* Class queueUsingStack */
class queueUsingStack
{
    Stack<Integer> s ;
    Stack<Integer> tmp ;

    /* Constructor */
    public queueUsingStack()
    {
        s = new Stack<Integer>();
        tmp = new Stack<Integer>();
    }
    /*  Function to insert an element to the queue */
    public void insert(int data)
    {
        /* if no element is present in stack s then
         * push the new element to stack s */
        if (s.size() == 0)
            s.push(data);
        else
            {
                /* if elements are present in stack s then
                 * pop all the elements from stack s and
                 * push them to stack tmp  */
                int l = s.size();
                for (int i = 0; i < l; i++)
                    tmp.push(s.pop());
                /* push the new element to stack s */
                s.push(data);
                /* pop all elements from stack tmp and
                 * push them to stack s */
                for (int i = 0; i < l; i++)
                    s.push(tmp.pop());
            }
    }
    /*  Function to remove front element from the queue */
    public int remove()
    {
        if (s.size() == 0)
            throw new NoSuchElementException("Underflow Exception");
        return s.pop();
    }
    /*  Function to check the front element of the queue */
    public int peek()
    {
        if (s.size() == 0)
            throw new NoSuchElementException("Underflow Exception");
        return s.peek();
    }
    /*  Function to check if queue is empty */
    public boolean isEmpty()
    {
        return s.size() == 0 ;
    }
    /*  Function to get the size of the queue */
    public int getSize()
    {
        return s.size();
    }
    /*  Function to display the status of the queue */
    public void display()
    {
        System.out.print("\nQueue = ");
        int l = getSize();
        if (l == 0)
            System.out.print("Empty\n");
        else
            {
                /* Iterator wont return for stack in order */
                for (int i = l - 1; i >= 0; i--)
                    System.out.print(s.get(i)+" ");
                System.out.println();
            }
    }
}

/*  Class QueueImplementUsingTwoStacks */
public class QueueImplementUsingTwoStacks
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class queueUsingStack */
        queueUsingStack qus = new queueUsingStack();
        /* Perform Queue Operations */
        System.out.println("Queue Using Two Stacks Test\n");
        char ch;
        do
            {
                System.out.println("\nQueue Operations");
                System.out.println("1. insert");
                System.out.println("2. remove");
                System.out.println("3. peek");
                System.out.println("4. check empty");
                System.out.println("5. size");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        qus.insert( scan.nextInt() );
                        break;
                    case 2 :
                        try
                            {
                                System.out.println("Removed Element = "+ qus.remove() );
                            }
                        catch (Exception e)
                            {
                                System.out.println("Error : " + e.getMessage());
                            }
                        break;
                    case 3 :
                        try
                            {
                                System.out.println("Peek Element = "+ qus.peek() );
                            }
                        catch (Exception e)
                            {
                                System.out.println("Error : " + e.getMessage());
                            }
                        break;
                    case 4 :
                        System.out.println("Empty status = "+ qus.isEmpty() );
                        break;
                    case 5 :
                        System.out.println("Size = "+ qus.getSize() );
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /* Display Queue */
                qus.display();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
4
Empty status = true

Queue = Empty

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
1
Enter integer element to insert
99

Queue = 99

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
1
Enter integer element to insert
162

Queue = 99 162

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
1
Enter integer element to insert
3

Queue = 99 162 3

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
1
Enter integer element to insert
77

Queue = 99 162 3 77

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
1
Enter integer element to insert
42

Queue = 99 162 3 77 42

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
1
Enter integer element to insert
67

Queue = 99 162 3 77 42 67

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
1
Enter integer element to insert
34

Queue = 99 162 3 77 42 67 34

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
5
Size = 7

Queue = 99 162 3 77 42 67 34

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
3
Peek Element = 99

Queue = 99 162 3 77 42 67 34

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
2
Removed Element = 99

Queue = 162 3 77 42 67 34

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
2
Removed Element = 162

Queue = 3 77 42 67 34

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
2
Removed Element = 3

Queue = 77 42 67 34

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
2
Removed Element = 77

Queue = 42 67 34

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
2
Removed Element = 42

Queue = 67 34

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
2
Removed Element = 67

Queue = 34

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
2
Removed Element = 34

Queue = Empty

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
3
Error : Underflow Exception

Queue = Empty

Do you want to continue (Type y or n)

y

Queue Operations
1. insert
2. remove
3. peek
4. check empty
5. size
5
Size = 0

Queue = Empty

Do you want to continue (Type y or n)

n
