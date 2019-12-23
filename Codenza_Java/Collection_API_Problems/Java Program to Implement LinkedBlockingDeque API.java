import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingDequeImpl<E>
{
    private LinkedBlockingDeque<E> linkedBlockingDeque;

    /** Creates a LinkedBlockingDeque with a capacity of Integer.MAX_VALUE. **/
    public LinkedBlockingDequeImpl()
    {
        linkedBlockingDeque = new LinkedBlockingDeque<E>();
    }

    /**
     * Creates a LinkedBlockingDeque with a capacity of Integer.MAX_VALUE,
     * initially containing the elements of the given collection, added in
     * traversal order of the collection's iterator.
     **/
    public LinkedBlockingDequeImpl(Collection<? extends E> c)
    {
        linkedBlockingDeque = new LinkedBlockingDeque<E>(c);
    }

    /** Creates a LinkedBlockingDeque with the given (fixed) capacity. **/
    public LinkedBlockingDequeImpl(int capacity)
    {
        linkedBlockingDeque = new LinkedBlockingDeque<E>(capacity);
    }

    /** Atomically removes all of the elements from this deque. **/
    public void clear()
    {
        linkedBlockingDeque.clear();
    }

    /** Returns true if this deque contains the specified element. **/
    public boolean contains(Object o)
    {
        return linkedBlockingDeque.contains(o);
    }

    /**
     * Removes all available elements from this deque and adds them to the given
     * collection.
     **/
    public int drainTo(Collection<? super E> c)
    {
        return linkedBlockingDeque.drainTo(c);
    }

    /**
     * Removes at most the given number of available elements from this deque
     * and adds them to the given collection.
     **/
    public int drainTo(Collection<? super E> c, int maxElements)
    {
        return linkedBlockingDeque.drainTo(c, maxElements);
    }

    /** Returns an iterator over the elements in this deque in proper sequence. **/
    public Iterator<E> iterator()
    {
        return linkedBlockingDeque.iterator();
    }

    /**
     * Inserts the specified element at the tail of this queue if it is possible
     * to do so immediately without exceeding the queue's capacity, returning
     * true upon success and false if this deque is full.
     **/
    public boolean offer(E e)
    {
        return linkedBlockingDeque.offer(e);
    }

    /**
     * Inserts the specified element at the tail of this queue, waiting up to
     * the specified wait time for space to become available if the deque is
     * full.
     **/
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException
    {
        return linkedBlockingDeque.offer(e, timeout, unit);
    }

    /**
     * Retrieves, but does not remove, the head of this deque, or returns null
     * if this queue is empty.
     **/
    public E peek()
    {
        return linkedBlockingDeque.peek();
    }

    /**
     * Retrieves and removes the head of this deque, or returns null if this
     * queue is empty.
     **/
    public E poll()
    {
        return linkedBlockingDeque.poll();
    }

    /**
     * Retrieves and removes the head of this deque, waiting up to the specified
     * wait time if necessary for an element to become available.
     **/
    public E poll(long timeout, TimeUnit unit) throws InterruptedException
    {
        return linkedBlockingDeque.poll(timeout, unit);
    }

    /**
     * Inserts the specified element at the tail of this deque, waiting for
     * space to become available if the queue is full.
     **/
    public void put(E e) throws InterruptedException
    {
        linkedBlockingDeque.put(e);
    }

    /**
     * Returns the number of additional elements that this deque can ideally (in
     * the absence of memory or resource constraints) accept without blocking.
     **/
    public int remainingCapacity()
    {
        return linkedBlockingDeque.remainingCapacity();
    }

    /**
     * Removes a single instance of the specified element from this deque, if it
     * is present.
     **/
    public boolean remove(Object o)
    {
        return linkedBlockingDeque.remove(o);
    }

    .   /** Returns the number of elements in this deque. **/
    public int size()
    {
        return linkedBlockingDeque.size();
    }

    /*
     * Retrieves and removes the head of this deque, waiting if necessary until
     * an element becomes available
     */
    public E take() throws InterruptedException
    {
        return linkedBlockingDeque.take();
    } /*

     * Returns an array containing all of the elements in this deque, in proper
     * sequence.
     */
    public Object[] toArray()
    {
        return linkedBlockingDeque.toArray();
    }

    /**
     * Returns an array containing all of the elements in this deque, in proper
     * sequence; the runtime type of the returned array is that of the specified
     * array.
     **/
    public <T> T[] toArray(T[] a)
    {
        return linkedBlockingDeque.toArray(a);
    }

    /** Returns a string representation of this collection. **/
    public String toString()
    {
        return linkedBlockingDeque.toString();
    }

    /** Inserts the specified element at the front of this deque. **/
    public void addFirst(E e)
    {
        linkedBlockingDeque.addFirst(e);
    }

    /** Inserts the specified element at the end of this deque. **/
    public void addLast(E e)
    {
        linkedBlockingDeque.addLast(e);
    }

    /** Retrieves, but does not remove, the first element of this deque. **/
    public void getFirst()
    {
        linkedBlockingDeque.getFirst();
    }

    /** Retrieves, but does not remove, the last element of this deque. **/
    public void getLast()
    {
        linkedBlockingDeque.getLast();
    }

    /** Inserts the specified element at the front of this deque. **/
    public boolean offerFirst(E e)
    {
        return linkedBlockingDeque.offerFirst(e);
    }

    /** Inserts the specified element at the end of this deque. **/
    public boolean offerLast(E e)
    {
        return linkedBlockingDeque.offerLast(e);
    }

    /**
     * Retrieves, but does not remove, the first element of this deque, or
     * returns null if this deque is empty.
     **/
    public E peekFirst()
    {
        return linkedBlockingDeque.peekFirst();
    }

    /**
     * Retrieves, but does not remove, the last element of this deque, or
     * returns null if this deque is empty.
     **/
    public E peekLast()
    {
        return linkedBlockingDeque.peekLast();
    }

    public static void main(String... arg)
    {
        LinkedBlockingDequeImpl<Integer> linkedBlockingDeque = new LinkedBlockingDequeImpl<Integer>();
        try
            {
                linkedBlockingDeque.put(100);
                linkedBlockingDeque.put(200);
                linkedBlockingDeque.put(300);
            }
        catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        System.out.println("the elements of the linkedBlockingDeque is ");
        Iterator<Integer> itr = linkedBlockingDeque.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        linkedBlockingDeque.offer(600);
        linkedBlockingDeque.offer(700);
        System.out.println("the peak element of the linkedBlockingDeque is(by peeking) "
                           + linkedBlockingDeque.peek());
        System.out.println("the peak element of the linkedBlockingDeque is(by polling) "
                           + linkedBlockingDeque.poll());
        System.out.println("the remaining capcity is "+ linkedBlockingDeque.remainingCapacity());
        System.out.println("element 300 removed " + linkedBlockingDeque.remove(300));
        System.out.println("the linkedBlockingDeque contains 400 :" + linkedBlockingDeque.contains(400));
        System.out.println("the linkedBlockingDeque contains 100 :" + linkedBlockingDeque.contains(100));
        System.out.println("the size of the linkedBlockingDeque is "+ linkedBlockingDeque.size());
        System.out.println(linkedBlockingDeque);
    }
}

/*

the elements of the linkedBlockingDeque is
100 200 300
the peak element of the linkedBlockingDeque is(by peeking) 100
the peak element of the linkedBlockingDeque is(by polling) 100
the remaining capcity is 2147483643
element 300 removed true
the linkedBlockingDeque contains 400 :false
the linkedBlockingDeque contains 600 :true
the size of the linkedBlockingDeque is 3
[200, 600, 700]
