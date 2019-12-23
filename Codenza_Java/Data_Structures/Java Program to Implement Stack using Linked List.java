/*This is a Java Program to implement a stack using linked list. Stack is an area of memory that holds all local variables and parameters used by any function, and remembers the order in which functions are called so that function returns occur correctly. Each time a function is called, its local variables and parameters are “pushed onto” the stack. When the function returns, these locals and parameters are “popped”. Because of this, the size of a program’s stack fluctuates constantly as the program is running, but it has some maximum size. Stack is a Last In First Out (LIFO) abstract data type and linear data structure. Linked list is a data structure consisting of a group of nodes which together represent a sequence. Here we need to apply the application of linked list to perform basic operations of stack.*/

/*
 * Java Program to Implement Stack using Linked List
 */

import java.util.*;

/*  Class Node  */
class Node
{
    protected int data;
    protected Node link;

    /*  Constructor  */
    public Node()
    {
        link = null;
        data = 0;
    }
    /*  Constructor  */
    public Node(int d,Node n)
    {
        data = d;
        link = n;
    }
    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }
    /*  Function to set data to current Node  */
    public void setData(int d)
    {
        data = d;
    }
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }
    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }
}

/*  Class linkedStack  */
class linkedStack
{
    protected Node top ;
    protected int size ;

    /*  Constructor  */
    public linkedStack()
    {
        top = null;
        size = 0;
    }
    /*  Function to check if stack is empty */
    public boolean isEmpty()
    {
        return top == null;
    }
    /*  Function to get the size of the stack */
    public int getSize()
    {
        return size;
    }
    /*  Function to push an element to the stack */
    public void push(int data)
    {
        Node nptr = new Node (data, null);
        if (top == null)
            top = nptr;
        else
            {
                nptr.setLink(top);
                top = nptr;
            }
        size++ ;
    }
    /*  Function to pop an element from the stack */
    public int pop()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception") ;
        Node ptr = top;
        top = ptr.getLink();
        size-- ;
        return ptr.getData();
    }
    /*  Function to check the top element of the stack */
    public int peek()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception") ;
        return top.getData();
    }
    /*  Function to display the status of the stack */
    public void display()
    {
        System.out.print("\nStack = ");
        if (size == 0)
            {
                System.out.print("Empty\n");
                return ;
            }
        Node ptr = top;
        while (ptr != null)
            {
                System.out.print(ptr.getData()+" ");
                ptr = ptr.getLink();
            }
        System.out.println();
    }
}

/* Class LinkedStackImplement */
public class LinkedStackImplement
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedStack */
        linkedStack ls = new linkedStack();
        /* Perform Stack Operations */
        System.out.println("Linked Stack Test\n");
        char ch;
        do
            {
                System.out.println("\nLinked Stack Operations");
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
                        ls.push( scan.nextInt() );
                        break;
                    case 2 :
                        try
                            {
                                System.out.println("Popped Element = "+ ls.pop());
                            }
                        catch (Exception e)
                            {
                                System.out.println("Error : " + e.getMessage());
                            }
                        break;
                    case 3 :
                        try
                            {
                                System.out.println("Peek Element = "+ ls.peek());
                            }
                        catch (Exception e)
                            {
                                System.out.println("Error : " + e.getMessage());
                            }
                        break;
                    case 4 :
                        System.out.println("Empty status = "+ ls.isEmpty());
                        break;
                    case 5 :
                        System.out.println("Size = "+ ls.getSize());
                        break;
                    case 6 :
                        System.out.println("Stack = ");
                        ls.display();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /* display stack */
                ls.display();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Linked Stack Operations
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

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
33

Stack = 33 5

Do you want to continue (Type y or n)

y

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
24

Stack = 24 33 5

Do you want to continue (Type y or n)

y

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
87

Stack = 87 24 33 5

Do you want to continue (Type y or n)

y

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
99

Stack = 99 87 24 33 5

Do you want to continue (Type y or n)

y

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
1
Enter integer element to push
1

Stack = 1 99 87 24 33 5

Do you want to continue (Type y or n)

y

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
5
Size = 6

Stack = 1 99 87 24 33 5

Do you want to continue (Type y or n)

y

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
3
Peek Element = 1

Stack = 1 99 87 24 33 5

Do you want to continue (Type y or n)

y

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
2
Popped Element = 1

Stack = 99 87 24 33 5

Do you want to continue (Type y or n)

y

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
2
Popped Element = 99

Stack = 87 24 33 5

Do you want to continue (Type y or n)

y

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
2
Popped Element = 87

Stack = 24 33 5

Do you want to continue (Type y or n)

y

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
5
Size = 3

Stack = 24 33 5

Do you want to continue (Type y or n)

y

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
2
Popped Element = 24

Stack = 33 5

Do you want to continue (Type y or n)

y

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
3
Peek Element = 33

Stack = 33 5

Do you want to continue (Type y or n)

y

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
2
Popped Element = 33

Stack = 5

Do you want to continue (Type y or n)

y

Linked Stack Operations
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

Linked Stack Operations
1. push
2. pop
3. peek
4. check empty
5. size
2
Error : Underflow Exception

Stack = Empty

Do you want to continue (Type y or n)

y

Linked Stack Operations
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

Linked Stack Operations
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
