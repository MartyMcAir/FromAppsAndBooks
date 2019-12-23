/*This is a Java Program to implement a stack using two queues.
Stack is a particular kind of abstract data type or collection in which the principal (or only) operations on the collection are the addition of an entity to the collection, known as push and removal of an entity, known as pop. The relation between the push and pop operations is such that the stack is a Last-In-First-Out (LIFO) data structure.

Queue is a particular kind of abstract data type or collection in which the entities in the collection are kept in order and the principal (or only) operations on the collection are the addition of entities to the rear terminal position, known as enqueue, and removal of entities from the front terminal position, known as dequeue. This makes the queue a First-In-First-Out (FIFO) data structure.

However a stack can be implemented using two queues. Algorithm is as follows :

Create two queues : 'q' and 'tmp' as in the program given below
For push operation :
    if size of q = 0 then
        enqueue value into q
    else
        dequeue all elements from q to tmp
        enqueue value into q
        dequeue all elements from tmp to q

For pop operation :
    if size of q = 0 then
        throw 'underflow' exception
    else
        return front element of q*/

/*
 *  Java Program to Implement Stack using Two Queues
 */

import java.util.*;

/* Class stackUsingQueue */
class stackUsingQueue
{
    Queue<Integer> q ;
    Queue<Integer> tmp ;

    /* Constructor */
    public stackUsingQueue()
    {
        q = new LinkedList<Integer>();
        tmp = new LinkedList<Integer>();
    }
    /*  Function to push an element to the stack */
    public void push(int data)
    {
        /* if no element is present in queue q then
         * enqueue the new element into q  */
        if (q.size() == 0)
            q.add(data);
        else
            {
                /* if elements are present in q then
                 * dequeue all the elements to
                 * temporary queue tmp */
                int l = q.size();
                for (int i = 0; i < l; i++)
                    tmp.add(q.remove());
                /* enqueue the new element into q */
                q.add(data);
                /* dequeue all the elements from
                 * temporary queue tmp to q */
                for (int i = 0; i < l; i++)
                    q.add(tmp.remove());
            }
    }
    /*  Function to remove top element from the stack */
    public int pop()
    {
        if (q.size() == 0)
            throw new NoSuchElementException("Underflow Exception");
        return q.remove();
    }
    /*  Function to check the top element of the stack */
    public int peek()
    {
        if (q.size() == 0)
            throw new NoSuchElementException("Underflow Exception");
        return q.peek();
    }
    /*  Function to check if stack is empty */
    public boolean isEmpty()
    {
        return q.size() == 0 ;
    }
    /*  Function to get the size of the stack */
    public int getSize()
    {
        return q.size();
    }
    /*  Function to display the status of the stack */
    public void display()
    {
        System.out.print("\nStack = ");
        int l = getSize();
        if (l == 0)
            System.out.print("Empty\n");
        else
            {
                Iterator it = q.iterator();
                while (it.hasNext())
                    System.out.print(it.next()+" ");
                System.out.println();
            }
    }
}
/*  Class StackImplementUsingTwoQueues  */
public class StackImplementUsingTwoQueues
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        stackUsingQueue suq = new stackUsingQueue();
        /* Perform Stack Operations */
        System.out.println("Stack Using Two Queues Test\n");
        char ch;
        do
            {
                System.out.println("\nStack Operations");
                System.out.println("1. push");
                System.out.println("2. pop");
                System.out.println("3. peek");
                System.out.println("4. check empty");
                System.out.println("5. size");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to push");
                        suq.push( scan.nextInt() );
                        break;
                    case 2 :
                        try
                            {
                                System.out.println("Popped Element = "+ suq.pop() );
                            }
                        catch (Exception e)
                            {
                                System.out.println("Error : " + e.getMessage());
                            }
                        break;
                    case 3 :
                        try
                            {
                                System.out.println("Peek Element = "+ suq.peek() );
                            }
                        catch (Exception e)
                            {
                                System.out.println("Error : " + e.getMessage());
                            }
                        break;
                    case 4 :
                        System.out.println("Empty status = "+ suq.isEmpty() );
                        break;
                    case 5 :
                        System.out.println("Size = "+ suq.getSize() );
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /* Display Stack */
                suq.display();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}
/*
Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
4
Empty status = true

Stack = Empty

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
5

Stack = 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
99

Stack = 99 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
73

Stack = 73 99 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
50

Stack = 50 73 99 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
1

Stack = 1 50 73 99 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
24

Stack = 24 1 50 73 99 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
5
Size = 6

Stack = 24 1 50 73 99 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
3
Peek Element = 24

Stack = 24 1 50 73 99 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
2
Popped Element = 24

Stack = 1 50 73 99 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
2
Popped Element = 1

Stack = 50 73 99 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
2
Popped Element = 50

Stack = 73 99 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
2
Popped Element = 73

Stack = 99 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
2

Stack = 2 99 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
2
Popped Element = 2

Stack = 99 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
2
Popped Element = 99

Stack = 5

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
2
Popped Element = 5

Stack = Empty

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
3
Error : Underflow Exception

Stack = Empty

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
4
Empty status = true

Stack = Empty

Do you want to continue (Type y or n)

n



