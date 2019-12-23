/*This is a Java Program to implement Leftist Heap. A leftist heap is a priority queue implemented with a variant of a binary heap. Every node has an s-value which is the distance to the nearest leaf. In contrast to a binary heap, a leftist tree attempts to be very unbalanced. In addition to the heap property, leftist trees are maintained so the right descendant of each node has the lower s-value.*/

/**
 *  Java Program to Implement LeftistHeap
 **/

import java.util.Scanner;

/** Class LeftHeapNode **/
class LeftHeapNode
{
    int element, sValue;
    LeftHeapNode left, right;

    public LeftHeapNode(int ele)
    {
        this(ele, null, null);
    }
    public LeftHeapNode(int ele, LeftHeapNode left, LeftHeapNode right)
    {
        this.element = ele;
        this.left = left;
        this.right = right;
        this.sValue = 0;
    }
}

/** Class LeftistHeap **/
class LeftistHeap
{
    private LeftHeapNode root;

    /** Constructor **/
    public LeftistHeap()
    {
        root = null;
    }

    /** Check if heap is empty **/
    public boolean isEmpty()
    {
        return root == null;
    }

    /** Make heap empty **/
    public void clear( )
    {
        root = null;
    }

    /** Function to insert data **/
    public void insert(int x )
    {
        root = merge(new LeftHeapNode( x ), root);
    }

    /** Function merge **/
    public void merge(LeftistHeap rhs)
    {
        if (this == rhs)
            return;
        root = merge(root, rhs.root);
        rhs.root = null;
    }

    /** Function merge **/
    private LeftHeapNode merge(LeftHeapNode x, LeftHeapNode y)
    {
        if (x == null)
            return y;
        if (y == null)
            return x;
        if (x.element > y.element)
            {
                LeftHeapNode temp = x;
                x = y;
                y = temp;
            }
        x.right = merge(x.right, y);
        if(x.left == null)
            {
                x.left = x.right;
                x.right = null;
            }
        else
            {
                if(x.left.sValue < x.right.sValue)
                    {
                        LeftHeapNode temp = x.left;
                        x.left = x.right;
                        x.right = temp;
                    }
                x.sValue = x.right.sValue + 1;
            }
        return x;
    }

    /** Function to delete minimum element **/
    public int deleteMin( )
    {
        if (isEmpty() )
            return -1;
        int minItem = root.element;
        root = merge(root.left, root.right);
        return minItem;
    }

    /** Inorder traversal **/
    public void inorder()
    {
        inorder(root);
        System.out.println();
    }
    private void inorder(LeftHeapNode r)
    {
        if (r != null)
            {
                inorder(r.left);
                System.out.print(r.element +" ");
                inorder(r.right);
            }
    }
}

/** Class LeftistHeapTest **/
public class LeftistHeapTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("LeftistHeap Test\n\n");
        LeftistHeap lh = new LeftistHeap();
        char ch;
        /**  Perform LeftistHeap operations  **/
        do
            {
                System.out.println("\nLeftist Heap Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. delete min");
                System.out.println("3. check empty");
                System.out.println("4. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        lh.insert( scan.nextInt() );
                        break;
                    case 2 :
                        lh.deleteMin();
                        break;
                    case 3 :
                        System.out.println("Empty status = "+ lh.isEmpty());
                        break;
                    case 4 :
                        lh.clear();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /** Display heap **/
                System.out.print("\nInorder Traversal : ");
                lh.inorder();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*

Leftist Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
24

Inorder Traversal : 24

Do you want to continue (Type y or n)

y

Leftist Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
6

Inorder Traversal : 24 6

Do you want to continue (Type y or n)

y

Leftist Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
19

Inorder Traversal : 24 6 19

Do you want to continue (Type y or n)

y

Leftist Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
94

Inorder Traversal : 24 6 94 19

Do you want to continue (Type y or n)

y

Leftist Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
5

Inorder Traversal : 24 6 94 19 5

Do you want to continue (Type y or n)

y

Leftist Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
63

Inorder Traversal : 24 6 94 19 5 63

Do you want to continue (Type y or n)

y

Leftist Heap Operations

1. insert
2. delete min
3. check empty
4. clear
2

Inorder Traversal : 94 19 63 6 24

Do you want to continue (Type y or n)

y

Leftist Heap Operations

1. insert
2. delete min
3. check empty
4. clear
2

Inorder Traversal : 94 19 63 24

Do you want to continue (Type y or n)

y

Leftist Heap Operations

1. insert
2. delete min
3. check empty
4. clear
2

Inorder Traversal : 63 24 94

Do you want to continue (Type y or n)

y

Leftist Heap Operations

1. insert
2. delete min
3. check empty
4. clear
2

Inorder Traversal : 94 63

Do you want to continue (Type y or n)

y

Leftist Heap Operations

1. insert
2. delete min
3. check empty
4. clear
4

Inorder Traversal :

Do you want to continue (Type y or n)

y

Leftist Heap Operations

1. insert
2. delete min
3. check empty
4. clear
3
Empty status = true

Inorder Traversal :

Do you want to continue (Type y or n)

n
