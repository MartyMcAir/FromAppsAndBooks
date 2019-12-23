/*This Java program is to implement max heap. A Heap data structure is a Tree based data structure that satisfies the HEAP Property “If A is a parent node of B then key(A) is ordered with respect to key(B) with the same ordering applying across the heap.”
So in a Min Heap this property will be “If A is a parent node of B then key(A) is less than key(B) with the same ordering applying across the heap.” and in a max heap the key(A) will be greater than Key(B).*/

public class MaxHeap
{
    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public MaxHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos)
    {
        return pos / 2;
    }

    private int leftChild(int pos)
    {
        return (2 * pos);
    }

    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos)
    {
        if (pos >=  (size / 2)  &&  pos <= size)
            {
                return true;
            }
        return false;
    }

    private void swap(int fpos,int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void maxHeapify(int pos)
    {
        if (!isLeaf(pos))
            {
                if ( Heap[pos] < Heap[leftChild(pos)]  || Heap[pos] < Heap[rightChild(pos)])
                    {
                        if (Heap[leftChild(pos)] > Heap[rightChild(pos)])
                            {
                                swap(pos, leftChild(pos));
                                maxHeapify(leftChild(pos));
                            }
                        else
                            {
                                swap(pos, rightChild(pos));
                                maxHeapify(rightChild(pos));
                            }
                    }
            }
    }

    public void insert(int element)
    {
        Heap[++size] = element;
        int current = size;
        while(Heap[current] > Heap[parent(current)])
            {
                swap(current,parent(current));
                current = parent(current);
            }
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++ )
            {
                System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i]
                                 + " RIGHT CHILD :" + Heap[2 * i  + 1]);
                System.out.println();
            }
    }

    public void maxHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--)
            {
                maxHeapify(pos);
            }
    }

    public int remove()
    {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        maxHeapify(FRONT);
        return popped;
    }

    public static void main(String...arg)
    {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.maxHeap();
        maxHeap.print();
        System.out.println("The max val is " + maxHeap.remove());
    }
}

/*
The Max Heap is
 PARENT : 84 LEFT CHILD : 22 RIGHT CHILD :19
 PARENT : 22 LEFT CHILD : 17 RIGHT CHILD :10
 PARENT : 19 LEFT CHILD : 5 RIGHT CHILD :6
 PARENT : 17 LEFT CHILD : 3 RIGHT CHILD :9
The max val is 84
