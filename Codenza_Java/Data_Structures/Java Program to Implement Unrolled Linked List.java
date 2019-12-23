/*This is a Java Program to implement an Unrolled Linked List. An unrolled linked list is a variation on the linked list which stores multiple elements in each node. It can dramatically increase cache performance, while decreasing the memory overhead associated with storing list metadata such as references. It is related to the B-tree.*/

/*
 *  Java Program to Implement Unrolled Linked List
 */

import java.util.Scanner;

/*  Class ULLNode  */
class ULLNode
{
    ULLNode next;
    int numElements;
    int array[];

    /* Constructor */
    public ULLNode(int n)
    {
        next = null;
        numElements = 0;
        array = new int[n];
    }
}

/* Class UnrolledLinkedList */
class UnrolledLinkedList
{
    private ULLNode start;
    private ULLNode end;
    private int sizeNode;
    private int nNode;

    /* Constructor */
    public UnrolledLinkedList(int capacity)
    {
        start = null;
        end = null;
        nNode = 0;
        sizeNode = capacity + 1;
    }
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return start == null;
    }
    /*  Function to get size of list  */
    public int getSize()
    {
        return nNode;
    }
    /* Function to clear list */
    public void makeEmpty()
    {
        start = null;
        end = null;
        nNode = 0;
    }
    /* Function to insert element */
    public void insert(int x)
    {
        nNode++;
        if (start == null)
            {
                start = new ULLNode(sizeNode);
                start.array[0] = x;
                start.numElements++;
                end = start;
                return;
            }
        if (end.numElements + 1 < sizeNode)
            {
                end.array[end.numElements] = x;
                end.numElements++;
            }
        else
            {
                ULLNode nptr = new ULLNode(sizeNode);
                int j = 0;
                for (int i = end.numElements / 2 + 1; i < end.numElements; i++)
                    nptr.array[j++] = end.array[i];
                nptr.array[j++] = x;
                nptr.numElements = j;
                end.numElements = end.numElements/2 + 1;
                end.next = nptr;
                end = nptr;
            }
    }
    /* Function to display list */
    public void display()
    {
        System.out.print("\nUnrolled Linked List = ");
        if (nNode == 0)
            {
                System.out.print("empty\n");
                return;
            }
        System.out.println();
        ULLNode ptr = start;
        while (ptr != null)
            {
                for (int i = 0; i < ptr.numElements; i++)
                    System.out.print(ptr.array[i] +" ");
                System.out.println();
                ptr = ptr.next;
            }
    }

}

/*  Class UnrolledLinkedListTest  */
public class UnrolledLinkedListTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Unrolled Linked List Test\n");
        System.out.println("Enter array size of each node");
        /* Creating object of class UnrolledLinkedList */
        UnrolledLinkedList ull = new UnrolledLinkedList(scan.nextInt() );
        char ch;
        /*  Perform list operations  */
        do
            {
                System.out.println("\nUnrolled Linked List Operations\n");
                System.out.println("1. insert");
                System.out.println("2. check empty");
                System.out.println("3. get size");
                System.out.println("4. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        ull.insert( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Empty status = "+ ull.isEmpty());
                        break;
                    case 3 :
                        System.out.println("Size = "+ ull.getSize() +" \n");
                        break;
                    case 4 :
                        System.out.println("List Cleared\n");
                        ull.makeEmpty();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /*  Display List  */
                ull.display();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Enter array size of each node
5

Unrolled Linked List Operations

1. insert
2. check empty
3. get size
4. clear
1
Enter integer element to insert
23

Unrolled Linked List =
23

Do you want to continue (Type y or n)

y

Unrolled Linked List Operations

1. insert
2. check empty
3. get size
4. clear
1
Enter integer element to insert
7

Unrolled Linked List =
23 7

Do you want to continue (Type y or n)

y

Unrolled Linked List Operations

1. insert
2. check empty
3. get size
4. clear
1
Enter integer element to insert
87

Unrolled Linked List =
23 7 87

Do you want to continue (Type y or n)

y

Unrolled Linked List Operations

1. insert
2. check empty
3. get size
4. clear
1
Enter integer element to insert
19

Unrolled Linked List =
23 7 87 19

Do you want to continue (Type y or n)

y

Unrolled Linked List Operations

1. insert
2. check empty
3. get size
4. clear
1
Enter integer element to insert
24

Unrolled Linked List =
23 7 87 19 24

Do you want to continue (Type y or n)

y

Unrolled Linked List Operations

1. insert
2. check empty
3. get size
4. clear
1
Enter integer element to insert
6

Unrolled Linked List =
23 7 87
19 24 6

Do you want to continue (Type y or n)

y

Unrolled Linked List Operations

1. insert
2. check empty
3. get size
4. clear
1
Enter integer element to insert
94

Unrolled Linked List =
23 7 87
19 24 6 94

Do you want to continue (Type y or n)

y

Unrolled Linked List Operations

1. insert
2. check empty
3. get size
4. clear
1
Enter integer element to insert
28

Unrolled Linked List =
23 7 87
19 24 6 94 28

Do you want to continue (Type y or n)

y

Unrolled Linked List Operations

1. insert
2. check empty
3. get size
4. clear
1
Enter integer element to insert
5

Unrolled Linked List =
23 7 87
19 24 6
94 28 5

Do you want to continue (Type y or n)

y

Unrolled Linked List Operations

1. insert
2. check empty
3. get size
4. clear
1
Enter integer element to insert
63

Unrolled Linked List =
23 7 87
19 24 6
94 28 5 63

Do you want to continue (Type y or n)

y

Unrolled Linked List Operations

1. insert
2. check empty
3. get size
4. clear
3
Size = 10


Unrolled Linked List =
23 7 87
19 24 6
94 28 5 63

Do you want to continue (Type y or n)

y

Unrolled Linked List Operations

1. insert
2. check empty
3. get size
4. clear
4
List Cleared


Unrolled Linked List = empty

Do you want to continue (Type y or n)

y

Unrolled Linked List Operations

1. insert
2. check empty
3. get size
4. clear
2
Empty status = true

Unrolled Linked List = empty

Do you want to continue (Type y or n)

n
