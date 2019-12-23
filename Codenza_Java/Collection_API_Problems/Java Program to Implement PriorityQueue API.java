import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueImpl<E>
{
    private PriorityQueue<E> priorityQueue;

    /**
     * Creates a PriorityQueue with the default initial capacity (11) that
     * orders its elements according to their natural ordering.
     **/
    public PriorityQueueImpl()
    {
        priorityQueue = new PriorityQueue<E>();
    }

    /**
     * Creates a PriorityQueue containing the elements in the specified
     * collection.
     **/
    public PriorityQueueImpl(Collection<? extends E> c)
    {
        priorityQueue = new PriorityQueue<E>(c);
    }

    /**
     * Creates a PriorityQueue with the specified initial capacity that orders
     * its elements according to their natural ordering.
     **/
    public PriorityQueueImpl(int initialCapacity)
    {
        priorityQueue = new PriorityQueue<E>(initialCapacity);
    }

    /**
     * Creates a PriorityQueue with the specified initial capacity that orders
     * its elements according to the specified comparator.
     **/
    public PriorityQueueImpl(int initialCapacity, Comparator<? super E> comparator)
    {
        priorityQueue = new PriorityQueue<E>(initialCapacity, comparator);
    }

    /** Inserts the specified element at the tail of this queue. **/
    public boolean add(E e)
    {
        return priorityQueue.add(e);
    }

    /** Atomically removes all of the elements from this queue. **/
    public void clear()
    {
        priorityQueue.clear();
    }

    /** Returns true if this queue contains the specified element. **/
    public boolean contains(Object o)
    {
        return priorityQueue.contains(o);
    }

    /** Returns an iterator over the elements in this queue in proper sequence. **/
    public Iterator<E> iterator()
    {
        return priorityQueue.iterator();
    }

    /**
     * Inserts the specified element at the tail of this queue if it is possible
     * to do so immediately without exceeding the queue's capacity, returning
     * true upon success and false if this queue is full.
     **/
    public boolean offer(E e)
    {
        return priorityQueue.offer(e);
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null
     * if this queue is empty.
     **/
    public E peek()
    {
        return priorityQueue.peek();
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this
     * queue is empty.
     **/
    public E poll()
    {
        return priorityQueue.poll();
    }

    /**
     * Removes a single instance of the specified element from this queue, if it
     * is present.
     **/
    public boolean remove(Object o)
    {
        return priorityQueue.remove(o);
    }

    /** Returns the number of elements in this queue. **/
    public int size()
    {
        return priorityQueue.size();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence.
     **/
    public Object[] toArray()
    {
        return priorityQueue.toArray();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence; the runtime type of the returned array is that of the specified
     * array.
     **/
    public <T> T[] toArray(T[] a)
    {
        return priorityQueue.toArray(a);
    }

    public static void main(String... arg)
    {
        PriorityQueueImpl<Integer> priorityQueue = new PriorityQueueImpl<Integer>();
        priorityQueue.add(200);
        priorityQueue.add(49);
        priorityQueue.add(-400);
        priorityQueue.add(240);
        priorityQueue.add(0);
        System.out.println("the elements of the priorityQueue is ");
        Iterator<Integer> itr = priorityQueue.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        priorityQueue.offer(600);
        priorityQueue.offer(700);
        System.out.println("the peak element of the priorityQueue is(by peeking) " + priorityQueue.peek());
        System.out.println("the peak element of the priorityQueue is(by polling) " + priorityQueue.poll());
        System.out.println("element 300 removed " + priorityQueue.remove(300));
        System.out.println("the priorityQueue contains 400 :" + priorityQueue.contains(400));
        System.out.println("the priorityQueue contains 100 :" + priorityQueue.contains(200));
        System.out.println("the size of the priorityQueue is " + priorityQueue.size());
    }
}

/*
the elements of the priorityQueue is
-400    0   49  240 200
the peak element of the priorityQueue is(by peeking) -400
the peak element of the priorityQueue is(by polling) -400
element 300 removed false
the priorityQueue contains 400 :false
the priorityQueue contains 100 :true
the size of the priorityQueue is 6
