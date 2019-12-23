/*This is a Java Program to implement D-ary Heap. A heap is a specialized tree-based data structure that satisfies the heap property: If A is a parent node of B then key(A) is ordered with respect to key(B) with the same ordering applying across the heap. Either the keys of parent nodes are always greater than or equal to those of the children and the highest key is in the root node (max heap) or the keys of parent nodes are less than or equal to those of the children and the lowest key is in the root node (min heap). Heaps are crucial in several efficient graph algorithms such as Dijkstra’s algorithm and in the sorting algorithm heapsort.
The d-ary heap or d-heap is a priority queue data structure, a generalization of the binary heap in which the nodes have d children instead of 2.*/

/**
 *   Java Program to Implement D-ary-Heap
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;

/** Class D-ary Heap **/
class DaryHeap
{
    /** The number of children each node has **/
    private int d;
    private int heapSize;
    private int[] heap;

    /** Constructor **/
    public DaryHeap(int capacity, int numChild)
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

/** Class DaryHeapTest **/
public class DaryHeapTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("D ary Heap Test\n\n");
        System.out.println("Enter size and D of D-ary Heap");
        /** Make object of DaryHeapHeap **/
        DaryHeap dh = new DaryHeap(scan.nextInt(), scan.nextInt() );
        char ch;
        /**  Perform D-ary Heap operations  **/
        do
            {
                System.out.println("\nD-ary Heap Operations\n");
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
                                dh.insert( scan.nextInt() );
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
                                dh.delete(scan.nextInt() - 1);
                            }
                        catch (Exception e)
                            {
                                System.out.println(e.getMessage() );
                            }
                        break;
                    case 3 :
                        System.out.println("Full status = "+ dh.isFull());
                        break;
                    case 4 :
                        System.out.println("Empty status = "+ dh.isEmpty());
                        break;
                    case 5 :
                        dh.clear();
                        System.out.println("Heap Cleared\n");
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /** Display heap **/
                dh.printHeap();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*

Enter size and D of D-ary Heap
6 3

D-ary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
1
Enter integer element to insert
24

Heap = 24

Do you want to continue (Type y or n)

y

D-ary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
1
Enter integer element to insert
6

Heap = 6 24

Do you want to continue (Type y or n)

y

D-ary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
1
Enter integer element to insert
23

Heap = 6 24 23

Do you want to continue (Type y or n)

y

D-ary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
1
Enter integer element to insert
12

Heap = 6 24 23 12

Do you want to continue (Type y or n)

y

D-ary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
1
Enter integer element to insert
75

Heap = 6 24 23 12 75

Do you want to continue (Type y or n)

y

D-ary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
1
Enter integer element to insert
78

Heap = 6 24 23 12 75 78

Do you want to continue (Type y or n)

y

D-ary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
1
Enter integer element to insert
29

Heap = 6 24 23 12 75 78 29

Do you want to continue (Type y or n)

y

D-ary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
2
Enter delete position
5

Heap = 6 24 23 12 29 78

Do you want to continue (Type y or n)

y

D-ary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
2
Enter delete position
6

Heap = 6 24 23 12 29

Do you want to continue (Type y or n)

y

D-ary Heap Operations

1. insert
2. delete
3. check full
4. check empty
5. clear
2
Enter delete position
3

Heap = 6 24 29 12

Do you want to continue (Type y or n)

y

D-ary Heap Operations

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

D-ary Heap Operations

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
