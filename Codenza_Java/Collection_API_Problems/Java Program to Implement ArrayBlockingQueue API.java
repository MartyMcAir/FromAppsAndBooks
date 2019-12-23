import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueImpl<E>
{
    private ArrayBlockingQueue<E> arrayBlockingQueue;

    /** Creates an ArrayBlockingQueue with the given (fixed) capacity and default access policy. **/
    public ArrayBlockingQueueImpl(int capacity)
    {
        arrayBlockingQueue = new ArrayBlockingQueue<E>(capacity);
    }

    /** Creates an ArrayBlockingQueue with the given (fixed) capacity and the  specified access policy. **/
    public ArrayBlockingQueueImpl(int capacity, boolean fair)
    {
        arrayBlockingQueue = new ArrayBlockingQueue<>(capacity, fair);
    }

    /** Creates an ArrayBlockingQueue with the given (fixed) capacity, the specified access policy and
     * initially containing the elements of the given collection, added in traversal order of the
     * collection's iterator.
     **/
    public ArrayBlockingQueueImpl(int capacity, boolean fair, Collection<? extends E> c)
    {
        arrayBlockingQueue = new ArrayBlockingQueue<E>(capacity, fair, c);
    }

    /**
     * Inserts the specified element at the tail of this queue if it is possible
     * to do so immediately without exceeding the queue's capacity, returning
     * true upon success and throwing an IllegalStateException if this queue is full.
     **/
    boolean add(E e)
    {
        return arrayBlockingQueue.add(e);
    }

    /** Atomically removes all of the elements from this queue. **/
    void clear()
    {
        arrayBlockingQueue.clear();
    }

    /** Returns true if this queue contains the specified element. **/
    public boolean contains(Object o)
    {
        return arrayBlockingQueue.contains(o);
    }

    /** Removes all available elements from this queue and adds them to the given collection. **/
    public int drainTo(Collection<? super E> c)
    {
        return arrayBlockingQueue.drainTo(c);
    }

    /** Removes at most the given number of available elements from this queue
     * and adds them to the given collection.
     **/
    public int drainTo(Collection<? super E> c, int maxElements)
    {
        return arrayBlockingQueue.drainTo(c, maxElements);
    }

    /** Returns an iterator over the elements in this queue in proper sequence. **/
    public Iterator<E> iterator()
    {
        return arrayBlockingQueue.iterator();
    }

    /**
     * Inserts the specified element at the tail of this queue if it is possible
     * to do so immediately without exceeding the queue's capacity, returning
     * true upon success and false if this queue is full.
     **/
    public boolean offer(E e)
    {
        return arrayBlockingQueue.offer(e);
    }

    /**
     * Inserts the specified element at the tail of this queue, waiting up to
     * the specified wait time for space to become available if the queue is
     * full.
     **/
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException
    {
        return arrayBlockingQueue.offer(e, timeout, unit);
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null
     * if this queue is empty.
     **/
    public E peek()
    {
        return arrayBlockingQueue.peek();
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this
     * queue is empty.
     **/
    public E poll()
    {
        return arrayBlockingQueue.poll();
    }

    /**
     * Retrieves and removes the head of this queue, waiting up to the specified
     * wait time if necessary for an element to become available.
     **/
    public E poll(long timeout, TimeUnit unit) throws InterruptedException
    {
        return arrayBlockingQueue.poll(timeout, unit);
    }

    /**
     * Inserts the specified element at the tail of this queue, waiting for
     * space to become available if the queue is full.
     **/
    public void put(E e) throws InterruptedException
    {
        arrayBlockingQueue.put(e);
    }

    /**
     * Returns the number of additional elements that this queue can ideally (in
     * the absence of memory or resource constraints) accept without blocking.
     **/
    public int remainingCapacity()
    {
        return arrayBlockingQueue.remainingCapacity();
    }

    /**
     * Removes a single instance of the specified element from this queue, if it
     * is present.
     **/
    public boolean remove(Object o)
    {
        return arrayBlockingQueue.remove(o);
    }

    /** Returns the number of elements in this queue. **/
    public int size()
    {
        return arrayBlockingQueue.size();
    }

    /**
     * Retrieves and removes the head of this queue, waiting if necessary until
     * an element becomes available
     **/
    public E take() throws InterruptedException
    {
        return arrayBlockingQueue.take();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence.
     **/
    public Object[] toArray()
    {
        return arrayBlockingQueue.toArray();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence; the runtime type of the returned array is that of the specified
     * array.
     **/
    public <T> T[] toArray(T[] a)
    {
        return arrayBlockingQueue.toArray(a);
    }

    /** Returns a string representation of this collection. **/
    public String toString()
    {
        return arrayBlockingQueue.toString();
    }

    public static void main(String... arg)
    {
        ArrayBlockingQueueImpl<Integer> arrayBlockingQueue = new ArrayBlockingQueueImpl<Integer>(10);
        try
            {
                arrayBlockingQueue.put(100);
                arrayBlockingQueue.put(200);
                arrayBlockingQueue.put(300);
            }
        catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        arrayBlockingQueue.add(400);
        arrayBlockingQueue.add(500);
        System.out.println("the elements of the arrayblockingqueue is ");
        Iterator<Integer> itr = arrayBlockingQueue.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        arrayBlockingQueue.offer(600);
        arrayBlockingQueue.offer(700);
        System.out.println("the peak element of the arrayblockingqueue is(by peeking) "
                           + arrayBlockingQueue.peek());
        System.out.println("the peak element of the arrayblockingqueue is(by polling) "
                           + arrayBlockingQueue.poll());
        System.out.println("the remaining capacity is " + arrayBlockingQueue.remainingCapacity());
        System.out.println("element 300 removed " + arrayBlockingQueue.remove(300));
        System.out.println("the arrayblockingqueue contains 400 :" + arrayBlockingQueue.contains(400));
        System.out.println("the hash arrayblockingqueue contains 100 :" + arrayBlockingQueue.contains(100));
        System.out.println("the size of the arrayblocingqueue is " + arrayBlockingQueue.size());
        System.out.println(arrayBlockingQueue);
    }
}

/*
the elements of the arrayblockingqueue is
100 200 300 400 500
the peak element of the arrayblockingqueue is(by peeking) 100
the peak element of the arrayblockingqueue is(by polling) 100
the remaining capacity is 4
element 300 removed true
the arrayblockingqueue contains 400 :true
the hash arrayblockingqueue contains 100 :false
the size of the arrayblocingqueue is 5
[200, 400, 500, 600, 700]
