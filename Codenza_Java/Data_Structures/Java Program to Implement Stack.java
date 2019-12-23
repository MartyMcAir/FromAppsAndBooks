/*This is a Java Program to implement a stack. Stack is an area of memory that holds all local variables and parameters used by any function and remembers the order in which functions are called so that function returns occur correctly. ‘push’ operation is used to add an element to stack and ‘pop’ operation is used to remove an element from stack. ‘peek’ operation is also implemented returning the value of the top element without removing it. The relation between the push and pop operations is such that the stack is a Last-In-First-Out (LIFO) data structure. The implemented stack has bounded capacity.*/

/*
 * Java Program to Implement Stack
 */

import java.util.*;

/*  Class arrayStack  */
class arrayStack
{
    protected int arr[];
    protected int top, size, len;
    /*  Constructor for arrayStack */
    public arrayStack(int n)
    {
        size = n;
        len = 0;
        arr = new int[size];
        top = -1;
    }
    /*  Function to check if stack is empty */
    public boolean isEmpty()
    {
        return top == -1;
    }
    /*  Function to check if stack is full */
    public boolean isFull()
    {
        return top == size -1 ;
    }
    /*  Function to get the size of the stack */
    public int getSize()
    {
        return len ;
    }
    /*  Function to check the top element of the stack */
    public int peek()
    {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return arr[top];
    }
    /*  Function to add an element to the stack */
    public void push(int i)
    {
        if(top + 1 >= size)
            throw new IndexOutOfBoundsException("Overflow Exception");
        if(top + 1 < size )
            arr[++top] = i;
        len++ ;
    }
    /*  Function to delete an element from the stack */
    public int pop()
    {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        len-- ;
        return arr[top--];
    }
    /*  Function to display the status of the stack */
    public void display()
    {
        System.out.print("\nStack = ");
        if (len == 0)
            {
                System.out.print("Empty\n");
                return ;
            }
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}

/*  Class StackImplement  */
public class StackImplement
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Stack Test\n");
        System.out.println("Enter Size of Integer Stack ");
        int n = scan.nextInt();
        /* Creating object of class arrayStack */
        arrayStack stk = new arrayStack(n);
        /* Perform Stack Operations */
        char ch;
        do
            {
                System.out.println("\nStack Operations");
                System.out.println("1. push");
                System.out.println("2. pop");
                System.out.println("3. peek");
                System.out.println("4. check empty");
                System.out.println("5. check full");
                System.out.println("6. size");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to push");
                        try
                            {
                                stk.push( scan.nextInt() );
                            }
                        catch (Exception e)
                            {
                                System.out.println("Error : " + e.getMessage());
                            }
                        break;
                    case 2 :
                        try
                            {
                                System.out.println("Popped Element = " + stk.pop());
                            }
                        catch (Exception e)
                            {
                                System.out.println("Error : " + e.getMessage());
                            }
                        break;
                    case 3 :
                        try
                            {
                                System.out.println("Peek Element = " + stk.peek());
                            }
                        catch (Exception e)
                            {
                                System.out.println("Error : " + e.getMessage());
                            }
                        break;
                    case 4 :
                        System.out.println("Empty status = " + stk.isEmpty());
                        break;
                    case 5 :
                        System.out.println("Full status = " + stk.isFull());
                        break;
                    case 6 :
                        System.out.println("Size = " + stk.getSize());
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /* display stack */
                stk.display();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Enter Size of Integer Stack
5

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

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
5. check full
6. size

1
Enter integer element to push
24

Stack = 24

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

1
Enter integer element to push
6

Stack = 6 24

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

1
Enter integer element to push
162

Stack = 162 6 24

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

1
Enter integer element to push
19

Stack = 19 162 6 24

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

1
Enter integer element to push
94

Stack = 94 19 162 6 24

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

5
Full status = true

Stack = 94 19 162 6 24

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

1
Enter integer element to push
32
Error : Overflow Exception

Stack = 94 19 162 6 24

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

3
Peek Element = 94

Stack = 94 19 162 6 24

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

2
Popped Element = 94

Stack = 19 162 6 24

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

2
Popped Element = 19

Stack = 162 6 24

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

2
Popped Element = 162

Stack = 6 24

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

6
Size = 2

Stack = 6 24

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

2
Popped Element = 6

Stack = 24

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

2
Popped Element = 24

Stack = Empty

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

2
Error : Underflow Exception

Stack = Empty

Do you want to continue (Type y or n)

y

Stack Operations
1. push
2. pop
3. peek
4. check empty
5. check full
6. size

4
Empty status = true

Stack = Empty

Do you want to continue (Type y or n)

n
