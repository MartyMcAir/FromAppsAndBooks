/*This is a Java Program to implement Circular Buffer. A circular buffer, cyclic buffer or ring buffer is a data structure that uses a single, fixed-size buffer as if it were connected end-to-end. This structure lends itself easily to buffering data streams.*/

/**
 ** Java Program to implement Circular Buffer
 **/

import java.util.Scanner;

/** Class Circular Buffer **/
class CircularBuffer
{
    private int maxSize;
    private int front = 0;
    private int rear = 0;
    private int bufLen = 0;
    private char[] buf;

    /** constructor **/
    public CircularBuffer(int size)
    {
        maxSize = size;
        front = rear = 0;
        rear = 0;
        bufLen = 0;
        buf = new char[maxSize];
    }
    /** function to get size of buffer **/
    public int getSize()
    {
        return bufLen;
    }
    /** function to clear buffer **/
    public void clear()
    {
        front = rear = 0;
        rear = 0;
        bufLen = 0;
        buf = new char[maxSize];
    }
    /** function to check if buffer is empty **/
    public boolean isEmpty()
    {
        return bufLen == 0;
    }
    /** function to check if buffer is full **/
    public boolean isFull()
    {
        return bufLen == maxSize;
    }
    /** insert an element **/
    public void insert(char c)
    {
        if (!isFull() )
            {
                bufLen++;
                rear = (rear + 1) % maxSize;
                buf[rear] = c;
            }
        else
            System.out.println("Error : Underflow Exception");
    }
    /** delete an element **/
    public char delete()
    {
        if (!isEmpty() )
            {
                bufLen--;
                front = (front + 1) % maxSize;
                return buf[front];
            }
        else
            {
                System.out.println("Error : Underflow Exception");
                return ' ';
            }
    }
    /** function to print buffer **/
    public void display()
    {
        System.out.print("\nBuffer : ");
        for (int i = 0; i < maxSize; i++)
            System.out.print(buf[i] +" ");
        System.out.println();
    }
}


/** Class CircularBufferTest  **/
public class CircularBufferTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Circular Buffer Test\n");
        System.out.println("Enter Size of Buffer ");
        int n = scan.nextInt();
        /* creating object of class CircularBuffer */
        CircularBuffer cb = new CircularBuffer(n);
        /* Perform Circular Buffer Operations */
        char ch;
        do
            {
                System.out.println("\nCircular Buffer Operations");
                System.out.println("1. insert");
                System.out.println("2. remove");
                System.out.println("3. size");
                System.out.println("4. check empty");
                System.out.println("5. check full");
                System.out.println("6. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter character to insert");
                        cb.insert( scan.next().charAt(0) );
                        break;
                    case 2 :
                        System.out.println("Removed Element = "+ cb.delete());
                        break;
                    case 3 :
                        System.out.println("Size = "+ cb.getSize());
                        break;
                    case 4 :
                        System.out.println("Empty status = "+ cb.isEmpty());
                        break;
                    case 5 :
                        System.out.println("Full status = "+ cb.isFull());
                        break;
                    case 6 :
                        System.out.println("\nBuffer Cleared\n");
                        cb.clear();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /* display Buffer */
                cb.display();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Enter Size of Buffer
5

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
1
Enter character to insert
a

Buffer :   a

Do you want to continue (Type y or n)

y

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
1
Enter character to insert
b

Buffer :   a b

Do you want to continue (Type y or n)

y

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
1
Enter character to insert
c

Buffer :   a b c

Do you want to continue (Type y or n)

y

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
1
Enter character to insert
d

Buffer :   a b c d

Do you want to continue (Type y or n)

y

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
1
Enter character to insert
e

Buffer : e a b c d

Do you want to continue (Type y or n)

y

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
1
Enter character to insert
f
Error : Underflow Exception

Buffer : e a b c d

Do you want to continue (Type y or n)

y

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
2
Removed Element = a

Buffer : e a b c d

Do you want to continue (Type y or n)

y

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
1
Enter character to insert
f

Buffer : e f b c d

Do you want to continue (Type y or n)

y

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
3
Size = 5

Buffer : e f b c d

Do you want to continue (Type y or n)

y

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
5
Full status = true

Buffer : e f b c d

Do you want to continue (Type y or n)

y

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
2
Removed Element = b

Buffer : e f b c d

Do you want to continue (Type y or n)

y

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
3
Size = 4

Buffer : e f b c d

Do you want to continue (Type y or n)

y

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
6

Buffer Cleared


Buffer :

Do you want to continue (Type y or n)

y

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
3
Size = 0

Buffer :

Do you want to continue (Type y or n)

y

Circular Buffer Operations
1. insert
2. remove
3. size
4. check empty
5. check full
6. clear
4
Empty status = true

Buffer :

Do you want to continue (Type y or n)

n
