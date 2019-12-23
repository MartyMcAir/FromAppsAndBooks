/**
 *   Java Program to Implement Ternary-Heap
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;

/** Class Ternary Heap **/
class TernaryHeap
{
    private int d;
    private int heapSize;
    private int[] heap;

    /** Constructor **/
    public TernaryHeap  (int capacity, int numChild)
    {
        heapSize = 0;
        d = numChild;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }

    /** Function to check if heap is empty **/
    public boolean isEmpty( )
    {
        return heapSize == 0;
    }

    /** Check if heap is full **/
    public boolean isFull( )
    {
        return heapSize == heap.length;
    }

    /** Clear heap */
    public void clear( )
    {
        heapSize = 0;
    }

    /** Function to  get index parent of i **/
    private int parent(int i)
    {
        return (i - 1)/d;
    }

    /** Function to get index of k th child of i **/
    private int kthChild(int i, int k)
    {
        return d * i + k;
    }

    /** Function to insert element */
    public void insert(int x)
    {
        if (isFull( ) )
            throw new NoSuchElementException("Overflow Exception");
        /** Percolate up **/
        heap[heapSize++] = x;
        heapifyUp(heapSize - 1);
    }

    /** Function to find least element **/
    public int findMin( )
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return heap[0];
    }

    /** Function to delete element at an index **/
    public int delete(int ind)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        int keyItem = heap[ind];
        heap[ind] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(ind);
        return keyItem;
    }

    /** Function heapifyUp  **/
    private void heapifyUp(int childInd)
    {
        int tmp = heap[childInd];
        while (childInd > 0 && tmp < heap[parent(childInd)])
            {
                heap[childInd] = heap[ parent(childInd) ];
                childInd = parent(childInd);
            }
        heap[childInd] = tmp;
    }

    /** Function heapifyDown **/
    private void heapifyDown(int ind)
    {
        int child;
        int tmp = heap[ ind ];
        while (kthChild(ind, 1) < heapSize)
            {
                child = minChild(ind);
                if (heap[child] < tmp)
                    heap[ind] = heap[child];
                else
                    break;
                ind = child;
            }
        heap[ind] = tmp;
    }

    /** Function to get smallest child **/
    private int minChild(int ind)
    {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < heapSize))
            {
                if (heap[pos] < heap[bestChild])
                    bestChild = pos;
                pos = kthChild(ind, k++);
            }
        return bestChild;
    }

    /** Function to print heap **/
    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }
}

/** Class TernaryHeapTest **/
public class TernaryHeapTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ternary Heap Test\n\n");
        System.out.println("Enter size and no of nodes each child has");
        /** Make object of TernaryHeapHeap **/
        TernaryHeap th = new TernaryHeap(scan.nextInt(), scan.nextInt() );
        char ch;
        /**  Perform Ternary Heap operations **/
        do
            {
                System.out.println("\nTernary Heap Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. delete");
                System.out.println("3. check full");
                System.out.println("4. check empty");
                System.out.println("5. clear");
                boolean chk;
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        try
                            {
                                System.out.println("Enter integer element to insert");
                                th.insert( scan.nextInt() );
                            }
                        catch (Exception e)
                            {
                                System.out.println(e.getMessage() );
                            }
                        break;
                    case 2 :
                        try
                            {
                                System.out.println("Enter delete position");
                                th.delete(scan.nextInt() - 1);
                            }
                        catch (Exception e)
                            {
                                System.out.println(e.getMessage() );
                            }
                        break;
                    case 3 :
                        System.out.println("Full status = "+ th.isFull());
                        break;
                    case 4 :
                        System.out.println("Empty status = "+ th.isEmpty());
                        break;
                    case 5 :
                        th.clear();
                        System.out.println("Heap Cleared\n");
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /** Display heap **/
                th.printHeap();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Enter size and no of nodes each child has
3 3

Ternary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
1
Enter integer element to insert
57

Heap = 57

Do you want to continue (Type y or n)

y

Ternary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
1
Enter integer element to insert
17

Heap = 17 57

Do you want to continue (Type y or n)

y

Ternary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
1
Enter integer element to insert
19

Heap = 17 57 19

Do you want to continue (Type y or n)

y

Ternary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
1
Enter integer element to insert
7

Heap = 7 57 19 17

Do you want to continue (Type y or n)

y

Ternary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
1
Enter integer element to insert
24
Overflow Exception

Heap = 7 57 19 17

Do you want to continue (Type y or n)

y

Ternary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
2
Enter delete position
2

Heap = 7 17 19

Do you want to continue (Type y or n)

y

Ternary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
2
Enter delete position
1

Heap = 17 19

Do you want to continue (Type y or n)

y

Ternary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
2
Enter delete position
2

Heap = 17

Do you want to continue (Type y or n)

y

Ternary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
4
Empty status = false

Heap = 17

Do you want to continue (Type y or n)

y

Ternary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
5
Heap Cleared


Heap =

Do you want to continue (Type y or n)

y

Ternary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
4
Empty status = true

Heap =

Do you want to continue (Type y or n)

n
