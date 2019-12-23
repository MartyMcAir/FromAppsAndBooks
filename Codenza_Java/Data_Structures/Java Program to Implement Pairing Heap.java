/*This is a Java Program to implement Pairing Heap. A pairing heap is a type of heap data structure with relatively simple implementation and excellent practical amortized performance. However, it has proven very difficult to determine the precise asymptotic running time of pairing heaps.Pairing heaps are heap ordered multiway trees. This program is based on the implementation by Mark Allen Weiss.*/

/*
 *  Java Program to Implement Pairing Heap
 */

import java.util.Scanner;
/* Class PairNode */
class PairNode
{
    int element;
    PairNode leftChild;
    PairNode nextSibling;
    PairNode prev;

    /* Constructor */
    public PairNode(int x)
    {
        element = x;
        leftChild = null;
        nextSibling = null;
        prev = null;
    }
}

/* Class PairHeap */
class PairHeap
{
    private PairNode root;
    private PairNode [ ] treeArray = new PairNode[ 5 ];
    /* Constructor */
    public PairHeap( )
    {
        root = null;
    }
    /* Check if heap is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Make heap logically empty */
    public void makeEmpty( )
    {
        root = null;
    }
    /* Function to insert data */
    public PairNode insert(int x)
    {
        PairNode newNode = new PairNode( x );
        if (root == null)
            root = newNode;
        else
            root = compareAndLink(root, newNode);
        return newNode;
    }
    /* Function compareAndLink */
    private PairNode compareAndLink(PairNode first, PairNode second)
    {
        if (second == null)
            return first;
        if (second.element < first.element)
            {
                /* Attach first as leftmost child of second */
                second.prev = first.prev;
                first.prev = second;
                first.nextSibling = second.leftChild;
                if (first.nextSibling != null)
                    first.nextSibling.prev = first;
                second.leftChild = first;
                return second;
            }
        else
            {
                /* Attach second as leftmost child of first */
                second.prev = first;
                first.nextSibling = second.nextSibling;
                if (first.nextSibling != null)
                    first.nextSibling.prev = first;
                second.nextSibling = first.leftChild;
                if (second.nextSibling != null)
                    second.nextSibling.prev = second;
                first.leftChild = second;
                return first;
            }
    }
    private PairNode combineSiblings(PairNode firstSibling)
    {
        if( firstSibling.nextSibling == null )
            return firstSibling;
        /* Store the subtrees in an array */
        int numSiblings = 0;
        for ( ; firstSibling != null; numSiblings++)
            {
                treeArray = doubleIfFull( treeArray, numSiblings );
                treeArray[ numSiblings ] = firstSibling;
                /* break links */
                firstSibling.prev.nextSibling = null;
                firstSibling = firstSibling.nextSibling;
            }
        treeArray = doubleIfFull( treeArray, numSiblings );
        treeArray[ numSiblings ] = null;
        /* Combine subtrees two at a time, going left to right */
        int i = 0;
        for ( ; i + 1 < numSiblings; i += 2)
            treeArray[ i ] = compareAndLink(treeArray[i], treeArray[i + 1]);
        int j = i - 2;
        /* j has the result of last compareAndLink */
        /* If an odd number of trees, get the last one */
        if (j == numSiblings - 3)
            treeArray[ j ] = compareAndLink( treeArray[ j ], treeArray[ j + 2 ] );
        /* Now go right to left, merging last tree with */
        /* next to last. The result becomes the new last */
        for ( ; j >= 2; j -= 2)
            treeArray[j - 2] = compareAndLink(treeArray[j-2], treeArray[j]);
        return treeArray[0];
    }
    private PairNode[] doubleIfFull(PairNode [ ] array, int index)
    {
        if (index == array.length)
            {
                PairNode [ ] oldArray = array;
                array = new PairNode[index * 2];
                for( int i = 0; i < index; i++ )
                    array[i] = oldArray[i];
            }
        return array;
    }
    /* Delete min element */
    public int deleteMin( )
    {
        if (isEmpty( ) )
            return -1;
        int x = root.element;
        if (root.leftChild == null)
            root = null;
        else
            root = combineSiblings( root.leftChild );
        return x;
    }
    /* inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(PairNode r)
    {
        if (r != null)
            {
                inorder(r.leftChild);
                System.out.print(r.element +" ");
                inorder(r.nextSibling);
            }
    }
}

/* Class PairHeapTest */
public class PairHeapTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("PairHeap Test\n\n");
        PairHeap ph = new PairHeap();
        char ch;
        /*  Perform PairHeap operations  */
        do
            {
                System.out.println("\nPair Heap Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. delete min");
                System.out.println("3. check empty");
                System.out.println("4. clear");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        ph.insert( scan.nextInt() );
                        break;
                    case 2 :
                        ph.deleteMin();
                        break;
                    case 3 :
                        System.out.println("Empty status = "+ ph.isEmpty());
                        break;
                    case 4 :
                        ph.makeEmpty();
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /* Display heap */
                System.out.print("\nInorder Traversal : ");
                ph.inorder();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
67

Inorder Traversal : 67
Do you want to continue (Type y or n)

y

Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
23

Inorder Traversal : 67 23
Do you want to continue (Type y or n)

y

Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
12

Inorder Traversal : 67 23 12
Do you want to continue (Type y or n)

y

Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
6

Inorder Traversal : 67 23 12 6
Do you want to continue (Type y or n)

y

Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
78

Inorder Traversal : 78 67 23 12 6
Do you want to continue (Type y or n)

y

Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
34

Inorder Traversal : 34 78 67 23 12 6
Do you want to continue (Type y or n)

y

Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
45

Inorder Traversal : 45 34 78 67 23 12 6
Do you want to continue (Type y or n)

y

Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
98

Inorder Traversal : 98 45 34 78 67 23 12 6
Do you want to continue (Type y or n)

y

Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
1
Enter integer element to insert
67

Inorder Traversal : 67 98 45 34 78 67 23 12 6
Do you want to continue (Type y or n)

y

Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
2

Inorder Traversal : 98 67 45 34 78 67 23 12
Do you want to continue (Type y or n)

y

Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
2

Inorder Traversal : 98 67 45 34 78 67 23
Do you want to continue (Type y or n)

y

Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
2

Inorder Traversal : 67 78 98 67 45 34
Do you want to continue (Type y or n)

y

Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
2

Inorder Traversal : 78 67 98 67 45
Do you want to continue (Type y or n)

y

Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
4

Inorder Traversal :
Do you want to continue (Type y or n)

y

Pair Heap Operations

1. insert
2. delete min
3. check empty
4. clear
3
Empty status = true

Inorder Traversal :
Do you want to continue (Type y or n)

n
