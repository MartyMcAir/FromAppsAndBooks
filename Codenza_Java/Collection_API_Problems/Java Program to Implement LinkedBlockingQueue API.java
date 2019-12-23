import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueImpl<E>
{
    private LinkedBlockingQueue<E> linkedBlockingQueue;

    /** Creates a LinkedBlockingQueue with a capacity of Integer.MAX_VALUE. **/
    public LinkedBlockingQueueImpl()
    {
        linkedBlockingQueue = new LinkedBlockingQueue<E>();
    }

    /**
     * Creates a LinkedBlockingQueue with a capacity of Integer.MAX_VALUE,
     * initially containing the elements of the given collection, added in
     * traversal order of the collection's iterator.
     **/
    public LinkedBlockingQueueImpl(Collection<? extends E> c)
    {
        linkedBlockingQueue = new LinkedBlockingQueue<E>(c);
    }

    /** Creates a LinkedBlockingQueue with the given (fixed) capacity. **/
    public LinkedBlockingQueueImpl(int capacity)
    {
        linkedBlockingQueue = new LinkedBlockingQueue<E>(capacity);
    }

    /** Atomically removes all of the elements from this queue. **/
    void clear()
    {
        linkedBlockingQueue.clear();
    }

    /** Returns true if this queue contains the specified element. **/
    public boolean contains(Object o)
    {
        return linkedBlockingQueue.contains(o);
    }

    /**
     * Removes all available elements from this queue and adds them to the given
     * collection.
     **/
    public int drainTo(Collection<? super E> c)
    {
        return linkedBlockingQueue.drainTo(c);
    }

    /**
     * Removes at most the given number of available elements from this queue
     * and adds them to the given collection.
     **/
    public int drainTo(Collection<? super E> c, int maxElements)
    {
        return linkedBlockingQueue.drainTo(c, maxElements);
    }

    /** Returns an iterator over the elements in this queue in proper sequence. **/
    public Iterator<E> iterator()
    {
        return linkedBlockingQueue.iterator();
    }

    /**
     * Inserts the specified element at the tail of this queue if it is possible
     * to do so immediately without exceeding the queue's capacity, returning
     * true upon success and false if this queue is full.
     **/
    public boolean offer(E e)
    {
        return linkedBlockingQueue.offer(e);
    }

    /**
     * Inserts the specified element at the tail of this queue, waiting up to
     * the specified wait time for space to become available if the queue is
     * full.
     **/
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException
    {
        return linkedBlockingQueue.offer(e, timeout, unit);
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null
     * if this queue is empty.
     **/
    public E peek()
    {
        return linkedBlockingQueue.peek();
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this
     * queue is empty.
     **/
    public E poll()
    {
        return linkedBlockingQueue.poll();
    }

    /**
     * Retrieves and removes the head of this queue, waiting up to the specified
     * wait time if necessary for an element to become available.
     **/
    public E poll(long timeout, TimeUnit unit) throws InterruptedException
    {
        return linkedBlockingQueue.poll(timeout, unit);
    }

    /**
     * Inserts the specified element at the tail of this queue, waiting for
     * space to become available if the queue is full.
     **/
    public void put(E e) throws InterruptedException
    {
        linkedBlockingQueue.put(e);
    }

    /**
     * Returns the number of additional elements that this queue can ideally (in
     * the absence of memory or resource constraints) accept without blocking.
     **/
    public int remainingCapacity()
    {
        return linkedBlockingQueue.remainingCapacity();
    }

    /**
     * Removes a single instance of the specified element from this queue, if it
     * is present.
     **/
    public boolean remove(Object o)
    {
        return linkedBlockingQueue.remove(o);
    }

    /** Returns the number of elements in this queue. **/
    public int size()
    {
        return linkedBlockingQueue.size();
    }

    /**
     * Retrieves and removes the head of this queue, waiting if necessary until
     * an element becomes available
     **/
    public E take() throws InterruptedException
    {
        return linkedBlockingQueue.take();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence.
     **/
    public Object[] toArray()
    {
        return linkedBlockingQueue.toArray();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence; the runtime type of the returned array is that of the specified
     * array.
     **/
    public <T> T[] toArray(T[] a)
    {
        return linkedBlockingQueue.toArray(a);
    }

    /** Returns a string representation of this collection. **/
    public String toString()
    {
        return linkedBlockingQueue.toString();
    }

    public static void main(String... arg)
    {
        LinkedBlockingQueueImpl<Integer> linkedBlockingQueue = new LinkedBlockingQueueImpl<Integer>();
        try
            {
                linkedBlockingQueue.put(100);
                linkedBlockingQueue.put(200);
                linkedBlockingQueue.put(300);
            }
        catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        System.out.println("the elements of the linkedBlockingQueue is ");
        Iterator<Integer> itr = linkedBlockingQueue.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        linkedBlockingQueue.offer(600);
        linkedBlockingQueue.offer(700);
        System.out.println("the peak element of the linkedBlockingQueue is(by peeking) "
                           + linkedBlockingQueue.peek());
        System.out.println("the peak element of the linkedBlockingQueue is(by polling) "
                           + linkedBlockingQueue.poll());
        System.out.println("the remaining capcity is "
                           + linkedBlockingQueue.remainingCapacity());
        System.out.println("element 300 removed "
                           + linkedBlockingQueue.remove(300));
        System.out.println("the linkedBlockingQueue contains 400 :"
                           + linkedBlockingQueue.contains(400));
        System.out.println("the linkedBlockingQueue contains 100 :"
                           + linkedBlockingQueue.contains(100));
        System.out.println("the size of the linkedBlockingQueue is "
                           + linkedBlockingQueue.size());
        System.out.println(linkedBlockingQueue);
    }
}

/*
the elements of the linkedBlockingQueue is
100 200 300
the peak element of the linkedBlockingQueue is(by peeking) 100
the peak element of the linkedBlockingQueue is(by polling) 100
the remaining capcity is 2147483643
element 300 removed true
the linkedBlockingQueue contains 400 :false
the linkedBlockingQueue contains 100 :false
the size of the linkedBlockingQueue is 3
[200, 600, 700]
