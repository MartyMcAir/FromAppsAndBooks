/*This is a Java Program to implement Fibonacci Heap. Fibonacci heap is a heap data structure consisting of a collection of trees. It has a better amortized running time than a binomial heap. The name of Fibonacci heap comes from Fibonacci numbers which are used in the running time analysis. Using Fibonacci heaps for priority queues improves the asymptotic running time of important algorithms, such as Dijkstra’s algorithm for computing the shortest path between two nodes in a graph.*/

/**
 *  Java Program to Implement FibonacciHeap
 **/

import java.util.*;

/* Fibonacci Heap Node **/
class FibonacciHeapNode
{
    FibonacciHeapNode child, left, right, parent;
    int element;

    /** Constructor **/
    public FibonacciHeapNode(int element)
    {
        this.right = this;
        this.left = this;
        this.element = element;
    }
}

/** Class FibonacciHeap **/
class FibonacciHeap
{
    private FibonacciHeapNode root;
    private int count;

    /** Constructor **/
    public FibonacciHeap()
    {
        root = null;
        count = 0;
    }

    /** Check if heap is empty **/
    public boolean isEmpty()
    {
        return root == null;
    }

    /** Make heap empty **/
    public void clear()
    {
        root = null;
        count = 0;
    }

    /** Function to insert **/
    public void insert(int element)
    {
        FibonacciHeapNode node = new FibonacciHeapNode(element);
        node.element = element;
        if (root != null)
            {
                node.left = root;
                node.right = root.right;
                root.right = node;
                node.right.left = node;
                if (element < root.element)
                    root = node;
            }
        else
            root = node;
        count++;
    }

    /** function to display **/
    public void display()
    {
        System.out.print("\nHeap = ");
        FibonacciHeapNode ptr = root;
        if (ptr == null)
            {
                System.out.print("Empty\n");
                return;
            }
        do
            {
                System.out.print(ptr.element +" ");
                ptr = ptr.right;
            }
        while (ptr != root && ptr.right != null);
        System.out.println();
    }
}

/** Class FibonacciHeapTest **/
public class FibonacciHeapTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("FibonacciHeap Test\n\n");
        FibonacciHeap fh = new FibonacciHeap();
        char ch;
        /**  Perform FibonacciHeap operations  **/
        do
            {
                System.out.println("\nFibonacciHeap Operations\n");
                System.out.println("1. insert element ");
                System.out.println("2. check empty");
                System.out.println("3. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter element");
                        fh.insert( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Empty status = "+ fh.isEmpty());
                        break;
                    case 3 :
                        fh.clear();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                fh.display();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
FibonacciHeap Operations

1. insert element
2. check empty
3. clear
1
Enter element
24

Heap = 24

Do you want to continue (Type y or n)

y

FibonacciHeap Operations

1. insert element
2. check empty
3. clear
1
Enter element
6

Heap = 6 24

Do you want to continue (Type y or n)

y

FibonacciHeap Operations

1. insert element
2. check empty
3. clear
1
Enter element
28

Heap = 6 28 24

Do you want to continue (Type y or n)

y

FibonacciHeap Operations

1. insert element
2. check empty
3. clear
1
Enter element
14

Heap = 6 14 28 24

Do you want to continue (Type y or n)

y

FibonacciHeap Operations

1. insert element
2. check empty
3. clear
1
Enter element
63

Heap = 6 63 14 28 24

Do you want to continue (Type y or n)

y

FibonacciHeap Operations

1. insert element
2. check empty
3. clear
2
Empty status = false

Heap = 6 63 14 28 24

Do you want to continue (Type y or n)

y

FibonacciHeap Operations

1. insert element
2. check empty
3. clear
3

Heap = Empty

Do you want to continue (Type y or n)

y

FibonacciHeap Operations

1. insert element
2. check empty
3. clear
2
Empty status = true

Heap = Empty

Do you want to continue (Type y or n)

n
