import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;

public class ArrayDequeImpl<E>
{
    private ArrayDeque<E> arrayDeque;

    /**
     * Constructs an empty array deque with an initial capacity sufficient to
     * hold 16 elements.
     **/
    public ArrayDequeImpl()
    {
        arrayDeque = new ArrayDeque<E>();
    }

    /**
     * Constructs a deque containing the elements of the specified collection,
     * in the order they are returned by the collection's iterator.
     **/
    public ArrayDequeImpl(Collection<? extends E> c)
    {
        arrayDeque = new ArrayDeque<E>(c);
    }

    /**
     * Constructs an empty array deque with an initial capacity sufficient to
     * hold the specified number of elements.
     **/
    public ArrayDequeImpl(int numElements)
    {
        arrayDeque = new ArrayDeque<E>(numElements);
    }

    /** Inserts the specified element at the tail of this queue. **/
    public boolean add(E e)
    {
        return arrayDeque.add(e);
    }

    /** Atomically removes all of the elements from this queue. **/
    public void clear()
    {
        arrayDeque.clear();
    }

    /** Returns true if this queue contains the specified element. **/
    public boolean contains(Object o)
    {
        return arrayDeque.contains(o);
    }

    /** Returns an iterator over the elements in this queue in proper sequence. **/
    public Iterator<E> iterator()
    {
        return arrayDeque.iterator();
    }

    /**
     * Inserts the specified element at the tail of this queue if it is possible
     * to do so immediately without exceeding the queue's capacity, returning
     * true upon success and false if this queue is full.
     **/
    public boolean offer(E e)
    {
        return arrayDeque.offer(e);
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null
     * if this queue is empty.
     **/
    public E peek()
    {
        return arrayDeque.peek();
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this
     * queue is empty.
     **/
    public E poll()
    {
        return arrayDeque.poll();
    }

    /**
     * Removes a single instance of the specified element from this queue, if it
     * is present.
     **/
    public boolean remove(Object o)
    {
        return arrayDeque.remove(o);
    }

    /** Returns the number of elements in this queue. **/
    public int size()
    {
        return arrayDeque.size();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence.
     **/
    public Object[] toArray()
    {
        return arrayDeque.toArray();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence; the runtime type of the returned array is that of the specified
     * array.
     **/
    public <T> T[] toArray(T[] a)
    {
        return arrayDeque.toArray(a);
    }

    /** Returns a string representation of this collection. **/
    public String toString()
    {
        return arrayDeque.toString();
    }

    /** Inserts the specified element at the front of this deque. **/
    public void addFirst(E e)
    {
        arrayDeque.addFirst(e);
    }

    /** Inserts the specified element at the end of this deque. **/
    public void addLast(E e)
    {
        arrayDeque.addLast(e);
    }

    /** Retrieves, but does not remove, the first element of this deque. **/
    public void getFirst()
    {
        arrayDeque.getFirst();
    }

    /** Retrieves, but does not remove, the last element of this deque. **/
    public void getLast()
    {
        arrayDeque.getLast();
    }

    /** Inserts the specified element at the front of this deque. **/
    public boolean offerFirst(E e)
    {
        return arrayDeque.offerFirst(e);
    }

    /** Inserts the specified element at the end of this deque. **/
    public boolean offerLast(E e)
    {
        return arrayDeque.offerLast(e);
    }

    /**
     * Retrieves, but does not remove, the first element of this deque, or
     * returns null if this deque is empty.
     **/
    public E peekFirst()
    {
        return arrayDeque.peekFirst();
    }

    /**
     * Retrieves, but does not remove, the last element of this deque, or
     * returns null if this deque is empty.
     **/
    public E peekLast()
    {
        return arrayDeque.peekLast();
    }

    public static void main(String... arg)
    {
        ArrayDequeImpl<Integer> arrayDeque = new ArrayDequeImpl<Integer>();
        arrayDeque.add(300);
        arrayDeque.add(200);
        arrayDeque.add(600);
        arrayDeque.add(-400);
        arrayDeque.add(240);
        System.out.println("the elements of the arrayDeque is ");
        Iterator<Integer> itr = arrayDeque.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next() + "\t");
            }
        System.out.println();
        arrayDeque.offer(600);
        arrayDeque.offer(700);
        arrayDeque.offerFirst(3);
        arrayDeque.offerLast(10);
        System.out.println("the peak element of the arrayDeque is(by peeking) " + arrayDeque.peek());
        System.out.println("the peak element of the arrayDeque is(by polling) " + arrayDeque.poll());
        System.out.println("the last element of arrayDeque is (peeking)" + arrayDeque.peekLast());
        System.out.println("element 300 removed " + arrayDeque.remove(300));
        System.out.println("the arrayDeque contains 400 :" + arrayDeque.contains(400));
        System.out.println("the arrayDeque contains 600 :" + arrayDeque.contains(600));
        System.out.println("the size of the arrayDeque is " + arrayDeque.size());
        System.out.println(arrayDeque);
    }
}

/*
the elements of the arrayDeque is
300 200 600 -400    240
the peak element of the arrayDeque is(by peeking) 3
the peak element of the arrayDeque is(by polling) 3
the last element of arrayDeque is (peeking)10
element 300 removed true
the arrayDeque contains 400 :false
the arrayDeque contains 600 :true
the size of the arrayDeque is 7
[200, 600, -400, 240, 600, 700, 10]
