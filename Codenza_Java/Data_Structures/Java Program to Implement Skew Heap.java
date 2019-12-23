/*This is a Java Program to implement Skew Heap. A skew heap (or self-adjusting heap) is a heap data structure implemented as a binary tree. Skew heaps are advantageous because of their ability to merge more quickly than binary heaps. In contrast with binary heaps, there are no structural constraints, so there is no guarantee that the height of the tree is logarithmic.*/

/**
 *  Java Program to Implement Skew Heap
 **/

import java.util.*;

/** Class SkewNode **/
class SkewNode
{
    int element;
    SkewNode left, right;

    /** Constructor **/
    public SkewNode(int val)
    {
        this.element = val;
        this.left = null;
        this.right = null;
    }
}

/** Class SkewHeap **/
class SkewHeap
{
    private SkewNode root;
    private int size;

    /** Constructor **/
    public SkewHeap()
    {
        root = null;
        size = 0;
    }

    /** Check if heap is empty **/
    public boolean isEmpty()
    {
        return root == null;
    }

    /** clear heap **/
    public void clear()
    {
        root = null;
        size = 0;
    }

    /** Function to get size **/
    public int getSize()
    {
        return size;
    }

    /** Function to insert **/
    public void insert(int val)
    {
        root = merge(root, new SkewNode(val));
        size++ ;
    }

    /** Function to remove element **/
    public void remove()
    {
        if (root == null)
            throw new NoSuchElementException("Element not found");
        root = merge(root.left, root.right);
        size--;
    }

    /** Function merge **/
    private SkewNode merge(SkewNode x, SkewNode y)
    {
        if (x == null)
            return y;
        if (y == null)
            return x;
        if (x.element < y.element)
            {
                SkewNode temp = x.left;
                x.left = merge(x.right, y);
                x.right = temp;
                return x;
            }
        else
            {
                SkewNode temp = y.right;
                y.right = merge(y.left, x);
                y.left = temp;
                return y;
            }
    }

    /** Function to display heap **/
    public void displayHeap()
    {
        System.out.print("\nHeap : ");
        displayHeap(root);
        System.out.println("\n");
    }
    private void displayHeap(SkewNode r)
    {
        if (r != null)
            {
                displayHeap(r.left);
                System.out.print(r.element +" ");
                displayHeap(r.right);
            }
    }
}

/** Class SkewHeapTest **/
public class SkewHeapTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Skew Heap Test\n\n");
        /** Make object of SkewHeap **/
        SkewHeap sh = new SkewHeap( );
        char ch;
        /**  Perform SkewHeap operations  **/
        do
            {
                System.out.println("\nSkewHeap Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. delete ");
                System.out.println("3. size");
                System.out.println("4. check empty");
                System.out.println("5. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        sh.insert( scan.nextInt() );
                        break;
                    case 2 :
                        sh.remove();
                        break;
                    case 3 :
                        System.out.println("Size = "+ sh.getSize());
                        break;
                    case 4 :
                        System.out.println("Empty status = "+ sh.isEmpty());
                        break;
                    case 5 :
                        sh.clear();
                        System.out.println("Heap Cleared\n");
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /** Display heap **/
                sh.displayHeap();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
SkewHeap Operations

1. insert
2. delete
3. size
4. check empty
5. clear
4
Empty status = true

Heap :


Do you want to continue (Type y or n)

y

SkewHeap Operations

1. insert
2. delete
3. size
4. check empty
5. clear
1
Enter integer element to insert
1

Heap : 1


Do you want to continue (Type y or n)

y

SkewHeap Operations

1. insert
2. delete
3. size
4. check empty
5. clear
1
Enter integer element to insert
5

Heap : 5 1


Do you want to continue (Type y or n)

y

SkewHeap Operations

1. insert
2. delete
3. size
4. check empty
5. clear
1
Enter integer element to insert
7

Heap : 7 1 5


Do you want to continue (Type y or n)

y

SkewHeap Operations

1. insert
2. delete
3. size
4. check empty
5. clear
1
Enter integer element to insert
14

Heap : 14 5 1 7


Do you want to continue (Type y or n)

y

SkewHeap Operations

1. insert
2. delete
3. size
4. check empty
5. clear
1
Enter integer element to insert
70

Heap : 70 7 1 14 5


Do you want to continue (Type y or n)

y

SkewHeap Operations

1. insert
2. delete
3. size
4. check empty
5. clear
1
Enter integer element to insert
91

Heap : 91 5 14 1 70 7


Do you want to continue (Type y or n)

y

SkewHeap Operations

1. insert
2. delete
3. size
4. check empty
5. clear
2

Heap : 7 14 70 5 91


Do you want to continue (Type y or n)

y

SkewHeap Operations

1. insert
2. delete
3. size
4. check empty
5. clear
2

Heap : 91 70 14 7


Do you want to continue (Type y or n)

y

SkewHeap Operations

1. insert
2. delete
3. size
4. check empty
5. clear
2

Heap : 91 70 14


Do you want to continue (Type y or n)

y

SkewHeap Operations

1. insert
2. delete
3. size
4. check empty
5. clear
2

Heap : 91 70


Do you want to continue (Type y or n)

n
