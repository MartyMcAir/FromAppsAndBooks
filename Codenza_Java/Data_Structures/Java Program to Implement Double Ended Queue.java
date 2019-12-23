/*This is a Java Program to implement a Double Ended Queue. Queue is a particular kind of abstract data type or collection in which the entities in the collection are kept in order and the principal (or only) operations on the collection are the addition of entities to the rear terminal position and removal of entities from the front terminal position. This makes queue a First-In-First-Out (FIFO) data structure. However in a double ended queue addition and removal of entities can be performed at both ends. A double-ended queue (dequeue) is an abstract data type that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).*/

/*
 * Java Program to Implement Double Ended Queue
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

/*  Class Dequeue  */
class Dequeue
{
    private Node front, rear;
    private int size;

    /* Constructor */
    public Dequeue()
    {
        front = null;
        rear = null;
        size = 0;
    }
    /*  Function to check if queue is empty */
    public boolean isEmpty()
    {
        return front == null;
    }
    /*  Function to get the size of the queue */
    public int getSize()
    {
        return size;
    }
    /* Clear dequeue */
    public void clear()
    {
        front = null;
        rear = null;
        size = 0;
    }
    /*  Function to insert an element at begining  */
    public void insertAtFront(int val)
    {
        Node nptr = new Node(val, null);
        size++ ;
        if (front == null)
            {
                front = nptr;
                rear = front;
            }
        else
            {
                nptr.setLink(front);
                front = nptr;
            }
    }
    /*  Function to insert an element at end  */
    public void insertAtRear(int val)
    {
        Node nptr = new Node(val,null);
        size++ ;
        if (rear == null)
            {
                rear = nptr;
                front = rear;
            }
        else
            {
                rear.setLink(nptr);
                rear = nptr;
            }
    }
    /*  Function to remove front element from the queue */
    public int removeAtFront()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        Node ptr = front;
        front = ptr.getLink();
        if (front == null)
            rear = null;
        size-- ;
        return ptr.getData();
    }
    /*  Function to remove rear element from the queue */
    public int removeAtRear()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        int ele = rear.getData();
        Node s = front;
        Node t = front;
        while (s != rear)
            {
                t = s;
                s = s.getLink();
            }
        rear = t;
        rear.setLink(null);
        size --;
        return ele;
    }
    /*  Function to check the front element of the queue */
    public int peekAtFront()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return front.getData();
    }
    /*  Function to check the front element of the queue */
    public int peekAtRear()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return rear.getData();
    }
    /*  Function to display the status of the queue */
    public void display()
    {
        System.out.print("\nDequeue = ");
        if (size == 0)
            {
                System.out.print("Empty\n");
                return ;
            }
        Node ptr = front;
        while (ptr != rear.getLink() )
            {
                System.out.print(ptr.getData()+" ");
                ptr = ptr.getLink();
            }
        System.out.println();
    }
}

/*  Class DoubleEndedQueueTest  */
public class DoubleEndedQueueTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class Dequeue */
        Dequeue dq = new Dequeue();
        /* Perform Dequeue Operations */
        System.out.println("Dequeue Test\n");
        char ch;
        do
            {
                System.out.println("\nDequeue Operations");
                System.out.println("1. insert at front");
                System.out.println("2. insert at rear");
                System.out.println("3. delete at front");
                System.out.println("4. delete at rear");
                System.out.println("5. peek at front");
                System.out.println("6. peek at rear");
                System.out.println("7. size");
                System.out.println("8. check empty");
                System.out.println("9. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        dq.insertAtFront( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter integer element to insert");
                        dq.insertAtRear( scan.nextInt() );
                        break;
                    case 3 :
                        try
                            {
                                System.out.println("Removed Element = "+ dq.removeAtFront());
                            }
                        catch (Exception e)
                            {
                                System.out.println("Error : " + e.getMessage());
                            }
                        break;
                    case 4 :
                        try
                            {
                                System.out.println("Removed Element = "+ dq.removeAtRear());
                            }
                        catch (Exception e)
                            {
                                System.out.println("Error : " + e.getMessage());
                            }
                        break;
                    case 5 :
                        try
                            {
                                System.out.println("Peek Element = "+ dq.peekAtFront());
                            }
                        catch (Exception e)
                            {
                                System.out.println("Error : " + e.getMessage());
                            }
                        break;
                    case 6 :
                        try
                            {
                                System.out.println("Peek Element = "+ dq.peekAtRear());
                            }
                        catch (Exception e)
                            {
                                System.out.println("Error : " + e.getMessage());
                            }
                        break;
                    case 7 :
                        System.out.println("Size = "+ dq.getSize());
                        break;
                    case 8 :
                        System.out.println("Empty status = "+ dq.isEmpty());
                        break;
                    case 9 :
                        System.out.println("\nDequeue Cleared\n");
                        dq.clear();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /* display dequeue */
                dq.display();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*

Dequeue Operations
1. insert at front
2. insert at rear
3. delete at front
4. delete at rear
5. peek at front
6. peek at rear
7. size
8. check empty
9. clear
1
Enter integer element to insert
5

Dequeue = 5

Do you want to continue (Type y or n)

y

Dequeue Operations
1. insert at front
2. insert at rear
3. delete at front
4. delete at rear
5. peek at front
6. peek at rear
7. size
8. check empty
9. clear
1
Enter integer element to insert
8

Dequeue = 8 5

Do you want to continue (Type y or n)

y

Dequeue Operations
1. insert at front
2. insert at rear
3. delete at front
4. delete at rear
5. peek at front
6. peek at rear
7. size
8. check empty
9. clear
2
Enter integer element to insert
3

Dequeue = 8 5 3

Do you want to continue (Type y or n)

y

Dequeue Operations
1. insert at front
2. insert at rear
3. delete at front
4. delete at rear
5. peek at front
6. peek at rear
7. size
8. check empty
9. clear
2
Enter integer element to insert
45

Dequeue = 8 5 3 45

Do you want to continue (Type y or n)

y

Dequeue Operations
1. insert at front
2. insert at rear
3. delete at front
4. delete at rear
5. peek at front
6. peek at rear
7. size
8. check empty
9. clear
1
Enter integer element to insert
28

Dequeue = 28 8 5 3 45

Do you want to continue (Type y or n)

y

Dequeue Operations
1. insert at front
2. insert at rear
3. delete at front
4. delete at rear
5. peek at front
6. peek at rear
7. size
8. check empty
9. clear
5
Peek Element = 28

Dequeue = 28 8 5 3 45

Do you want to continue (Type y or n)

y

Dequeue Operations
1. insert at front
2. insert at rear
3. delete at front
4. delete at rear
5. peek at front
6. peek at rear
7. size
8. check empty
9. clear
6
Peek Element = 45

Dequeue = 28 8 5 3 45

Do you want to continue (Type y or n)

y

Dequeue Operations
1. insert at front
2. insert at rear
3. delete at front
4. delete at rear
5. peek at front
6. peek at rear
7. size
8. check empty
9. clear
7
Size = 5

Dequeue = 28 8 5 3 45

Do you want to continue (Type y or n)

y

Dequeue Operations
1. insert at front
2. insert at rear
3. delete at front
4. delete at rear
5. peek at front
6. peek at rear
7. size
8. check empty
9. clear
3
Removed Element = 28

Dequeue = 8 5 3 45

Do you want to continue (Type y or n)

y

Dequeue Operations
1. insert at front
2. insert at rear
3. delete at front
4. delete at rear
5. peek at front
6. peek at rear
7. size
8. check empty
9. clear
4
Removed Element = 45

Dequeue = 8 5 3

Do you want to continue (Type y or n)

y

Dequeue Operations
1. insert at front
2. insert at rear
3. delete at front
4. delete at rear
5. peek at front
6. peek at rear
7. size
8. check empty
9. clear
3
Removed Element = 8

Dequeue = 5 3

Do you want to continue (Type y or n)

y

Dequeue Operations
1. insert at front
2. insert at rear
3. delete at front
4. delete at rear
5. peek at front
6. peek at rear
7. size
8. check empty
9. clear
7
Size = 2

Dequeue = 5 3

Do you want to continue (Type y or n)

y

Dequeue Operations
1. insert at front
2. insert at rear
3. delete at front
4. delete at rear
5. peek at front
6. peek at rear
7. size
8. check empty
9. clear
9

Dequeue Cleared


Dequeue = Empty

Do you want to continue (Type y or n)

y

Dequeue Operations
1. insert at front
2. insert at rear
3. delete at front
4. delete at rear
5. peek at front
6. peek at rear
7. size
8. check empty
9. clear
8
Empty status = true

Dequeue = Empty

Do you want to continue (Type y or n)

n
