import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueImpl<E>
{
    private ConcurrentLinkedQueue<E> concurrentLinkedQueue;

    /** Creates a ConcurrentLinkedQueue that is initially empty. **/
    public ConcurrentLinkedQueueImpl()
    {
        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
    }

    /**
     * Creates a ConcurrentLinkedQueue initially containing the elements of the
     * given collection, added in traversal order of the collection's iterator.
     **/
    public ConcurrentLinkedQueueImpl(Collection<? extends E> c)
    {
        concurrentLinkedQueue = new ConcurrentLinkedQueue<>(c);
    }

    /** Inserts the specified element at the tail of this queue. **/
    public boolean add(E e)
    {
        return concurrentLinkedQueue.add(e);
    }

    /** Returns true if this queue contains the specified element. **/
    public boolean contains(Object o)
    {
        return concurrentLinkedQueue.contains(o);
    }

    /** Returns an iterator over the elements in this queue in proper sequence. **/
    public Iterator<E> iterator()
    {
        return concurrentLinkedQueue.iterator();
    }

    /** Inserts the specified element at the tail of this queue. **/
    public boolean offer(E e)
    {
        return concurrentLinkedQueue.offer(e);
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null
     * if this queue is empty.
     **/
    public E peek()
    {
        return concurrentLinkedQueue.peek();
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this
     * queue is empty.
     **/
    public E poll()
    {
        return concurrentLinkedQueue.poll();
    }

    /**
     * Removes a single instance of the specified element from this queue, if it
     * is present.
     **/
    public boolean remove(Object o)
    {
        return concurrentLinkedQueue.remove(o);
    }

    /** Returns the number of elements in this queue. **/
    public int size()
    {
        return concurrentLinkedQueue.size();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence.
     **/
    public Object[] toArray()
    {
        return concurrentLinkedQueue.toArray();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence; the runtime type of the returned array is that of the specified
     * array.
     **/
    public <T> T[] toArray(T[] a)
    {
        return concurrentLinkedQueue.toArray(a);
    }

    public static void main(String... arg)
    {
        ConcurrentLinkedQueueImpl<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueueImpl<Integer>();
        concurrentLinkedQueue.add(100);
        concurrentLinkedQueue.add(200);
        concurrentLinkedQueue.add(300);
        concurrentLinkedQueue.add(400);
        concurrentLinkedQueue.add(500);
        System.out.println("the elements of the arrayblockingqueue is ");
        Iterator<Integer> itr = concurrentLinkedQueue.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        concurrentLinkedQueue.offer(600);
        concurrentLinkedQueue.offer(700);
        System.out.println("the peak element of the concurrentLinkedQueue is(by peeking) "
                           + concurrentLinkedQueue.peek());
        System.out.println("the peak element of the concurrentLinkedQueue is(by polling) "
                           + concurrentLinkedQueue.poll());
        System.out.println("element 300 removed " + concurrentLinkedQueue.remove(300));
        System.out.println("the concurrentLinkedQueue contains 400 :"
                           + concurrentLinkedQueue.contains(400));
        System.out.println("the hash concurrentLinkedQueue contains 100 :"
                           + concurrentLinkedQueue.contains(100));
        System.out.println("the size of the concurrentLinkedQueue is "
                           + concurrentLinkedQueue.size());
    }
}

/*
the elements of the arrayblockingqueue is
100 200 300 400 500
the peak element of the concurrentLinkedQueue is(by peeking) 100
the peak element of the concurrentLinkedQueue is(by polling) 100
element 300 removed true
the concurrentLinkedQueue contains 400 :true
the hash concurrentLinkedQueue contains 100 :false
the size of the concurrentLinkedQueue is 5
