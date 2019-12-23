/*This is a Java Program to implement Heap. A heap is a specialized tree-based data structure that satisfies the heap property: If A is a parent node of B then key(A) is ordered with respect to key(B) with the same ordering applying across the heap. Either the keys of parent nodes are always greater than or equal to those of the children and the highest key is in the root node (max heap) or the keys of parent nodes are less than or equal to those of the children and the lowest key is in the root node (min heap). Heaps are crucial in several efficient graph algorithms such as Dijkstra’s algorithm and in the sorting algorithm heapsort.*/

/**
 *  Java Program to Implement Heap
 */

import java.util.Scanner;

/** Class Heap */
class Heap
{

    private int[] heapArray;
    /** size of array **/
    private int maxSize;
    /** number of nodes in array **/
    private int heapSize;

    /** Constructor **/
    public Heap(int mx)
    {
        maxSize = mx;
        heapSize = 0;
        heapArray = new int[maxSize];
    }
    /** Check if heap is empty **/
    public boolean isEmpty()
    {
        return heapSize == 0;
    }
    /** Function to insert element **/
    public boolean insert(int ele)
    {
        if (heapSize + 1 == maxSize)
            return false;
        heapArray[++heapSize] = ele;
        int pos = heapSize;
        while (pos != 1 && ele > heapArray[pos/2])
            {
                heapArray[pos] = heapArray[pos/2];
                pos /=2;
            }
        heapArray[pos] = ele;
        return true;
    }

    /** function to remove element **/
    public int remove()
    {
        int parent, child;
        int item, temp;
        if (isEmpty() )
            throw new RuntimeException("Error : Heap empty!");
        item = heapArray[1];
        temp = heapArray[heapSize--];
        parent = 1;
        child = 2;
        while (child <= heapSize)
            {
                if (child < heapSize && heapArray[child] < heapArray[child + 1])
                    child++;
                if (temp >= heapArray[child])
                    break;
                heapArray[parent] = heapArray[child];
                parent = child;
                child *= 2;
            }
        heapArray[parent] = temp;
        return item;
    }

    /** Function to print values **/
    public void displayHeap()
    {
        /* Array format */
        System.out.print("\nHeap array: ");
        for(int i = 1; i <= heapSize; i++)
            System.out.print(heapArray[i] +" ");
        System.out.println("\n");
    }
}

/** Class HeapTest **/
public class HeapTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Heap Test\n\n");
        System.out.println("Enter size of heap");
        Heap h = new Heap(scan.nextInt() );
        char ch;
        /**  Perform Heap operations  **/
        do
            {
                System.out.println("\nHeap Operations\n");
                System.out.println("1. insert ");
                System.out.println("2. delete item with max key ");
                System.out.println("3. check empty");
                boolean chk;
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        chk = h.insert( scan.nextInt() );
                        if (chk)
                            System.out.println("Insertion successful\n");
                        else
                            System.out.println("Insertion failed\n");
                        break;
                    case 2 :
                        System.out.println("Enter integer element to delete");
                        if (!h.isEmpty())
                            h.remove();
                        else
                            System.out.println("Error. Heap is empty\n");
                        break;
                    case 3 :
                        System.out.println("Empty status = "+ h.isEmpty());
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                /** Display heap **/
                h.displayHeap();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*
Enter size of heap
10

Heap Operations

1. insert
2. delete item with max key
3. check empty
1
Enter integer element to insert
7
Insertion successful


Heap array: 7


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
1
Enter integer element to insert
3
Insertion successful


Heap array: 7 3


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
1
Enter integer element to insert
2
Insertion successful


Heap array: 7 3 2


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
1
Enter integer element to insert
5
Insertion successful


Heap array: 7 5 2 3


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
1
Enter integer element to insert
8
Insertion successful


Heap array: 8 7 2 3 5


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
1
Enter integer element to insert
1
Insertion successful


Heap array: 8 7 2 3 5 1


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
1
Enter integer element to insert
9
Insertion successful


Heap array: 9 7 8 3 5 1 2


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
2
Enter integer element to delete

Heap array: 8 7 2 3 5 1


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
2
Enter integer element to delete

Heap array: 7 5 2 3 1


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
2
Enter integer element to delete

Heap array: 5 3 2 1


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
2
Enter integer element to delete

Heap array: 3 1 2


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
2
Enter integer element to delete

Heap array: 2 1


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
2
Enter integer element to delete

Heap array: 1


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
2
Enter integer element to delete

Heap array:


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
2
Enter integer element to delete
Error. Heap is empty


Heap array:


Do you want to continue (Type y or n)

y

Heap Operations

1. insert
2. delete item with max key
3. check empty
3
Empty status = true

Heap array:


Do you want to continue (Type y or n)

n
