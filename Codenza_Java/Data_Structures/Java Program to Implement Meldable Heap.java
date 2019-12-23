/*This is a Java Program to Implement Meldable Heap. A randomized meldable heap (also Meldable Heap or Randomized Meldable Priority Queue) is a priority queue based data structure in which the underlying structure is also a heap-ordered binary tree. However, there are no restrictions on the shape of the underlying binary tree.*/

/**
 **  Java Program to Implement Meldable Heap
 **/

import java.util.Scanner;
import java.util.Random;

/** Class Node **/
class Node
{
    Node left, right, parent;
    int x;

    public Node(Node parent, Node left, Node right, int x)
    {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.x = x;
    }
}

/** Class MedlableHeap **/
class MeldableHeap
{
    private Random rand;
    private int n;
    private Node root;

    public MeldableHeap()
    {
        root = null;
        rand = new Random();
        n = 0;
    }

    /** Check if heap is empty **/
    public boolean isEmpty()
    {
        return root == null;
    }

    /** clear heap **/
    public void makeEmpty()
    {
        root = null;
        rand = new Random();
        n = 0;
    }

    /** function to get size **/
    public int getSize()
    {
        return n;
    }

    /** function to insert an element **/
    public void add(int x)
    {
        Node u = new Node(null, null, null, x);
        root = meld(u, root);
        root.parent = null;
        n++;
    }

    /** function to remove an element **/
    public int remove()
    {
        int x = root.x;
        root = meld(root.left, root.right);
        if (root != null)
            root.parent = null;
        n--;
        return x;
    }

    /** function to merge two nodes **/
    public Node meld(Node q1, Node q2)
    {
        if (q1 == null)
            return q2;
        if (q2 == null)
            return q1;
        if (q2.x < q1.x)
            return meld(q2, q1);
        if (rand.nextBoolean())
            {
                q1.left = meld(q1.left, q2);
                q1.left.parent = q1;
            }
        else
            {
                q1.right = meld(q1.right, q2);
                q1.right.parent = q1;
            }
        return q1;
    }

    /** function to print heap **/
    public void displayHeap()
    {
        System.out.print("\nMeldable Heap : ");
        if (root == null)
            {
                System.out.print("Empty\n");
                return;
            }
        Node prev, w = root;
        while (w.left != null)
            w = w.left;
        while (w != null)
            {
                System.out.print(w.x +" ");
                prev = w;
                w = nextNode(w);
            }
        System.out.println();
    }

    /** function to get next node in heap **/
    private Node nextNode(Node w)
    {
        if (w.right != null)
            {
                w = w.right;
                while (w.left != null)
                    w = w.left;
            }
        else
            {
                while (w.parent != null && w.parent.left != w)
                    w = w.parent;
                w = w.parent;
            }
        return w;
    }
}

/** Class MeldableHeapTest **/
public class MeldableHeapTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Meldable Heap Test\n\n");
        /* Make object of MeldableHeap */
        MeldableHeap mh = new MeldableHeap();
        char ch;
        /*  Perform Meldable Heap operations  */
        do
            {
                System.out.println("\nMeldable Heap Operations\n");
                System.out.println("1. add");
                System.out.println("2. remove");
                System.out.println("3. size");
                System.out.println("4. check empty");
                System.out.println("5. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        mh.add( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Removed Element : "+ mh.remove() );
                        break;
                    case 3 :
                        System.out.println("Size = "+ mh.getSize());
                        break;
                    case 4 :
                        System.out.println("Empty status = "+ mh.isEmpty());
                        break;
                    case 5 :
                        mh.makeEmpty();
                        System.out.println("Heap Cleared\n");
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /* Display heap */
                mh.displayHeap();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
4
Empty status = true

Meldable Heap : Empty

Do you want to continue (Type y or n)

y

Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
1
Enter integer element to insert
24

Meldable Heap : 24

Do you want to continue (Type y or n)

y

Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
1
Enter integer element to insert
6

Meldable Heap : 24 6

Do you want to continue (Type y or n)

y

Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
1
Enter integer element to insert
28

Meldable Heap : 28 24 6

Do you want to continue (Type y or n)

y

Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
1
Enter integer element to insert
94

Meldable Heap : 28 24 6 94

Do you want to continue (Type y or n)

y

Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
1
Enter integer element to insert
19

Meldable Heap : 28 24 6 19 94

Do you want to continue (Type y or n)

y

Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
1
Enter integer element to insert
5

Meldable Heap : 28 24 6 19 94 5

Do you want to continue (Type y or n)

y

Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
1
Enter integer element to insert
63

Meldable Heap : 28 24 6 19 94 5 63

Do you want to continue (Type y or n)

y

Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
3
Size = 7

Meldable Heap : 28 24 6 19 94 5 63

Do you want to continue (Type y or n)

y

Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
2
Removed Element : 5

Meldable Heap : 28 63 24 6 19 94

Do you want to continue (Type y or n)

y

Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
2
Removed Element : 6

Meldable Heap : 28 63 24 19 94

Do you want to continue (Type y or n)

y

Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
2
Removed Element : 19

Meldable Heap : 28 63 24 94

Do you want to continue (Type y or n)

y

Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
2
Removed Element : 24

Meldable Heap : 94 28 63

Do you want to continue (Type y or n)

y

Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
5
Heap Cleared


Meldable Heap : Empty

Do you want to continue (Type y or n)

y

Meldable Heap Operations

1. add
2. remove
3. size
4. check empty
5. clear
4
Empty status = true

Meldable Heap : Empty

Do you want to continue (Type y or n)

n
