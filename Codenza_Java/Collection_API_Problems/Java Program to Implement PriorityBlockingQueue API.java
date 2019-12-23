import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PriorityBlockingQueueImpl<E>
{
    private PriorityBlockingQueue<E> priorityBlockingQueue;

    /** Creates an initially empty LinkedTransferQueue. **/
    public PriorityBlockingQueueImpl()
    {
        priorityBlockingQueue = new PriorityBlockingQueue<E>();
    }

    /**
     * Creates a LinkedTransferQueue initially containing the elements of the
     * given collection, added in traversal order of the collection's iterator.
     **/
    public PriorityBlockingQueueImpl(Collection<? extends E> c)
    {
        priorityBlockingQueue = new PriorityBlockingQueue<E>(c);
    }

    /**
     * Creates a PriorityBlockingQueue with the specified initial capacity that
     * orders its elements according to their natural ordering.
     **/
    public PriorityBlockingQueueImpl(int initialCapacity)
    {
        priorityBlockingQueue = new PriorityBlockingQueue<E>(initialCapacity);
    }

    /**
     * Creates a PriorityBlockingQueue with the specified initial capacity that
     * orders its elements according to the specified comparator.
     **/
    public PriorityBlockingQueueImpl(int initialCapacity, Comparator<? super E> comparator)
    {
        priorityBlockingQueue = new PriorityBlockingQueue<E>(initialCapacity, comparator);
    }

    /** Inserts the specified element at the tail of this queue. **/
    public boolean add(E e)
    {
        return priorityBlockingQueue.add(e);
    }

    /** Atomically removes all of the elements from this queue. **/
    public void clear()
    {
        priorityBlockingQueue.clear();
    }

    /** Returns true if this queue contains the specified element. **/
    public boolean contains(Object o)
    {
        return priorityBlockingQueue.contains(o);
    }

    /**
     * Removes all available elements from this queue and adds them to the given
     * collection.
     **/
    public int drainTo(Collection<? super E> c)
    {
        return priorityBlockingQueue.drainTo(c);
    }

    /**
     * Removes at most the given number of available elements from this queue
     * and adds them to the given collection.
     **/
    public int drainTo(Collection<? super E> c, int maxElements)
    {
        return priorityBlockingQueue.drainTo(c, maxElements);
    }

    /** Returns an iterator over the elements in this queue in proper sequence. **/
    public Iterator<E> iterator()
    {
        return priorityBlockingQueue.iterator();
    }

    /**
     * Inserts the specified element at the tail of this queue if it is possible
     * to do so immediately without exceeding the queue's capacity, returning
     * true upon success and false if this queue is full.
     **/
    public boolean offer(E e)
    {
        return priorityBlockingQueue.offer(e);
    }

    /**
     * Inserts the specified element at the tail of this queue, waiting up to
     * the specified wait time for space to become available if the queue is
     * full.
     **/
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException
    {
        return priorityBlockingQueue.offer(e, timeout, unit);
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null
     * if this queue is empty.
     **/
    public E peek()
    {
        return priorityBlockingQueue.peek();
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this
     * queue is empty.
     **/
    public E poll()
    {
        return priorityBlockingQueue.poll();
    }

    /**
     * Retrieves and removes the head of this queue, waiting up to the specified
     * wait time if necessary for an element to become available.
     **/
    public E poll(long timeout, TimeUnit unit) throws InterruptedException
    {
        return priorityBlockingQueue.poll(timeout, unit);
    }

    /**
     * Inserts the specified element at the tail of this queue, waiting for
     * space to become available if the queue is full.
     **/
    public void put(E e) throws InterruptedException
    {
        priorityBlockingQueue.put(e);
    }

    /**
     * Always returns Integer.MAX_VALUE because a PriorityBlockingQueue is not
     * capacity constrained.
     **/
    public int remainingCapacity()
    {
        return priorityBlockingQueue.remainingCapacity();
    }

    /**
     * Removes a single instance of the specified element from this queue, if it
     * is present.
     **/
    public boolean remove(Object o)
    {
        return priorityBlockingQueue.remove(o);
    }

    /** Returns the number of elements in this queue. **/
    public int size()
    {
        return priorityBlockingQueue.size();
    }

    /**
     * Retrieves and removes the head of this queue, waiting if necessary until
     * an element becomes available
     **/
    public E take() throws InterruptedException
    {
        return priorityBlockingQueue.take();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence.
     **/
    public Object[] toArray()
    {
        return priorityBlockingQueue.toArray();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence; the runtime type of the returned array is that of the specified
     * array.
     **/
    public <T> T[] toArray(T[] a)
    {
        return priorityBlockingQueue.toArray(a);
    }

    /** Returns a string representation of this collection. **/
    public String toString()
    {
        return priorityBlockingQueue.toString();
    }

    public static void main(String... arg)
    {
        PriorityBlockingQueueImpl<Integer> priorityBlockingQueue = new PriorityBlockingQueueImpl<Integer>();
        try
            {
                priorityBlockingQueue.put(300);
                priorityBlockingQueue.put(200);
                priorityBlockingQueue.put(600);
            }
        catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        priorityBlockingQueue.add(-400);
        priorityBlockingQueue.add(240);
        System.out.println("the elements of the PriorityBlockingQueue is ");
        Iterator<Integer> itr = priorityBlockingQueue.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        priorityBlockingQueue.offer(600);
        priorityBlockingQueue.offer(700);
        System.out.println("the peak element of the PriorityBlockingQueue is(by peeking) "
                           + priorityBlockingQueue.peek());
        System.out.println("the peak element of the PriorityBlockingQueue is(by polling) "
                           + priorityBlockingQueue.poll());
        System.out.println("the remaining capcity is " + priorityBlockingQueue.remainingCapacity());
        System.out.println("element 300 removed " + priorityBlockingQueue.remove(300));
        System.out.println("the PriorityBlockingQueue contains 400 :" + priorityBlockingQueue.contains(400));
        System.out.println("the PriorityBlockingQueue contains 100 :" + priorityBlockingQueue.contains(100));
        System.out.println("the size of the PriorityBlockingQueue is " 	+ priorityBlockingQueue.size());
        System.out.println(priorityBlockingQueue);
    }
}

/*
the elements of the PriorityBlockingQueue is
-400    200 600 300 240
the peak element of the PriorityBlockingQueue is(by peeking) -400
the peak element of the PriorityBlockingQueue is(by polling) -400
the remaining capcity is 2147483647
element 300 removed true
the PriorityBlockingQueue contains 400 :false
the PriorityBlockingQueue contains 100 :false
the size of the PriorityBlockingQueue is 5
[200, 240, 600, 600, 700]
